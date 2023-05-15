package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class PuebaCasaDeElectrodomesticos {

	@Test
	public void queSePuedaInstanciarUnaTienda() {
	
		//preparacion
		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		
		//ejecucion
		tienda = new Tienda(NOMBRE,CUIT);
		
		//validacion
		assertNotNull(tienda);
		
	}
	
	@Test
	public void queSePuedanAgregarProductosALaTienda() {
	
		//preparacion
		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
		Lavarropa lavarropa1;
		Televisor televisor1;
		Refrigerador refrigerador1; 
		final Integer CANTIDAD_DE_PRODUCTOS_AGREGADOS = 3; 
		
		//ejecucion
		lavarropa1 = new Lavarropa(1,"Lavadora 1", 600.0, 3, "Marca 1", "Modelo 1", "Tipo 1", 30, "Superior");
		televisor1 = new Televisor(2, "Televisor 1", 500.0, 5, "Marca 2", "Modelo 2", "Tipo 2", 50, "Full HD");
		refrigerador1 = new Refrigerador(3, "Refrigerador 1", 800.0, 3, "Marca 3", "Modelo 3", "Tipo 3", 400, "Enfriamiento Directo");
		
		tienda.agregarProducto(lavarropa1);
		tienda.agregarProducto(televisor1);
		tienda.agregarProducto(refrigerador1);
		
		//validacion
		assertEquals(CANTIDAD_DE_PRODUCTOS_AGREGADOS, tienda.getCantidadProductos() );
		
	}
	@Test
	public void queElToStringDeTiendaMuestreLosElectrodomesticosDisponibles() {
	
		//preparacion
		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
		Lavarropa lavarropa1;
		lavarropa1 = new Lavarropa(1,"Lavadora 1", 600.0, 3, "Marca 1", "Modelo 1", "Tipo 1", 30, "Superior");
		String resultadoEsperado = "||Producto: Lavadora 1 Precio: 600.0 Codigo: 1 Cantidad Disponible: 3 Marca: Marca 1 Modelo: Modelo 1 Tipo: Tipo 1 Capacidad: 30 Tipo de Carga: Superior";
		
		//ejecucion
		
		tienda.agregarProducto(lavarropa1);
		
		
		//validacion
		assertEquals(resultadoEsperado,tienda.toString());
	}
	
	@Test
	public void queSePuedaRegistrarLaVentaDeUnProducto() {
	
		//preparacion
		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
		Lavarropa lavarropa1;
		lavarropa1 = new Lavarropa(1,"Lavadora 1", 600.0, 3, "Marca 1", "Modelo 1", "Tipo 1", 30, "Superior");
		tienda.agregarProducto(lavarropa1);
		Integer cantidadDisponibleEsperada = 1;
		
		//ejecucion
		
		
		//validacion
		assertTrue(tienda.registrarVenta(1, 2));
		assertEquals(cantidadDisponibleEsperada, lavarropa1.getCantidadDisponible());
	}
	
	@Test
    public void testQueNoSePuedaVenderMasProductosDeLosQueHayDisponibles() {

		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
        Lavarropa lavadora1 = new Lavarropa(3, "miLavadora", 650.0, 2, "Drean", "Next 7.09 Eco", "Lavadora", 400, "A");

        tienda.agregarProducto(lavadora1);

        tienda.registrarVenta(3, 3); //Se intenta registrar una venta de 3 lavadoras, cuando solo hay 2.

        assertEquals(false, tienda.registrarVenta(3, 3));
    }
	
	@Test
	public void queSePuedaCalcularElTotalDeVentas() {
	
		//preparacion
		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
		Lavarropa lavarropa1;
		Televisor televisor1;
		lavarropa1 = new Lavarropa(1,"Lavadora 1", 600.0, 3, "Marca 1", "Modelo 1", "Tipo 1", 10, "Superior");
		televisor1 = new Televisor(2, "Televisor 1", 500.0, 5, "Marca 2", "Modelo 2", "Tipo 2", 50, "Full HD");
		tienda.agregarProducto(lavarropa1);
		tienda.agregarProducto(televisor1);
		Double totalDeVentasEsperado = 1100.0;
		
		
		//ejecucion
		tienda.registrarVenta(1, 1);
		tienda.registrarVenta(2, 1);
		
		
		//validacion
		assertEquals(totalDeVentasEsperado, tienda.CalcularTotalVentas());
	}
	
	@Test
    public void testCalcularPrecioTelevisorConMasDe50Pulgadas() {

		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
        Televisor televisor1 = new Televisor(2, "miTelevisor", 500.0, 5, "Samsung", "UN55AU7000GXUG LED", "Televisor", 55, "4k");

        tienda.agregarProducto(televisor1);

        Double ve = (500.0  * 3 )* 1.1; // 10% mas cara si el tamaño es mayor a 50 pulgadas

        assertEquals(ve, televisor1.calcularPrecioVenta(3), 0.1);
}
	@Test
    public void testCalcularPrecioRefrigeradorDoblePuerta() {

		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
        Refrigerador refrigerador1 = new Refrigerador(1, "miHeladera", 800.0, 3, "LG", "Inverter Lm57sxt Instaview 423", "Refrigerador", 400, "Doble puerta");

        tienda.agregarProducto(refrigerador1);

        Double ve = (800.0  * 2 )* 1.2; // 20% mas cara si es de tipoRefrigerador doble puerta

        assertEquals(ve, refrigerador1.calcularPrecioVenta(2), 0.1);
    }


	@Test
    public void testCalcularPrecioLavadoraConCargFrontal() {

		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
        Lavarropa lavadora  = new Lavarropa(1, "miLavadora", 800.0, 3, "Drean", "Next 7.09 Eco3", "Lavadora", 30, "frontal");

        tienda.agregarProducto(lavadora);

        double ve = 800.0 + 50 + 100; // 50 de recargo por tipo de carga, y 100 por exceder la capacidad

        assertEquals(ve, lavadora.calcularPrecioVenta(1), 0.1);
    }
	
	//test Angel Santillan
	@Test
	public void queNoSePuedaVenderTVSinStock() {
		//Preparaci�n
		Tienda tienda;
		tienda = new Tienda("Garcarino",897856412L);
		
		final Integer compraSolicitada=50;
		final Integer Stock=20;
		Televisor tv1;
		tv1 = new Televisor(001,"TV",150.0, Stock,"Samsung","HL25","Televisor",43,"Full-HD");
		//ejecuci�n
		tienda.registrarVenta(tv1.getCodigo(),compraSolicitada);
		//validacion
		assertFalse(tienda.registrarVenta(tv1.getCodigo(),compraSolicitada));
		
	}
	@Test
	public void queNoSePuedaVenderHeladeraSinStock() {
		//Preparaci�n
		Tienda tienda;
		tienda = new Tienda("Garcarino",897856412L);
				
		final Integer compraSolicitada=50;
		final Integer Stock=20;
		Refrigerador dream1;
		dream1 = new Refrigerador(0, null,0.0, Stock, null, null, null,0, null);
		
		Boolean check = tienda.registrarVenta(dream1.getCodigo(),compraSolicitada);
		
		assertFalse(check);
		
	}
	@Test
	public void queSePuedaBuscarUnaTV() {
		Tienda tienda;
		tienda = new Tienda("Garcarino",897856412L);
		
		Integer id=666;
		Televisor tv1;
		tv1 = new Televisor(id, null, 0.0, id, null, null, null, id, null);
		
		tienda.agregarProducto(tv1);
		
		assertEquals(tv1,tienda.buscarProducto(tv1.getCodigo()));
	
	}
	@Test
	public void queNoSePuedaRegistrarUnaVenta() {
		//preparacion
		Tienda tienda;
		final String NOMBRE = "Megatone";
		final Long CUIT = 6478135L;
		tienda = new Tienda(NOMBRE,CUIT);
		Lavarropa lavarropa1;
		lavarropa1 = new Lavarropa(1,"Lavadora 1", 600.0, 1, "Marca 1", "Modelo 1", "Tipo 1", 30, "Superior");
		tienda.agregarProducto(lavarropa1);
		Integer cantidadDisponibleEsperada = 1;
		
		//ejecucion
		
		
		//validacion
		assertFalse(tienda.registrarVenta(1, 2));
		
	}
	
}

















