package com.example.demo.views;

public class PersonaSinRolView {

    private String documento;
    private String nombre;
    private String email;

    public PersonaSinRolView(String documento, String nombre, String mail) {
        this.documento = documento;
        this.nombre = nombre;
        this.email = mail;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return this.email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }
}