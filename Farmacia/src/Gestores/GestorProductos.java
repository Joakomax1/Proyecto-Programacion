
package Gestores;
import Modelo.Producto;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joako
 */


public class GestorProductos {
    /*TODO:
    * Métodos:
    * Cargar(abrir archiv, leer contenido, convertir en aray, inicializar en cosntructor)(por cada Clase)
    * listar(abrir archiv, leer contenido, convertir en aray, y return con array)
    * subir(Abrir archivo, agregar nueva linea en el archivo(correspondiente, Usuarios, productos, etc.., y guardar datos )
    * 
    */
    // TODO: Agregar los archivos productos, usuarios, boletas, etc...
    private static final String ARCHIVO = "productos.dat"; // nombre del archivo

    private ArrayList<Producto> almacen;

    public GestorProductos() {
        almacen = new ArrayList<>();
    }

    public void agregar(Usuario p) {
        almacen.add(p);
        System.out.println("Producto agragado exitosamente......: " + p.getNombre());
    }
    // TODO: Sobre carga cambiando parametro y hay que cambiar el archivo
    public void agregar(Boleta p) {
        almacen.add(p);
        System.out.println("Producto agragado exitosamente......: " + p.getNombre());
    }

    public void listar(usuario p) {
        if (almacen.isEmpty()) {
            System.out.println("No hay Stock.");
            return;
        }
        System.out.println("\n=== Productos (" + almacen.size() + ") ===");
        for (int i = 0; i < almacen.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + almacen.get(i));
        }
    }
}
