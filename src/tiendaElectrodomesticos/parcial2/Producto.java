package tiendaElectrodomesticos.parcial2;

public abstract class Producto {

    protected int codigo;
    protected String nombre;
    protected double precio;
    protected int cantidadDisponible;
    protected int cantidadVendida=0;

    public Producto(int codigo, String nombre, double precio, int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public abstract double calcularPrecioVenta(int cantidad);

    public abstract void registrarVenta(int cantidad);

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}