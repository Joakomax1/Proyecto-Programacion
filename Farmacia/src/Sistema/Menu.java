package Sistema;

import Modelo.Boleta;
import Enums.Marca;
import Excepciones.RegistroUsuarioExcepcion;
import Excepciones.StockInsuficienteException;
import Gestores.GestorBoletas;
import Gestores.GestorEstadisticas;
import Gestores.GestorProductos;
import Gestores.GestorUsuarios;
import Modelo.Cosmeticos;
import Modelo.Medicamento;
import Modelo.Producto;
import Modelo.Suplementos;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private GestorProductos gestorP = new GestorProductos();
    private GestorUsuarios gestorU = new GestorUsuarios();
    private GestorBoletas gestorB = new GestorBoletas();
    private GestorEstadisticas gestorE = new GestorEstadisticas();

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        // Carga persistente completa
        gestorU.cargar();
        gestorP.cargar();
        gestorB.cargar(gestorU, gestorP);

        int opcion;
        do {
            mostrarOpciones();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1: // Mostrar / Comprar Productos // [REQUISITO: 3.3. Operaciones principales]
                        if (gestorP.listar()) {
                            System.out.println("\nSelecciona ID del producto a comprar (0 para volver): ");
                            int idSel = getInt(sc);
                            if (idSel != 0) {
                                comprarProductoPorId(sc, idSel);
                            }
                        }
                        break;
                    case 2: // Buscar Producto por ID
                        System.out.print("Ingresa el ID del producto a buscar: ");
                        int idBuscar = getInt(sc);
                        Producto pBuscado = gestorP.buscarPorId(idBuscar);
                        if (pBuscado != null) {
                            System.out.println("\nProducto Encontrado:\n" + pBuscado.obtenerFichaDetallada());
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;
                    case 3: // Ordenar Productos // [REQUISITO: 3.1. Gestión de clases principales]]
                        System.out.println("1. Ordenar por Precio 2. Ordenar por Nombre");
                        int subO = getInt(sc);
                        if (subO == 1) {
                            gestorP.ordenarPorPrecio();
                        } else if (subO == 2) {
                            gestorP.ordenarPorNombre();
                        }
                        gestorP.listar();
                        break;
                    case 4: // Agregar Usuario
                        try {
                            gestorU.agregar(crearUsuario(sc));
                        } catch (RegistroUsuarioExcepcion e) {
                            System.out.println("Error al agregar usuario: " + e.getMessage());
                        }
                        break;
                    case 5: // Agregar Producto // [REQUISITO: 3.1. Gestión de clases principales]]
                        agregarProducto(sc);
                        break;
                    case 6: // Consultar Perfil Cliente por RUT // [REQUISITO: 3.2. Gestión de clientes / usuarios]]
                        System.out.print("Ingresa el RUT del usuario: ");
                        String rutB = sc.nextLine();
                        Usuario usuarioEncontrado = gestorU.buscarPorRut(rutB);
                        if (usuarioEncontrado != null) {
                            System.out.println(usuarioEncontrado.obtenerFichaDetallada());
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;
                    case 7: // Historial Global de Boletas
                        gestorB.listar();
                        break;
                    case 8: // Estadísticas// [REQUISITO: 3.4. Ranking / Reporte]
                        gestorE.getTopComprador(gestorU.getLista());
                        gestorE.getTopProducto(gestorB.getLista());
                        gestorE.getVentasHistoricas(gestorB.getLista());// [REQUISITO: 3.3. Operaciones principales]
                        break;
                    case 0:
                        System.out.println("Cerrando el sistema y guardando estado...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {// [REQUISITO EXEPCION] // SCANNER

                System.out.println("Error: Debe ingresar un numero valido.");
                opcion = 99;
            } catch (StockInsuficienteException e) {// [REQUISITO EXEPCION]

                System.out.println("Error de Stock: " + e.getMessage());
                opcion = 99;
            }
        } while (opcion != 0);

        // Guardado de estado final
        // [REQUISITO: 3.5. General ]
        gestorU.guardar();
        gestorP.guardar();
        gestorB.guardar();
        sc.close();
        System.out.println("Sistema finalizado.");
    }

    public static void mostrarOpciones() {
        System.out.println("\n=== SISTEMA DE GESTION FARMACIA ===");
        System.out.println("1. Mostrar y Comprar Productos");
        System.out.println("2. Buscar Producto por ID");
        System.out.println("3. Ordenar Catalogo de Productos");
        System.out.println("4. Registrar Usuario");
        System.out.println("5. Registrar Producto");
        System.out.println("6. Consultar Perfil de Cliente por RUT");
        System.out.println("7. Ver Historial Global de Boletas");
        System.out.println("8. Ver Reportes y Estadisticas");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    private Usuario crearUsuario(Scanner sc) {
        System.out.println("\n=== REGISTRO DE USUARIO ===");
        System.out.print("Ingresa nombre del usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresa RUT del usuario: ");
        String rut = sc.nextLine();
        Usuario nuevoUsuario = new Usuario(nombre, rut);
        try { // [REQUISITO 2.7. Manejo de excepciones]
            // Intentamos agregar el usuario a través del gestor
            gestorU.agregar(nuevoUsuario);
            return nuevoUsuario; // Retorna el usuario si se guardó con éxito
        } catch (RegistroUsuarioExcepcion e) {
            // Se atrapa el throw generado en GestorUsuarios
            System.out.println("\nERROR : " + e.getMessage());
        }

        return null;
    }

    public void comprarProductoPorId(Scanner sc, int idProducto) {
        Producto productos;
        int cantidades;
        int valores;

        Producto producto = gestorP.buscarPorId(idProducto);
        // ID existe o NO
        if (producto == null) {
            System.out.println("El producto con ID " + idProducto + " no existe.");
            return;
        }
        // Stock es 0
        if (producto.getStock() <= 0) {
            System.out.println("El producto sin stock.");
            return;
        }
        // Seleccion de stock en rango
        System.out.println("Cuantas unidades? Disponibles: " + producto.getStock() + " : ");
        int cant = getInt(sc);
        if (cant < 1 || cant > producto.getStock()) {
            throw new StockInsuficienteException(producto.getStock(), cant);// [REQUISITO 2.7. Manejo de excepciones]
        }
        // Si se agrega verificar que el usuario existe
        System.out.println("Ingresa el RUT del cliente que realiza la compra: ");
        String rut = sc.nextLine();
        Usuario usuario = gestorU.buscarPorRut(rut);
        // Registrar usuario
        System.out.println("\nUsuario no encontrado, Registrate.");
        do {
            try {
                usuario = crearUsuario(sc);
            } catch (RegistroUsuarioExcepcion e) {
                // Se atrapa el throw generado en GestorUsuarios
                System.out.println("\nERROR Hack : " + e.getMessage());
            }
        } while (usuario == null);

        // datos definidos
        productos = producto;
        cantidades = cant;
        valores = producto.calcularDescuento();

        // restar stock comprado
        producto.setStock(producto.getStock() - cant);
        // Crear Boleta y adjuntar al usuario
        Boleta boleta = new Boleta(usuario, productos, cantidades, valores);
        gestorB.agregar(boleta);
        usuario.addTransaccion(boleta);
        //usuario.setTotalGastado(boleta.getPrecioTotal());

        System.out.println("\n=== COMPRA COMPLETADA CON EXITO ===");
        System.out.println(boleta);
    }

    public void agregarProducto(Scanner sc) {
        System.out.println("\nTipo de producto: 1-Medicamento 2-Suplemento 3-Cosmetico");
        int opcion;
        //Solicitar datos
        do {
            opcion = getInt(sc);
            if (opcion < 1 || opcion > 3) {
                System.out.println("\nOpcion invalida, intente denuevo:    ");
            }
        } while (opcion < 1 || opcion > 3);

        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Precio del producto: ");
        int precio = getInt(sc);
        System.out.println("Stock del producto: ");
        int stock = getInt(sc);
        // Imprime Todas las Marcas
        Marca.listarMarcas();
        // Seleccionar marca
        System.out.println("SeleccionaMarca: ");
        int marcaSelect = getInt(sc);
        Marca marca = Marca.getPorPos(marcaSelect);

        switch (opcion) {
            case 1:// Medicamento
                System.out.println("El medicamento requiere receta 1-Si 2-NO: ");
                int subOpcion1 = getInt(sc);
                boolean receta = (subOpcion1 == 1);
                // Instanciar o procesar Medicamento con 'receta'
                gestorP.agregar(new Medicamento(stock, precio, nombre, receta, marca));
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

    public int getInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }
}
