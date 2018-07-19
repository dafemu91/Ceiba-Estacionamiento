package co.com.ceiba.estacionamiento.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="vehiculo")
public class VehiculoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String placa;
	
	@NotNull
	private int cilindraje;
	
	
	@OneToMany(mappedBy="vehiculo", cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<FacturaEntity> facturas;
	
	@ManyToOne
	@JoinColumn(name="tipo_vehiculo_id")
	private TipoVehiculoEntity tipoVehiculo;
	
	public VehiculoEntity() {
		facturas = new ArrayList<FacturaEntity>();
	}
	
	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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
	public List<FacturaEntity> getFacturas() {
		return facturas;
	} 
	public void setFacturas(List<FacturaEntity> facturas) {
		this.facturas = facturas;
	}
	

}
