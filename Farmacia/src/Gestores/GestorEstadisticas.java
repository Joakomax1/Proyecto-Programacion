package Gestores;

import Modelo.Producto;
import Modelo.Usuario;
import Modelo.Boleta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 01ian
 */
public class GestorEstadisticas {

    public void getTopComprador(ArrayList<Usuario> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        Usuario topComprador = usuarios.get(0);
        for (Usuario u : usuarios) {
            if (u.getTotalTransacciones() > topComprador.getTotalTransacciones()) {
                topComprador = u;
            }
        }
        System.out.println("\n=== TOP COMPRADOR ===");
        System.out.println("Cliente: " + topComprador.getNombre() + " | RUT: " + topComprador.getRut()
                + " | Total Gastado: $" + topComprador.getTotalTransacciones());
    }

    // Encuentra el producto con más unidades vendidas en total
    public void getTopProducto(ArrayList<Boleta> boletas) {
        if (boletas == null || boletas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        //[REQUISITO: HASHMAP]
        HashMap<Producto, Integer> conteo = obtenerConteoVentas(boletas);
        String topProducto = null;
        int maxCantidad = 0;
        for (Map.Entry<Producto, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                topProducto = entry.getKey().getNombre();
                maxCantidad = entry.getValue();
            }
        }

        if (topProducto != null) {
            System.out.println("\n=== PRODUCTO MAS VENDIDO ===");
            System.out.println("Producto: " + topProducto + " | Unidades vendidas: " + maxCantidad);
        }
    }

    // Muestra fichadetallada completo de productos 
    public void getVentasHistoricas(ArrayList<Boleta> boletas) {
        if (boletas == null || boletas.isEmpty()) {
            System.out.println("No hay ventas registradas en el historial.");
            return;
        }
        //[REQUISITO: HASHMAP]
        HashMap<Producto, Integer> conteo = obtenerConteoVentas(boletas);
        System.out.println("\n===VENTAS HISTORICAS ===");
        for (Map.Entry<Producto, Integer> entry : conteo.entrySet()) {
            System.out.println("Producto: " + entry.getKey().getNombre() + " | Unidades Vendidas: " + entry.getValue());
        }
    }

    // Helper iterar boletas y sumar cantidades por producto
    private HashMap<Producto, Integer> obtenerConteoVentas(ArrayList<Boleta> boletas) {
        HashMap<Producto, Integer> conteo = new HashMap<>();//[REQUISITO: HASHMAP]
        for (Boleta b : boletas) {
            Producto producto = b.getProducto();
            int cantidad = b.getCantidad();
            int cantidadVendida = cantidad;
            conteo.put(producto, conteo.getOrDefault(producto, 0) + cantidadVendida);
        }
        return conteo;
    }
}
