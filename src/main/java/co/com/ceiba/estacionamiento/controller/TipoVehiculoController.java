package co.com.ceiba.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.model.entity.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.model.service.ITipoVehiculoService;

@RestController
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoController {
	
	@Autowired
	private ITipoVehiculoService tipoVehiculoService;
	
	@PostMapping("/crearTipoVehiculo")
	public void guardar(@RequestBody TipoVehiculoEntity tipoVehiculoEntity) {
		tipoVehiculoService.guardar(tipoVehiculoEntity);
	}
	
	
	

}
