package com.gestaoDeFuncionarios.impl;

import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.time.LocalDate;
import java.time.Period;

public class BonusTempoServico extends Bonus {

    public BonusTempoServico(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public double aplicaBonus(Funcionario funcionario) {
        LocalDate now = LocalDate.now();
        LocalDate earlier = LocalDate.parse(funcionario.getDataAdmissao());
        Period period = Period.between(now, earlier);
        int years = Math.abs(period.getYears());

        if (years >= 1 && years <= 5) {
            return (0.02 * funcionario.getSalarioBase());
        } else {
            if (years >= 6 && years <= 10) {
                return (0.03 * funcionario.getSalarioBase());
            } else {
                if (years >= 11 && years <= 15) {
                    return (0.08 * funcionario.getSalarioBase());
                } else {
                    if (years >= 16 && years <= 20) {
                        return (0.1 * funcionario.getSalarioBase());
                    } else {
                        return (0.15 * funcionario.getSalarioBase());
                    }
                }
            }
        }
    }

    @Override
    public boolean accept(Funcionario funcionario) {
        LocalDate now = LocalDate.now();
        LocalDate earlier = LocalDate.parse(funcionario.getDataAdmissao());
        Period period = Period.between(now, earlier);
        int years = Math.abs(period.getYears());
        if (years > 0) {
            return true;
        }
        return false;
    }

}
