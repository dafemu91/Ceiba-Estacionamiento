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
	
	/**
	 * consultar vehiulo por tipo y si esta en el parqueadero
	 * @param id
	 * @return
	 */
	Integer findVehiculoByTipoVehiculoActivo(Long id);
	
	/**
	 * consultar vehiculo por placa
	 */
	VehiculoEntity findByPlaca(String placa);
	
	/**
	 * consultar vehiculo por placa
	 */
	VehiculoEntity findVehiculoByPlacaVehiculoActivo(String placa);
	
	/**
	 * Consultar vehiculos activos en el parqueadero
	 */
	List<VehiculoEntity> findVehiculosActivos(); 
}
