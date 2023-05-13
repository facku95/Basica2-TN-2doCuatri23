package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;


public class Tienda {
	
	private String nombre;
	private Long cuit;
	List<Producto> productos;
	
	
	
	public Tienda(String nombre, Long cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.productos = new ArrayList<>();
	}

	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
			
	}
	
	public Integer getCantidadProductos() {
		return productos.size();
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getCuit() {
		return cuit;
	}


	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String toString() {
		String resultado = "";
		
		for(Producto producto: productos) {
			resultado += "||Producto: " + producto.getNombre() + " Precio: " + producto.getPrecio() + " Codigo: " + producto.getCodigo() + " Cantidad Disponible: " + producto.getCantidadDisponible();
			if(producto instanceof Electrodomestico) {
				Electrodomestico electrodomestico = (Electrodomestico) producto;
				resultado += " Marca: " + electrodomestico.getMarca() + " Modelo: " + electrodomestico.getModelo() + " Tipo: " + electrodomestico.tipo;
			}
			if(producto instanceof Lavarropa) {
				Lavarropa lavarropa = (Lavarropa) producto;
				resultado += " Capacidad: " + lavarropa.getCapacidad() + " Tipo de Carga: " + lavarropa.getTipoDeCarga();
			}
			
		}
		return resultado;
		
	}

	public Boolean registrarVenta(Integer codigo , Integer cantidad) {
		Boolean resultado = false;
		Producto producto = buscarProducto(codigo);
		if(producto != null && producto.getCantidadDisponible()>= cantidad) {
			producto.registrarVenta(cantidad);
			resultado = true;
		}
		return resultado;
		
	}

	private Producto buscarProducto(Integer codigo) {
		for(Producto producto : productos) {
			if(producto.getCodigo() == codigo) {
				return producto;
			}
		}
		return null;
	}

	public Double CalcularTotalVentas() {
		Double totalVentas = 0.0;
		for(Producto producto: productos)
			totalVentas += producto.calcularPrecioVenta(1);
		return totalVentas;
	}


	


}
