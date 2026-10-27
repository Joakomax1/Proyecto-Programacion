package Modelo;

import Enums.Marca;
import java.io.Serializable;

 /*
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Medicamento extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean receta;

    public Medicamento(int stock, int precio, String nombre, boolean receta, Marca marca) {
        super(stock, precio, nombre, marca);
        this.receta = receta;
    }

    public boolean isReceta() {
        return receta;
    }

    public void setReceta(boolean receta) {
        this.receta = receta;
    }

    @Override
    public void procesarVenta() {
        // Implementar lógica específica
    }

    @Override
    public void verificarStock() {
        // Implementar lógica específica
    }

    @Override
    public void verificarReceta() {
        // Implementar lógica específica
    }
}