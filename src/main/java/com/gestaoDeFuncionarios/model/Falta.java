package com.gestaoDeFuncionarios.model;

import java.time.LocalDateTime;

public class Falta {

    private int quantidade;

    private LocalDateTime data;

    public Falta(int quantidade) {
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Falta(s):\n{Quantidade:"
                + this.quantidade + "\nData:"
                + this.data.getDayOfMonth()
                + "/" + this.data.getMonthValue()
                + "/" + this.data.getYear() + "}";
    }

}
