package co.com.ceiba.estacionamiento.util;

public class Constantes {
	
	public static class TipoVehiculo{
		public static final Long MOTO = 1L;
		public static final Long CARRO = 2L;
		
		public static final int CANTIDAD_MAXIMA_MOTOS = 10;
		public static final int CANTIDAD_MAXIMA_CARROS = 20;
	}
	
	public static class Excepciones{
		public static final String VEHICULO_NO_AUTORIZADO = "Vehiculo no esta autorizado a ingresar";
		public static final String SIN_CUPO = "No hay cupo para el vehiculo";
		public static final String VEHICULO_DENTRO ="El vehiculo se encuentra en el parqueadero";
		public static final String NO_HAY_VEHICULOS ="No se encuentran vehiculos en el parqueadero";
	}
	
	public static class Mensajes{
		//descripcion factura
		public static final String FACTURA_VEHICULO = "Factura vehiculo";
	}
	
	public static final class Vehiculo{
		public static final int CILINDRAJE_AUMENTO_MOTO = 500; 
	}
	
	public static final class Tarifa{
		//tipos de tarifa
		public static final Long TARIFA_MOTO_CILINDRAJE = 5L;
		public static final Long TARIFA_MOTO_DIA = 3L;
		public static final Long TARIFA_CARRO_DIA = 4L; 
		public static final Long TARIFA_MOTO_HORA = 1L;
		public static final Long TARIFA_CARRO_HORA = 2L;
	}
	
	public static final class Fechas{
		public static final String FORMATO_FECHA="yyyy/MM/dd hh:mm:ss";
	}

}
