package com.example.demo.views;

public class ImagenView {
    private int numero;
    private String direccion;
    private String tipo;

    public ImagenView(Integer numero, String direccion, String tipo) {
        this.numero = numero;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
