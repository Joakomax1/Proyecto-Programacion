package Modelo;
import Enums.Estado;
import Enums.Marca;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public abstract class Producto implements Vendible, Serializable {
    private static final long serialVersionUID = 1L; // [REQUISITO: Persistencia    
    // Genera contador para cada id de producto
    private static final AtomicInteger counter = new AtomicInteger(1);
    private final int id;
    protected int stock;
    protected int precio;
    protected String nombre;
    private final Marca marca;

    
    //protected int staticID;
  //  protected boolean estado;

    public Producto(int stock, int precio, String nombre, Marca marca) {
        this.id = counter.getAndIncrement();
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;
        this.marca = marca;
  //      this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
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
    public void setStockComprado(int comprado){
        this.stock -= comprado;
    }
    
    // Getter ID unico
    public int getId() {
        return id;
    }
    public int getPrecio() {
        return precio;
    }
    
    public Estado getEstadoStock(){
        if (stock>0){
            return Estado.con_Stock;
        }
        return Estado.sin_Stock;
    }

 //   public int getStaticID() {
  //      return staticID;
 //   }

  //  public boolean isEstado() {
     //   return estado;
   // }
}    