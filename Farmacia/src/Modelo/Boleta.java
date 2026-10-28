package Modelo;// [REQUISITO: Package]

/**
 *
 * @authors Joaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
import Interfaces.Consultable;
import Modelo.Usuario;
import Modelo.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Boleta implements Serializable, Consultable {

    private static final long serialVersionUID = 1L;
    private static final AtomicInteger counter = new AtomicInteger(1);// Genera contador para cada id de boleta
    private final int id;
    private final Usuario usuario;
    private final Producto producto;
    private final int cantidad;
    private final int valorPorUnidad;

    public Boleta(Usuario usuario, Producto productos, int cantidad, int valor) {
        this.id = counter.getAndIncrement();// Añade id
        this.usuario = usuario;
        this.producto = productos;
        this.cantidad = cantidad;
        this.valorPorUnidad = valor;
    }

    // Suma de valor de todos los productos
    public int getPrecioTotal() {
        int total = 0;

        total += valorPorUnidad * cantidad;// sumar valores por cantidad
        return total;
    }

    public int getId() {
        return id;
    }

    public String getRut() {
        return this.usuario.getRut();
    }

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    @Override
    public String obtenerFichaDetallada() {
        return toString();
    }

    @Override
    public String toString() {
 // [REQUISITO: 3.1. Gestión de clases principales]]
        StringBuilder string = new StringBuilder();
        string.append("\n=== BOLETA Numero: ").append(id).append(" ===\n");
        string.append("Cliente RUT: ").append(usuario.getRut()).append("\n");
        string.append(String.format("%-20s %-10s %-10s\n", "Producto", "Cantidad", "Precio Unit."));
        string.append("------------------------------------------\n");

        string.append(String.format("%-20s %-10d $%d\n",
                producto.getNombre(),
                cantidad,
                valorPorUnidad));

        string.append("------------------------------------------\n");
        string.append("TOTAL: $").append(getPrecioTotal()).append("\n");
        return string.toString();
    }
}
