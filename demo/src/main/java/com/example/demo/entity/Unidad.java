package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidades")
public class Unidad {
    /*
     * Departamentos que pertenecen a un edificio.
     * Una unidad puede tener varios dueños
     * Donde las personas pueden ser dueños y/o inquilinos.
     * identificador: de la unidad.
     * piso: al que pertenece la undiad dentro del edificio.
     * numero: dentro del piso, su identificador.
     * habitado: para indicar si tiene inquilinos o no.
     * lista dueños: una unidad puede tener uno o más dueños.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    private Integer identificador;

    @Column(name = "piso")
    private Integer piso;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "habitado")
    private String habitado;

    @ManyToOne
    @JoinColumn(name = "codigoedificio")
    private Edificio edificio;

    @ManyToOne
    @JoinColumn(name = "identificador", insertable = false, updatable = false)
    private Duenio duenio;

    public Unidad() {

    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;

    };

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

    public Edificio getEdificio() {
        return this.edificio;
    }

    public Duenio getDuenio() {
        return this.duenio;
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
}
