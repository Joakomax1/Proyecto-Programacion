/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
