package Modelo;

/*
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
import Enums.Marca;

public class Medicamento extends Producto {

    private static final long serialVersionUID = 1L;
    private boolean receta;
    //[REQUISITO: FINAL]
    private final float DESCUENTO = (float) 0.25;

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
    public int calcularDescuento() {
        // Medicamentos CON receta tienen 25% de descuento
        if (receta == false) {
            return 0;
        } else {
            return (int) (precio * DESCUENTO);
        }
    }

    @Override//[REQUISITO: INTERFACE] // [REQUISITO: 3.1. Gestión de clases principales]]
    public String obtenerFichaDetallada() {
        if (receta == false) {// DESCONTADO
            return String.format("MEDICAMENTO | ID: %d | %s | Marca: %s | Requiere Receta: %s | Precio: $%d | Stock: %d",
                    getId(), nombre, marca, receta ? "SI" : "NO", precio, stock);
        } else {
            return String.format("MEDICAMENTO | ID: %d | %s | Marca: %s | Requiere Receta: %s | Precio: $%d DESCONTADO: $%d | Stock: %d",
                    getId(), nombre, marca, receta ? "SI" : "NO", precio, getPrecioDescontado(), stock);
        }

    }

    @Override
    public String toString() {
        return super.toString() + " | Receta: " + (receta ? "SI" : "NO");
    }
}
