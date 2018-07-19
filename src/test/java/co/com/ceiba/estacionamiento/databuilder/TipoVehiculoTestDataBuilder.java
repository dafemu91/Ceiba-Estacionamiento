package co.com.ceiba.estacionamiento.databuilder;

import co.com.ceiba.estacionamiento.model.TipoVehiculo;

public class TipoVehiculoTestDataBuilder {
	
	private static final String DESCRIPCION_TIPO_VEHICULO = "moto";
	
	private String descripcion;

	public TipoVehiculoTestDataBuilder() {
		this.descripcion = DESCRIPCION_TIPO_VEHICULO;
	}
	
	public TipoVehiculoTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public TipoVehiculo build() {
		return new TipoVehiculo(this.descripcion);
	}
}