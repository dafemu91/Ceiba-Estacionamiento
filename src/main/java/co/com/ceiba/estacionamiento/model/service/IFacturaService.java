package co.com.ceiba.estacionamiento.model.service;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;

public interface IFacturaService {
	
	/**
	 * Consultar todas las facturas
	 */
	List<FacturaEntity> findAll();
	
	/**
	 * Consultar factura por id
	 */
	Optional<FacturaEntity> findById(Long id);
		
	/**
	 * Editar factura
	 */
	void actualizar(FacturaEntity factura);
	
	/**
	 * Guardar factura
	 * @throws Exception 
	 */
	void guardar(FacturaEntity factura) throws Exception;
	
	/**
	 * eliminar factura
	 */
	void eliminar(Long id);

}
