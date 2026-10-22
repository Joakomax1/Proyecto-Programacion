package Modelo;


import Sistema.Boleta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joako
 */
public class Usuario {

    public static void setNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private HashMap<String,String> usuarios;
    private String rut;
    private String nombre;
    private LocalDate fechaCreacion = LocalDate.now();  
    private ArrayList<Boleta> Transacciones;

    public Usuario() {
        this.usuarios =new HashMap<>();
        usuarios.put(nombre, rut);
    }
    
 
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTransacciones(ArrayList<Boleta> Transacciones) {
        this.Transacciones = Transacciones;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Boleta> getTransacciones() {
        return Transacciones;
    }

    public Usuario(String rut, String nombre, ArrayList<Boleta> Transacciones) {
        this.rut = rut;
        this.nombre = nombre;
        this.Transacciones = Transacciones;
    }

    public void setUsuarios(HashMap<String, String> usuarios) {
        this.usuarios = usuarios;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
     
}
