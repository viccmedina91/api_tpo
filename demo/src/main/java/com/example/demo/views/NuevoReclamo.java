package com.example.demo.views;

public class NuevoReclamo {
    private String documento;
    private Integer codigo;
    private Integer identificador;
    private String ubicacion;
    private String descripcion;

    public NuevoReclamo(String documento, Integer codigo, Integer identificador,
            String ubicacion, String descripcion) {
        this.documento = documento;
        this.codigo = codigo;
        this.identificador = identificador;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;

    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
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

}
