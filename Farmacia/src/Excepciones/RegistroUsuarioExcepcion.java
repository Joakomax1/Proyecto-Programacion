/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author LAB202
 */
// Paso 1: Crear la clase de excepción 

public class RegistroUsuarioExcepcion extends RuntimeException {
    public RegistroUsuarioExcepcion(String nombre) {
        super("Error registro usuario: " + nombre
        );
    }
    public RegistroUsuarioExcepcion(String nombre, String rut) {
        super("Error registro usuario: " + nombre + " "
                + " Rut: " + rut
        );
    }
    
    
}
