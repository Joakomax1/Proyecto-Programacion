package Sistema;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Modelo.Usuario;
import Modelo.Producto;
import Modelo.Medicamento;
import Modelo.Suplementos;
import Modelo.Cosmeticos;
import java.util.Scanner;

/**
 *
 * @author joako
 */

public class Menu {

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
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

    public void agregarUsuario(Scanner sc) {
        System.out.println("Nombre del Cliente:  ");
        String nombre = sc.nextLine();

        System.out.println("Rut del usuario: ");
        String rut = sc.nextLine();
    }
/*
partimos preguntando de que tipo es el medicamento no obstante es un dato
que arrastraremos para despues ya que primero pediremos los datos generales para
no tener que sobreescribir los datos que cumplen todos los productos tantas veces    
*/ 
    
    public void agregarProducto(Scanner sc) {

    }
}

//public void agregarProducto(Scanner sc){
//    System.out.println("Tipo de producto: 1-Medicamento 2-Suplemento 3-Cosmetico");
//    int opcion = sc.nextLine();
//
//    System.out.println("Nombre del producto:  ");
//    String nombre = sc.nextLine();
//
//    System.out.println("precio del producto:  ");
//    int precio = sc.nextLine();
//
//    System.out.println("Stock del producto:  ");
//    int stock = sc.nextLine();
//    
//     switch (opcion){
//        case 1{
//            System.out.println("El medicamento requiere receta 1-Si 2-NO  ");
//            int opcion = sc.nextLine();
//            if (opcion==1){
//            receta=true}
//            else if (opcion==2){
//            receta==false}
//        case 2{
//            System.out.println("El medicamento es de origen animal 1-Si 2-NO  ");
//            int opcion = sc.nextLine();
//            if (opcion==1){
//            receta=true}
//            else if (opcion==2){
//            receta==false}
//        case 3{
//            System.out.println("El medicamento es organico 1-Si 2-NO  ");
//            int opcion = sc.nextLine();
//            if (opcion==1){
//            receta=true}
//            if (opcion==2){
//            receta==false}
//        }        
//    }
//}