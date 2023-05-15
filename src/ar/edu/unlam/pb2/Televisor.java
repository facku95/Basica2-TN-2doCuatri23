package ar.edu.unlam.pb2;

public class Televisor extends Electrodomestico {
	
	private double tamano;
    private String resolucion;
	
	
	public Televisor(int codigo, String nombre, double precio, int cantidadDisponible, String marca, String modelo, String tipo, int tamano,
			String resolucion){
		super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
		
		this.tamano = tamano;
		this.resolucion = resolucion;
	}

	@Override
    public Double calcularPrecioVenta(Integer cantidad) {
        Double precioVenta = getPrecio() * cantidad;
        if (tamano > 50) {
            precioVenta *= 1.1; // aumentar el 10% del precio si es mayor a 50 pulgadas
        }
        return precioVenta;
    }
	
	public double getTamano() {
		return tamano;
	}


	public void setTamano(double tamano) {
		this.tamano = tamano;
	}


	public String getResolucion() {
		return resolucion;
	}


	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	
	@Override
	public String toString() {
		return ""+codigo+nombre+precio+cantidadDisponible+marca+modelo+tamano+resolucion;
	}
	
		
	}


