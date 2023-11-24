package com.example.demo.views;

public class EdificioView {
    private int codigo;
    private String nombre;
    private String direccion;

    public EdificioView() {
    }

    public EdificioView(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        return this.codigo + " " + this.nombre;
    }
}
