package Excepciones;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(int actual, int pedido) {
        super("Stock insuficiente: hay " + actual
                + ", se pidieron " + pedido + ".");
    }
}
