package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "duenios")
public class Duenio {
    /*
     * Una persona es dueña de unidade.
     * id: generico, autoincrementado en uno.
     * identificador: de la unidad de la cual es dueña.
     * documento: de la persona dueña de la unidad.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "documento")
    Persona persona;

    @Column(name = "identificador")
    private Integer identificador;

    public Duenio() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return this.id;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public String toString() {
        return "Documento: " + this.persona.getDocumento() + " - ID Unidad: " + this.identificador;
    }
}
