package ar.edu.unlam.pb2;

public class Lavarropa extends Electrodomestico {
	
	private Integer capacidad;
    private String tipoDeCarga;
    
	public Lavarropa(Integer codigo, String nombre, Double precio, Integer cantidadDisponible, String marca, String modelo, String tipo, Integer capacidad,
			String tipoDeCarga) {
		super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
		
		this.capacidad = capacidad;
		this.tipoDeCarga = tipoDeCarga;
	}
	@Override
    public Double calcularPrecioVenta(Integer cantidad) {
        Double precioVenta = this.precio;
        if (this.tipoDeCarga.equalsIgnoreCase("frontal")) {
            precioVenta += 50;
        }
        if (this.capacidad > 10) {
            precioVenta += 100;
        }
        precioVenta *= cantidad;
        return precioVenta;
    }

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipoDeCarga() {
		return tipoDeCarga;
	}

	public void setTipoDeCarga(String tipoDeCarga) {
		this.tipoDeCarga = tipoDeCarga;
	}
	
    
    

	
}
