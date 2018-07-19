package co.com.ceiba.estacionamiento.unitarias.model.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.estacionamiento.databuilder.TarifaFacturaTestDataBuilder;
import co.com.ceiba.estacionamiento.model.TarifaFactura;
import co.com.ceiba.estacionamiento.model.entity.TarifaFacturaEntity;
import co.com.ceiba.estacionamiento.model.entity.builder.TarifaFacturaBuilder;
import co.com.ceiba.estacionamiento.model.service.implementation.VigilanteServiceImpl;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class VigilanteServiceTest {
	
	@InjectMocks
	VigilanteServiceImpl vigilanteService;
	
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void calcularDiasHoras() {
		Date fechaInicio = new Date("18/07/2018 05:00");
		Date fechaFin = new Date("18/07/2018 05:00");
		
		
	}
	
	@Test
	public void calcularValor() {
		List<TarifaFacturaEntity> tarifasFacturas = new ArrayList<>();
		TarifaFactura  tarifaFactura = new TarifaFacturaTestDataBuilder().build();
		tarifasFacturas.add(TarifaFacturaBuilder.convertirAEntity(tarifaFactura));
		
		double valor = vigilanteService.calcularValorTotal(tarifasFacturas);
		
		assertEquals((double)20000, valor, 0.001);
		
		
		
		
	}

}
