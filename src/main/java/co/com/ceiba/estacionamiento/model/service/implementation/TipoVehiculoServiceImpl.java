package co.com.ceiba.estacionamiento.model.service.implementation;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.model.dao.ITipoVehiculoDAO;
import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.ITipoVehiculoService;

@Repository
@Transactional
public class TipoVehiculoServiceImpl implements ITipoVehiculoService{
	
	@Autowired
	private ITipoVehiculoDAO tipoVehiculoDAO;
	
	public List<TipoVehiculoEntity> findAll() {
		return (List<TipoVehiculoEntity>) tipoVehiculoDAO.findAll(); 
	}

	@Override
	public Optional<TipoVehiculoEntity> findById(Long id) {
		return tipoVehiculoDAO.findById(id);
	}

	@Override
	public void update(TipoVehiculoEntity tipoVehiculoEntity) {
		tipoVehiculoDAO.save(tipoVehiculoEntity);
		
	}

	@Override
	public void delete(Long id) {
		tipoVehiculoDAO.deleteById(id);
		
	}

	@Override
	public void guardar(TipoVehiculoEntity entity) {
		tipoVehiculoDAO.save(entity);
	}

}
