package Sistema;// [REQUISITO: Package]
/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Boleta {
    private final int rut;
    private final String nombreProducto;
    private final int precio;
    private final int cantidad;

    public Boleta(int rut, String nombreProducto, int precio, int cantidad) {
        this.rut = rut;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getRut() {
        return rut;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
