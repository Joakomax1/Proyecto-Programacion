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

public class RegistroUsuarioException extends RuntimeException {
    public RegistroUsuarioException(String nombre) {
        super("Error registro usuario: " + nombre
        );
    }
    public RegistroUsuarioException(String nombre, String rut) {
        super("Error registro usuario: " + nombre + " "
                + " Rut: " + rut
        );
    }
    
    
}
