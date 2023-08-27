package com.example.demo.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
@Table(name = "reclamos")
public class Reclamo {
    @Id
    private Integer idReclamo;
    private Integer documento;
    private Integer codigo;
    private String ubicacion;
    private String descripcion;
    private Integer identificador;

    public Reclamo() {

    }

    public Reclamo(Integer idReclamo, Integer documento, Integer codigo, String ubicacion, 
        String descripcion, Integer identificador){
            this.idReclamo = idReclamo;
            this.documento = documento;
            this.codigo = codigo;
            this.ubicacion = ubicacion;
            this.descripcion = descripcion;
            this.identificador = identificador;
    }

    public void setidReclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdReclamo() {
        return this.idReclamo;
    }

    public Integer getDocumento() {
        return this.documento;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }
}
