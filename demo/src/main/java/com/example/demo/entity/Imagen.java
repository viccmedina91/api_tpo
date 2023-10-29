package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "idreclamo")
    private Reclamo reclamo;

    @Column(name = "path")
    private String path;

    @Column(name = "tipo")
    private String tipo;

    public Imagen() {

    }

    public Integer getNumero() {
        return this.numero;
    }

    public Reclamo getReclamo() {
        return this.reclamo;
    }

    public String getPath() {
        return this.path;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Autowired
    public String toString() {
        return "Nro: " + this.numero +
                " Path: " + this.path +
                " Tipo: " + this.tipo;
    }

}
