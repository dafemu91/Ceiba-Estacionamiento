package co.com.ceiba.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
