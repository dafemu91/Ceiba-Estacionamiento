package co.com.ceiba.estacionamiento.model;

public class TarifaFactura {
	
	private Factura factura;
	
	private Tarifa tarifa;
	
	public TarifaFactura(Factura factura, Tarifa tarifa) {
		this.factura = factura;
		this.tarifa = tarifa;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	
	
	

}
