/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DestinoControlador;

import DestinoModelo.DestinoModelo;
import DestinoVista.DestinoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class DestinoControlador {
    private DestinoVista vista;
    private DestinoModelo modelo;

    public DestinoControlador(DestinoVista vista, DestinoModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.btnMasAdulto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.modificarAdulto(1);
                actualizarInterfaz();
            }
        });

        this.vista.btnMenosAdulto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.modificarAdulto(-1);
                actualizarInterfaz();
            }
        });
        
        

        this.vista.btnBuscarVuelos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarVuelo();
            }
        });

        this.vista.btnMasNinio.addActionListener(e -> {
            modelo.modificarNinio(1);
            actualizarInterfaz();
        });
        
        this.vista.btnMenosNinio.addActionListener(e -> {
            modelo.modificarNinio(-1);
            actualizarInterfaz();
        });

        this.vista.btnMasAdultoMayor.addActionListener(e -> {
            modelo.modificarAdultoMayor(1);
            actualizarInterfaz();
        });
        
        this.vista.btnMenosAdultoMayor.addActionListener(e -> {
            modelo.modificarAdultoMayor(-1);
            actualizarInterfaz();
        });

        this.vista.btnMasDiscapacitado.addActionListener(e -> {
            modelo.modificarDiscapacitado(1);
            actualizarInterfaz();
        });
        
        this.vista.btnMenosDiscapacitado.addActionListener(e -> {
            modelo.modificarDiscapacitado(-1);
            actualizarInterfaz();
        });
    }

    private void actualizarInterfaz() {
        int total = modelo.getTotalPasajeros();
        vista.txtTotalPasajeros.setText(String.valueOf(total));
    }

    private void validarVuelo() {
        String origen = vista.cbOrigen.getSelectedItem().toString();
        String destino = vista.cbDestino.getSelectedItem().toString();
        int totalPasajeros = modelo.getTotalPasajeros();
        
        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(vista, "El origen y el destino no pueden ser iguales.");
        }
        if(totalPasajeros <= 0) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar al menos un pasajero.");
        } 
    }
}
