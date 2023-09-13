package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    private String documento;
    private String nombre;
    private String mail;
    private String contrasenia;
    @OneToMany(mappedBy = "persona") // Indica una relación One-to-Many
    private List<Reclamo> reclamos = new ArrayList<>();

    public Persona() {

    }

    public Persona(String documento, String nombre, String contrasenia, String mail) {
        this.documento = documento;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.mail = mail;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void addReclamo(Reclamo reclamo) {
        this.reclamos.add(reclamo);
    }

    public String getDocumento() {
        return this.documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getMail() {
        return this.mail;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public List<Reclamo> getReclamos() {
        return this.reclamos;
    }
}
