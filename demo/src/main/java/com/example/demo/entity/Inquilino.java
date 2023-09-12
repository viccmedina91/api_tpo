package com.example.demo.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "inquilinos")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer identificador;
    private String documento;

    public Inquilino() {

    }

    public Inquilino(Integer identificador, String documento) {
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

    public String toString() {
        return this.id + " " + this.identificador + " " + this.documento;
    }
}
