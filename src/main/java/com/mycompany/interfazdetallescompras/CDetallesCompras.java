package com.mycompany.interfazdetallescompras;

import javax.swing.JOptionPane;

public class CDetallesCompras {

    private VDetallesCompra vista;
    private Compra compra;

    public CDetallesCompras(VDetallesCompra vista) {
        this.vista = vista;

        // Conectar botón SIGUIENTE
        this.vista.getBtnSiguiente().addActionListener(e -> procesarBoleto());
    }

    private void procesarBoleto() {
    try {
        // Crear la compra la primera vez
        if (compra == null) {
            int totalPasajeros = Integer.parseInt(
                vista.getTxtNumeroPasajeros().getText()
            );
            compra = new Compra(totalPasajeros);

            // Bloquear el campo de número de pasajeros
            vista.getTxtNumeroPasajeros().setEditable(false);
        }

        // Obtener datos
        String nombre = vista.getTxtNombre().getText().trim();
        String cedula = vista.getTxtCedula().getText().trim();
        String pasaporte = vista.getTxtPasaporte().getText().trim();
        boolean maletas = vista.getBtnMaletas().isSelected();
        boolean regreso = vista.getBtnVueloRegreso().isSelected();
        String clase = (String) vista.getComboClase().getSelectedItem(); // Obtener clase de vuelo

        // Validaciones
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el nombre");
            return;
        }
        if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(vista, "El nombre solo puede contener letras y espacios");
            return;
        }

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese la cédula");
            return;
        }
        if (!cedulaValida(cedula)) {
            JOptionPane.showMessageDialog(vista, "Cédula inválida (máx. 11 dígitos numéricos)");
            return;
        }

        if (pasaporte.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el pasaporte");
            return;
        }
        if (!pasaporteValido(pasaporte)) {
            JOptionPane.showMessageDialog(vista, "Pasaporte inválido (Ej: A12345678)");
            return;
        }

        // Crear y guardar boleto con clase
        Boleto boleto = new Boleto(nombre, maletas, regreso, clase);
        compra.agregarBoleto(boleto);

        // Limpiar campos para el siguiente pasajero
        vista.getTxtNombre().setText("");
        vista.getTxtCedula().setText("");
        vista.getTxtPasaporte().setText("");
        vista.getBtnMaletas().setSelected(false);
        vista.getBtnVueloRegreso().setSelected(false);
        vista.getComboClase().setSelectedIndex(0); // reset combo

        // Revisar si ya se ingresaron todos los boletos
        if (compra.estaCompleta()) {
            JOptionPane.showMessageDialog(vista, "La compra ha sido realizada con éxito");

            // Imprimir en consola
            int i = 1;
            for (Boleto b : compra.getBoletos()) {
                System.out.println(
                    "Pasajero " + i +
                    " | Nombre: " + b.getNombre() +
                    " | Maletas: " + (b.isTieneMaletas() ? "Si" : "No") +
                    " | Regreso: " + (b.isVueloRegreso() ? "Si" : "No") +
                    " | Clase: " + b.getClaseVuelo()
                );
                i++;
            }

            vista.dispose(); // cerrar ventana opcional
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vista, "Número de pasajeros inválido");
    }
}


    private boolean cedulaValida(String cedula) {
        // Solo números, máximo 11 dígitos
        return cedula.matches("\\d{10,11}");
    }

    private boolean pasaporteValido(String pasaporte) {
        // 1 letra mayúscula + 7 u 8 números
        return pasaporte.matches("[A-Z][0-9]{7,8}");
    }
}
