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


