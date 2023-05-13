package tiendaElectrodomesticos.parcial2;

public class Lavadora extends Electrodomestico {
    private int capacidad;
    private String tipoDeCarga;

    public Lavadora(int codigo, String nombre, double precio, int cantidadDisponible, String marca, String modelo, String tipo, int capacidad, String tipoDeCarga) {
    	super(codigo, nombre, precio, cantidadDisponible, marca, modelo, tipo);
        this.capacidad = capacidad;
        this.tipoDeCarga = tipoDeCarga;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public void registrarVenta(int cantidad) {
        this.cantidadDisponible -= cantidad;
        System.out.println("Se registro la venta de " + cantidad + " unidad(es) de " + this.getNombre() + ".");
    }

    @Override
    public double calcularPrecioVenta(int cantidad) {
        double precioVenta = this.precio;
        if (this.tipoDeCarga.equalsIgnoreCase("frontal")) {
            precioVenta += 50;
        }
        if (this.capacidad > 10) {
            precioVenta += 100;
        }
        precioVenta *= cantidad;
        return precioVenta;
    }
}