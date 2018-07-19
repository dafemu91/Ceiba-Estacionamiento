package co.com.ceiba.estacionamiento.model.validator.implementation;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;
import co.com.ceiba.estacionamiento.model.validator.IValidator;
import co.com.ceiba.estacionamiento.model.validator.exception.ValidatorException;
import co.com.ceiba.estacionamiento.util.Constantes;

public class ValidadorVehiculoParqueado implements IValidator {

	IVehiculoService vehiculoService;
	
	public ValidadorVehiculoParqueado(IVehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}
	
	@Override
	public void verificar(VehiculoEntity vehiculo) {
		VehiculoEntity vehiculoEntity = vehiculoService.findVehiculoByPlacaVehiculoActivo(vehiculo.getPlaca());
		if(vehiculoEntity!=null) {
			throw new ValidatorException(Constantes.Excepciones.VEHICULO_DENTRO);
		}

	}

}
