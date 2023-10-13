package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "imagen")
    List<Imagen> imagenes;

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

    public List<Imagen> getImagenes() {
        return this.imagenes;
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

    public void addImagen(Imagen imagen) {
        this.imagenes.add(imagen);
    }

    @Autowired
    public String toString() {
        return "ID: " + this.idreclamo;

    }
}
