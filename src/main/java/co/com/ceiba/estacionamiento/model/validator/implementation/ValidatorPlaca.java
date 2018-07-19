package co.com.ceiba.estacionamiento.model.validator.implementation;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.validation.ValidationException;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.validator.IValidator;
import co.com.ceiba.estacionamiento.util.Constantes;

public class ValidatorPlaca implements IValidator{

	@Override
	public void verificar(VehiculoEntity vehiculo) {
		LocalDateTime fechaActual = LocalDateTime.now();
		if(vehiculo.getPlaca().startsWith("A") && 
				(fechaActual.getDayOfWeek()==DayOfWeek.SUNDAY || fechaActual.getDayOfWeek()==DayOfWeek.MONDAY)) {
			throw new ValidationException(Constantes.Excepciones.VEHICULO_NO_AUTORIZADO);
		}
	}
	
	

}
