package com.example.demo.views;

import java.util.List;

import com.example.demo.entity.Estado;

public class ReclamoView {

    private int numero;
    private PersonaSinRolView usuario;
    private EdificioView edificio;
    private String ubicacion;
    private String descripcion;
    private UnidadView unidad;
    private Estado estado;
    private List<ImagenView> imagenes;

    public ReclamoView(Integer numero, PersonaSinRolView persona,
            EdificioView edificio, String descripcion, Estado estado,
            List<ImagenView> imagenes, UnidadView unidad, String ubicacion) {
        this.numero = numero;
        this.usuario = persona;
        this.edificio = edificio;
        this.estado = estado;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.unidad = unidad;
        this.ubicacion = ubicacion;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public PersonaSinRolView getPersonaSinRol() {
        return this.usuario;
    }

    public void setPersonaSinRol(PersonaSinRolView persona) {
        this.usuario = persona;
    }

    public EdificioView getEdificio() {
        return this.edificio;
    }

    public void setEdificio(EdificioView edificio) {
        this.edificio = edificio;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UnidadView getUnidad() {
        return this.unidad;
    }

    public void setUnidad(UnidadView unidad) {
        this.unidad = unidad;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<ImagenView> getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(List<ImagenView> imagenes) {
        this.imagenes = imagenes;
    }
}