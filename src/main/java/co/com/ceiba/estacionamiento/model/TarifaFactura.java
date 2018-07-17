package co.com.ceiba.estacionamiento.model;

import co.com.ceiba.estacionamiento.model.entity.FacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;

public class TarifaFactura {
	
	private FacturaEntity factura;
	
	private TarifaEntity tarifa;
	
	public TarifaFactura(FacturaEntity factur, TarifaEntity tarifaCilindraje) {
		this.factura = factur;
		this.tarifa = tarifaCilindraje;
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
