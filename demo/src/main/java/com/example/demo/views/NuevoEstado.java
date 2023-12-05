package com.example.demo.views;

public class NuevoEstado {
    private Integer numero;
    private Integer estado;
    private String documento;

    public NuevoEstado(Integer numero, Integer estado, String documento) {
        this.numero = numero;
        this.estado = estado;
        this.documento = documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return this.documento;
    }

    public Integer getEstado() {
        return this.estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
