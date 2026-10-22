package Sistema;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joako
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
