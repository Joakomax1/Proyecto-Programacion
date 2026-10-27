package Sistema;// [REQUISITO: Package]

import Modelo.Usuario;
import Gestores.GestorProductos;
import Gestores.GestorUsuarios;
import Gestores.GestorBoletas;
import Modelo.Producto;
import Modelo.Medicamento;
import Modelo.Suplementos;
import Modelo.Cosmeticos;
import java.util.Scanner;
import Enums.Marca;
import Gestores.GestorEstadisticas;
import java.util.ArrayList;
/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Menu {
    private GestorProductos gestorP = new GestorProductos();
    private GestorUsuarios gestorU = new GestorUsuarios();
    private GestorBoletas gestorB = new GestorBoletas();
    private GestorEstadisticas gestorE = new GestorEstadisticas();
    // [REQUISITO: Menu-scanner]
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        // Cargar archivos memoria
        gestorU.cargar();
        gestorP.cargar();
        gestorB.cargar();
//        gestorU.listar();
//        gestorP.listar();
//        gestorB.listar();
        int opcion;
        do {
            mostrarOpciones();
            opcion = getInt(sc);//Metodo reducir texto goto def
            switch (opcion) {
                case 1: // Listar Comprar                   
                    if (mostrarProductos()) { // Mostrar retorna true or false si tiene stock
                        System.out.println("\nSelecciona el producto 0 para volver atras: ");
                        opcion = getInt(sc);
                        if (opcion == 0) {
                            break;
                        }
                        comprarProductos(sc, opcion); // Pasa el producto ya seleccionado
                    }
                    break;
                case 2://Agregar Usuario
                    gestorU.agregar(agregarUsuario(sc));
                    break;
                case 3://Agregar Producto
                    agregarProducto(sc);
                    break;
                case 4://Editar Producto
                    // TODO: INVOCAR FUNCIONES
                    break;
                case 5://Eliminar Producto
                    // TODO: INVOCAR FUNCIONES
                    break;
                case 6://Estadisticas
                    //TODO:Mostrar productos más vendidos
                    //TODO:Mostrar productos más comprados por usuario
                    //TODO:Mostrar ventas Históricas
                    mostrarGestorEstadisticas( );
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
        // Guardar Boletas 
        gestorB.guardar();
    }

    public static void mostrarOpciones() {
        System.out.println("\n=== MENU ===");
        System.out.println("\n=== COMPRAR ===");
        System.out.println("1. Mostrar Productos");
        System.out.println("\n=== GESTION ===");
        System.out.println("2. Agregar usuario");
        System.out.println("3. Agregar producto");
        System.out.println("4. editar producto");
        System.out.println("5. eliminar producto");
        System.out.println("6. Ver estadisicas de la Farmacia");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }
    
    public boolean mostrarProductos(){
        // Retorna True or False dependiendo de Stock
         return gestorP.listar();  
    }
    
    public void mostrarUsuarios(){
         gestorU.listar();
    }
    
    public void mostrarGestorEstadisticas( ){
    System.out.println("                                               ");
    gestorE.getTopProducto(gestorB.getLista(), gestorP.getLista());
    gestorE.getTopComprador(gestorU.getLista());
    gestorE.getVentasHistoricas(gestorB.getLista());
    }
    
    public Usuario agregarUsuario(Scanner sc){
        System.out.println("Ingresa nombre usuario ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa Rut usuario: ");
        String rut = sc.nextLine();
        Usuario u = new Usuario(nombre, rut);
        return u;     
    }

    public void comprarProductos(Scanner sc, int opcion) {
        ArrayList<Integer> cantidad = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        ArrayList<Producto> listaCompra = new ArrayList<>();
        int cantidadProductos = gestorP.getLista().size();
        //Comprar productos looop
        do {
            // Seleccionar producto
            while (opcion < 1 || opcion > cantidadProductos) {
                System.out.println("\nProducto no existe, intente de nuevo: ");
                opcion = getInt(sc);
            }
            // Conseguir objeto producto seleccionado
            Producto producto = (Producto) gestorP.getLista().get(opcion - 1);
            listaCompra.add(producto); // agregar a lista de compra
            // TODO: Verificar que hay suficientes unidades de stock
            // Pedir cantidad
            System.out.println("\nCuantas unidades? Disponibles: " + producto.getStock());
            int cant = getInt(sc);
            cantidad.add(cant);
            valores.add(producto.getPrecio());
            // Preguntar si desea continuar comprando
            if (gestorP.listar()) {
                System.out.print("Opcion (0 para terminar): ");
                opcion = getInt(sc);
            } else {
                opcion = 0; // si no hay stock termina
            }
        } while (opcion != 0);
        // TODO: Preguntar Si desea agregar nuevo usuario o no
        // Si se agrega verificar que el usuario existe
        Usuario usuario = agregarUsuario(sc);
        gestorU.agregar(usuario);
        // Crear Boleta
        Boleta boleta = new Boleta(usuario, listaCompra, cantidad, valores);
        gestorB.agregar(boleta);
        //
        // Adjuntar boleta a usuario
        System.out.println(boleta);
        usuario.setTransacciones(boleta);
        System.out.println("\n=== TRANSACCION COMPLETA ===");
    }
    
    //partimos preguntando de que tipo es el medicamento no obstante es un dato que arrastraremos para despues ya que primero pediremos los datos generales para no tener que sobreescribir los datos que cumplen todos los productos tantas veces
    public void agregarProducto(Scanner sc) {
        System.out.println("\nTipo de producto: 1-Medicamento 2-Suplemento 3-Cosmetico");
        int opcion;
        do {
            opcion = getInt(sc);
            if (opcion < 1 || opcion > 3) {
                System.out.println("\nOpcion invalida, intente denuevo:    ");
            }
        } while (opcion < 1 || opcion > 3);
        //Solicitar datos
        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Precio del producto: ");
        int precio = getInt(sc);
        System.out.println("Stock del producto: ");
        int stock = getInt(sc);    
        // Imprime Todas las Marcas
        Marca.listarMarcas();
        // Seleccionar marca
        System.out.println("Que marca es el producto: ");
        int marcaSelect;
        do {
            marcaSelect = getInt(sc);
            if (marcaSelect < 1 || marcaSelect > Marca.getCantidad()) {
                System.out.println("  Opcion invalida, intente denuevo:    ");
            }
        } while (marcaSelect < 1 || marcaSelect > Marca.getCantidad());
        // convierte seleccion en un enum
        Marca marca = Marca.getPorPos(marcaSelect);
        
        switch (opcion) {
            case 1:// Medicamento
                System.out.println("El medicamento requiere receta 1-Si 2-NO: ");
                int subOpcion1 = getInt(sc);
                boolean receta = (subOpcion1 == 1);
                
                gestorP.agregar(new Medicamento(stock, precio, nombre, receta, marca));
                // Instanciar o procesar Medicamento con 'receta'
                break;

            case 2:// Suplemento
                System.out.println("El suplemento es de origen animal 1-Si 2-NO: ");
                int subOpcion2 = getInt(sc);
                // Instanciar o procesar Suplemento con 'esAnimal'
                boolean origenAnimal = (subOpcion2 == 1);
                gestorP.agregar(new Suplementos(stock, precio, nombre, origenAnimal, marca));
                break;
            case 3:// Cosmetico
                System.out.println("El cosmetico es organico 1-Si 2-NO: ");
                int subOpcion3 = getInt(sc);
                // Instanciar o procesar Cosmetico con 'esOrganico'
                boolean organico = (subOpcion3 == 1);
                gestorP.agregar(new Cosmeticos(stock, precio, nombre, organico, marca));
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    public int getInt(Scanner sc){
            return Integer.parseInt(sc.nextLine());
        }
}

    
