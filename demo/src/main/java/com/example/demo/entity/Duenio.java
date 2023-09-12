package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "duenios")
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer identificador;
    private String documento;

    public Duenio() {

    }

    public Duenio(Integer id, Integer identificador, String documento) {
        this.id = id;
        this.identificador = identificador;
        this.documento = documento;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public String getDocumento() {
        return this.documento;
    }
}
