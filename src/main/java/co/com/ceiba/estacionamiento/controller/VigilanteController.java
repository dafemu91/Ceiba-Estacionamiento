package co.com.ceiba.estacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.model.Factura;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.IVigilanteService;

@RestController
@RequestMapping("/vigilante")
public class VigilanteController {
	
	@Autowired
	IVigilanteService vigilanteService;

	@PostMapping("/registrarVehiculo")
	public void registrarVehiculo(@RequestBody VehiculoEntity vehiculo) {
		vigilanteService.registrarVehiculo(vehiculo);
	}
	
	@PostMapping("/generarFactura/{placa}")
	public Factura generarFactura(@PathVariable String placa) {
		return vigilanteService.generarFactura(placa);
	}
	
	@GetMapping("/listarVehiculos")
	public List<Vehiculo> consultarVehiculos(){
		return vigilanteService.consultarVehiculo();
	}
	
}
