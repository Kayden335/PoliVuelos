package com.mycompany.interfazdetallescompras;

public class Boleto {

    private String nombre;
    private boolean tieneMaletas;
    private boolean vueloRegreso;
    private String claseVuelo; // <-- nuevo atributo

    public Boleto(String nombre, boolean tieneMaletas, boolean vueloRegreso, String claseVuelo) {
        this.nombre = nombre;
        this.tieneMaletas = tieneMaletas;
        this.vueloRegreso = vueloRegreso;
        this.claseVuelo = claseVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isTieneMaletas() {
        return tieneMaletas;
    }

    public boolean isVueloRegreso() {
        return vueloRegreso;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }
}
