package co.com.ceiba.estacionamiento.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;

public interface ITarifaFacturaDAO extends JpaRepository<TarifaFacturaEntity, Long> { 
	
	@Query(value="SELECT * FROM TARIFA_FACTURA WHERE FACTURA_ID =?1", nativeQuery=true)
	List<TarifaFacturaEntity> findTarifasFacturasByIdFactura(Long idFactura);
	
}
