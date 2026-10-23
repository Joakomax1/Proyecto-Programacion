
package Gestores;
import Enums.Marca;
import Modelo.Producto;
import Modelo.Usuario;
import Sistema.Boleta;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joako ASD
 */


public class GestorProductos {
    /*TODO:
    * Métodos:
    * Cargar(abrir archiv, leer contenido, convertir en aray, inicializar en cosntructor)(por cada Clase)
    * listar(abrir archiv, leer contenido, convertir en aray, y return con array)
    * agregar(Abrir archivo, agregar nueva linea en el archivo(correspondiente, Usuarios, productos, etc.., y guardar datos )
    * 
    */
    // TODO: Agregar los archivos productos, usuarios, boletas, etc...
    private static final String ARCHIVO = "productos.dat"; // nombre del archivo

    private ArrayList<Producto> lista;

    public GestorProductos() {
        lista = new ArrayList<>();

    }
    
    public void guardar(Producto p) {
        lista.add(p);
        System.out.println("Producto agragado exitosamente......: " + p.getNombre());
    }
    // Metodos listar contenido Sobrecarga
    // Metodos guardar contenido Sobrecarga
    
    public void listarUsuarios() {
        if (almacenU.isEmpty()) {
            System.out.println("No hay Personas.");
            return;
        }
        System.out.println("\n=== Productos (" + almacenU.size() + ") ===");
        for (int i = 0; i < almacenU.size(); i++) {
            Usuario p = almacenU.get(i);
            System.out.println("  " + (i + 1) + ". " + "nombre: " + p.getNombre()+ " Rut:  " + p.getRut() );
        }
    }
    public void listarProductos(){
        if (almacenP.isEmpty()) {
            System.out.println("No hay Stock.");
            return;
        }
        System.out.println("\n=== Productos (" + almacenP.size() + ") ===");
        for (int i = 0; i < almacenP.size(); i++) {
            Producto p = almacenP.get(i);
            System.out.println("  " + (i + 1) + ". " + "nombre: " + p.getNombre()+ " Stock:  " + p.getStock() + "  Precio:  " + p.getPrecio() );
        }
    }
    public void mostrarMarcas() {
        System.out.println("Selecciona la marca del producto :");
        Marca[] marcas = Marca.values();

        for (int i = 0; i < marcas.length; i=i+1) {
            System.out.println((i + 1) + ". " + marcas[i]);
        }
    }
}
        

    /*    // ── CARGAR: lee la lista desde el disco ──────────────────
    //  [REQUISITO: Persistencia]
    @SuppressWarnings("unchecked")
    public void cargar() {
        File archivo = new File(ARCHIVO);

        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("No hay datos guardados. Lista vacía.");
            return;
        }

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            lista = (ArrayList<Producto>) ois.readObject();
            System.out.println("Cargado: " + lista.size() + " producto(s) desde '"
                               + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
            lista = new ArrayList<>();

        } catch (ClassNotFoundException e) {
            System.out.println("Archivo incompatible con esta versión.");
            lista = new ArrayList<>();
        }
    }

    public int getTamanio() { 
        return lista.size(); 
    }
*/
