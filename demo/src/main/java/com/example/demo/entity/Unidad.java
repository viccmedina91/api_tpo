package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidades")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    @ManyToOne // Indica la relación Many-to-One con Edificio
    @JoinColumn(name = "codigoEdificio") // Nombre de la columna de clave foránea en la tabla de Unidad
    private Edificio edificio;
    private Integer piso;
    private Integer numero;
    private String habitado;

    public Unidad() {

    }

    public Unidad(Integer piso, Integer numero, String habitado) {
        this.piso = piso;
        this.numero = numero;
        this.habitado = habitado;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setHabitado(String habitado) {
        this.habitado = habitado;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public Integer getPiso() {
        return this.piso;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getHabitado() {
        return this.habitado;
    }

    public Edificio getEdificio() {
        return this.edificio;
    }

    public String toString() {
        return this.identificador + " " + this.numero + " " + this.piso + " " + this.edificio.getCodigo();
    }
}
