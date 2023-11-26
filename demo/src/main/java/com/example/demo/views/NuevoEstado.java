package com.example.demo.views;

public class NuevoEstado {
    private Integer numero;
    private Integer estado;

    public NuevoEstado(Integer numero, Integer estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public Integer getEstado() {
        return this.estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
