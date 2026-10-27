package Sistema;// [REQUISITO: Package]

/**
 *
 * @authors Joaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
import Modelo.Usuario;
import Modelo.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Boleta implements Serializable{
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger counter = new AtomicInteger(1);// Genera contador para cada id de boleta
    private final int id;
    private final Usuario usuario;
    private final ArrayList<Producto> producto;
    private final ArrayList<Integer> cantidad;
    private final ArrayList<Integer> valor;

    public Boleta(Usuario usuario, ArrayList<Producto> productos, ArrayList<Integer> cantidad, ArrayList<Integer> valor) {
        this.id = counter.getAndIncrement();// Añade id
        this.usuario = usuario;
        this.producto = productos;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    // Suma de valor de todos los productos
    public int getPrecioTotal() {
        int total = 0;
        int n = this.producto.size();// Por cada producto
        for (int i = 0; i < n; i++){
            total += valor.get(i) * cantidad.get(i);// sumar valores por cantidad
        }
        return total;
    }

    public String getRut() {
        return this.usuario.getRut();
    }
    
    public ArrayList<Producto> getProductos() {
        return this.producto;
    }

    public ArrayList<Integer> getCantidades() {
        return this.cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== BOLETA N° ").append(id).append(" ===\n");
        sb.append("Cliente RUT: ").append(usuario.getRut()).append("\n");
        sb.append(String.format("%-20s %-10s %-10s\n", "Producto", "Cantidad", "Precio Unit."));
        sb.append("------------------------------------------\n");

        for (int i = 0; i < producto.size(); i++) {
            sb.append(String.format("%-20s %-10d $%d\n",
                    producto.get(i).getNombre(),
                    cantidad.get(i),
                    valor.get(i)));
        }
        sb.append("------------------------------------------\n");
        sb.append("TOTAL: $").append(getPrecioTotal()).append("\n");
        return sb.toString();
    }

}
