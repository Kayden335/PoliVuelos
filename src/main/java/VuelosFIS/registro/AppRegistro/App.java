package App;

import View.FrmRegistro;
import controller.UsuarioController;
import model.UsuarioDAO;

public class AppRegistro {
    public static void main(String[] args) {
        FrmRegistro vista = new FrmRegistro();
        UsuarioDAO modelo = new UsuarioDAO();
        UsuarioController controlador = new UsuarioController(vista, modelo);
        controlador.iniciar();
    }
}


