package tienda;

abstract public class Producto {
	
	protected Double precio;
	protected Integer id;
	protected Integer stock;
	protected String marca;
	protected String modelo;
	
	public Producto(Double precio, Integer id, Integer stock,
					String marca,String modelo) {
		this.precio = precio;
		this.id = id;
		this.stock = stock;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	abstract Double calcularImpuesto(Double precio);
	
	Boolean Compra(int cantidad) {
		if(cantidad<this.stock) {
			setStock(this.stock-cantidad);
			return true;
		}else return false;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
