package co.com.ceiba.estacionamiento.model;

import java.io.Serializable;

public class TipoVehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
