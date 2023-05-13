package ar.edu.unlam.pb2;

public abstract class Producto {
	
	protected Integer codigo;
    protected String nombre;
    protected Double precio;
    protected Integer cantidadDisponible;
    
    public Producto(Integer codigo, String nombre, Double precio, Integer cantidadDisponible) {
    	
    	this.codigo = codigo;
    	this.nombre = nombre;
    	this.precio = precio;
    	this.cantidadDisponible = cantidadDisponible;
    }
    
    public abstract Double calcularPrecioVenta(Integer cantidad);

    public abstract void registrarVenta(Integer cantidad);

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
    

}
