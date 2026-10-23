package Modelo;// [REQUISITO: Package]

import Enums.Marca;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class Suplementos extends Producto{
    private boolean origenAnimal;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
