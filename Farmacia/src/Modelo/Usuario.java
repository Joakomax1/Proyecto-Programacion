package Modelo;// [REQUISITO: Package]

import Sistema.Boleta;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L; // [REQUISITO: Persistencia] OPCIONAL
    private String rut;
    private String nombre;
    private LocalDate fechaCreacion = LocalDate.now();
    private ArrayList<Boleta> transacciones;
    private int totalTransacciones;

    public Usuario(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
        this.transacciones = new ArrayList<>();
        this.totalTransacciones = 0;

    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Boleta> getTransacciones() {
        return transacciones;
    }
    
    public int getTotalTransacciones(){
        return totalTransacciones;
    }

    public String getRut() {
        return rut;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTransacciones(Boleta transaccion) {
        this.transacciones.add(transaccion);
    }

    public void setTotalTransacciones(int valor) {
        this.totalTransacciones += valor;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


}
