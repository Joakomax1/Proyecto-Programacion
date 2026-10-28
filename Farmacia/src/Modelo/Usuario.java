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
    private LocalDate fechaCreacion = LocalDate.now();
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
    
    
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setTotalGastado(int gastado){
        this.totalGastado += gastado;
    }
            
    public void addTransaccion(Boleta boleta) {
        this.transacciones.add(boleta);
        this.totalGastado += boleta.getPrecioTotal();
    }

    @Override//[REQUISITO: INTERFACE] // [REQUISITO: 3.1. Gestión de clases principales]]
    public String obtenerFichaDetallada() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n=== PERFIL DE CLIENTE ===\n")
                .append("Nombre: ").append(nombre).append("\n")
                .append("RUT: ").append(rut).append("\n")
                .append("Fecha Registro: ").append(fechaCreacion).append("\n")
                .append("Total Gastado: $").append(totalGastado).append("\n")
                .append("Compras realizadas: ").append(transacciones.size()).append("\n");
        if (!transacciones.isEmpty()) {
            sb.append("\n-- Historial de Boletas --\n");
            for (Boleta b : transacciones) {
                sb.append(" Boleta N° ").append(b.getId()).append(" | Total: $").append(b.getPrecioTotal()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("RUT: %s | Nombre: %s | Gastado: $%d", rut, nombre, totalGastado);
    }
}
