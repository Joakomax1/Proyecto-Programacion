package Gestores;

import Enums.Marca;
import Modelo.Cosmeticos;
import Modelo.Medicamento;
import Modelo.Producto;
import Modelo.Suplementos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author joako
 */
public class GestorProductos {

    private static final String ARCHIVO = "productos.dat"; // nombre del archivo

    private ArrayList<Producto> lista;
    // inicializar array

    public GestorProductos() {
        lista = new ArrayList<>();

    }

    public ArrayList getLista() {
        return lista;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    //[REQUISITO: COLECCION]
    public void ordenarPorPrecio() {
        Collections.sort(lista, (p1, p2) -> Integer.compare(p1.getPrecio(), p2.getPrecio()));
        System.out.println("Productos ordenados por precio ascendente. [menor a mayor]");
    }

    //[REQUISITO: COLECCION]
    public void ordenarPorNombre() {
        Collections.sort(lista, (p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
        System.out.println("Productos ordenados alfabeticamente por nombre. [A-Z]");
    }

    // ── Guardar: lee la lista desde el disco ──────────────────
    public void agregar(Producto p) {
        lista.add(p);
        System.out.println("Producto exitosamente agregado: " + p.getNombre());
    }

    // ── GUARDAR: escribe la lista al disco ───────────────────
    //  [REQUISITO: Persistencia]
    public void guardar() {
        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            //System.out.println(lista);
            oos.writeObject(lista);
            System.out.println("Guardado: " + lista.size() + " producto(s) en '"
                    + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // ── listar: Mostrar todo ──────────────────
    public boolean listar() {
        if (lista.isEmpty()) {
            System.out.println("\nNo hay Stock!!!.");
            return false;
        }
        System.out.println("\n=== Productos (" + lista.size() + ") ===");
        for (int i = 0; i < lista.size(); i++) {
            Producto p = lista.get(i);
            System.out.println("  " + p.obtenerFichaDetallada());
        }
        return true;
    }

    // ── CARGAR: lee la lista desde el disco ──────────────────
    //  [REQUISITO: Persistencia]
    @SuppressWarnings("unchecked")
    public void cargar() {
        File archivo = new File(ARCHIVO);

        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("No hay datos guardados PRODUCTOS GENERAR.\n");
            precargarDatos();
            return;
        }

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            lista = (ArrayList<Producto>) ois.readObject();
            System.out.println("Cargado: " + lista.size() + " producto(s) desde '"
                    + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
            lista = new ArrayList<>();
            precargarDatos();

        } catch (ClassNotFoundException e) {
            System.out.println("Archivo incompatible con esta versión.");
            // TODO: remover archivo
            lista = new ArrayList<>();
            precargarDatos();
        }
    }
    // [REQUISITO: 4. Datos Precargados Obligatorios]
    public void precargarDatos() {
        //Medicamentos
        agregar(new Medicamento(15, 2500, "Paracetamol 500", false, Marca.Bayer));
        agregar(new Medicamento(10, 8900, "Ibuprofeno 200", true, Marca.Pfizer_Chile));
        agregar(new Medicamento(8, 12500, "Amoxicilina 250", true, Marca.Knop_Laboratorios));

        // Suplementos
        agregar(new Suplementos(20, 15900, "Creatina 1k", false, Marca.Wild_Protein));
        agregar(new Suplementos(12, 19900, "Proteina 1kg", true, Marca.ProteinMix));
        agregar(new Suplementos(25, 9900, "Doctor Simi", false, Marca.SimiVit));

        // Cosmetuicos
        agregar(new Cosmeticos(14, 15990, "Crema", false, Marca.CeraVe));
        agregar(new Cosmeticos(9, 22990, "Isdin IV", false, Marca.Isdin));
        agregar(new Cosmeticos(18, 67990, "Crema Vichy", true, Marca.Vichy));

        System.out.println("9 productos agregados.");
        guardar();
        cargar();
    }

    public int getTamanio() {
        return lista.size();
    }
}
