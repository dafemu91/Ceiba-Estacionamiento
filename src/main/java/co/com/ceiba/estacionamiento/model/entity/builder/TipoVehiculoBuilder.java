package co.com.ceiba.estacionamiento.model.entity.builder;

import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;

public class TipoVehiculoBuilder {
	private TipoVehiculoBuilder() {}
	
	public static TipoVehiculo convertirAObject(TipoVehiculoEntity tipoVehiculoEntity) {
		TipoVehiculo tipoVehiculo = null;
		if(tipoVehiculoEntity != null) {
			tipoVehiculo = new TipoVehiculo();
			tipoVehiculo.setDescripcion(tipoVehiculoEntity.getDescripcion());
		}
		return tipoVehiculo;
	}
	
	public static TipoVehiculoEntity convertirAEntity(TipoVehiculo tipoVehiculo) {
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setDescripcion(tipoVehiculo.getDescripcion());
		return tipoVehiculoEntity;
	}
}
