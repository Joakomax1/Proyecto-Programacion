package Sistema;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
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
        public void mostrarMenu(){
            Scanner sc = new Scanner(System.in);
            int opcion;
            do {
                mostrarOpciones();
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1: 
    //                    listar();
                        break;
                    case 2:
                        agregarUsuario(scanner.sc);
                        break;
                    case 3: 
                        agregarProducto(scanner.sc);

                        break; 
                    case 0:
                        System.out.println("Buscar usuario");
                        String rut = sc.nextLine();



                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (opcion != 0);
            sc.close();
            //TODO: Menu
            // 
}
}
    public static void mostrarOpciones(){
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Listar");
            System.out.println("2. Ranking");
            System.out.println("2. Registrar");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
    }
}
//falta el gestorProductos

public agregarUsuario(scanner.sc){
    System.out.println("Nombre del Cliente:  ");
    String nombre = sc.nextLine();

    System.out.println("Rut del usuario: ");
    String rut = sc.nextLine();
}
//partimos preguntando de que tipo es el medicamento no obstante es un dato que arrastraremos para despues ya que primero pediremos los datos generales para no tener que sobreescribir los datos que cumplen todos los productos tantas veces
public agregarProducto(scanner.sc)
     System.out.println("Tipo de producto: 1-Medicamento 2-Suplemento 3-Cosmetico");
     int opcion = sc.nextLine();

     System.out.println("Nombre del producto:  ");
     String nombre = sc.nextLine();

     System.out.println("precio del producto:  ");
     int precio = sc.nextLine();

     System.out.println("Stock del producto:  ");
     int stock = sc.nextLine();

     do{
//los datos especificos de cada producto son solamente booleanos
}
     switch (opcion){
        case 1{
                System.out.println("El medicamento requiere receta 1-Si 2-NO  ");
                int opcion = sc.nextLine();
                if (opcion==1){
                receta=true}
                if (opcion==2){
                receta==false}
        case 2{
               System.out.println("El medicamento es de origen animal 1-Si 2-NO  ");
               int opcion = sc.nextLine();
               if (opcion==1){
               receta=true}
               if (opcion==2){
               receta==false}
        case 3{
                       System.out.println("El medicamento es organico 1-Si 2-NO  ");
                       int opcion = sc.nextLine();
                       if (opcion==1){
                       receta=true}
                       if (opcion==2){
                       receta==false}
}
             
}

}

