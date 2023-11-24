package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
import jakarta.persistence.JoinTable;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "duenios", joinColumns = {
            @JoinColumn(name = "unidadidentificador"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "documento")
    })
    private List<Persona> duenios;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "inquilinos", joinColumns = {
            @JoinColumn(name = "identificador"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "documento")
    })
    private List<Persona> inquilinos;

    public Unidad() {

    }

    public void transferir(Persona nuevoDuenio) {
        duenios = new ArrayList<Persona>();
        duenios.add(nuevoDuenio);
    }

    public void agregarDuenio(Persona duenio) {
        duenios.add(duenio);
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

    public Edificio getEdificio() {
        return this.edificio;
    }

    public List<Persona> getDuenios() {
        return this.duenios;
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

    public Boolean getHabitado() {
        if (this.habitado.equals("S")) {
            return true;
        }
        return false;
    }

    public List<Persona> getInquilinos() {
        return this.inquilinos;
    }

    public boolean estaHabitado() {
        if (this.habitado.equals("S")) {
            return true;
        }
        return false;
    }

    public boolean esDuenio(Persona persona) {
        AtomicBoolean esDuenio = new AtomicBoolean(false);
        duenios.forEach(duenio -> {
            if (duenio.getDocumento().equals(persona.getDocumento())) {
                esDuenio.set(true);
            }
        });
        return esDuenio.get();
    }

    public UnidadView toView() {
        EdificioView auxEdificio = this.edificio.toView();
        return new UnidadView(this.identificador, this.piso, this.numero,
                this.habitado, auxEdificio);
    }

    public UnidadSinEdificioView toViewSinEdificios() {
        return new UnidadSinEdificioView(this.identificador, this.piso,
                this.numero, this.habitado);
    }

    public boolean esInquilino(Persona persona) {
        AtomicBoolean esInquilino = new AtomicBoolean(false);
        inquilinos.forEach(inquilino -> {
            if (inquilino.getDocumento().equals(persona.getDocumento())) {
                esInquilino.set(true);
            }
        });
        return esInquilino.get();
    }

    public Boolean alquilar(Persona inquilino) {
        if (!getHabitado()) {
            this.habitado = "S";
            inquilinos = new ArrayList<Persona>();
            inquilinos.add(inquilino);
            return true;
        }
        return false;
    }

    public void agregarInquilino(Persona inquilino) {
        inquilinos.add(inquilino);
    }

    public void liberar() {
        this.inquilinos = new ArrayList<Persona>();
        this.habitado = "N";
    }

    public Boolean habitar() {
        if (this.getHabitado()) {
            return true;

        } else {
            this.habitado = "S";
        }
        return false;

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
