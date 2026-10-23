package Sistema;// [REQUISITO: Package]

import Modelo.Usuario;
import Gestores.*;
import Modelo.Producto;
import Modelo.Medicamento;
import Modelo.Suplementos;
import Modelo.Cosmeticos;
import static Sistema.Menu.mostrarOpciones;
import java.util.Scanner;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Menu {
    private GestorProductos gestor = new GestorProductos();
// [REQUISITO: Menu-scanner]
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        // Gestor gestor = new Gestor();
        GestorUsuarios gestorU = new GestorUsuarios();
        gestorU.cargar();
        int opcion;
        do {
            mostrarOpciones();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1://TODO: Mostrar productos
                    // listar();
                    break;
                case 2://TODO:Agregar usuario
                    gestorU.agregar(agregarUsuario(sc));
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
        System.out.println("Farmacia Cerrada");
        // Guardar datos nuevos
        gestorU.guardar(); 
        gestorU.listar();
    }

    public static void mostrarOpciones() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Agregar");
        System.out.println("3. Registrar");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }
    //TODO:Mostrar Productos ()
    public void mostrarProductos(){
        //TODO: usar gestor para traer un array de todos los productos
        //TODO: Iterar lista para mostrar producto por producto
    }
    
    public Usuario agregarUsuario(Scanner sc){
        System.out.println("Ingresa nombre usuario ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa Rut usuario: ");
        String rut = sc.nextLine();
        Usuario u = new Usuario(nombre, rut);
        return u;
        
    }
    
    //partimos preguntando de que tipo es el medicamento no obstante es un dato que arrastraremos para despues ya que primero pediremos los datos generales para no tener que sobreescribir los datos que cumplen todos los productos tantas veces
    public void agregarProducto(Scanner sc) {
        System.out.println("Tipo de producto: 1-Medicamento 2-Suplemento 3-Cosmetico");
        int opcion = Integer.parseInt(sc.nextLine());

        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.println("Precio del producto: ");
        int precio = Integer.parseInt(sc.nextLine());

        System.out.println("Stock del producto: ");
        int stock = Integer.parseInt(sc.nextLine());
        
        //los datos especificos de cada producto son solamente booleanos

        switch (opcion) {
            case 1:
                System.out.println("El medicamento requiere receta 1-Si 2-NO: ");
                int subOpcion1 = Integer.parseInt(sc.nextLine());
                boolean receta = (subOpcion1 == 1);
                gestor.agregarProducto(new Medicamento(stock, precio, nombre, receta));
                // Instanciar o procesar Medicamento con 'receta'
                break;

            case 2:
                System.out.println("El suplemento es de origen animal 1-Si 2-NO: ");
                int subOpcion2 = Integer.parseInt(sc.nextLine());
                boolean origenAnimal = (subOpcion2 == 1);
                gestor.agregarProducto(new Suplementos(stock, precio, nombre, origenAnimal));
                
                // Instanciar o procesar Suplemento con 'esAnimal'
                break;

            case 3:
                System.out.println("El cosmetico es organico 1-Si 2-NO: ");
                int subOpcion3 = Integer.parseInt(sc.nextLine());
                boolean organico = (subOpcion3 == 1);
                gestor.agregarProducto(new Cosmeticos(stock, precio, nombre, organico));
                // Instanciar o procesar Cosmetico con 'esOrganico'
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
        }
/*
partimos preguntando de que tipo es el medicamento no obstante es un dato
que arrastraremos para despues ya que primero pediremos los datos generales para
no tener que sobreescribir los datos que cumplen todos los productos tantas veces    
*/ 
    
