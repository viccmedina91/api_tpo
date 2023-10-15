package com.example.demo.controller;

public class AltaDuenioRequest {
    private String documento;
    private Integer identificador;
    private String mail;
    private String contrasenia;
    private String nombre;

    public String getDocumento() {
        return this.documento;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public String getMail() {
        return this.mail;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

}
