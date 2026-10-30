package Modelo;// [REQUISITO: Package]

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
import Enums.Marca;

public class Suplementos extends Producto {
    //[REQUISITO: STATIC]
    private static final long serialVersionUID = 1L;
    private boolean origenAnimal;
    //[REQUISITO: FINAL]
    private final float DESCUENTO = (float) 0.35;

    public Suplementos(int stock, int precio, String nombre, boolean origenAnimal, Marca marca) {
        super(stock, precio, nombre, marca);
        this.origenAnimal = origenAnimal;
    }

    public boolean isOrigenAnimal() {
        return origenAnimal;
    }

    public void setOrigenAnimal(boolean origenAnimal) {
        this.origenAnimal = origenAnimal;
    }

    @Override
    public int calcularDescuento() {
        //Suplementos origen NO animal tienen 35% de descuento
        if (origenAnimal == true) {
            return 0;
        } else {
            return (int) (precio * DESCUENTO);
        }
    }

    @Override//[REQUISITO: INTERFACE] // [REQUISITO: 3.1. Gestión de clases principales]]
    public String obtenerFichaDetallada() {
        if (origenAnimal == false) {// DESCONTADO
            return String.format("SUPLEMENTO | ID: %d | %s | Marca: %s | Origen Animal: %s | Precio: $%d DESCONTADO: $%d, | Stock: %d",
                    getId(), nombre, marca, origenAnimal ? "SI" : "NO", precio, calcularDescuento(), stock);
        } else {
            return String.format("SUPLEMENTO | ID: %d | %s | Marca: %s | Origen Animal: %s | Precio: $%d | Stock: %d",
                    getId(), nombre, marca, origenAnimal ? "SI" : "NO", precio, stock);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Origen Animal: " + (origenAnimal ? "SI" : "NO");
    }
}
