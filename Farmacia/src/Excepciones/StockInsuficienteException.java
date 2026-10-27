package Excepciones;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
// Paso 1: Crear la clase de excepción 

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(int actual, int pedido) {
        super("Stock insuficiente: hay " + actual
                + ", se pidieron " + pedido + ".");
    }
}
