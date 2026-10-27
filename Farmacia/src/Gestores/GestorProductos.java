package Gestores;
import Enums.Marca;
import Modelo.Producto;
import Modelo.Usuario;
import Sistema.Boleta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
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
    * MÃ©todos:
    * Cargar(abrir archiv, leer contenido, convertir en aray, inicializar en cosntructor)(por cada Clase)
    * listar(abrir archiv, leer contenido, convertir en aray, y return con array)
    * agregar(Abrir archivo, agregar nueva linea en el archivo(correspondiente, Usuarios, productos, etc.., y guardar datos )
    * 
    */
    // TODO: Agregar los archivos productos, usuarios, boletas, etc...
    private static final String ARCHIVO = "productos.dat"; // nombre del archivo

    private ArrayList<Producto> lista;
       // inicializar array
    public GestorProductos() {
        lista = new ArrayList<>();

    }
    public ArrayList getLista(){
        return lista;
    }
    public void restarStockComprado(AtomicInteger id, int stockComprado){
        
    }
    // ── Guardar: lee la lista desde el disco ──────────────────
    public void agregar(Producto p) {
        lista.add(p);
        System.out.println("Producto exitosamente agregado: " );
       }
    
    // ── GUARDAR: escribe la lista al disco ───────────────────
    //  [REQUISITO: Persistencia]
    public void guardar() {
        try (ObjectOutputStream oos =
            new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            System.out.println(lista);
            oos.writeObject(lista);
            System.out.println("Guardado: " + lista.size() + " producto(s) en '"
                               + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    // ── listar: Mostrar todo ──────────────────
    public boolean listar(){
        if (lista.isEmpty()) {
            System.out.println("\nNo hay Stock!!!.");
            return false;
        }
        System.out.println("\n=== Productos (" + lista.size() + ") ===");
        for (int i = 0; i < lista.size(); i++) {
            Producto p = lista.get(i);
            System.out.println("  " + (i + 1) + ". " + "nombre: " + p.getNombre()+ " Stock:  " + p.getStock() + "  Precio:  " + p.getPrecio() );
        }
        return true;
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
