package com.example.demo.requests;

public class AltaImagenRequest {
    private String path;
    private Integer reclamoid;
    private String tipo;

    public String getPath() {
        return this.path;
    }

    public Integer getReclamoid() {
        return this.reclamoid;
    }

    public String getTipo() {
        return this.tipo;
    }
}