package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.IFacturaDAO;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.service.IFacturaService;

@Transactional
@Repository
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	IFacturaDAO facturaDAO;
	
	@Override
	public List<FacturaEntity> findAll() {
		return facturaDAO.findAll();
	}

	@Override
	public Optional<FacturaEntity> findById(Long id) {
		return facturaDAO.findById(id);
	}

	@Override
	public void actualizar(FacturaEntity factura) {
		facturaDAO.save(factura);
	}

	@Override
	public void guardar(FacturaEntity factura) throws Exception {
		facturaDAO.save(factura);
	}

	@Override
	public void eliminar(Long id) {
		facturaDAO.deleteById(id);
	}
	

}
