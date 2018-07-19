package co.com.ceiba.estacionamiento.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public interface IVehiculoDAO extends JpaRepository<VehiculoEntity, Long> {
	
	@Query(value="SELECT COUNT(*) FROM VEHICULO AS V INNER JOIN FACTURA AS F ON V.ID = F.VEHICULO_ID WHERE V.TIPO_VEHICULO_ID=?1 AND F.FECHA_SALIDA IS NULL", nativeQuery=true)
	Integer findVehiculoByTipoVehiculoActivo(Long id);
	
	@Query(value="SELECT * FROM VEHICULO WHERE PLACA =?1", nativeQuery=true)
	VehiculoEntity findByPlaca(String placa);
	
	@Query(value="SELECT V.* FROM VEHICULO AS V INNER JOIN FACTURA AS F ON V.ID = F.VEHICULO_ID WHERE V.PLACA =?1 AND F.FECHA_SALIDA IS NULL", nativeQuery=true)
	VehiculoEntity findVehiculoByPlacaVehiculoActivo(String placa);
	
	@Query(value="SELECT V.* FROM VEHICULO AS V INNER JOIN FACTURA AS F ON V.ID = F.VEHICULO_ID WHERE FECHA_SALIDA IS NULL", nativeQuery=true)
	List<VehiculoEntity> findVehiculosActivos(); 


}
