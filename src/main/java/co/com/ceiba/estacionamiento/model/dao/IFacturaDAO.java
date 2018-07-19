package co.com.ceiba.estacionamiento.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;

public interface IFacturaDAO extends JpaRepository<FacturaEntity, Long>{
	
	@Query(value="SELECT F.* FROM FACTURA AS F INNER JOIN VEHICULO AS V ON F.VEHICULO_ID = V.ID WHERE V.PLACA =?1 AND F.FECHA_SALIDA IS NULL", nativeQuery=true)
	FacturaEntity findFacturaVehiculoByPlaca(String placa);
	

}
