package com.example.demo.entity;

import com.example.demo.entity.Reclamo;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    private Integer numero;
    private String path;
    // @ManyToOne Indica la relación Many-to-One con Reclamo
    // @JoinColum name = "idReclamo") Nombre de la columna de clave foránea en la
    // tabla de Reclamo

    public Imagen() {

    }

    public Imagen(Integer numero, String path) {
        this.numero = numero;
        this.path = path;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getPath() {
        return this.path;
    }

}
