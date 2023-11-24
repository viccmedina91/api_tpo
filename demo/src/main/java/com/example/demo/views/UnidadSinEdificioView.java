package com.example.demo.views;

public class UnidadSinEdificioView {
    private int id;
    private String piso;
    private String numero;
    private String habitado;

    public UnidadSinEdificioView() {

    }

    public UnidadSinEdificioView(Integer identificador, String piso,
            String numero, String habitado) {
        this.id = identificador;
        this.piso = piso;
        this.numero = numero;
        this.habitado = habitado;
    }

    public Integer getID() {
        return this.id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getPiso() {
        return this.piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNurmero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getHabitado() {
        return this.habitado;
    }

    public void setHabitado(String habitado) {
        this.habitado = habitado;
    }

}
