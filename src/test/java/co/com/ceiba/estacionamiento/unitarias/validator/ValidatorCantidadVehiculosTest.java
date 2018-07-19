package co.com.ceiba.estacionamiento.unitarias.validator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import co.com.ceiba.estacionamiento.model.service.IVehiculoService;
import co.com.ceiba.estacionamiento.model.service.implementation.VehiculoServiceImpl;

public class ValidatorCantidadVehiculosTest {
	
	@Test
	public void validar() {
		
		IVehiculoService vehiculoService = mock(VehiculoServiceImpl.class);
		
		when(vehiculoService.findVehiculoByTipoVehiculoActivo(1L)).thenReturn(10);
		when(vehiculoService.findVehiculoByTipoVehiculoActivo(2L)).thenReturn(20);
		
		assertEquals((Integer) 10, vehiculoService.findVehiculoByTipoVehiculoActivo(1L));
	}

}
