package co.com.ceiba.estacionamiento.model.validator.implementation;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.IVehiculoDAO;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;
import co.com.ceiba.estacionamiento.model.service.implementation.VehiculoServiceImpl;
import co.com.ceiba.estacionamiento.model.validator.IValidator;
import co.com.ceiba.estacionamiento.util.Constantes;

public class ValidatorCantidadVehiculos implements IValidator {
	
	IVehiculoService vehiculoService;
	
	public ValidatorCantidadVehiculos(IVehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	@Transactional 
	@Override
	public void verificar(VehiculoEntity vehiculo) {
		Long idTipoVehiculo = vehiculo.getTipoVehiculo().getId();
		if(idTipoVehiculo == Constantes.TipoVehiculo.MOTO) {
			Integer cantidadMotos = vehiculoService.findVehiculoByTipoVehiculoActivo(idTipoVehiculo);
			if(cantidadMotos>Constantes.TipoVehiculo.CANTIDAD_MAXIMA_MOTOS) {
				throw new ValidationException(Constantes.Excepciones.SIN_CUPO);
			}
		}else if(idTipoVehiculo == Constantes.TipoVehiculo.CARRO) {
			int cantidadCarros = vehiculoService.findVehiculoByTipoVehiculoActivo(idTipoVehiculo);
			if(cantidadCarros>Constantes.TipoVehiculo.CANTIDAD_MAXIMA_CARROS) {
				throw new ValidationException(Constantes.Excepciones.SIN_CUPO);
			}
		}
		
	}
	
	

}
