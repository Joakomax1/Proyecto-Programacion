package Excepciones;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
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
