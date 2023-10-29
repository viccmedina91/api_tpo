package com.example.demo.controller;

public class AltaImagenRequest {
    private String pathImagen;
    private Integer nroReclamo;
    private String tipo;

    public String getPathImagen() {
        return this.pathImagen;
    }

    public Integer getNroRelcamo() {
        return this.nroReclamo;
    }

    public String getTipo() {
        return this.tipo;
    }
}