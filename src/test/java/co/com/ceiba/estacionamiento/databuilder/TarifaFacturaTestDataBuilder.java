package co.com.ceiba.estacionamiento.databuilder;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.TarifaFactura;
import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;
import co.com.ceiba.estacionamiento.model.entity.builder.FacturaBuilder;
import co.com.ceiba.estacionamiento.model.entity.builder.TarifaBuilder;

public class TarifaFacturaTestDataBuilder {
	
	private static final int CANTIDAD = 20;
	private static final Tarifa TARIFA = new TarifaTestDataBuilder().build();
	private static final Factura FACTURA = new FacturaTestDataBuilder().build();
	
	private Tarifa tarifa;
	private Factura factura;
	private int cantidad;
	
	public TarifaFacturaTestDataBuilder() {
		this.tarifa = TARIFA;
		this.factura = FACTURA;
		this.cantidad = CANTIDAD;
	}
	
	public TarifaFacturaTestDataBuilder conCantidad(int cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	
	public TarifaFactura build() {
		FacturaEntity facturaEntity = FacturaBuilder.convertirAEntity(this.factura);
		TarifaEntity tarifaEntity = TarifaBuilder.convertirAEntity(this.tarifa);
		return new TarifaFactura(facturaEntity, tarifaEntity, this.cantidad);
	}

}
