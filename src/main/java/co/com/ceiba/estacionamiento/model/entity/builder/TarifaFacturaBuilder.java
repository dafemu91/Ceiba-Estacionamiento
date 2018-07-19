package co.com.ceiba.estacionamiento.model.entity.builder;

import co.com.ceiba.estacionamiento.model.TarifaFactura;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;

public class TarifaFacturaBuilder {
	
	public static TarifaFactura convertirAObject(TarifaFacturaEntity tarifaFacturaEntity) {
		FacturaEntity factura = tarifaFacturaEntity.getFactura();
		TarifaEntity tarifa = tarifaFacturaEntity.getTarifa();
		Integer cantidad = tarifaFacturaEntity.getCantidad();
		TarifaFactura tarifaFactura= null;
		if(tarifaFacturaEntity != null) {
			tarifaFactura = new TarifaFactura(factura, tarifa, cantidad);
		}
		return tarifaFactura;
	}
	
	public static TarifaFacturaEntity convertirAEntity(TarifaFactura tarifaFactura) {
		FacturaEntity factura = tarifaFactura.getFactura();
		TarifaEntity tarifa = tarifaFactura.getTarifa();
		Integer cantidad = tarifaFactura.getCantidad();
		TarifaFacturaEntity tarifaFacturaEntity = new TarifaFacturaEntity();
		tarifaFacturaEntity.setFactura(factura);
		tarifaFacturaEntity.setTarifa(tarifa);
		tarifaFacturaEntity.setCantidad(cantidad);
		return tarifaFacturaEntity;
	}

}
