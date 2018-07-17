package co.com.ceiba.estacionamiento.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;

public interface ITarifaFacturaDAO extends JpaRepository<TarifaFacturaEntity, Long> { 

}
