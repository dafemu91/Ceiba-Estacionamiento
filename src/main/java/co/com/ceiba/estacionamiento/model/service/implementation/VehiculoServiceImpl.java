package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.IVehiculoDAO;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;

@Transactional
@Repository
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoDAO vehiculoDAO;

	@Override
	public void eliminar(Long id) {
		vehiculoDAO.deleteById(id);
	}

	@Override
	public void actualizar(VehiculoEntity vehiculo) {
		vehiculoDAO.save(vehiculo);
		
	}

	@Override
	public void guardar(VehiculoEntity vehiculo) {
		vehiculoDAO.save(vehiculo);
		
	}

	@Override
	public List<VehiculoEntity> findAll() {
		return vehiculoDAO.findAll();
	}

	@Override
	public VehiculoEntity findById(Long id) {
		return findById(id);
	}

}
