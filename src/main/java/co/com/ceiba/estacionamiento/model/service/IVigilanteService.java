package co.com.ceiba.estacionamiento.model.service;

import java.util.List;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public interface IVigilanteService {
	
	void registrarVehiculo(VehiculoEntity vehiculo);
	
	Factura generarFactura(String placa);
	
	List<Vehiculo> consultarVehiculo();

}
