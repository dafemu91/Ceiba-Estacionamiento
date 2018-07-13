package co.com.ceiba.estacionamiento.model.entity.builder;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;

public class FacturaBuilder {
	
	private FacturaBuilder() {}
	
	public static Factura convertirAObject(FacturaEntity facturaEntity) {
		Vehiculo vehiculo=VehiculoBuilder.convertirAObject(facturaEntity.getVehiculo());
		Factura factura= null;
		if(facturaEntity != null) {
			factura = new Factura(facturaEntity.getDescripcion(), facturaEntity.getFechaIngreso(), facturaEntity.getFechaSalida(),
					vehiculo, facturaEntity.getValorFinal());
		}
		return factura;
	}
	
	public static FacturaEntity convertirAEntity(Factura factura) {
		VehiculoEntity vehiculoEntity = VehiculoBuilder.convertirAEntity(factura.getVehiculo());
		FacturaEntity facturaEntity = new FacturaEntity();
		facturaEntity.setDescripcion(factura.getDescripcion());
		facturaEntity.setFechaIngreso(factura.getFechaIngreso());
		facturaEntity.setFechaSalida(factura.getFechaSalida());
		facturaEntity.setVehiculo(vehiculoEntity);
		facturaEntity.setValorFinal(factura.getValorFinal());
		return facturaEntity;
	}

}
