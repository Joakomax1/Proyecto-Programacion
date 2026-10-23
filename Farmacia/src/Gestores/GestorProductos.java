
package Gestores;
import Modelo.Producto;
import Modelo.Usuario;
import Sistema.Boleta;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author joako
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

    public void listar(Usuario p) {
        if (lista.isEmpty()) {
            System.out.println("No hay Stock.");
            return;
        }
        System.out.println("\n=== Productos (" + lista.size() + ") ===");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + lista.get(i));
        }
    }
    // ── CARGAR: lee la lista desde el disco ──────────────────
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

}
