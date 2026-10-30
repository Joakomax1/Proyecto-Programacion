package Modelo;// [REQUISITO: Package]

import Interfaces.Consultable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class Usuario implements Consultable, Serializable {

    private static final long serialVersionUID = 1L; // [REQUISITO: Persistencia]
    private String rut;
    private String nombre;
    private ArrayList<Boleta> transacciones;
    private int totalGastado;

    public Usuario(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
        this.transacciones = new ArrayList<>();
        this.totalGastado = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public ArrayList<Boleta> getTransacciones() {
        return transacciones;
    }

    public int getTotalTransacciones() {
        return totalGastado;
    }

    public void addTransaccion(Boleta boleta) {
        this.transacciones.add(boleta);
        this.totalGastado += boleta.getPrecioTotal();
    }

    @Override//[REQUISITO: INTERFACE] // [REQUISITO: 3.1. Gestión de clases principales]]
    public String obtenerFichaDetallada() {
        String resultado = ""; // Crea un String común

        resultado += "\n=== PERFIL DE CLIENTE ===\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "RUT: " + rut + "\n";
        resultado += "Total Gastado: $" + totalGastado + "\n";
        resultado += "Compras realizadas: " + transacciones.size() + "\n";

        if (!transacciones.isEmpty()) {
            resultado += "\n-- Historial de Boletas --\n";
            for (Boleta b : transacciones) {
                resultado += " Boleta Numero: " + b.getId() + " | Total: $" + b.getPrecioTotal() + "\n";
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return String.format("RUT: %s | Nombre: %s | Gastado: $%d", rut, nombre, totalGastado);
    }
}
