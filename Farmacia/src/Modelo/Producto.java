package Modelo;

/*
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
import Enums.Estado;
import Enums.Marca;
import Interfaces.Consultable;
import Interfaces.Descontable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
//[REQUISITO: CLASE ABSTRACTA]
public abstract class Producto implements Consultable, Descontable, Serializable {

    private static final long serialVersionUID = 1L;
    //// [REQUISITO: Persistencia]
    private static final AtomicInteger counter = new AtomicInteger(1);

    private final int id;
    protected int stock;
    protected int precio;
    protected String nombre;
    protected Marca marca;

    public Producto(int stock, int precio, String nombre, Marca marca) {
        this.id = counter.getAndIncrement();
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public Estado getEstadoStock() {
        if (stock > 0) {
            return Estado.con_Stock;
        } else {
            return Estado.sin_Stock;
        }
    }
    // [REQUISITO: POLIMORFISMO]
    public int getPrecioDescontado() {
        return (int) (precio - calcularDescuento());
    }
   
    @Override // [REQUISITO: 3.1. Gestión de clases principales]]
    public String toString() {
        return String.format("id: %d | nombre: %s | Stock: %d | $%d, %s\n",
                id, nombre, stock, precio, marca);
    }
}