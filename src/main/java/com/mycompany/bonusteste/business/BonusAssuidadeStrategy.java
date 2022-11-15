package com.mycompany.bonusteste.business;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Falta;
import com.gestaoDeFuncionarios.model.Funcionario;

public class BonusAssuidadeStrategy implements ICalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {

        String tipoBonus = "Bonus Assuidade";
        double bonus = 0;
        for (Falta faltas : funcionario.getFaltas()) {
            if (faltas.getQuantidade() == 0) {
                bonus = 1.05;
                funcionario.addBonus(new Bonus(tipoBonus, bonus));
            } else if (faltas.getQuantidade() >= 1 && faltas.getQuantidade() <= 3) {
                bonus = 1.03;
                funcionario.addBonus(new Bonus(tipoBonus, bonus));
            } else {
                bonus = 1.01;
                funcionario.addBonus(new Bonus(tipoBonus, bonus));
            }
        }
    }

}
