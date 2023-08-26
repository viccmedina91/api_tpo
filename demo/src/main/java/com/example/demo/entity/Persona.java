package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    private Integer documento;
    private String nombre;
    private String mail;
    private String contrasenia;

    public Persona() {

    }

    public Persona(Integer documento, String nombre, String contrasenia) {
        this.documento = documento;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Integer getDocumento() {
        return this.documento;
    }

    public String getNombre() {
        return this.nombre;
    }
}
