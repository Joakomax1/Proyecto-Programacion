package Sistema;// [REQUISITO: Package]

import Modelo.Usuario;
import Gestores.GestorProductos;
import Gestores.GestorUsuarios;
import Modelo.Producto;
import Modelo.Medicamento;
import Modelo.Suplementos;
import Modelo.Cosmeticos;
import static Sistema.Menu.mostrarOpciones;
import java.util.Scanner;
import Enums.Marca;
/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Menu {
    private GestorProductos gestorP = new GestorProductos();
    private GestorUsuarios gestorU = new GestorUsuarios();
// [REQUISITO: Menu-scanner]
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        // Cargar archivos memoria
        gestorU.cargar();
        gestorP.cargar();
        gestorU.listar();
        gestorP.listar();
        int opcion;
        do {
            mostrarOpciones();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1://TODO: Mostrar productos
                    mostrarProductos();
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
        // Guardar usuarios 
        gestorU.guardar(); 
        gestorU.listar();
        // Guardar Productos
        gestorP.guardar(); 
        gestorP.listar();
        
    }

    public static void mostrarOpciones() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Mostrar Productos");
        System.out.println("2. Agregar usuario");
        System.out.println("3. Agregar producto");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }
    //TODO:Mostrar Productos ()
    public void mostrarProductos(){
         gestorP.listar();
        //TODO: usar gestor para traer un array de todos los productos
        //TODO: Iterar lista para mostrar producto por producto
    }
    
    public void mostrarUsuarios(){
         gestorU.listar();
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
        int opcion;
        do {
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion < 1 || opcion > 3) {
                System.out.println("  Opcion invalida, intente denuevo:    ");
            }
        } while (opcion < 1 || opcion > 3);
        

        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.println("Precio del producto: ");
        int precio = Integer.parseInt(sc.nextLine());
 

        System.out.println("Stock del producto: ");
        int stock = Integer.parseInt(sc.nextLine());
        
        // Imprime Todas las Marcas
        Marca.listarMarcas();
        
        // Seleccionar marca
        System.out.println("Que marca es el producto: ");
        int marcaSelect;
        do {
            marcaSelect = Integer.parseInt(sc.nextLine());
            if (marcaSelect < 1 || marcaSelect > Marca.getCantidad()) {
                System.out.println("  Opcion invalida, intente denuevo:    ");
            }
        } while (marcaSelect < 1 || marcaSelect > Marca.getCantidad());
        
        // convierte seleccion en un enum
        Marca marca = Marca.getPorPos(marcaSelect);
        
        switch (opcion) {
            case 1:// Medicamento
                System.out.println("El medicamento requiere receta 1-Si 2-NO: ");
                int subOpcion1 = Integer.parseInt(sc.nextLine());
                boolean receta = (subOpcion1 == 1);
                
                gestorP.agregar(new Medicamento(stock, precio, nombre, receta, marca));
                // Instanciar o procesar Medicamento con 'receta'
                break;

            case 2:// Suplemento
                System.out.println("El suplemento es de origen animal 1-Si 2-NO: ");
                int subOpcion2 = Integer.parseInt(sc.nextLine());
                boolean origenAnimal = (subOpcion2 == 1);
                gestorP.agregar(new Suplementos(stock, precio, nombre, origenAnimal, marca));
                
                // Instanciar o procesar Suplemento con 'esAnimal'
                break;

            case 3:// Cosmetico
                System.out.println("El cosmetico es organico 1-Si 2-NO: ");
                int subOpcion3 = Integer.parseInt(sc.nextLine());
                boolean organico = (subOpcion3 == 1);
                gestorP.agregar(new Cosmeticos(stock, precio, nombre, organico, marca));
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
    
