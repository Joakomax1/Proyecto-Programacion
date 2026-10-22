package Modelo;// [REQUISITO: Package]

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */

public class Suplementos extends Producto{
    private boolean origenAnimal_Vegetal;

    public Suplementos(boolean origenAnimal_Vegetal, int stock, int precio, String nombre, int staticID, boolean estado) {
        super(stock, precio, nombre, staticID, estado);
        this.origenAnimal_Vegetal = origenAnimal_Vegetal;
    }

    @Override
    public void procesarVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void verificarStock() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void verificarReceta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
