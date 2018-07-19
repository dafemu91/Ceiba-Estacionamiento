package co.com.ceiba.estacionamiento.databuilder;

import co.com.ceiba.estacionamiento.model.Tarifa;

public class TarifaTestDataBuilder {
	
	private static final double VALOR = 1000;
	private static final String DESCRPCION = "Moto hora";
	
	private double valor;
	private String descripcion;
	
	public TarifaTestDataBuilder() {
		this.descripcion = DESCRPCION;
		this.valor = VALOR;
	}
	
	public TarifaTestDataBuilder conDescripcion(String decripcion) {
		this.descripcion = decripcion;
		return this;
	}
	
	public TarifaTestDataBuilder conValor(double valor) {
		this.valor = valor;
		return this;
	}
	
	public Tarifa build() {
		return new Tarifa(this.descripcion, this.valor);
	}
	

}
