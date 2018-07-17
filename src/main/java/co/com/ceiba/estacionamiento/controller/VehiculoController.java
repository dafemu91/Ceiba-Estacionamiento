package co.com.ceiba.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.model.entity.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.IVehiculoService;


@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
	
	@Autowired
	IVehiculoService vehiculoService;
	
	@PostMapping("/registrarVehiculo")
	public void registarVehiculo(@RequestBody VehiculoEntity vehiculo) {
		vehiculoService.guardar(vehiculo);
	}

}
