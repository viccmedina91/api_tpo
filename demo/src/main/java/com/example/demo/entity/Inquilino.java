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
    private Integer documento;

    public Inquilino() {

    }

    public Inquilino(Integer id, Integer identificador, Integer documento) {
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

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public Integer getDocumento() {
        return this.documento;
    }
}
