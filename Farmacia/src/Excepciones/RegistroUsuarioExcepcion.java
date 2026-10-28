package Excepciones;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
// [REQUISITO EXEPCION]
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
