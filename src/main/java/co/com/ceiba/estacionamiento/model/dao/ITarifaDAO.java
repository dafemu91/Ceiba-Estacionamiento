package co.com.ceiba.estacionamiento.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;

public interface ITarifaDAO extends JpaRepository<TarifaEntity, Long>{

}
