package co.com.ceiba.estacionamiento.model.entity.builder;

import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public class VehiculoBuilder {
	
	private VehiculoBuilder() {}
	
	public static Vehiculo convertirAObject(VehiculoEntity vehiculoEntity) {
		TipoVehiculo tipoVehiculo = TipoVehiculoBuilder.convertirAObject(vehiculoEntity.getTipoVehiculo());
		Vehiculo vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new Vehiculo(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(), tipoVehiculo);
		}
		return vehiculo;
	}
	
	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {
		TipoVehiculoEntity tipoVehiculoEntity = TipoVehiculoBuilder.convertirAEntity(vehiculo.getTipoVehiculo());
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setTipoVehiculo(tipoVehiculoEntity);
		return vehiculoEntity;
	}

}
