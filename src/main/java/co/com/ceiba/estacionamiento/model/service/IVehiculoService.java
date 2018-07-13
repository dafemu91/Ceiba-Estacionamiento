package co.com.ceiba.estacionamiento.model.service;

import java.util.List;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public interface IVehiculoService {

	/**
	 * Consultar todos los vehiculos
	 */
	List<VehiculoEntity> findAll();
	
	/**
	 * Consultar vehiculo por id
	 */
	VehiculoEntity findById(Long id);
		
	/**
	 * Editar vehiculo
	 */
	void actualizar(VehiculoEntity vehiculo);
	
	/**
	 * Guardar vehiculo
	 */
	void guardar(VehiculoEntity vehiculo);
	
	/**
	 * eliminar vehiculo
	 */
	void eliminar(Long id);
}
