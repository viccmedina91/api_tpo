package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.views.ImagenView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "path")
    private String path;

    @Column(name = "tipo")
    private String tipo;

    public Imagen() {

    }

    public Imagen(Integer numero, String path, String tipo) {
        this.numero = numero;
        this.path = path;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getPath() {
        return this.path;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ImagenView toView() {
        return new ImagenView(this.numero, this.path, this.tipo);
    }

}
