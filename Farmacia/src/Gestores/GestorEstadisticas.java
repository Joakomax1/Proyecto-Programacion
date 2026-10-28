package Gestores;

import Modelo.Producto;
import Modelo.Usuario;
import Sistema.Boleta;
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
        HashMap<String, Integer> conteo = obtenerConteoVentas(boletas);
        String topProducto = null;
        int maxCantidad = 0;

        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() > maxCantidad) {
                maxCantidad = entry.getValue();
                topProducto = entry.getKey();
            }
        }

        if (topProducto != null) {
            System.out.println("\n=== PRODUCTO MAS VENDIDO ===");
            System.out.println("Producto: " + topProducto + " | Unidades vendidas: " + maxCantidad);
        }
    }

    // Muestra el desglose completo de unidades vendidas por producto
    public void getVentasHistoricas(ArrayList<Boleta> boletas) {
        if (boletas == null || boletas.isEmpty()) {
            System.out.println("No hay ventas registradas en el historial.");
            return;
        }

        HashMap<String, Integer> conteo = obtenerConteoVentas(boletas);
        System.out.println("\n===VENTAS HISTORICAS ===");
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + " | Unidades Vendidas: " + entry.getValue());
        }
    }

    // Método auxiliar para iterar sobre todas las boletas y sumar cantidades por producto
    private HashMap<String, Integer> obtenerConteoVentas(ArrayList<Boleta> boletas) {
        HashMap<String, Integer> conteo = new HashMap<>();
        for (Boleta b : boletas) {
            ArrayList<Producto> productos = b.getProductos();
            ArrayList<Integer> cantidades = b.getCantidades();

            for (int i = 0; i < productos.size(); i++) {
                String nombreProd = productos.get(i).getNombre();
                int cantidadVendida = cantidades.get(i);
                conteo.put(nombreProd, conteo.getOrDefault(nombreProd, 0) + cantidadVendida);
            }
        }
        return conteo;
    }
}
