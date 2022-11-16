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
                salvar();
            }
        });

    }

    private void salvar() {
        Funcionario funcionario;

        Falta faltas;
        String nome = view.getTxtNome().getText();
        int idade = Integer.parseInt(view.getTxtIdade().getText());
        double salarioBase = Double.parseDouble(view.getTxtSalario().getText());
        String cargo = (String) view.getCbOpcoesCargo().getSelectedItem();
        int numFaltas = Integer.parseInt(view.getTxtFaltas().getText());
        String dataAdmissao = view.getTxtDataAdmissao().getText();
        boolean funcionarioDoMes = view.getCheckedFuncionarioMes().isSelected();
//        funcionario = new Funcionario(nome, idade, salarioBase, cargo);
//        funcionario = new Funcionario(nome, idade, salarioBase, cargo, numFaltas, dataAdmissao, funcionarioDoMes);

        funcionario = new Funcionario(nome, idade, cargo, salarioBase, numFaltas, dataAdmissao, funcionarioDoMes);
        funcionarios.create(funcionario);

        faltas = new Falta(numFaltas);
        funcionario.addFalta(faltas);
        JOptionPane.showMessageDialog(view, "Funcionario :" + funcionario.getNome() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade() + " \nsalvo com sucesso!");
        limparCampos();
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

    private void limparCampos() {

        view.getTxtNome().setText("");
        view.getTxtSalario().setText("");
        view.getTxtIdade().setText("");
        view.getTxtFaltas().setText("");
        view.getTxtDataAdmissao().setText("");
    }

}
