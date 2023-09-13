package com.example.demo.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReclamo;
    @ManyToOne // Indica la relación Many-to-One con Edificio
    @JoinColumn(name = "documento") // Nombre de la columna de clave foránea en la tabla de Persona
    private Persona persona;
    @ManyToOne // Indica la relación Many-to-One con Edificio
    @JoinColumn(name = "codigo") // Nombre de la columna de clave foránea en la tabla de Edificio
    private Edificio edificio;
    private String ubicacion;
    private String descripcion;
    private Integer identificador;

    public Reclamo() {

    }

    public Reclamo(String ubicacion,
            String descripcion, Integer identificador) {
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.identificador = identificador;
    }

    public void setidReclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdReclamo() {
        return this.idReclamo;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public Edificio getEdificio() {
        return this.edificio;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }
}
