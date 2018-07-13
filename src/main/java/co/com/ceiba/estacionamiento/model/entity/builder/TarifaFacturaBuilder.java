package co.com.ceiba.estacionamiento.model.entity.builder;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.TarifaFactura;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;

public class TarifaFacturaBuilder {
	
	public static TarifaFactura convertirAObject(TarifaFacturaEntity tarifaFacturaEntity) {
		Factura factura = FacturaBuilder.convertirAObject(tarifaFacturaEntity.getFactura());
		Tarifa tarifa = TarifaBuilder.convertirAObject(tarifaFacturaEntity.getTarifa());
		TarifaFactura tarifaFactura= null;
		if(tarifaFacturaEntity != null) {
			tarifaFactura = new TarifaFactura(factura, tarifa);
		}
		return tarifaFactura;
	}
	
	public static TarifaFacturaEntity convertirAEntity(TarifaFactura tarifaFactura) {
		FacturaEntity factura = FacturaBuilder.convertirAEntity(tarifaFactura.getFactura());
		TarifaEntity tarifa = TarifaBuilder.convertirAEntity(tarifaFactura.getTarifa());
		TarifaFacturaEntity tarifaFacturaEntity = new TarifaFacturaEntity();
		tarifaFacturaEntity.setFactura(factura);
		tarifaFacturaEntity.setTarifa(tarifa);
		return tarifaFacturaEntity;
	}

}
