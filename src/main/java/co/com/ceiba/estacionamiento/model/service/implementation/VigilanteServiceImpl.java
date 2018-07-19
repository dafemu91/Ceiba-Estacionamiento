package co.com.ceiba.estacionamiento.model.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.TarifaFactura;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.entity.builder.FacturaBuilder;
import co.com.ceiba.estacionamiento.model.entity.builder.TarifaFacturaBuilder;
import co.com.ceiba.estacionamiento.model.entity.builder.VehiculoBuilder;
import co.com.ceiba.estacionamiento.model.service.IFacturaService;
import co.com.ceiba.estacionamiento.model.service.ITarifaFacturaService;
import co.com.ceiba.estacionamiento.model.service.ITarifaService;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;
import co.com.ceiba.estacionamiento.model.service.IVigilanteService;
import co.com.ceiba.estacionamiento.model.validator.IValidator;
import co.com.ceiba.estacionamiento.model.validator.exception.ValidatorException;
import co.com.ceiba.estacionamiento.model.validator.implementation.ValidadorVehiculoParqueado;
import co.com.ceiba.estacionamiento.model.validator.implementation.ValidatorCantidadVehiculos;
import co.com.ceiba.estacionamiento.model.validator.implementation.ValidatorPlaca;
import co.com.ceiba.estacionamiento.util.Constantes;

@Service
public class VigilanteServiceImpl implements IVigilanteService{

	@Autowired
	IVehiculoService vehiculoService;
	
	@Autowired
	IFacturaService facturaService;
	
	@Autowired
	ITarifaService tarifaService;
	
	@Autowired
	ITarifaFacturaService tarifaFacturaService;
	
	
	private static final Logger LOGGER = Logger.getLogger(VigilanteServiceImpl.class.getName());
	
	private static final String VALOR_HORAS = "horas";
	private static final String VALOR_DIAS = "dias";
	private static final Integer CILINDRAJE = 1;
	
	@Transactional
	@Override
	public void registrarVehiculo(VehiculoEntity vehiculo) {
		//Construcción factura
		try {
			
			vehiculo.setPlaca(vehiculo.getPlaca().toUpperCase());
			Factura factura = new Factura(Constantes.Mensajes.FACTURA_VEHICULO, new Date(), vehiculo);
			
			List<IValidator> validaciones  = new ArrayList<>();
			validaciones.add(new ValidatorCantidadVehiculos(vehiculoService));
			validaciones.add(new ValidatorPlaca());
			validaciones.add(new ValidadorVehiculoParqueado(vehiculoService));
			
			for (IValidator validacion : validaciones) {
				validacion.verificar(vehiculo);
			}
			
			//si el vehiculo ya existe no volver a ingresar
			VehiculoEntity vehiculoValidacion = vehiculoService.findByPlaca(vehiculo.getPlaca());
			if(vehiculoValidacion==null ) {
				vehiculoService.guardar(vehiculo);
			}
			
			//inicio factura
			FacturaEntity facturaEntity = FacturaBuilder.convertirAEntity(factura);
			facturaEntity.setVehiculo(vehiculoValidacion==null?vehiculo:vehiculoValidacion);
			facturaService.guardar(facturaEntity);
			
			
			
			if(vehiculo.getTipoVehiculo().getId() == Constantes.TipoVehiculo.MOTO ) {
				insertarTarifaFactura(Constantes.TipoVehiculo.MOTO, facturaEntity, vehiculo);
			}else {
				insertarTarifaFactura(Constantes.TipoVehiculo.CARRO, facturaEntity, vehiculo);
			}
			
		}catch(ValidatorException e) {
			LOGGER.info(e.getMessage());
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		
		
	}
	


	@Override
	public Factura generarFactura(String placa) {
		Factura facturaRetorno = null;
		//obtener informacion factura creada al momento del registro del vehiculo
		FacturaEntity factura = facturaService.findFacturaVehiculoByPlaca(placa);
		Date fechaSalida = new Date();
		Map<String, Long> horasDias = calcularHorasDias(factura.getFechaIngreso(),fechaSalida);
		
		//actualizar fecha de salida
		factura.setFechaSalida(fechaSalida);
		facturaService.actualizar(factura);
		
		//actualizar cantidad de horas y dias en tarifa_factura segun la factura
		List<TarifaFacturaEntity> tarifasFacturas = tarifaFacturaService.findTarifasFacturasByIdFactura(factura.getId());
		insertarCantidadTarifaFactura(tarifasFacturas, horasDias);		
		
		//obtener informacion factura con informacion actualizada
		FacturaEntity facturaActual = facturaService.findById(factura.getId()).get();
		double valorTotal = calcularValorTotal(facturaActual.getTarifaFacturas());
		facturaActual.setValorFinal(valorTotal);
		facturaService.actualizar(facturaActual);
		
		facturaRetorno = FacturaBuilder.convertirAObject(facturaActual);
		return facturaRetorno;
		
	}

	@Override
	public List<Vehiculo> consultarVehiculo() { 
		List<Vehiculo> vehiculosRespuesta = new ArrayList<>();
		List<VehiculoEntity> vehiculosActivos = vehiculoService.findVehiculosActivos();
		if(vehiculosActivos==null) {
			throw new ValidatorException(Constantes.Excepciones.NO_HAY_VEHICULOS);
		}
		for (VehiculoEntity vehiculoEntity : vehiculosActivos) {
			Vehiculo vehiculo = VehiculoBuilder.convertirAObject(vehiculoEntity);
			vehiculosRespuesta.add(vehiculo);
		}
		return vehiculosRespuesta;
	}
	
	private void insertarTarifaFactura(Long tipoVehiculo, FacturaEntity factura, VehiculoEntity vehiculo) throws Exception {
		List<TarifaFacturaEntity> tarifasFacturas = new ArrayList<>();
		if(Constantes.TipoVehiculo.MOTO == tipoVehiculo) {
			TarifaEntity tarifaHora = tarifaService.findById(Constantes.Tarifa.TARIFA_MOTO_HORA).get();
			TarifaEntity tarifaCilindraje = tarifaService.findById(Constantes.Tarifa.TARIFA_MOTO_CILINDRAJE).get();
			TarifaEntity tarifaDia = tarifaService.findById(Constantes.Tarifa.TARIFA_MOTO_DIA).get();
			TarifaFactura tarifaFacturaCilindraje = new TarifaFactura(factura, tarifaCilindraje);
			if(vehiculo.getCilindraje()>Constantes.Vehiculo.CILINDRAJE_AUMENTO_MOTO) {
				tarifaFacturaCilindraje.setCantidad(CILINDRAJE);
			}
			TarifaFactura tarifaFacturaHora = new TarifaFactura(factura, tarifaHora);
			TarifaFactura tarifaFacturaDia = new TarifaFactura(factura, tarifaDia);
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaHora));
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaCilindraje));
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaDia));
			tarifaFacturaService.guardarTodos(tarifasFacturas);
		}else {
			TarifaEntity tarifaHora = tarifaService.findById(Constantes.Tarifa.TARIFA_CARRO_HORA).get();
			TarifaEntity tarifaDia = tarifaService.findById(Constantes.Tarifa.TARIFA_CARRO_DIA).get();
			TarifaFactura tarifaFacturaHora = new TarifaFactura(factura, tarifaHora);
			TarifaFactura tarifaFacturaDia = new TarifaFactura(factura, tarifaDia);
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaDia));
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaHora));
			tarifaFacturaService.guardarTodos(tarifasFacturas);
		}
		
	}
	
	public Map<String, Long> calcularHorasDias(Date fechaIngreso, Date fechaSalida){
		Map<String, Long> horaDias = new  HashMap<>();
		Long fechaMilisegundos = fechaSalida.getTime() - fechaIngreso.getTime();
		Long dias = ((fechaMilisegundos/(1000*60*60))+1)/24; 
		Long horasFaltantes = ((fechaMilisegundos/(1000*60*60))+1)%24;
		if(horasFaltantes>=9) {
			dias +=1;
			horasFaltantes =0L;
		}
		horaDias.put(VALOR_DIAS, dias);
		horaDias.put(VALOR_HORAS, horasFaltantes);
		return horaDias;
	}
	
	
	
