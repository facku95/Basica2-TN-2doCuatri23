package tiendaElectrodomesticos.parcial2;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private List<Producto> productos;

    public Tienda() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto(int codigo) {
        Producto producto = buscarProducto(codigo);
        if (producto != null) {
            this.productos.remove(producto);
        }
    }

    public Producto buscarProducto(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        System.out.println("LISTA DE PRODUCTOS:");
        System.out.println("====================");
        for (Producto producto : productos) {
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Cantidad disponible: " + producto.getCantidadDisponible());
            if (producto instanceof Electrodomestico) {
                Electrodomestico electrodomestico = (Electrodomestico) producto;
                System.out.println("Marca: " + electrodomestico.getMarca());
                System.out.println("Modelo: " + electrodomestico.getModelo());
                System.out.println("Tipo: " + electrodomestico.getTipo());
            }
            if (producto instanceof Televisor) {
                Televisor televisor = (Televisor) producto;
                System.out.println("Tamaño: " + televisor.getTamaño() + " pulgadas");
                System.out.println("Resolucion: " + televisor.getResolucion());
            }
            if (producto instanceof Refrigerador) {
                Refrigerador refrigerador = (Refrigerador) producto;
                System.out.println("Capacidad: " + refrigerador.getCapacidad() + " litros");
                System.out.println("Tipo de refrigerador: " + refrigerador.getTipoRefrigerador());
            }
            System.out.println("====================");
        }
    }

    public double calcularTotalVentas() {
        double totalVentas = 0;
        for (Producto producto : productos) {
            totalVentas += producto.calcularPrecioVenta(producto.cantidadVendida);
        }
        return totalVentas;
    }

    public boolean registrarVenta(int codigo, int cantidad) {
        Producto producto = buscarProducto(codigo);
        if (producto != null && producto.getCantidadDisponible() >= cantidad) {
            producto.registrarVenta(cantidad);
            producto.cantidadVendida += cantidad;
            return true;
        } else {
            System.out.println("No se pudo registrar la venta de " + cantidad + " unidad(es) de " + producto.getNombre() + ".");
            return false;
        }
    }
}