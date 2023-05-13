package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

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
	public void queSePuedaCalcularElTotalDeVentas() {
	
		//preparacion
		Tienda tienda;
		final String NOMBRE = "La casa del audio";
		final Long CUIT = 30678213094L;
		tienda = new Tienda(NOMBRE,CUIT);
		Lavarropa lavarropa1;
		Televisor televisor1;
		lavarropa1 = new Lavarropa(1,"Lavadora 1", 600.0, 3, "Marca 1", "Modelo 1", "Tipo 1", 30, "Superior");
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
}
