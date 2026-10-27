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
    private final ArrayList<Producto> productos;
    private final ArrayList<Integer> cantidades;
    private final ArrayList<Integer> valores;

    public Boleta(Usuario usuario, ArrayList<Producto> productos, ArrayList<Integer> cantidad, ArrayList<Integer> valor) {
        this.id = counter.getAndIncrement();// Añade id
        this.usuario = usuario;
        this.productos = productos;
        this.cantidades = cantidad;
        this.valores = valor;
    }

    // Suma de valor de todos los productos
    public int getPrecioTotal() {
        int total = 0;
        int n = this.productos.size();// Por cada producto
        for (int i = 0; i < n; i++){
            total += valores.get(i) * cantidades.get(i);// sumar valores por cantidad
        }
        return total;
    }

    public String getRut() {
        return this.usuario.getRut();
    }
    
    public String getNombreProducto(Producto p) {
        return p.getNombre();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== BOLETA N° ").append(id).append(" ===\n");
        sb.append("Cliente RUT: ").append(usuario.getRut()).append("\n");
        sb.append(String.format("%-20s %-10s %-10s\n", "Producto", "Cantidad", "Precio Unit."));
        sb.append("------------------------------------------\n");

        for (int i = 0; i < productos.size(); i++) {
            sb.append(String.format("%-20s %-10d $%d\n",
                    productos.get(i).getNombre(),
                    cantidades.get(i),
                    valores.get(i)));
        }
        sb.append("------------------------------------------\n");
        sb.append("TOTAL: $").append(getPrecioTotal()).append("\n");
        return sb.toString();
    }

}
