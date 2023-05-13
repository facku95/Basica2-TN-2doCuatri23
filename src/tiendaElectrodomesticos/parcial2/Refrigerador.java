package tiendaElectrodomesticos.parcial2;

public class Refrigerador extends Electrodomestico {

    private int capacidad;
    private String tipoRefrigerador;

    public Refrigerador(int codigo, String nombre, double precio, int cantidadDisponible, String marca, String modelo, String tipo, int capacidad, String tipoRefrigerador) {
        super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
        this.capacidad = capacidad;
        this.tipoRefrigerador = tipoRefrigerador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoRefrigerador() {
        return tipoRefrigerador;
    }

    public void tipoRefrigerador(String tipoRefrigerador) {
        this.tipoRefrigerador = tipoRefrigerador;
    }

    @Override
    public double calcularPrecioVenta(int cantidad) {
        double precioVenta = getPrecio() * cantidad;
        if (tipoRefrigerador.equalsIgnoreCase("Doble puerta")) {
            precioVenta *= 1.2; // aumentar el 20% del precio si es doble puerta
        }
        return precioVenta;
    }

    @Override
    public void registrarVenta(int cantidad) {
        this.cantidadDisponible -= cantidad;
        System.out.println("Se registro la venta de " + cantidad + " unidad(es) de " + this.getNombre() + ".");
    }
}
