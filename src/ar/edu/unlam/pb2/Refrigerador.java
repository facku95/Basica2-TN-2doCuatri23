package ar.edu.unlam.pb2;

public class Refrigerador extends Electrodomestico {
	
	private int capacidad;
    private String tipoDeEnfriamiento;

	public Refrigerador(int codigo, String nombre, double precio, int cantidadDisponible, String marca, String modelo, String tipo, int capacidad,
			String tipoDeEnfiamiento) {
		super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipoDeEnfriamiento() {
		return tipoDeEnfriamiento;
	}

	public void setTipoDeEnfriamiento(String tipoDeEnfriamiento) {
		this.tipoDeEnfriamiento = tipoDeEnfriamiento;
	}

	
}
