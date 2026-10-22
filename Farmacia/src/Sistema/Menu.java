package Sistema;// [REQUISITO: Package]

import Modelo.Usuario;
import Modelo.Producto;
import Modelo.Medicamento;
import Modelo.Suplementos;
import Modelo.Cosmeticos;
import java.util.Scanner;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Menu {
// [REQUISITO: Menu-scanner]
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        // Gestor gestor = new Gestor();
        int opcion;
        do {
            mostrarOpciones();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1://TODO: Mostrar productos
                    // listar();
                    break;
                case 2://TODO:Agregar usuario
                    agregarUsuario(sc);
                    break;
                case 3://TODO:Agregar producto
                    agregarProducto(sc);

                    break;
                case 4://Estadisticas
                    //TODO:Mostrar productos más vendidos
                    //TODO:Mostrar productos más comprados por usuario
                    break;
                case 0://Cerrar
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
        sc.close();
        // Guardar datos nuevos
        // gestor.guardar();
        
    }

    public static void mostrarOpciones() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Agregar");
        System.out.println("2. Registrar");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }
    //TODO:Mostrar Productos ()
    public void mostrarProductos(){
        //TODO: usar gestor para traer un array de todos los productos
        //TODO: Iterar lista para mostrar producto por producto
    }
    
    public void agregarUsuario(Scanner sc) {
        System.out.println("Nombre del Cliente:  ");
        String nombre = sc.nextLine();
        System.out.println("Rut del usuario: ");
        String rut = sc.nextLine(); 
        
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setRut(rut);
    }
/*
partimos preguntando de que tipo es el medicamento no obstante es un dato
que arrastraremos para despues ya que primero pediremos los datos generales para
no tener que sobreescribir los datos que cumplen todos los productos tantas veces    
*/ 
    
    public void agregarProducto(Scanner sc) {

    }
    
}
