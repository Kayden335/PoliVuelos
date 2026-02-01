package com.mycompany.interfazdetallescompras;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private int totalPasajeros;
    private int pasajerosIngresados;
    private List<Boleto> boletos;

    public Compra(int totalPasajeros) {
        this.totalPasajeros = totalPasajeros;
        this.pasajerosIngresados = 0;
        this.boletos = new ArrayList<>();
    }

    public void agregarBoleto(Boleto boleto) {
        boletos.add(boleto);
        pasajerosIngresados++;
    }

    public boolean estaCompleta() {
        return pasajerosIngresados >= totalPasajeros;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public int getPasajerosIngresados() {
        return pasajerosIngresados;
    }

    public int getTotalPasajeros() {
        return totalPasajeros;
    }
}