//	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy hh:mm");
//		Date fechaInicio = ff.parse("18/07/2018 05:00");
//		Date fechaFin = new Date();
//		Long fechaMilisegundos = fechaFin.getTime() - fechaInicio.getTime();
//		Long dias = ((fechaMilisegundos/(1000*60*60))+1)/24; 
//		Long horasFaltantes = ((fechaMilisegundos/(1000*60*60))+1)%24;
//	}
	
	private void insertarCantidadTarifaFactura(List<TarifaFacturaEntity> tarifasFacturas, Map<String, Long> horasDias) {
		for (TarifaFacturaEntity tarifaFacturaEntity : tarifasFacturas) {
			Long idTipoVehiculo = tarifaFacturaEntity.getFactura().getVehiculo().getTipoVehiculo().getId();
			Long tipoTarifa = tarifaFacturaEntity.getTarifa().getId();
			if(idTipoVehiculo == Constantes.TipoVehiculo.MOTO) {
				if(tipoTarifa == Constantes.Tarifa.TARIFA_MOTO_DIA) {
					tarifaFacturaEntity.setCantidad(horasDias.get(VALOR_DIAS).intValue());
					tarifaFacturaService.actualizar(tarifaFacturaEntity);
				}else {
					tarifaFacturaEntity.setCantidad(horasDias.get(VALOR_HORAS).intValue());
					tarifaFacturaService.actualizar(tarifaFacturaEntity);
				}
			}else if(idTipoVehiculo == Constantes.TipoVehiculo.CARRO){
				if(tipoTarifa == Constantes.Tarifa.TARIFA_CARRO_DIA) {
					tarifaFacturaEntity.setCantidad(horasDias.get(VALOR_DIAS).intValue());
					tarifaFacturaService.actualizar(tarifaFacturaEntity);
				}else {
					tarifaFacturaEntity.setCantidad(horasDias.get(VALOR_HORAS).intValue());
					tarifaFacturaService.actualizar(tarifaFacturaEntity);
				}
			}
		}
	}
	
	public double calcularValorTotal(List<TarifaFacturaEntity> tarifasFacturas) {
		double valorTotal = 0;
		for (TarifaFacturaEntity tarifaFacturaEntity : tarifasFacturas) {
			valorTotal += tarifaFacturaEntity.getCantidad() * tarifaFacturaEntity.getTarifa().getValor();
		}
		return valorTotal;
	}



}
