package co.com.ceiba.estacionamiento.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;

public interface ITipoVehiculoDAO extends JpaRepository<TipoVehiculoEntity, Long> {
	
}
