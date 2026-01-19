/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.Controller;

import oop.Model.*;
import oop.View.*;

import java.util.ArrayList;

public class PagoController {

    private ArrayList<Boleto> boletos = new ArrayList<>();
    private PagoModel pagoModel = new PagoModel();
    private DetalleViajeView detalleView;

    public PagoController(DetalleViajeView view) {
        this.detalleView = view;
        cargarBoletos();
        actualizarVista();
    }

    private void cargarBoletos() {
        boletos.add(new Boleto("Básico", 120));
        boletos.add(new Boleto("Premium", 220));
    }

    public void eliminarBoleto(int index) {
        boletos.remove(index);
        actualizarVista();
    }

    public void continuarPago() {
        new PagoView(this, calcularTotal()).setVisible(true);
        detalleView.dispose();
    }

    public double calcularTotal() {
        return boletos.stream().mapToDouble(Boleto::getPrecio).sum();
    }

    private void actualizarVista() {
        detalleView.actualizarLista(boletos, calcularTotal());
    }

    public boolean procesarTarjeta(String n, String c, String f) {
        return pagoModel.validarTarjeta(n, c, f);
    }

    public boolean procesarPaypal(String email) {
        return pagoModel.validarPaypal(email);
    }

    public boolean procesarTransferencia(String banco, String ref) {
        return pagoModel.validarTransferencia(banco, ref);
    }
}
