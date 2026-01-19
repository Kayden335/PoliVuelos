package controller;

import Model.Usuario;
import View.FrmRegistro;
import model.UsuarioDAO;

public class UsuarioController {

    private FrmRegistro vista;
    private UsuarioDAO modelo;

    public UsuarioController(FrmRegistro vista, UsuarioDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciar() {
        vista.setVisible(true);

        vista.getBtnRegistrar().addActionListener(e -> registrar());
        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());
    }

    private void registrar() {
        Usuario u = vista.getUsuarioDesdeFormulario();

        if (u.getNombre().isEmpty() || u.getEmail().isEmpty() || u.getPassword().isEmpty()) {
            vista.mostrarMensaje("Completa los campos obligatorios");
            return;
        }

        if (modelo.guardar(u)) {
            vista.mostrarMensaje("Registro exitoso");
            vista.limpiarFormulario();
        } else {
            vista.mostrarMensaje("Error al registrar usuario");
        }
    }
}
