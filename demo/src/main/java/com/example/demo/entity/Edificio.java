package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "edificios")
public class Edificio {
    /*
     * Contiene unidades y reclamos.
     * codigo: identificador del edificio.
     * nombre: nombre lirico del edificio.
     * direccion: calle y numeración del edificio.
     * lista unidades: son los departamentos/unidades que componen al edificio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "edificio")
    List<Unidad> unidades;

    @OneToMany(mappedBy = "reclamo")
    List<Reclamo> reclamos;

    public Edificio() {

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

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    @Autowired
    public String toString() {
        return this.nombre + " " + this.direccion + " " + this.codigo;
    }

    public List<Unidad> getUnidades() {
        return this.unidades;
    }

    public List<Reclamo> getReclamos() {
        return this.reclamos;
    }

}