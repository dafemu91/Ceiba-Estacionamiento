package co.com.ceiba.estacionamiento.model.validator;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public interface IValidator {
	
	void verificar(VehiculoEntity vehiculo);

}
