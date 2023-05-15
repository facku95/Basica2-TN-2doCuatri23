package ar.edu.unlam.pb2;

public class Refrigerador extends Electrodomestico {
	
	private Integer capacidad;
    private String tipoRefrigerador;

	public Refrigerador(int codigo, String nombre, double precio, int cantidadDisponible, String marca, String modelo, String tipo, int capacidad,
			String tipoRefrigerador) {
	super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
	this.capacidad = capacidad;
	this.tipoRefrigerador = tipoRefrigerador;
	}
	
	@Override
    public Double calcularPrecioVenta(Integer cantidad) {
        Double precioVenta = getPrecio() * cantidad;
        if (tipoRefrigerador.equalsIgnoreCase("Doble puerta")) {
            precioVenta *= 1.2; // aumentar el 20% del precio si es doble puerta
        }
        return precioVenta;
    }
	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipoDeEnfriamiento() {
		return tipoRefrigerador;
	}

	public void setTipoDeEnfriamiento(String tipoDeEnfriamiento) {
		this.tipoRefrigerador = tipoDeEnfriamiento;
	}
	@Override
	public String toString() {
		return ""+codigo+nombre+precio+cantidadDisponible+marca+modelo+tipo+capacidad;
	}
	
}
