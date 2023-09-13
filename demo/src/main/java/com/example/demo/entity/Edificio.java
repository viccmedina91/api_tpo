package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private String direccion;
    @OneToMany(mappedBy = "edificio") // Indica una relación One-to-Many
    private List<Unidad> unidades = new ArrayList<>();
    @OneToMany(mappedBy = "edificio") // Indica una relación One-to-Many
    private List<Reclamo> reclamos = new ArrayList<>();

    public Edificio() {

    }

    public Edificio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;

    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void addReclamo(Reclamo reclamo) {
        this.reclamos.add(reclamo);
    }

    public void addUnidades(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public List<Reclamo> getReclamos() {
        return this.reclamos;
    }

    public List<Unidad> getUnidades() {
        return this.unidades;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String toString() {
        return this.nombre + " " + this.direccion + " " + this.codigo;
    }

}