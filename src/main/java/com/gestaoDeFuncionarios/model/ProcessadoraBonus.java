package com.gestaoDeFuncionarios.model;

import com.gestaoDeFuncionarios.impl.BonusAssiduidade;
import com.gestaoDeFuncionarios.impl.BonusFuncionarioDoMes;
import com.gestaoDeFuncionarios.impl.BonusGeneroso;
import com.gestaoDeFuncionarios.impl.BonusNormal;
import com.gestaoDeFuncionarios.impl.BonusTempoServico;
import java.util.ArrayList;

public class ProcessadoraBonus {

    private ArrayList<Bonus> processadoresBonus = new ArrayList<>();

    public ProcessadoraBonus() {
        this.processadoresBonus.add(new BonusNormal("Normal"));
        this.processadoresBonus.add(new BonusGeneroso("Generoso"));
        this.processadoresBonus.add(new BonusAssiduidade("Assiduidade"));
        this.processadoresBonus.add(new BonusFuncionarioDoMes("FuncionarioDoMes"));
        this.processadoresBonus.add(new BonusTempoServico("TempoServico"));
    }

    public double processar(Funcionario funcionario) {
        double bonusTotal = 0;

        for (Bonus processador : processadoresBonus) {
            if (processador.accept(funcionario)) {
                processador.setValor(processador.aplicaBonus(funcionario));
                bonusTotal += processador.getValor();
                funcionario.addBonus(processador);
                //gera log
            }
        }

        return bonusTotal + funcionario.getSalarioBase();
    }
}
