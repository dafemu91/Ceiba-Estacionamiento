package co.com.ceiba.estacionamiento.model.service;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;

public interface ITipoVehiculoService {

	
	/**
	 * Guardar tipo vehiculo
	 * @param entity
	 */
	void guardar(TipoVehiculoEntity entity);
	
	
	/**
	 * Consultar todos los tipos de vehiculo
	 * @return
	 */
	List<TipoVehiculoEntity> findAll();
	
	/**
	 * Buscar tipo de vehiculo por id 
	 * @param id
	 * @return
	 */
	Optional<TipoVehiculoEntity> findById(Long id);
	
	/**
	 * Actualizar tipo vehiculo
	 * @param entity
	 */
	void update(TipoVehiculoEntity entity);
	
	/**
	 * Borrar tipo vehiculo
	 * @param id
	 */
	void delete(Long id);

}
