package model;

import java.io.FileWriter;
import java.io.IOException;
import Model.Usuario;

public class UsuarioDAO {

    private final String ARCHIVO = "usuarios.txt";

    public boolean guardar(Usuario u) {
        try (FileWriter fw = new FileWriter(ARCHIVO, true)) {
            fw.write(u.getNombre() + "," +
                     u.getApellido() + "," +
                     u.getEmail() + "," +
                     u.getCedula() + "," +
                     u.getTelefono() + "," +
                     u.getPassword() + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
}

