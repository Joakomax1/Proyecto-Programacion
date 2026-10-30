package Gestores;

import Enums.Marca;
import Excepciones.StockInsuficienteException;
import Modelo.Producto;
import Modelo.Usuario;
import Modelo.Boleta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author joako
 */
public class GestorBoletas {

    private static final String ARCHIVO = "boletas.dat"; // nombre del archivo

    private ArrayList<Boleta> lista;
    // inicializar array

    public GestorBoletas() {
        lista = new ArrayList<>();

    }

    public ArrayList getLista() {
        return lista;
    }

    // ── Guardar: lee la lista desde el disco ──────────────────
    public void agregar(Boleta b) {
        if (0 < (b.getCantidad() - b.getProducto().getStock())) {
            throw new StockInsuficienteException(b.getProducto().getStock(), (int) b.getCantidad());
        } else {
            lista.add(b);
            System.out.println("Producto Comprado Exitosamente: " + b.getProducto().getNombre());
        }
    }

    // ── GUARDAR: escribe la lista al disco ───────────────────
    //  [REQUISITO: Persistencia]
    public void guardar() {
        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            //System.out.println(lista);
            oos.writeObject(lista);
            System.out.println("Guardado: " + lista.size() + " Compras(s) en '"
                    + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // ── listar: Mostrar todo ──────────────────
    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("Sin boletas.");
            return;
        }
        System.out.println("\n=== Boleta (" + lista.size() + ") ===");
        for (Boleta b : lista) {
            System.out.println(b);
        }
    }

    // ── CARGAR: lee la lista desde el disco ──────────────────
    //  [REQUISITO: Persistencia]
    @SuppressWarnings("unchecked")
    public void cargar(GestorUsuarios gestorU, GestorProductos gestorP) {

        File archivo = new File(ARCHIVO);

        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("No hay datos guardados BOLETAS GENERAR.\n");
            precargarDatos(gestorU, gestorP);
            return;
        }

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            lista = (ArrayList<Boleta>) ois.readObject();
            System.out.println("Cargado: " + lista.size() + " producto(s) desde '"
                    + ARCHIVO + "'.");

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
            lista = new ArrayList<>();
            precargarDatos(gestorU, gestorP);

        } catch (ClassNotFoundException e) {
            System.out.println("Archivo incompatible con esta versión.");
            // TODO: remover archivo
            lista = new ArrayList<>();
            precargarDatos(gestorU, gestorP);
        }
    }

    // [REQUISITO: 4. Datos Precargados Obligatorios]
    public void precargarDatos(GestorUsuarios gestorU, GestorProductos gestorP) {
        if (gestorU.getLista().isEmpty() || gestorP.getLista().isEmpty()) {
            gestorU.precargarDatos();
            gestorP.precargarDatos();
        }
        int cantidad = 0;
        for (int i = 0; i < 8; i++) {
            Producto producto;
            int valor;
            // Conseguir usuarios y productos
            Usuario u = (Usuario) gestorU.getLista().get((i % 2) + 1);
            Producto p = (Producto) gestorP.getLista().get((i % 3) + 1);
            // rellenar arraylists con datos
            producto = p;
            cantidad = (i % 3) + 1;
            valor = p.getPrecio();
            // generar boleta 
            Boleta b = new Boleta(u, producto, cantidad, valor);
            agregar(b);
            // agregar transaccion al usuario
            u.addTransaccion(b);
        }
        System.out.println(String.format("%d Boletas generadas", 8));
        guardar();
    }

    public int getTamanio() {
        return lista.size();
    }
}
