package com.mycompany.bonusteste.business;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;

public class BonusPorDistanciaStrategy implements ICalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {
        String tipoBonus = "Bonus por distancia"; // 5%
        if (funcionario.getDistanciaTrabalho() >= 50 && funcionario.getDistanciaTrabalho() <= 100) {
            funcionario.addBonus(new Bonus("Bonus por distancia", 1.05));
        } else {
            // 10%
            if (funcionario.getDistanciaTrabalho() >= 101 && funcionario.getDistanciaTrabalho() <= 150) {
                funcionario.addBonus(new Bonus(tipoBonus, 1.10));
            } else if (funcionario.getDistanciaTrabalho() >= 151) {
                //15%
                funcionario.addBonus(new Bonus(tipoBonus, 1.15));

            }
        }
    }
}
