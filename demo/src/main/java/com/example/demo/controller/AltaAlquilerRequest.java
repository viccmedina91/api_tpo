package com.example.demo.controller;

public class AltaAlquilerRequest {
    private String documento;
    private Integer identificadorUnidad;

    public Integer getIdentificadorUnidad() {
        return this.identificadorUnidad;
    }

    public String getDocumento() {
        return this.documento;
    }
}