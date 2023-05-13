package ar.edu.unlam.pb2;

public class Electrodomestico extends Producto {
	
	protected String marca;
    protected String modelo;
    protected String tipo;
    
    public Electrodomestico(Integer codigo, String nombre, Double precio, Integer cantidadDisponible, String marca, String modelo, String tipo) {
        super(codigo, nombre, precio, cantidadDisponible);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

	@Override
	public Double calcularPrecioVenta(Integer cantidad) {
		return this.precio * cantidad;
	}

	@Override
	public void registrarVenta(Integer cantidad) {
		this.cantidadDisponible -= cantidad;
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    
    

}
