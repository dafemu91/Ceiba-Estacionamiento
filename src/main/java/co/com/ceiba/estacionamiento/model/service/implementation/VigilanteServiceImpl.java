package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.TarifaFactura;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.entity.builder.FacturaBuilder;
import co.com.ceiba.estacionamiento.model.entity.builder.TarifaFacturaBuilder;
import co.com.ceiba.estacionamiento.model.service.IFacturaService;
import co.com.ceiba.estacionamiento.model.service.ITarifaFacturaService;
import co.com.ceiba.estacionamiento.model.service.ITarifaService;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;
import co.com.ceiba.estacionamiento.model.service.IVigilanteService;
import co.com.ceiba.estacionamiento.model.validator.IValidator;
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
	
	@Transactional
	@Override
	public void registrarVehiculo(VehiculoEntity vehiculo) {
		//Construcción factura
		try {
			Factura factura = new Factura(Constantes.Mensajes.FACTURA_VEHICULO, new Date(), vehiculo);
			
			List<IValidator> validaciones  = new ArrayList<>();
			validaciones.add(new ValidatorCantidadVehiculos(vehiculoService));
			validaciones.add(new ValidatorPlaca());
			
			for (IValidator validacion : validaciones) {
				validacion.verificar(vehiculo);
			}
			
			vehiculoService.guardar(vehiculo);
			
			//inicio factura
			FacturaEntity facturaEntity = FacturaBuilder.convertirAEntity(factura);
			facturaService.guardar(facturaEntity);
			
			
			
			if(vehiculo.getTipoVehiculo().getId() == Constantes.TipoVehiculo.MOTO 
					&& vehiculo.getCilindraje()>Constantes.Vehiculo.CILINDRAJE_AUMENTO_MOTO) {
				insertarTarifaFactura(Constantes.Tarifa.TARIFA_MOTO_CILINDRAJE, facturaEntity);
			}else if(vehiculo.getTipoVehiculo().getId() == Constantes.TipoVehiculo.MOTO){
				insertarTarifaFactura(Constantes.Tarifa.TARIFA_MOTO_HORA, facturaEntity);
			}else {
				insertarTarifaFactura(Constantes.Tarifa.TARIFA_CARRO_HORA, facturaEntity);
			}
			
		}catch(ValidationException e) {
			LOGGER.info(e.getMessage());
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
		
		
	}
	
	private void insertarTarifaFactura(Long tipoTarifa, FacturaEntity factura) throws Exception {
		if(Constantes.Tarifa.TARIFA_MOTO_CILINDRAJE == tipoTarifa) {
			TarifaEntity tarifaHora = tarifaService.findById(Constantes.Tarifa.TARIFA_MOTO_HORA).get();
			TarifaEntity tarifaCilindraje = tarifaService.findById(Constantes.Tarifa.TARIFA_MOTO_CILINDRAJE).get();
			TarifaFactura tarifaFacturaCilindraje = new TarifaFactura(factura, tarifaCilindraje);
			TarifaFactura tarifaFacturaHora = new TarifaFactura(factura, tarifaHora);
			List<TarifaFacturaEntity> tarifasFacturas = new ArrayList<>();
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaHora));
			tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFacturaCilindraje));
			tarifaFacturaService.guardarTodos(tarifasFacturas);
		}else {
			Optional<TarifaEntity> tarifa = tarifaService.findById(tipoTarifa);
			TarifaFactura tarifaFactura = new TarifaFactura(factura, tarifa.get());
			tarifaFacturaService.guardar(TarifaFacturaBuilder.convertirAEntity(tarifaFactura));
		}
		
	}

}
