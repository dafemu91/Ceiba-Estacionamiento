package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.ITarifaDAO;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.service.ITarifaService;

@Repository
public class TarifaServiceImpl implements ITarifaService{
	
	@Autowired
	ITarifaDAO tarifaDAO;

	@Transactional
	@Override
	public List<TarifaEntity> findAll() {
		return tarifaDAO.findAll();
	}

	@Transactional
	@Override
	public void actualizar(TarifaEntity tarifa) {
		tarifaDAO.save(tarifa);
	}

	@Transactional
	@Override
	public void guardar(TarifaEntity tarifa) {
		tarifaDAO.save(tarifa);
		
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		tarifaDAO.deleteById(id);
	}

	@Transactional
	@Override
	public Optional<TarifaEntity> findById(Long id) {
		return tarifaDAO.findById(id);
	}

}
