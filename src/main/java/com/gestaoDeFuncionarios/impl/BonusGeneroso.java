package com.gestaoDeFuncionarios.impl;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;

public class BonusGeneroso extends Bonus {

    public BonusGeneroso(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public double aplicaBonus(Funcionario funcionario) {
        return 200;
    }

    @Override
    public boolean accept(Funcionario funcionario) {
        if (funcionario.getTipoBonus().equals(this.getTipo())) {
            return true;
        }
        return false;
    }

}
