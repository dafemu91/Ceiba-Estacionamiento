package co.com.ceiba.estacionamiento.model;

import java.io.Serializable;

import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;

public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String placa;
	private int cilindraje;
	private TipoVehiculo tipoVehiculo;
	
	public Vehiculo(String placa, int cilindraje, TipoVehiculo tipoVehiculo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
		
	}

	public String getPlaca() {
		return placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	
}
