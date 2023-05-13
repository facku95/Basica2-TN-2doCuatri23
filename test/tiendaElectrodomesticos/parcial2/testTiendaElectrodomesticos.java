package tiendaElectrodomesticos.parcial2;


import static org.junit.Assert.assertEquals;


import org.junit.Test;
public class testTiendaElectrodomesticos {

	@Test
    public void testCalcularPrecioTelevisorConMasDe50Pulgadas() {

        Tienda tienda = new Tienda();
        Televisor televisor1 = new Televisor(2, "miTelevisor", 500.0, 5, "Samsung", "UN55AU7000GXUG LED", "Televisor", 55, "4k");

        tienda.agregarProducto(televisor1);

        double ve = (500.0  * 3 )* 1.1; // 10% mas cara si el tamaño es mayor a 50 pulgadas

        assertEquals(ve, televisor1.calcularPrecioVenta(3), 0.1);
    }

	@Test
    public void testCalcularPrecioRefrigeradorDoblePuerta() {

        Tienda tienda = new Tienda();
        Refrigerador refrigerador1 = new Refrigerador(1, "miHeladera", 800.0, 3, "LG", "nverter Lm57sxt Instaview 423", "Refrigerador", 400, "doble puerta");

        tienda.agregarProducto(refrigerador1);

        double ve = (800.0  * 2 )* 1.2; // 20% mas cara si es de tipoRefrigerador doble puerta

        assertEquals(ve, refrigerador1.calcularPrecioVenta(2), 0.1);
    }

	@Test
    public void testQueNoSePuedaVenderMasProductosDeLosQueHayDisponibles() {

        Tienda tienda = new Tienda();
        Lavadora lavadora1 = new Lavadora(3, "miLavadora", 650.0, 2, "Drean", "Next 7.09 Eco", "Lavadora", 400, "A");

        tienda.agregarProducto(lavadora1);

        tienda.registrarVenta(3, 3); //Se intenta registrar una venta de 3 lavadoras, cuando solo hay 2.

        assertEquals(false, tienda.registrarVenta(3, 3));
    }

	@Test
    public void testCalcularPrecioLavadoraConCargFrontal() {

        Tienda tienda = new Tienda();
        Lavadora lavadora  = new Lavadora(1, "miLavadora", 800.0, 3, "Drean", "Next 7.09 Eco3", "Lavadora", 30, "frontal");

        tienda.agregarProducto(lavadora);

        double ve = 800.0 + 50 + 100; // 50 de recargo por tipo de carga, y 100 por exceder la capacidad

        assertEquals(ve, lavadora.calcularPrecioVenta(1), 0.1);
    }



}




