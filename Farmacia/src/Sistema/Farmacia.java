package Sistema;// [REQUISITO: Package]

import Modelo.Producto;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Scanner;  
import java.util.HashMap;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class Farmacia {
    private String nombre;
    private HashMap<String,String> usuarios;// [REQUISITO: Colecciones]

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