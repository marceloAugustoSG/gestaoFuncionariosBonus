package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.presenter.tabelas.TabelaBuscarPresenter;
import com.gestaoDeFuncionarios.view.BuscarFuncionarioView;
import com.gestaoDeFuncionarios.services.StateControle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuscarFuncionarioPresenter {

    private BuscarFuncionarioView view;
    private FuncionarioSQLDAO funcionarios;
    private TabelaBuscarPresenter tblBFuncionarios;
    private StateControle controleTela;

    public BuscarFuncionarioPresenter(FuncionarioSQLDAO funcionarios) throws SQLException {
        view = new BuscarFuncionarioView();
        this.funcionarios = funcionarios;
        this.controleTela = new StateControle();
        String colunas[] = {"Nome", "Idade", "Função", "Salário Base(R$)"};
        this.tblBFuncionarios = new TabelaBuscarPresenter(funcionarios, colunas);
        carregarTabela();

        view.getBtnFechar().addActionListener((ActionEvent e) -> {
            fechar();
        });

        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleTela.setEstados(new ManterFuncionarioPresenter(funcionarios));
            }
        });

        view.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarFuncionario();
            }
        });

        view.getBtnVerBonus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    VerBonusFuncionario();
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void carregarTabela() {

        for (Funcionario funcionario : funcionarios.getFuncionarios()) {
            tblBFuncionarios.addRow(funcionario);
        }

        view.getTblBuscarFuncionarios().setModel(tblBFuncionarios);

    }

    private void visualizarFuncionario() {
        Funcionario funcionario = new Funcionario();
        int index = view.getTblBuscarFuncionarios().getSelectedRow();
        if (index != -1) {
            funcionario = tblBFuncionarios.selectRow(index);

            controleTela.setEstados(new VisualizarFuncionarioPresenter(funcionario));

        }
    }

    private void VerBonusFuncionario() throws SQLException {

        Funcionario funcionario = new Funcionario();
        int index = view.getTblBuscarFuncionarios().getSelectedRow();
        if (index != -1) {
            funcionario = tblBFuncionarios.selectRow(index);

            controleTela.setEstados(new VerBonusPresenter(funcionario));

        }

    }

    private void fechar() {

        this.view.dispose();
    }
}
