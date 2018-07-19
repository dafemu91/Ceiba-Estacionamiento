package co.com.ceiba.estacionamiento.model;

import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;

public class TarifaFactura {
	
	private FacturaEntity factura;
	
	private TarifaEntity tarifa;
	
	private Integer cantidad;
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public TarifaFactura(FacturaEntity factura, TarifaEntity tarifaCilindraje) {
		this.factura = factura;
		this.tarifa = tarifaCilindraje;
		this.cantidad = 0;
	}

	public TarifaFactura(FacturaEntity factura, TarifaEntity tarifaCilindraje, int cantidad) {
		this.factura = factura;
		this.tarifa = tarifaCilindraje;
		this.cantidad = cantidad;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	public TarifaEntity getTarifa() {
		return tarifa;
	}

	public void setTarifa(TarifaEntity tarifa) {
		this.tarifa = tarifa;
	}

	
	
	

}
