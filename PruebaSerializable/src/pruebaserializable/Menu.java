/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaserializable;

import java.util.Scanner;

/**
 *
 * @author ramhg
 */
public class Menu {
    public void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();

        // Intentar cargar al arrancar
        gestor.cargar();

        int opcion;
        do {
            System.out.println("\n══════════════════════════");
            System.out.println("  PRODUCTOS — Menú");
            System.out.println("══════════════════════════");
            System.out.println("  1. Agregar producto");
            System.out.println("  2. Listar productos");
            System.out.println("  0. Salir (guarda automático)");
            System.out.print("Opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> agregarProducto(sc, gestor);
                case 2 -> gestor.listar();
                case 0 -> {
                    gestor.guardar();
                    System.out.println("Hasta luego.");
                }
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
    
    private  void agregarProducto(Scanner sc, GestorProductos gestor) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = leerDecimal(sc);

        System.out.print("Stock: ");
        int stock = leerEntero(sc);

        gestor.agregar(new Producto(nombre, precio, stock));
    }

    // Lectura robusta — nunca se cae con entrada inválida
    private  int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número entero: ");
            }
        }
    }

    private  double leerDecimal(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un número válido: ");
            }
        }
    }
}
