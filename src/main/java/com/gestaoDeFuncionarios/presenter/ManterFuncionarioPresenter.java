package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;

import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.view.ManterFuncionarioView;
import com.gestaoDeFuncionarios.model.Falta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ManterFuncionarioPresenter extends StateViews {

    private ManterFuncionarioView view;
    private FuncionarioSQLDAO funcionarios;

    public ManterFuncionarioPresenter(FuncionarioSQLDAO funcionarios) {
        this.funcionarios = funcionarios;
        
        view = new ManterFuncionarioView();
        configurarTelaInicial();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                salvar();
            }
        });

    }

    private void configurarTelaInicial() {
        view.getBtnEditar().setEnabled(false);
        view.getBtnExcluir().setEnabled(false);

    }

    private void fechar() {
        view.dispose();
    }

    @Override
    public void manterFuncionarioStateView() {
        new ManterFuncionarioPresenter(funcionarios);
    }

    @Override
    public void visualizarFuncionarioStateView(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
