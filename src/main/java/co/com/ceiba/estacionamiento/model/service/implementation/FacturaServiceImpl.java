package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.IFacturaDAO;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.service.IFacturaService;

@Repository
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	IFacturaDAO facturaDAO;
	
	@Transactional
	@Override
	public List<FacturaEntity> findAll() {
		return facturaDAO.findAll();
	}

	@Transactional
	@Override
	public Optional<FacturaEntity> findById(Long id) {
		return facturaDAO.findById(id);
	}

	@Transactional
	@Override
	public void actualizar(FacturaEntity factura) {
		facturaDAO.save(factura);
	}
	
	@Transactional
	@Override
	public void guardar(FacturaEntity factura) throws Exception {
		facturaDAO.save(factura);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		facturaDAO.deleteById(id);
	}
	

}
