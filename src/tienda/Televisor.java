package tienda;

public class Televisor extends Producto{
	private Integer pulgadas;
	private Boolean smart;
	
	public Televisor(Integer pulgadas, Boolean smart, Double precio, Integer id,
			Integer stock, String marca, String modelo) {
		super(precio, id, stock, marca,modelo);
		this.pulgadas=pulgadas;
		this.smart=smart;	
	}
	@Override
	Double calcularImpuesto(Double precio) {
		final Double porcentaje=1.15;
		Double preciofinal=precio*porcentaje;
		return preciofinal;
	}

}
