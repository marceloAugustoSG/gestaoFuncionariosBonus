package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.presenter.tabelas.TabelaCalculoSalarioPresenter;
import com.gestaoDeFuncionarios.view.CalcularSalarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CalcularSalarioPresenter {

    private CalcularSalarioView view;
    private FuncionarioSQLDAO funcionarios;
    private TabelaCalculoSalarioPresenter tblCalculoFuncionarios;

    public CalcularSalarioPresenter(FuncionarioSQLDAO funcionarios) throws SQLException {
        view = new CalcularSalarioView();
        this.funcionarios = funcionarios;
        String colunas[] = {"Funcionario", "Data", "Sálario Base", "Bônus(R$)", "Salário(R$)"};
        this.tblCalculoFuncionarios = new TabelaCalculoSalarioPresenter(colunas, funcionarios);
        carregarTabela();
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }

    private void carregarTabela() {

        for (Funcionario funcionario : funcionarios.getFuncionarios()) {
            tblCalculoFuncionarios.addRow(funcionario);
        }

        view.getTblCalcularSalarioFuncionario().setModel(tblCalculoFuncionarios);

    }

    private void fechar() {
        view.dispose();
    }

}
