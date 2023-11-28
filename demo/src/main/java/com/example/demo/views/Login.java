package com.example.demo.views;

public class Login {

    private String mail;
    private String contrasenia;

    public Login(String mail, String contrasenia) {
        this.mail = mail;
        this.contrasenia = contrasenia;
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
}
