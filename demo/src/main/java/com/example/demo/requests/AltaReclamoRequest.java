package com.example.demo.requests;

public class AltaReclamoRequest {
    private String ubicacion;
    private String descripcion;
    private String documento;
    private Integer codigo;
    private Integer identificador;

    public String getUbicacion() {
        return this.ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getDocumento() {
        return this.documento;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }
}