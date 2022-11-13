
package com.gestaoDeFuncionarios.impl;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;


public class BonusNormal extends Bonus{
    
    public BonusNormal(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public double aplicaBonus(Funcionario funcionario) {
        return 100;
    }
    
    @Override
    public boolean accept(Funcionario funcionario) {
        if(funcionario.getTipoBonus().equals(super.getTipo())) {
           return true;
        }
        return false;
    }
    
}
