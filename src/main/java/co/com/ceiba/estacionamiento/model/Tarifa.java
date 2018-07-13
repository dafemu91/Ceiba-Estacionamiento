package co.com.ceiba.estacionamiento.model;

import java.io.Serializable;

public class Tarifa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private double valor;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
