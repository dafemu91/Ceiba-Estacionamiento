package co.com.ceiba.estacionamiento.model;

import java.io.Serializable;
import java.util.Date;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private VehiculoEntity vehiculo;
	private double valorFinal;

	public Factura(String descripcion, Date fechaIngreso, Date fechaSalida, VehiculoEntity vehiculo, double valorFinal) {
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
		this.valorFinal = valorFinal;
	}

	public Factura(String descripcion, Date fechaIngreso, VehiculoEntity vehiculo) {
		this.descripcion =  descripcion;
		this.fechaIngreso = fechaIngreso;
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}
	
	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	
	

}
