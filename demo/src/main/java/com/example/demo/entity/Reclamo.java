package com.example.demo.entity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreclamo")
    private Integer idreclamo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "documento")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Edificio edificio;

    @ManyToOne
    @JoinColumn(name = "identificador")
    private Unidad unidad;

    public Reclamo() {

    }

    public Integer getIdReclamo() {
        return this.idreclamo;
    }

    public String getUbicaciones() {
        return this.ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public Edificio getEdificio() {
        return this.edificio;
    }

    public Unidad getUnidad() {
        return this.unidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public String toString() {
        return "ID: " + this.idreclamo +
                " Edificio: " + this.edificio.getCodigo() +
                " Unidad: " + this.unidad.getIdentificador() +
                " Descripción: " + this.descripcion +
                " Ubicación: " + this.ubicacion;
    }
}
