package com.gestaoDeFuncionarios.services;

import com.mycompany.bonusteste.business.BonusAssuidadeStrategy;
import com.mycompany.bonusteste.business.BonusPorDistanciaStrategy;
import com.mycompany.bonusteste.business.BonusTempoServicoStrategy;
import com.mycompany.bonusteste.business.ICalculaBonus;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.util.ArrayList;

public class CalculadoraBonus {

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<ICalculaBonus> calculosBonus = new ArrayList<>();

    public CalculadoraBonus() {

        this.calculosBonus.add(new BonusAssuidadeStrategy());
        this.calculosBonus.add(new BonusPorDistanciaStrategy());
        this.calculosBonus.add(new BonusTempoServicoStrategy());
        //this.calculosBonus.add(new BonusTeste());
    }

    public void addFuncionario(Funcionario funcionario) {

        if (this.funcionarios.contains(funcionario)) {
            throw new RuntimeException("Funcionario ja existente");
        } else {
            this.funcionarios.add(funcionario);

        }

    }

    public void addCalculoBonus(ICalculaBonus calculoBonus) {
        if (calculosBonus.contains(calculoBonus)) {

            throw new RuntimeException("calculo de bonus ja adicionado");
        } else {
            calculosBonus.add(calculoBonus);
            System.out.println("passou aqui");
        }

    }

    public void calcular() {
        //prits para testes
        System.out.println("------------------------------------------");
        for (ICalculaBonus calculo : calculosBonus) {
            for (Funcionario funcionario : funcionarios) {
                calculo.calcular(funcionario);
                funcionario.calculaSalario();
                System.out.println(funcionario.toString());
                System.out.println("------------------------------------------");
            }
        }

    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<ICalculaBonus> getCalculosBonus() {
        return calculosBonus;
    }

}
