package co.com.ceiba.estacionamiento.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;

public interface IFacturaDAO extends JpaRepository<FacturaEntity, Long>{
	

}
