package com.example.demo.views;

public class UnidadView {
    private Integer identificador;
    private EdificioView edificio;
    private String piso;
    private String numero;
    private String habitado;

    public UnidadView(Integer identificador, String piso,
            String numero, String habitado, EdificioView edificio) {
        this.identificador = identificador;
        this.piso = piso;
        this.numero = numero;
        this.habitado = habitado;
        this.edificio = edificio;
    }

    public Integer getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public EdificioView getEdificio() {
        return this.edificio;
    }

    public void setEdificio(EdificioView edificio) {
        this.edificio = edificio;
    }

    public String getPiso() {
        return this.piso;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getHabitado() {
        return this.habitado;
    }

    public void setHabitado(String habitado) {
        this.habitado = habitado;
    }

}
