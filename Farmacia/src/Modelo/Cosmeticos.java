package Modelo;// [REQUISITO: Package]

import Enums.Marca;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class Cosmeticos extends Producto {

    private static final long serialVersionUID = 1L;
    private boolean organico;
    //[REQUISITO: FINAL]
    private final float DESCUENTO = (float) 0.10;

    public Cosmeticos(int stock, int precio, String nombre, boolean organico, Marca marca) {
        super(stock, precio, nombre, marca);
        this.organico = organico;
    }

    public boolean isOrganico() {
        return organico;
    }

    public void setOrganico(boolean organico) {
        this.organico = organico;
    }

    @Override
    public int calcularDescuento() {
        //Cosmeticos NO organicos tienen 10% de descuento
        if (organico == true) {
            return 0;
        } else {
            return (int) (DESCUENTO * precio);
        }
    }

    @Override//[REQUISITO: INTERFACE] // [REQUISITO: 3.1. Gestión de clases principales]]
    public String obtenerFichaDetallada() {
        if (organico == false) {//DESCONTADO
            return String.format("COSMETICO | ID: %d | %s | Marca: %s | Organico: %s | Precio: $%d DESCONTADO: $%d",
                    getId(), nombre, marca, organico ? "SI" : "NO", precio, getPrecioDescontado());
        } else {
            return String.format("COSMETICO | ID: %d | %s | Marca: %s | Organico: %s | Precio: $%d",
                    getId(), nombre, marca, organico ? "SI" : "NO", precio);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Orgánico: " + (organico ? "SI" : "NO");
    }
}
