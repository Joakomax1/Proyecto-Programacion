package Excepciones;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
// [REQUISITO EXEPCION]
public class RegistroUsuarioExcepcion extends RuntimeException {

    public RegistroUsuarioExcepcion(String error) {
        super("Error registro Usuario: " + error);
    }
    public RegistroUsuarioExcepcion(String nombre, String rut) {
        super(String.format("Error registro de Usario: %s & rut %s",
                nombre, rut));
    }

    public RegistroUsuarioExcepcion(String nombre, String rut, String rutRepetido) {
        super(String.format("Error registro de Usario:"
                + " %s & rut %s, Usuario ya existe, la contraseña es %s",
                nombre, rut, rutRepetido));
    }
}
