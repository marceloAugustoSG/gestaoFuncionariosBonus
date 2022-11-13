package com.gestaoDeFuncionarios.collection;

import com.gestaoDeFuncionarios.model.Funcionario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionarioCollection {

    private ArrayList<Funcionario> funcionarios;

    public FuncionarioCollection() {
        funcionarios = new ArrayList<>();
    }

    public void add(Funcionario funcionario) {
        if (funcionarios.contains(funcionario)) {
            throw new RuntimeException("Funcionario já existe");
        }
        if (funcionario != null) {
            funcionarios.add(funcionario);
        } else {
            throw new RuntimeException("Forneça uma instancia de funcionario válida");
        }

    }

    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);

    }

}
