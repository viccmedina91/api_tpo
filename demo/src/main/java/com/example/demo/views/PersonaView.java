package com.example.demo.views;

public class PersonaView {
    private String documento;
    private String nombre;
    private String mail;
    private String contrasenia;

    public PersonaView() {
    }

    public PersonaView(String documento, String nombre, String mail, String contrasenia) {
        this.documento = documento;
        this.nombre = nombre;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setdocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String toString() {
        return this.documento + " " + this.nombre + " " + this.mail;
    }
}
