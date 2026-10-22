/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author 01ian
 */
public class gestorUsuarios {
    private static final String ARCHIVO = "usuarios.dat";
    private ArrayList<Usuario> lista;
    
    public gestorUsuarios() {
        lista = new ArrayList<>();
    }
    // ── Guardar: lee la lista desde el disco ──────────────────
    public void agregar(Usuario u) {
        lista.add(u);
        System.out.println("Usuario agragado exitosamente......: " + u.getNombre());
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
    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("No hay Usuarios.");
            return;
        }
        System.out.println("\n=== Usuarios (" + lista.size() + ") ===");
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

            lista = (ArrayList<Usuario>) ois.readObject();
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
