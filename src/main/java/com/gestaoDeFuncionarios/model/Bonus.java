package com.gestaoDeFuncionarios.model;

public abstract class Bonus {

    private String tipo;
    private double valor;
    
    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public abstract double aplicaBonus(Funcionario funcionario);
    public abstract boolean accept(Funcionario funcionario);

    @Override
    public String toString() {
        return "Bonus{" + "tipo=" + tipo + ", valor=" + valor + '}';
    }

}
