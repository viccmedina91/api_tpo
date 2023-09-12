package com.example.demo.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    private Integer numero;
    private String path;
    @ManyToOne // Indica la relación Many-to-One con Reclamo
    @JoinColumn(name = "idReclamo") // Nombre de la columna de clave foránea en la
    private Reclamo reclamo;

    public Imagen() {

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

    public Reclamo getReclamo() {
        return this.reclamo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getPath() {
        return this.path;
    }

}
