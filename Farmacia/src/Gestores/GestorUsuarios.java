package Gestores;

import Excepciones.RegistroUsuarioExcepcion;
import Modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public class GestorUsuarios {

    private static final String ARCHIVO = "usuarios.dat";
    private ArrayList<Usuario> lista;
    private HashMap<String, Usuario> mapaUsuarios; // [REQUISITO: HashMap]

    // inicializar array
    public GestorUsuarios() {
        lista = new ArrayList<>();
        mapaUsuarios = new HashMap<>();// [REQUISITO: Colecciones]

    }

    public ArrayList getLista() {
        return lista;
    }

    public HashMap<String, Usuario> getMapaUsuarios() {
        return mapaUsuarios;
    }

    // [REQUISITO: Colecciones]
    public Usuario buscarPorRut(String rut) {
        return mapaUsuarios.get(rut);
    }

    // ── Guardar: lee la lista desde el disco ──────────────────
    public void agregar(Usuario u) {
        // [REQUISITO 2.7. Manejo de excepciones]

        // Validar que el objeto y campos no esten vacios
        if (u == null || u.getNombre() == null || u.getNombre().trim().isEmpty()
                || u.getRut() == null || u.getRut().trim().isEmpty()) {
            throw new RegistroUsuarioExcepcion("Datos vacios");
        }
         // Validar si rut esta registrado
        if (buscarPorRut(u.getRut()) != null) {
            throw new RegistroUsuarioExcepcion(u.getNombre(), u.getRut(), buscarPorRut(u.getRut()).getRut());
        }

        // 3. Si pasa las validaciones, se agrega
        lista.add(u);
        System.out.println("Usuario agregado exitosamente: " + u.getNombre() + " (" + u.getRut() + ")");
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
        } catch (RegistroUsuarioExcepcion e) {
            System.out.println("Error: " + e);
        }
    }

    // ── listar: Mostrar todo ──────────────────
    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("No hay datos guardados.");
            precargarDatos();
            return;
        }
        System.out.println("\nUsuarios (" + lista.size() + ") ===");
        for (Usuario u : lista) {
            System.out.println("  " + u);
        }
    }

    // ── CARGAR: lee la lista desde el disco ──────────────────
    //  [REQUISITO: Persistencia]
    @SuppressWarnings("unchecked")
    public void cargar() {
        File archivo = new File(ARCHIVO);

        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("No hay datos guardados USUARIOS GENERAR.");
            precargarDatos();
            poblarHashmap();
            return;
        }

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            lista = (ArrayList<Usuario>) ois.readObject();
            System.out.println("Cargado: " + lista.size() + " producto(s) desde '"
                    + ARCHIVO + "'.");
            poblarHashmap();
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
            lista = new ArrayList<>();
            precargarDatos();
            poblarHashmap();

        } catch (ClassNotFoundException e) {
            System.out.println("Archivo incompatible con esta versión.");
            // TODO: remover archivo
            lista = new ArrayList<>();
            precargarDatos();
            poblarHashmap();

        }
    }

    public void poblarHashmap() {// [REQUISITO: COLECCIONES]
        // Poblar Hashmap
        for (int i = 0; i < lista.size(); i++) {
            mapaUsuarios.put(lista.get(i).getRut(), lista.get(i));
        }

    }

    // [REQUISITO: 4. Datos Precargados Obligatorios]
    public void precargarDatos() {

        // 5 Usuarios obligatorios
        agregar(new Usuario("Joaquin Gutierrez", "111"));
        agregar(new Usuario("Felipe Lorca", "222"));
        agregar(new Usuario("Ian Teixeira", "333"));
        agregar(new Usuario("pepe peper", "444"));
        agregar(new Usuario("pepe pepet", "555"));

        System.out.println("5 usuarios agregados.\n");
        guardar();
        cargar();
    }
}
