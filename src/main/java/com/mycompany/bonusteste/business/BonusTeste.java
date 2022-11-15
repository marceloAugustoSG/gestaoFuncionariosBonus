package com.mycompany.bonusteste.business;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;

public class BonusTeste implements ICalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {
        if (funcionario.getIdade() > 20) {
            funcionario.addBonus(new Bonus("Bonus Teste", 1.03));

        }
    }
}
