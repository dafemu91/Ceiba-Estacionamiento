package co.com.ceiba.estacionamiento.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="vehiculo")
public class VehiculoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String placa;
	
	@NotEmpty
	private int cilindraje;
	
	@NotNull
	@Column(name="tipo_vehiculo_id")
	private Long idTipoVehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_vehiculo_id", insertable= false, updatable=false)
	private TipoVehiculoEntity tipoVehiculo;
	
	@OneToMany(mappedBy="vehiculo", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	public List<FacturaEntity> facturas;
	
	public VehiculoEntity() {
		facturas = new ArrayList<FacturaEntity>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public List<FacturaEntity> getFacturas(){
		return facturas;
	}
	
	public void setFacturas(List<FacturaEntity> facturas) {
		this.facturas = facturas;
	}
	
	public void addFactura(FacturaEntity factura) {
		this.facturas.add(factura);
	}
	

}
