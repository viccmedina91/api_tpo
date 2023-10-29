package com.example.demo.requests;

public class ModificarEstadoRequest {
    private String estado;
    private Integer reclamoid;

    public Integer getReclamoid() {
        return this.reclamoid;
    }

    public String getEstado() {
        return this.estado;
    }
}