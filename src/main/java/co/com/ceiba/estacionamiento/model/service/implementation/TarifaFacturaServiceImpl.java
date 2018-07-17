package co.com.ceiba.estacionamiento.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.model.dao.ITarifaFacturaDAO;
import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;
import co.com.ceiba.estacionamiento.model.service.ITarifaFacturaService;


@Repository
public class TarifaFacturaServiceImpl implements ITarifaFacturaService{

	@Autowired
	ITarifaFacturaDAO tarifaFacturaDAO; 
	
	@Transactional
	@Override
	public List<TarifaFacturaEntity> findAll() {
		return tarifaFacturaDAO.findAll();
	}

	@Transactional
	@Override
	public Optional<TarifaFacturaEntity> findById(Long id) {
		return tarifaFacturaDAO.findById(id);
	}

	@Transactional
	@Override
	public void actualizar(TarifaFacturaEntity tarifaFactura) {
		tarifaFacturaDAO.save(tarifaFactura);
	}

	@Transactional
	@Override
	public void guardar(TarifaFacturaEntity tarifaFactura) throws Exception {
		tarifaFacturaDAO.save(tarifaFactura);
	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		tarifaFacturaDAO.deleteById(id);
	}

	@Transactional
	@Override
	public void guardarTodos(List<TarifaFacturaEntity> tarifasFacturas) {
		tarifaFacturaDAO.saveAll(tarifasFacturas);
	}
	
	

}
