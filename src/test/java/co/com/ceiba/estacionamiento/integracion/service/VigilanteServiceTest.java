package co.com.ceiba.estacionamiento.integracion.service;

import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.model.dao.IVehiculoDAO;
import co.com.ceiba.estacionamiento.model.service.implementation.VehiculoServiceImpl;

public class VigilanteServiceTest {
	
	@InjectMocks
	private VehiculoServiceImpl vehiculoService;
	
	@Mock
	private IVehiculoDAO vehiculoDAO;
	
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void registrarVehiculo() {
		
		
	}

}