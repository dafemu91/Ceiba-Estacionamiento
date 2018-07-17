package co.com.ceiba.estacionamiento.model.service;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;


public interface ITarifaService {
	
	/**
	 * Consultar todas las tarifa
	 */
	List<TarifaEntity> findAll();
	
	/**
	 * Consultar tarifa por id
	 */
	Optional<TarifaEntity> findById(Long id);
		
	/**
	 * Editar tarifa
	 */
	void actualizar(TarifaEntity tarifa);
	
	/**
	 * Guardar tarifa
	 */
	void guardar(TarifaEntity tarifa);
	
	/**
	 * eliminar tarifa
	 */
	void eliminar(Long id);

}
