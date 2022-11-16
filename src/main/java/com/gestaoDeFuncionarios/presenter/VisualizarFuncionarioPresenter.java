package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Falta;
import com.gestaoDeFuncionarios.view.BuscarFuncionarioView;
import com.gestaoDeFuncionarios.view.ManterFuncionarioView;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VisualizarFuncionarioPresenter extends StateViews {

    private ManterFuncionarioView view;
    private BuscarFuncionarioView telaBuscar;
    private FuncionarioSQLDAO funcionarios;
    private Funcionario funcionario = null;

    public VisualizarFuncionarioPresenter(Funcionario funcionario) {

        this.funcionario = funcionario;
        this.funcionarios = new FuncionarioSQLDAO();

        this.view = new ManterFuncionarioView();

        view.setTitle("Visualizar Funcionario");
        view.setLocationRelativeTo(null);
        view.getTxtNome().setText(funcionario.getNome());
        view.getTxtIdade().setText(String.valueOf(funcionario.getIdade()));
        view.getTxtSalario().setText(String.valueOf(funcionario.getSalarioBase()));
        //view.getTxtFaltas().setText(String.valueOf(funcionario.funcionario()));
        funcionario.setDataAdmissao("10082020");
        view.getTxtDataAdmissao().setText(funcionario.getDataAdmissao());
        view.getCheckedFuncionarioMes().isSelected();
        // System.out.println(view.getCheckedFuncionarioMes());

        configurarTelaDesabilitar();
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configurarTelaHabilitar();
            }
        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarOuCriar();
            }

        });

        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excluirFuncionario(funcionario);
                } catch (SQLException ex) {
                    Logger.getLogger(VisualizarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

    }

    private void excluirFuncionario(Funcionario funcionario) throws SQLException {

        FuncionarioSQLDAO funcionarioSDAO = new FuncionarioSQLDAO();

        String[] options = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this.view, "Deseja realmente excluir ?", "Excluir Funcionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (resposta == 1) {
            return;
        }
        if (resposta == 0) {

            funcionarioSDAO.delete(funcionario);
            //observer da tabela
        }
    }

    private void configurarTelaDesabilitar() {

        view.getTxtNome().setEditable(false);
        view.getTxtFaltas().setEditable(false);
        view.getTxtIdade().setEditable(false);
        view.getTxtSalario().setEditable(false);
        view.getTxtDataAdmissao().setEditable(false);
        view.getCbOpcoesCargo().setEnabled(false);
        //view.getCbOpcoesBonus().setEnabled(false);
        view.getBtnSalvar().setEnabled(false);

    }

    public void configurarTelaHabilitar() {

        view.getTxtNome().setEditable(true);
        view.getTxtFaltas().setEditable(true);
        view.getTxtIdade().setEditable(true);
        view.getTxtSalario().setEditable(true);
        view.getTxtDataAdmissao().setEditable(true);
        view.getCbOpcoesCargo().setEnabled(true);
        // view.getCbOpcoesBonus().setEnabled(true);
        view.getBtnSalvar().setEnabled(true);
    }

    @Override
    public void manterFuncionarioStateView() {
    }

    @Override
    public void visualizarFuncionarioStateView(Funcionario funcionario) {
        new VisualizarFuncionarioPresenter(funcionario);

    }

    private void limparCampos() {
        view.getTxtDataAdmissao().setText(" ");
        view.getTxtFaltas().setText(" ");
        view.getTxtIdade().setText(" ");
        view.getTxtNome().setText(" ");
        view.getTxtSalario().setText(" ");
        view.getCbOpcoesCargo().setSelectedIndex(0);

    }

    private void atualizarOuCriar() {

        Funcionario funcionario = null;
        Falta faltas;

        String nome = view.getTxtNome().getText();
        int idade = Integer.parseInt(view.getTxtIdade().getText());
        double salarioBase = Double.parseDouble(view.getTxtSalario().getText());
        String cargo = (String) view.getCbOpcoesCargo().getSelectedItem();
        int numFaltas = view.getTxtFaltas().getText().length() >= 1 ? Integer.parseInt(view.getTxtFaltas().getText()) : 0;
        String dataAdmissao = view.getTxtDataAdmissao().getText();
        boolean funcionarioDoMes = view.getCheckedFuncionarioMes().isSelected();

        if (this.funcionario != null) {
            funcionario = new Funcionario(nome, idade, cargo, salarioBase, numFaltas, dataAdmissao, funcionarioDoMes);
            funcionario.setIdFuncionario(this.funcionario.getIdFuncionario());

            faltas = new Falta(numFaltas);
            funcionario.addFalta(faltas);

            try {
                funcionarios.update(funcionario);

                JOptionPane.showMessageDialog(view, "Funcionario :" + funcionario.getNome() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade() + " \natualizado com sucesso!");

            } catch (HeadlessException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar o funcionário!",
                        e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }

        } else {
            funcionario = new Funcionario(nome, idade, cargo, salarioBase, numFaltas, dataAdmissao, funcionarioDoMes);
            funcionarios.create(funcionario);

            faltas = new Falta(numFaltas);
            funcionario.addFalta(faltas);
            JOptionPane.showMessageDialog(view, "Funcionario :" + funcionario.getNome() + "\nCargo: " + funcionario.getCargo() + "\nIdade: " + funcionario.getIdade() + " \nsalvo com sucesso!");
            limparCampos();
        }
    }
}
