package co.com.ceiba.estacionamiento.databuilder;

import java.util.Date;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.entity.builder.VehiculoBuilder;

public class FacturaTestDataBuilder {
	
	@SuppressWarnings("deprecation")
	private static final Date FECHA_INGRESO = new Date("18/7/2018 22:00");
	private static final Date FECHA_SALIDA = new Date("19/7/2018 22:00");
	private static final String DESCRIPCION = "Factura vehiculo";
	private static final double VALOR_FINAL = 2500;
	Vehiculo vehiculoTest = new VehiculoTestDataBuilder().build();
	
	private Vehiculo vehiculo;
	private String descripcion;
	private Date fechaIngreso;
	
	@SuppressWarnings("unused")
	private Date fechaSalida;
	
	@SuppressWarnings("unused")
	private double valorFinal;
	
	public FacturaTestDataBuilder() {
		this.vehiculo = vehiculoTest;
		this.descripcion = DESCRIPCION;
		this.fechaIngreso = FECHA_INGRESO;
		this.fechaSalida = FECHA_SALIDA;
		this.valorFinal = VALOR_FINAL;
	}
	
	public FacturaTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public FacturaTestDataBuilder conValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
		return this;
	}
	
	public Factura build() {
		VehiculoEntity vehiculoEntity = VehiculoBuilder.convertirAEntity(this.vehiculo);
		return new Factura(this.descripcion, this.fechaIngreso, vehiculoEntity);
	}

	
	
	

}
