package co.com.ceiba.estacionamiento.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tarifa_factura")
public class TarifaFacturaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private FacturaEntity factura;
	
	
	@NotNull
	@Column(name="tarifa_id")
	private Long idTarifa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tarifa_id", insertable= false, updatable=false)
	private TarifaEntity tarifa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	public Long getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public TarifaEntity getTarifa() {
		return tarifa;
	}

	public void setTarifa(TarifaEntity tarifa) {
		this.tarifa = tarifa;
	}
	
	
	
	
	

}
