package com.example.demo.requests;

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