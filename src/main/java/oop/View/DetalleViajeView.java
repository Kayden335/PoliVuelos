/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.View;

import oop.Controller.PagoController;
import oop.Model.Boleto;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DetalleViajeView extends JFrame {

    private DefaultListModel<Boleto> modelo = new DefaultListModel<>();
    private JList<Boleto> lista = new JList<>(modelo);
    private JLabel lblTotal = new JLabel("$0.00");
    private PagoController controller;

    public DetalleViajeView() {
        setTitle("Detalle del Viaje ✈️");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        controller = new PagoController(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(230, 242, 255));

        lista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);

        JPanel abajo = new JPanel();
        abajo.setBackground(new Color(200, 220, 255));

        JButton btnEliminar = new JButton("🗑 Eliminar");
        JButton btnContinuar = new JButton("➡ Continuar");

        abajo.add(new JLabel("Total: "));
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
        abajo.add(lblTotal);
        abajo.add(btnEliminar);
        abajo.add(btnContinuar);

        btnEliminar.addActionListener(e -> {
            int i = lista.getSelectedIndex();
            if (i >= 0) controller.eliminarBoleto(i);
        });

        btnContinuar.addActionListener(e -> controller.continuarPago());

        panel.add(abajo, BorderLayout.SOUTH);
        add(panel);
    }

    public void actualizarLista(List<Boleto> boletos, double total) {
        modelo.clear();
        boletos.forEach(modelo::addElement);
        lblTotal.setText("$" + total);
    }
}