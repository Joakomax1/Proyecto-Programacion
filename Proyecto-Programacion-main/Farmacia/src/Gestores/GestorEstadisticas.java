/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Modelo.Producto;
import Modelo.Usuario;
import Sistema.Boleta;
import java.util.ArrayList;

/**
 *
 * @author 01ian
 */
public class GestorEstadisticas {
    
    public void getTopComprador(ArrayList<Usuario> usuarios) {
        //verificamos que hayan usuarios
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        //creamos la variable top Usuario para luego mostrarlo en pantalla y el gasto se inicializa en -1 porque en el caso de ser 0 igual podria llegar a ser un top comprador
        Usuario topUsuario = null;
        int maxGasto = -1;
        //  recorremos la lista de usuarios una por una y creamos la varibale dond e
        for (Usuario u : usuarios) {
            int gastoTotalUsuario = 0;
            //y revisamos cada una de sus boletas de cada una extramenos el dinero que gasto y lo vamos sumando a el gasto total
            if (u.getTransacciones() != null) {
                for (Boleta b : u.getTransacciones()) {
                    gastoTotalUsuario += b.getPrecioTotal();
                }
            }
            //luego comparamos si su gasto su gasto fue mayor al que tenemos como top y si es asi lo guardamos junto a su nombre
            if (gastoTotalUsuario > maxGasto) {
                maxGasto = gastoTotalUsuario;
                topUsuario = u;
            }
        }

        if (topUsuario != null && maxGasto > 0) {
            System.out.println("\n=== CLIENTE QUE MAS COMPRO ===");
            System.out.println("Nombre: " + topUsuario.getNombre() + " | RUT: " + topUsuario.getRut());
            System.out.println("Total gastado: " + maxGasto);
        } else {
            System.out.println("Ningun usuario ha realizado una compra.");
        }
    }
    
    public void getTopProducto(ArrayList<Boleta> boletas, ArrayList<Producto> productos) {
        if (boletas == null || boletas.isEmpty() || productos == null || productos.isEmpty()) {
            System.out.println("No hay suficientes productos.");
            return;
        }
        //creamos una variable de tipo producto para almacenar nuestro producto mas vendido y una variable que nos permita tener un top 1 que se ira actualizando cada vez que iteremos
        Producto productoMasVendido = null;
        int topVentas = 0;
        //aqui tomamos producto con producto
        for (Producto prod : productos) {
            //con este contador sumaremos todas las cantidades que salga que la gente compro en cada boleta
            int totalUnidadesVendidas = 0;
            //teniendo un producto a revisar , revisaremos todas las boletas 
            for (Boleta boleta : boletas) {
                //ahora creamos una arraylist (porque son listas de datos) que extraiga los productos de cada boleta junto con sus cantidades y teniendo en cuenta que el producto [0] su cantidad esta en cantidades[0]
                ArrayList<Producto> listaProductosBoleta = boleta.getProductos();
                ArrayList<Integer> listaCantidadesBoleta = boleta.getCantidades();
                for (int i = 0; i < listaProductosBoleta.size(); i++) {
                    // ahora utlizaremos el id de los productos y los compararemos con los de la boletas si son iguales ("siginifica que compro el producto") utilizaremos la cantidad de veces que lo compro y se lo iremos sumando a el contador
                    if (listaProductosBoleta.get(i).getId() == prod.getId()) {
                        totalUnidadesVendidas += listaCantidadesBoleta.get(i);
                    }
                }
            }
            //si nuestro contsdor supera el top que se actualizara en cada ciclo este quedara guardado y asi obtendremos nuestro producto top ademas de guardar su nombre en la variable
            if (totalUnidadesVendidas > topVentas) {
                topVentas = totalUnidadesVendidas;
                productoMasVendido = prod;
            }
        }
        //terminado el ciclo solamente lo mostraremos en pantalla
        if (productoMasVendido != null && topVentas > 0) {
            System.out.println("\n=== PRODUCTO MAS VENDIDO ===");
            System.out.println("El producto mas vendido es: " + productoMasVendido.getNombre());
            System.out.println("Unidades vendidas: " + topVentas);
        } else {
            System.out.println("Aún no se han registrado ventas.");
        }
    }
      
    public void getVentasHistoricas(ArrayList<Boleta> boletas) {
        //aqui9 verificamos que hay boletas
        if (boletas == null || boletas.isEmpty()) {
            System.out.println("No hay Boletas.");
            return;
        }
        //si hay boletas creamos un contador que sume todo el dinero de las boletas
        int totalRecaudado = 0;
        //vamos boleta por boleta y con el metodo de el precio total lo vamos sumando a la variable
        for (Boleta boleta : boletas) {
            totalRecaudado += boleta.getPrecioTotal();
        }
        //vemos el tamaño de la lista y luego mostramos nuestra variable del total
        System.out.println("\n=== VENTAS HISTORICAS ===");
        
        System.out.println("Total de boletas registradas: " + boletas.size());
        System.out.println("Total de ingresos de la farmacia: $" + totalRecaudado);
    }
}
