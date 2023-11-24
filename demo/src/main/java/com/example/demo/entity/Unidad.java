package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.views.EdificioView;
import com.example.demo.views.UnidadSinEdificioView;
import com.example.demo.views.UnidadView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    private Integer identificador;

    @Column(name = "piso")
    private String piso;

    @Column(name = "numero")
    private String numero;

    @Column(name = "habitado")
    private String habitado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoedificio")
    private Edificio edificio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identificador", insertable = false, updatable = false)
    private Duenio duenio;

    @OneToMany(mappedBy = "unidad", fetch = FetchType.LAZY)
    private List<Inquilino> inquilinos = new ArrayList<Inquilino>();

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

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setHabitado(String habitado) {
        this.habitado = habitado;
    }

    public void addInquilinos(Inquilino inquilino) {
        this.inquilinos.add(inquilino);
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

    public String getPiso() {
        return this.piso;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getHabitado() {
        return this.habitado;
    }

    public List<Inquilino> getInquilinos() {
        return this.inquilinos;
    }

    public UnidadView toView() {
        EdificioView auxEdificio = edificio.toView();
        return new UnidadView(this.identificador, this.piso, this.numero,
                this.habitado, auxEdificio);
    }

    public UnidadSinEdificioView toViewSinEdificios() {
        return new UnidadSinEdificioView(this.identificador, this.piso,
                this.numero, this.habitado);
    }

    public String toString() {
        return "ID: " + this.identificador +
                " Edificio: " + this.edificio.getCodigo().toString() +
                " Nro: " + this.numero +
                " Piso: " + this.piso +
                " Habitado: " + this.habitado +
                " Cant Inquilinos: " + this.inquilinos.size();
    }

}
