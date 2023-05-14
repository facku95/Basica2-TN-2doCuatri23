package ar.edu.unlam.pb2;

public class Televisor extends Electrodomestico {
	
	private double tamaño;
    private String resolucion;
	
	
	public Televisor(int codigo, String nombre, double precio, int cantidadDisponible, String marca, String modelo, String tipo, int tamaño,
			String resolucion){
		super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
		
		this.tamaño = tamaño;
		this.resolucion = resolucion;
	}

	@Override
    public Double calcularPrecioVenta(Integer cantidad) {
        Double precioVenta = getPrecio() * cantidad;
        if (tamaño > 50) {
            precioVenta *= 1.1; // aumentar el 10% del precio si es mayor a 50 pulgadas
        }
        return precioVenta;
    }
	
	public double getTamaño() {
		return tamaño;
	}


	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}


	public String getResolucion() {
		return resolucion;
	}


	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	

	
		
	}


