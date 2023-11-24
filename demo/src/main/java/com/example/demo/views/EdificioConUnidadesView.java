package com.example.demo.views;

import java.util.List;

public class EdificioConUnidadesView {
    private Integer codigo;
    private String nombre;
    private String direccion;
    private List<UnidadSinEdificioView> unidades;

    public EdificioConUnidadesView(Integer codigo, String nombre,
            String direccion, List<UnidadSinEdificioView> unidadesSinEdificio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.unidades = unidadesSinEdificio;
    }

    public List<UnidadSinEdificioView> getUnidadesSinEdificioViews() {
        return this.unidades;
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
