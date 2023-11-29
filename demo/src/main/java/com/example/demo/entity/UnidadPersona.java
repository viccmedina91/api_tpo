package com.example.demo.entity;

public class UnidadPersona {
    private String codigoUnidad;

    private String documento;

    public UnidadPersona(String documento, String codigoUnidad) {
        this.documento = documento;
        this.codigoUnidad = codigoUnidad;

    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodigoUnidad() {
        return this.codigoUnidad;
    }

    public void setCodigoUnidad(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }
}
