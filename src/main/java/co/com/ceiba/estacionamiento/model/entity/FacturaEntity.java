package co.com.ceiba.estacionamiento.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="factura")
public class FacturaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String descripcion;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaIngreso;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaSalida;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private VehiculoEntity vehiculo;

	@OneToMany(mappedBy="tarifa", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	public List<TarifaFacturaEntity> tarifaFacturas;
	
	private double valorFinal;
	
	public FacturaEntity() {
		tarifaFacturas = new ArrayList<TarifaFacturaEntity>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}
	public List<TarifaFacturaEntity> getTarifaFacturas() {
		return tarifaFacturas;
	}

	public void setTarifaFacturas(List<TarifaFacturaEntity> tarifaFacturas) {
		this.tarifaFacturas = tarifaFacturas;
	}
	
	public void addTarifaFactura(TarifaFacturaEntity tarifaFactura) {
		this.tarifaFacturas.add(tarifaFactura);
	}

	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	

}
