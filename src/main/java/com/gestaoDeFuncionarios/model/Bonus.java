package com.gestaoDeFuncionarios.model;

public class Bonus {

    private String tipoBonus;
    private double valorBonus;

    public Bonus(String tipoBonus, double valorBonus) {
        this.tipoBonus = tipoBonus;
        this.valorBonus = valorBonus;
    }

    public Bonus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipoBonus() {
        return tipoBonus;
    }

    public void setTipoBonus(String tipoBonus) {
        this.tipoBonus = tipoBonus;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    @Override
    public String toString() {
        return "Tipo do bonus:" + getTipoBonus() + "\nValor Bonus:" + getValorBonus() + "]\n";
    }

}
