/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectob2;

import DestinoControlador.DestinoControlador;
import DestinoModelo.DestinoModelo;
import DestinoVista.DestinoVista;

/**
 *
 * @author USUARIO
 */

//Pestaña destino y pasajeros
public class ProyectoB2 {
    
    public static void main(String[] args) {
        DestinoVista vista = new DestinoVista();
        DestinoModelo modelo = new DestinoModelo();
        DestinoControlador controlador = new DestinoControlador(vista, modelo);
    
        vista.setVisible(true);
    }
}
