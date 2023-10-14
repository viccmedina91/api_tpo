package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquilinos")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "documento")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "identificador")
    private Unidad unidad;

    public Inquilino() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Integer getId() {
        return this.id;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public Unidad getUnidad() {
        return this.unidad;
    }

}
