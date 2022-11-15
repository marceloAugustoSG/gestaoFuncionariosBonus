package com.mycompany.bonusteste.business;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BonusTempoServicoStrategy implements ICalculaBonus {

    @Override
    public void calcular(Funcionario funcionario) {

        String tipoBonus = "Bonus Tempo de Serviço";
        LocalDate now = LocalDate.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("uuuu-MM-dd");

        //LocalDate testeParse = LocalDate.parse("10/11/2021", formatador);
        LocalDate earlier = LocalDate.parse(funcionario.getDataAdmissao(), formatador);
        Period period = Period.between(now, earlier);
        int ano = Math.abs(period.getYears());

        if (ano >= 1 && ano <= 5) {
            funcionario.addBonus(new Bonus(tipoBonus, 1.02));
        } else {
            if (ano >= 6 && ano <= 10) {
                funcionario.addBonus(new Bonus(tipoBonus, 1.03));
            } else {
                if (ano >= 11 && ano <= 15) {
                    funcionario.addBonus(new Bonus(tipoBonus, 1.08));
                } else {
                    if (ano >= 16 && ano <= 20) {
                        funcionario.addBonus(new Bonus(tipoBonus, 1.10));
                    } else {
                        funcionario.addBonus(new Bonus(tipoBonus, 1.15));
                    }
                }
            }
        }

    }
}
