package com.example.demo.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "inquilinos")
public class Inquilino {

    @Id
    private Integer id;
    private Integer identificador;
    private String documento;

    public Inquilino() {

    }

    public Inquilino(Integer id, Integer identificador, String documento) {
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
