package com.gestaoDeFuncionarios.DAO;

import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.presenter.IObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class FuncionarioDAO {

    public ArrayList<IObserver> observers;

    public abstract boolean create(Funcionario funcionario);
    
    public abstract boolean update(Funcionario funcionario);

    public abstract List<Funcionario> getFuncionarios(String nome);

    public abstract void notificar();

    public abstract void add(IObserver observer);

}
