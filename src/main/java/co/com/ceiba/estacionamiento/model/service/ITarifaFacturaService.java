package co.com.ceiba.estacionamiento.model.service;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;

public interface ITarifaFacturaService {
	
	/**
	 * Consultar todos los registros de tarifa_factura
	 */
	List<TarifaFacturaEntity> findAll();
	
	/**
	 * Consultar tarifa_factura por id
	 */
	Optional<TarifaFacturaEntity> findById(Long id);
	
	/**
	 * Editar tarifa_factura
	 */
	void actualizar(TarifaFacturaEntity tarifaFactura);
	
	/**
	 * Guardar tarifa_factura
	 * @throws Exception 
	 */
	void guardar(TarifaFacturaEntity tarifaFactura) throws Exception;
	
	/**
	 * eliminar registro tarifa_factura
	 */
	void eliminar(Long id);

}
