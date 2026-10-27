/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaserializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ramhg
 */
public class GestorProductos {
    private static final String ARCHIVO = "productos.dat"; // nombre del archivo

    private ArrayList<Producto> lista;

    public GestorProductos() {
        lista = new ArrayList<>();
    }

    // ── Agregar un producto ──────────────────────────────────

    public void agregar(Producto p) {
        lista.add(p);
        System.out.println("Producto agregado: " + p.getNombre());
    }

    // ── Mostrar todos ────────────────────────────────────────

    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }
        System.out.println("\n=== Productos (" + lista.size() + ") ===");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + lista.get(i));
        }
    }

    // ── GUARDAR: escribe la lista al disco ───────────────────
    //  [REQUISITO: Persistencia]

    public void guardar() {
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            oos.writeObject(lista);
            System.out.println("Guardado: " + lista.size() + " producto(s) en '"
                               + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
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
