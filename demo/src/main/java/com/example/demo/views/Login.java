package com.example.demo.views;

public class Login {

    private String documento;
    private String contrasenia;

    public Login(String documento, String contrasenia) {
        this.documento = documento;
        this.contrasenia = contrasenia;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
