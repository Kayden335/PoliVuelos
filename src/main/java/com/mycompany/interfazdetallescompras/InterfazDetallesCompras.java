package com.mycompany.interfazdetallescompras;

public class InterfazDetallesCompras {

    public static void main(String[] args) {

        // Crear la vista
        VDetallesCompra vista = new VDetallesCompra();

        // Crear el controlador con solo la vista
        CDetallesCompras controlador = new CDetallesCompras(vista);

        // Mostrar la ventana
        vista.setVisible(true);
    }
}
