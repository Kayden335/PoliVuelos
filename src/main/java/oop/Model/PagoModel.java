/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.Model;

import java.time.YearMonth;

public class PagoModel {

    public boolean validarTarjeta(String numero, String cvv, String fecha) {
        return numero.matches("\\d{16}")
                && cvv.matches("\\d{3}")
                && validarFecha(fecha);
    }

    private boolean validarFecha(String fecha) {
        if (!fecha.matches("(0[1-9]|1[0-2])/\\d{2}")) return false;
        String[] p = fecha.split("/");
        YearMonth tarjeta = YearMonth.of(2000 + Integer.parseInt(p[1]), Integer.parseInt(p[0]));
        return !tarjeta.isBefore(YearMonth.now());
    }

    public boolean validarPaypal(String email) {
        return email.matches("^[\\w.-]+@gmail\\.com$");
    }

    public boolean validarTransferencia(String banco, String ref) {
        return !banco.isBlank() && ref.matches("\\d{6,}");
    }
}