package com.example.demo.entity;

import java.util.List;

import com.example.demo.views.EdificioConUnidadesView;
import com.example.demo.views.EdificioView;
import com.example.demo.views.UnidadSinEdificioView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoedificio")
    private List<Unidad> unidades;

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

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public EdificioView toView() {
        return new EdificioView(this.codigo, this.nombre, this.direccion);
    }

    public EdificioConUnidadesView toViewConUnidades() {
        List<UnidadSinEdificioView> unidadesSinEdificio = this.unidades.stream().map(Unidad::toViewSinEdificios)
                .toList();
        return new EdificioConUnidadesView(this.codigo, this.nombre, this.direccion, unidadesSinEdificio);
    }
}