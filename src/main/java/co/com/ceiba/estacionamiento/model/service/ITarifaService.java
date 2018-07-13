package co.com.ceiba.estacionamiento.model.service;

import java.util.List;

import co.com.ceiba.estacionamiento.model.Tarifa;


public interface ITarifaService {
	
	/**
	 * Consultar todas las tarifa
	 */
	List<Tarifa> findAll();
	
	/**
	 * Consultar tarifa por id
	 */
	Tarifa findById(int id);
		
	/**
	 * Editar tarifa
	 */
	void actualizar(Tarifa tarifa);
	
	/**
	 * Guardar tarifa
	 */
	void guardar(Tarifa tarifa);
	
	/**
	 * eliminar tarifa
	 */
	void eliminar(int id);

}
