package co.com.ceiba.estacionamiento.model.entity.builder;

import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.entity.TarifaEntity;

public class TarifaBuilder {
	private TarifaBuilder() {}
	
	public static Tarifa convertirAObject(TarifaEntity tarifaEntity) {
		Tarifa tarifa = null;
		if(tarifaEntity != null) {
			tarifa = new Tarifa();
			tarifa.setDescripcion(tarifaEntity.getDescripcion());
			tarifa.setValor(tarifaEntity.getValor());
		}
		return tarifa;
	}
	
	public static TarifaEntity convertirAEntity(Tarifa tarifa) {
		TarifaEntity tarifaEntity = new TarifaEntity();
		tarifaEntity.setDescripcion(tarifa.getDescripcion());
		tarifaEntity.setValor(tarifa.getValor());
		return tarifaEntity;
	}
}
