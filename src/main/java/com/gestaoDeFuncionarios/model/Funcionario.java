package com.gestaoDeFuncionarios.model;

import com.gestaoDeFuncionarios.model.Falta;
import java.util.ArrayList;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private int idade;
    private String cargo;
    private double salarioBase;
    private double salario;
    private int numFaltas;
    private String dataAdmissao;
    private boolean isFuncionarioMes;
    private double distanciaTrabalho;
    private double tempoServico;
    private ArrayList<Bonus> bonusRecebidos = new ArrayList<>();
    private ArrayList<Falta> faltas = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, int idade, String cargo, double salarioBase, int numFaltas, String dataAdmissao, boolean isFuncionarioMes) {

        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.numFaltas = numFaltas;
        this.dataAdmissao = dataAdmissao;
        this.isFuncionarioMes = isFuncionarioMes;
    }

    public String getNome() {
        return nome;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int id) {
        this.idFuncionario = idFuncionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isIsFuncionarioMes() {
        return isFuncionarioMes;
    }

    public void setIsFuncionarioMes(boolean isFuncionarioMes) {
        this.isFuncionarioMes = isFuncionarioMes;
    }

    public double getDistanciaTrabalho() {
        return distanciaTrabalho;
    }

    public void setDistanciaTrabalho(double distanciaTrabalho) {
        this.distanciaTrabalho = distanciaTrabalho;
    }

    public double getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(double tempoServico) {
        this.tempoServico = tempoServico;
    }

    public ArrayList<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltaAoTrabalho(ArrayList<Falta> faltas) {
        this.faltas = faltas;
    }

    public void addFalta(Falta falta) {

        if (faltas.contains(falta)) {
            throw new RuntimeException("a falta já foi registrada");
        }
        if (falta != null) {
            faltas.add(falta);
        } else {
            throw new RuntimeException("Forneça uma instancia de falta válida");
        }
    }

    public void removeFalta(Falta falta) {

        if (faltas.contains(falta)) {
            faltas.remove(falta);
        }
        if (falta == null) {
            throw new RuntimeException("Forneça uma instancia de falta válida");
        }
    }

    public void addBonus(Bonus bonus) {

        if (bonusRecebidos.contains(bonus)) {
            throw new RuntimeException("Bonus já foi aplicado"); //tratar
        }
        if (bonus != null) {
            bonusRecebidos.add(bonus);
        } else {
            throw new RuntimeException("Forneça uma instancia de bonus válida");
        }
    }

    public void removeBonus(Bonus bonus) {

        if (bonusRecebidos.contains(bonus)) {
            bonusRecebidos.remove(bonusRecebidos);
        }
        if (bonus == null) {
            throw new RuntimeException("Forneça uma instancia de bonus válida");
        }
    }

    public ArrayList<Bonus> getBonusRecebidos() {
        return bonusRecebidos;
    }

    public void calculaSalario() {
        if (this.bonusRecebidos.size() == 0) {
            this.salario = this.salarioBase;
        } else {

            double salarioFuncioanario = 0;
            for (int i = 0; i < this.bonusRecebidos.size(); i++) {
                salarioFuncioanario += this.salarioBase * bonusRecebidos.get(i).getValorBonus();
            }
            this.salario = salarioFuncioanario;
        }
    }

    @Override
    public String toString() {
        // esse toString foi para testar na main
        String funcionario = "ID: " + this.getIdFuncionario() + " {Funcionario: " + nome + "\nIdade: " + idade + "\nCargo: " + cargo + "\nSalario Base: " + salarioBase + "\nSalario: " + salario + "\n[";
        for (int i = 0; i < getBonusRecebidos().size(); i++) {
            funcionario += this.getBonusRecebidos().get(i).toString();
        }
        return funcionario += this.getFaltas().toString() + "}";
    }

    public int getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }

    public Object getTipoBonus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isFuncionarioDoMes() {
        return isFuncionarioMes;
    }

}
