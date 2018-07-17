package co.com.ceiba.estacionamiento.integracion.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.implementation.TipoVehiculoServiceImpl;

public class TipoVehiculoDAOTest {
	
	@Test
	public void agregar() {
		int success = 1;
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setDescripcion("moto");
		TipoVehiculoServiceImpl tipoDao = new TipoVehiculoServiceImpl();
		try {
			tipoDao.guardar(tipoVehiculoEntity);
		} catch (Exception e) {
			success = 0;
		}
		
		assertEquals(1, success);
	}

}
