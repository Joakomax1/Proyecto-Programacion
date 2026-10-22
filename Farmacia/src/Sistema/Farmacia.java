package Sistema;


import Modelo.Producto;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Scanner;  
import java.util.HashMap;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joako
 */
public class Farmacia {
    private String nombre;
    private HashMap<String,String> usuarios;

    public Farmacia(String nombre, ArrayList<Boleta> boletas, ArrayList<Producto> productos) {
        this.nombre = nombre;
        this.boletas = boletas;
        this.productos = productos;
        this.usuarios= new HashMap<>();
    }
    ArrayList<Boleta> boletas;
    ArrayList<Producto> productos;
    
    public void guardarUsuario(String nombre, String rut){
        usuarios.put(nombre, rut);
    }
    
}