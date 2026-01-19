/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.View;

import oop.Controller.PagoController;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PagoView extends JFrame {

    public PagoView(PagoController controller, double total) {
        setTitle("Pago de Boletos 💳");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.setBackground(new Color(220, 235, 250)); // azul claro

        // Etiqueta de total
        JLabel lblTotal = new JLabel("Total a pagar: $" + total);
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTotal.setForeground(new Color(10, 50, 120));
        mainPanel.add(lblTotal, BorderLayout.NORTH);

        // Pestañas de métodos de pago
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        tabs.add("💳 Tarjeta", crearTarjetaPanel(controller));
        tabs.add("📧 PayPal", crearPaypalPanel(controller));
        tabs.add("🏦 Transferencia", crearTransferenciaPanel(controller));

        mainPanel.add(tabs, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JPanel crearTarjetaPanel(PagoController c) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(new Color(235, 245, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNum = new JLabel("Número:");
        JLabel lblCVV = new JLabel("CVV:");
        JLabel lblFecha = new JLabel("MM/AA:");
        JTextField num = new JTextField();
        JTextField cvv = new JTextField();
        JTextField fecha = new JTextField();

        gbc.gridx = 0; gbc.gridy = 0; p.add(lblNum, gbc);
        gbc.gridx = 1; p.add(num, gbc);
        gbc.gridx = 0; gbc.gridy = 1; p.add(lblCVV, gbc);
        gbc.gridx = 1; p.add(cvv, gbc);
        gbc.gridx = 0; gbc.gridy = 2; p.add(lblFecha, gbc);
        gbc.gridx = 1; p.add(fecha, gbc);

        JButton pagar = new JButton("💵 Pagar");
        JButton cancelar = new JButton("❌ Cancelar");

        gbc.gridx = 0; gbc.gridy = 3; p.add(pagar, gbc);
        gbc.gridx = 1; p.add(cancelar, gbc);

        pagar.addActionListener(e -> {
            if (c.procesarTarjeta(num.getText(), cvv.getText(), fecha.getText()))
                JOptionPane.showMessageDialog(this, "Pago exitoso 🎉");
            else
                JOptionPane.showMessageDialog(this, "Datos inválidos ❌");
        });

        cancelar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pago cancelado ⚠️");
            this.dispose();
        });

        return p;
    }

    private JPanel crearPaypalPanel(PagoController c) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(new Color(235, 245, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblEmail = new JLabel("Gmail:");
        JTextField email = new JTextField();

        gbc.gridx = 0; gbc.gridy = 0; p.add(lblEmail, gbc);
        gbc.gridx = 1; p.add(email, gbc);

        JButton pagar = new JButton("💵 Pagar");
        JButton cancelar = new JButton("❌ Cancelar");

        gbc.gridx = 0; gbc.gridy = 1; p.add(pagar, gbc);
        gbc.gridx = 1; p.add(cancelar, gbc);

        pagar.addActionListener(e -> {
            if (c.procesarPaypal(email.getText()))
                JOptionPane.showMessageDialog(this, "Pago exitoso 🎉");
            else
                JOptionPane.showMessageDialog(this, "Correo inválido ❌");
        });

        cancelar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pago cancelado ⚠️");
            this.dispose();
        });

        return p;
    }

    private JPanel crearTransferenciaPanel(PagoController c) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(new Color(235, 245, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblBanco = new JLabel("Banco:");
        JLabel lblRef = new JLabel("Referencia:");
        JTextField banco = new JTextField();
        JTextField ref = new JTextField();

        gbc.gridx = 0; gbc.gridy = 0; p.add(lblBanco, gbc);
        gbc.gridx = 1; p.add(banco, gbc);
        gbc.gridx = 0; gbc.gridy = 1; p.add(lblRef, gbc);
        gbc.gridx = 1; p.add(ref, gbc);

        JButton pagar = new JButton("💵 Pagar");
        JButton cancelar = new JButton("❌ Cancelar");

        gbc.gridx = 0; gbc.gridy = 2; p.add(pagar, gbc);
        gbc.gridx = 1; p.add(cancelar, gbc);

        pagar.addActionListener(e -> {
            if (c.procesarTransferencia(banco.getText(), ref.getText()))
                JOptionPane.showMessageDialog(this, "Pago exitoso 🎉");
            else
                JOptionPane.showMessageDialog(this, "Datos inválidos ❌");
        });

        cancelar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pago cancelado ⚠️");
            this.dispose();
        });

        return p;
    }
}
