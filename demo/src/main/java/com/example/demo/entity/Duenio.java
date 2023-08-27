package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "duenios")
public class Duenio {

    @Id
    private Integer id;
    private Integer identificador;
    private Integer documento;

    public Duenio() {

    }

    public Duenio(Integer id, Integer identificador, Integer documento) {
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

    public Integer getIdentificador(){
        return this.identificador;
    }

    public Integer getDocumento() {
        return this.documento;
    }
}
