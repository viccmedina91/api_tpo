package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;

import com.example.demo.views.EdificioView;
import com.example.demo.views.ImagenView;
import com.example.demo.views.PersonaSinRolView;
import com.example.demo.views.ReclamoView;
import com.example.demo.views.UnidadView;

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
@Table(name = "reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreclamo")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "documento")
    private Persona usuario;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Edificio edificio;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "identificador")
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name = "estadoid")
    private Estado estado;

    @OneToMany
    @JoinColumn(name = "idreclamo")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Imagen> imagenes;

    public Reclamo() {
        // Default constructor with no arguments
    }

    public Reclamo(Persona usuario, Edificio edificio, String ubicacion,
            String descripcion, Unidad unidad, Estado estado) {
        this.usuario = usuario;
        this.edificio = edificio;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.estado = estado;
        imagenes = new ArrayList<Imagen>();
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public Edificio getEdificio() {
        return this.edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Unidad getUnidad() {
        return this.unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void agregarImagen(String path, String tipo) {
        Imagen imagen = new Imagen();
        imagen.setPath(path);
        imagen.setTipo(tipo);
        imagenes.add(imagen);
    }

    public ReclamoView toView() {
        PersonaSinRolView auxPersona = this.usuario.toViewSinRol();
        EdificioView auxEdificio = null;

        if (this.edificio != null) {

            auxEdificio = edificio.toView();
        }
        UnidadView auxUnidad = null;
        if (this.unidad != null) {
            auxUnidad = unidad.toView();
        }
        List<ImagenView> auxImagen = new ArrayList<ImagenView>();
        for (Imagen img : imagenes) {
            auxImagen.add(img.toView());
        }

        return new ReclamoView(this.numero, auxPersona, auxEdificio, descripcion,
                estado, auxImagen, auxUnidad, ubicacion);
    }

}
