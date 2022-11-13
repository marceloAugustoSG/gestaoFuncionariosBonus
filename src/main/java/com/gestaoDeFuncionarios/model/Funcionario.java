package com.gestaoDeFuncionarios.model;

import java.util.ArrayList;

public class Funcionario {

    private int idFuncionario;
    private String nome;
    private int idade;
    private double salario;
    private double salarioBase;
    private String cargo;
    private int numFaltas;
    private String dataAdmissao;
    private boolean funcionarioDoMes;
    private String tipoBonus;
    private ArrayList<Bonus> listBonus;
    //private double bonus;

    // o bonus ainda nao está sendo usado para salvar o funcionario
    //private Bonus bonus;
    public Funcionario(String nome, int idade, double salario, String tipoBonus, String cargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.tipoBonus = tipoBonus;
        this.cargo = cargo;

    }

    public Funcionario(String nome, int idade, double salarioBase, String cargo, int numFaltas, String dataAdmissao, boolean funcionarioDoMes, String tipoBonus) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
        this.numFaltas = numFaltas;
        this.dataAdmissao = dataAdmissao;
        this.funcionarioDoMes = funcionarioDoMes;
        this.tipoBonus = tipoBonus;

    }

    public Funcionario(String nome, double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /*public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }*/
    public int getNumFaltas() {
        return this.numFaltas;
    }

    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }

    public String getDataAdmissao() {
        return this.dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isFuncionarioDoMes() {
        return funcionarioDoMes;
    }

    public void setFuncionarioDoMes(boolean funcionarioDoMes) {
        this.funcionarioDoMes = funcionarioDoMes;
    }

    public String getTipoBonus() {
        return tipoBonus;
    }

    public void setTipoBonus(String tipoBonus) {
        this.tipoBonus = tipoBonus;
    }

    public ArrayList<Bonus> getListBonus() {
        return listBonus;
    }

    public void setListBonus(ArrayList<Bonus> listBonus) {
        this.listBonus = listBonus;
    }

    public void addBonus(Bonus bonus) {
        if (listBonus.contains(bonus)) {
            throw new RuntimeException("Bônus já aplicado");
        }
        if (bonus != null) {
            listBonus.add(bonus);
        } else {
            throw new RuntimeException("Forneça uma instancia de bônus válida");
        }
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", idade=" + idade + ", salario=" + salario + ", salarioBase=" + salarioBase + ", cargo=" + cargo + ", numFaltas=" + numFaltas + ", dataAdmissao=" + dataAdmissao + ", funcionarioDoMes=" + funcionarioDoMes + ", tipoBonus=" + tipoBonus + ", listBonus=" + listBonus + '}';
    }

}
