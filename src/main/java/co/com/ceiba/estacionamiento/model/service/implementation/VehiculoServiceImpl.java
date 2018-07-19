package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.IVehiculoDAO;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;

@Repository
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoDAO vehiculoDAO;
 
	@Transactional
	@Override
	public void eliminar(Long id) {
		vehiculoDAO.deleteById(id);
	}

	@Transactional
	@Override
	public void actualizar(VehiculoEntity vehiculo) {
		vehiculoDAO.save(vehiculo);
		
	}

	@Transactional
	@Override
	public void guardar(VehiculoEntity vehiculo) {
		vehiculoDAO.save(vehiculo);
		
	}

	@Transactional
	@Override
	public List<VehiculoEntity> findAll() {
		return vehiculoDAO.findAll();
	}

	@Transactional
	@Override
	public VehiculoEntity findById(Long id) {
		return findById(id);
	}

	@Transactional
	@Override
	public Integer findVehiculoByTipoVehiculoActivo(Long id) {
		return vehiculoDAO.findVehiculoByTipoVehiculoActivo(id);
		
	}

	@Override
	public VehiculoEntity findByPlaca(String placa) {
		return vehiculoDAO.findByPlaca(placa);
	}

	@Override
	public VehiculoEntity findVehiculoByPlacaVehiculoActivo(String placa) {
		return vehiculoDAO.findVehiculoByPlacaVehiculoActivo(placa);
	}

	@Override
	public List<VehiculoEntity> findVehiculosActivos() {
		return vehiculoDAO.findVehiculosActivos();
	}
	
	

}
