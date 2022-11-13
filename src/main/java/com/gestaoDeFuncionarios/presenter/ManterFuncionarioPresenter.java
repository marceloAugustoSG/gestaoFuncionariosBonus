package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioDAO;
import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;

import com.gestaoDeFuncionarios.impl.BonusNormal;
import com.gestaoDeFuncionarios.model.Bonus;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.view.ManterFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManterFuncionarioPresenter {

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

    private void configurarTelaInicial() {
        view.getBtnEditar().setEnabled(false);
        view.getBtnExcluir().setEnabled(false);

    }

    private void fechar() {
        view.dispose();
    }

    private void limparCampos() {
        view.getTxtDataAdmissao().setText(" ");
        view.getTxtFaltas().setText(" ");
        view.getTxtIdade().setText(" ");
        view.getTxtNome().setText(" ");
        view.getTxtSalario().setText(" ");
        view.getCbOpcoesBonus().setSelectedIndex(0);
        view.getCbOpcoesCargo().setSelectedIndex(0);

    }

    private void salvar() {
        Funcionario funcionario;
        String nome = view.getTxtNome().getText();
        int idade = Integer.parseInt(view.getTxtIdade().getText());
        double salarioBase = Double.parseDouble(view.getTxtSalario().getText());
        String tipoBonus = (String) view.getCbOpcoesBonus().getSelectedItem();
        String cargo = (String) view.getCbOpcoesCargo().getSelectedItem();
        int numFaltas = Integer.parseInt(view.getTxtFaltas().getText());
        String dataAdmissao = view.getTxtDataAdmissao().getText();
        boolean funcionarioDoMes = view.getCheckedFuncionarioMes().isSelected();
        // funcionario = new Funcionario(nome, idade, salarioBase, tipoBonus, cargo);
        funcionario = new Funcionario( nome, idade,  salarioBase,  cargo,  numFaltas,  dataAdmissao,  funcionarioDoMes,  tipoBonus);
      
        funcionarios.create(funcionario);
        JOptionPane.showMessageDialog(view, "Funcionario :" + funcionario.getNome() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade() + " \nsalvo com sucesso!");
        limparCampos();
    }

}
