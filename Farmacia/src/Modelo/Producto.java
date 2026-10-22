package Modelo;// [REQUISITO: Package]

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public abstract class Producto implements Vendible {// [REQUISITO: Herencia]
    protected int stock;
    protected int precio;
    protected String nombre;
    protected int staticID;
    protected boolean estado;

    public Producto(int stock, int precio, String nombre, int staticID, boolean estado) {
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;
        this.staticID = staticID;
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStaticID(int staticID) {
        this.staticID = staticID;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStaticID() {
        return staticID;
    }

    public boolean isEstado() {
        return estado;
    }
}
