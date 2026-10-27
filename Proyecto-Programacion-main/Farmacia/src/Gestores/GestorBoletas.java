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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joako
 */


public class GestorBoletas {
    
    private static final String ARCHIVO = "boletas.dat"; // nombre del archivo

    private ArrayList<Boleta> lista;
       // inicializar array
    public GestorBoletas() {
        lista = new ArrayList<>();

    }
    public ArrayList getLista(){
        return lista;
    }
    // ── Guardar: lee la lista desde el disco ──────────────────
    public void agregar(Boleta b) {
        lista.add(b);
        System.out.println("Producto Comprado Exitosamente: " );
       }
    
    // ── GUARDAR: escribe la lista al disco ───────────────────
    //  [REQUISITO: Persistencia]
    public void guardar() {
        try (ObjectOutputStream oos =
            new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            System.out.println(lista);
            oos.writeObject(lista);
            System.out.println("Guardado: " + lista.size() + " Compras(s) en '"
                               + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
    // ── listar: Mostrar todo ──────────────────
    public void listar(){
        if (lista.isEmpty()) {
            System.out.println("No hay Stock.");
            return;
        }
        System.out.println("\n=== Productos (" + lista.size() + ") ===");
        for (int i = 0; i < lista.size(); i++) {
            Boleta p = lista.get(i);
            System.out.println("  " + (i + 1) + ". " + "nombre: ");
                    //+ p.getNombreProducto()+ " Stock:  "
                    //+ p.getPrecio() + "  Precio:  "
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

            lista = (ArrayList<Boleta>) ois.readObject();
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
