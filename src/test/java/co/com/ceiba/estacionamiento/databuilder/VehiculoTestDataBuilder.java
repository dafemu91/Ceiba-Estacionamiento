package co.com.ceiba.estacionamiento.databuilder;

import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final String PLACA = "MLL799";
	private static final int CILINDRJE= 100;
	private static final String DESCRIPCION_TIPO_VEHICULO = "moto";
	
	TipoVehiculo tipoVehiculoPrueba = new TipoVehiculo();
	
	
	private String placa;
	private int cilindraje;
	private TipoVehiculo tipoVehiculo;

	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRJE;
		this.tipoVehiculo = tipoVehiculoPrueba;
		tipoVehiculo.setDescripcion(DESCRIPCION_TIPO_VEHICULO);
	}

	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
		tipoVehiculo.setDescripcion(DESCRIPCION_TIPO_VEHICULO);
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public Vehiculo build() {
		return new Vehiculo(this.placa, this.cilindraje, this.tipoVehiculo);
	}
}
