/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaserializable;
import java.io.*;
/**
 *
 * @author ramhg
 */

// ────────────────────────────────────────────────────────────
//  PASO 1: Clase simple con datos
//  → Solo agregamos "implements Serializable" y serialVersionUID
//  → El resto de la clase no cambia
// ────────────────────────────────────────────────────────────
public class Producto implements Serializable {  // [REQUISITO: Persistencia]
    private static final long serialVersionUID = 1L; // [REQUISITO: Persistencia] OPCIONAL
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock  = stock;
    }

    public String getNombre() { 
        return nombre; 
    }
    public double getPrecio() { 
        return precio; 
    }
    public int    getStock()  { 
        return stock;  
    }

    @Override
    public String toString() {
        return nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }
    
}
