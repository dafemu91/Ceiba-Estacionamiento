package co.com.ceiba.estacionamiento.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public interface IVehiculoDAO extends JpaRepository<VehiculoEntity, Long> {
	
//	@Query(value="SELECT count(v.id) FROM VehiculoEntity v INNER JOIN FacturaEntity f WHERE v.idTipoVehiculo =:id AND f.fechaSalida IS NULL")
//	@Query(value="SELECT COUNT(*) FROM VEHICULO AS V INNER JOIN FACTURA AS F ON V.ID = F.VEHICULO_ID WHERE V.TIPO_VEHICULO_ID=?1 AND F.FECHA_SALIDA IS NULL", nativeQuery=true)
	@Query(value="SELECT COUNT(*) FROM TIPO_VEHICULO AS TV WHERE TV.ID =?1", nativeQuery=true)
	Integer findVehiculoByTipoVehiculoActivo(Long id);
	
	@Query(value="SELECT v FROM VehiculoEntity v INNER JOIN FacturaEntity f WHERE v.placa =:placa AND f.fechaSalida IS NULL")
	VehiculoEntity findVehiculoByPlacaVehiculoActivo(@Param("placa") String placa);


}
