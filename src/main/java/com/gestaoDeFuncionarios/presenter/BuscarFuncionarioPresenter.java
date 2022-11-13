package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.view.BuscarFuncionarioView;
import com.gestaoDeFuncionarios.view.ManterFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class BuscarFuncionarioPresenter {

    private BuscarFuncionarioView view;
    private FuncionarioSQLDAO funcionarios;
    private DefaultTableModel tblBFuncionarios;
    private ManterFuncionarioView telaGenerica;

    public BuscarFuncionarioPresenter(FuncionarioSQLDAO funcionarios) throws SQLException {
        view = new BuscarFuncionarioView();
        this.funcionarios = funcionarios;
        carregarTabela();

        view.getTblBuscarFuncionarios().setModel(tblBFuncionarios);
        view.getTblBuscarFuncionarios().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //configurarBtns();
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        view.getBtnNovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterFuncionarioPresenter(funcionarios);
            }
        });

        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFuncionario = view.getTxtBuscarFuncionario().getText();
                buscarFuncionario(nomeFuncionario);
            }
        });

        view.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaVisualizar();

            }
        });

    }

    private void abrirJanelaVisualizar() {
        int index = view.getTblBuscarFuncionarios().getSelectedRow();
        Funcionario funcionario = new Funcionario();
        FuncionarioSQLDAO funcionarioSDAO = new FuncionarioSQLDAO();
        funcionario.setIdFuncionario((int) view.getTblBuscarFuncionarios().getValueAt(index, 0));
        Funcionario funcionarioSelecionado = funcionarioSDAO.getFuncionario(funcionario.getIdFuncionario());
        System.out.println(funcionarioSelecionado.getNome() + "," + funcionarioSelecionado.getIdade() + "," + funcionarioSelecionado.getTipoBonus());

        telaGenerica = new ManterFuncionarioView();
        telaGenerica.setTitle("Visualizar Funcionario");
        telaGenerica.setLocationRelativeTo(null);
        telaGenerica.getTxtNome().setText(funcionarioSelecionado.getNome());
        telaGenerica.getTxtIdade().setText(String.valueOf(funcionarioSelecionado.getIdade()));
        telaGenerica.getTxtSalario().setText(String.valueOf(funcionarioSelecionado.getSalario()));
        telaGenerica.getTxtFaltas().setText(String.valueOf(funcionario.getNumFaltas()));
        funcionarioSelecionado.setDataAdmissao("10082020");
        telaGenerica.getTxtDataAdmissao().setText(funcionarioSelecionado.getDataAdmissao());
        telaGenerica.getCheckedFuncionarioMes().isSelected();
        System.out.println(telaGenerica.getCheckedFuncionarioMes());

        // inicia a janela com os campos nao editaveis e o btn salvar
        telaGenerica.getTxtNome().setEditable(false);
        telaGenerica.getTxtFaltas().setEditable(false);
        telaGenerica.getTxtIdade().setEditable(false);
        telaGenerica.getTxtSalario().setEditable(false);
        telaGenerica.getTxtDataAdmissao().setEditable(false);
        telaGenerica.getCbOpcoesCargo().setEnabled(false);
        telaGenerica.getCbOpcoesBonus().setEnabled(false);
        telaGenerica.getBtnSalvar().setEnabled(false);

        //eventos dos botoes
        telaGenerica.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaGenerica.getTxtNome().setEditable(true);
                telaGenerica.getTxtFaltas().setEditable(true);
                telaGenerica.getTxtIdade().setEditable(true);
                telaGenerica.getTxtSalario().setEditable(true);
                telaGenerica.getTxtDataAdmissao().setEditable(true);
                telaGenerica.getCbOpcoesCargo().setEnabled(true);
                telaGenerica.getCbOpcoesBonus().setEnabled(true);
                telaGenerica.getBtnSalvar().setEnabled(true);

            }
        });

        telaGenerica.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editarFuncioanario();
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        telaGenerica.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excluirFuncionario();
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        telaGenerica.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaGenerica.dispose();
            }
        });

    }

    private void editarFuncioanario() throws SQLException {
        int index = view.getTblBuscarFuncionarios().getSelectedRow();
        Funcionario funcionarioSelecionado = new Funcionario();
        FuncionarioSQLDAO funcionarioSDAO = new FuncionarioSQLDAO();
        funcionarioSelecionado.setIdFuncionario((int) view.getTblBuscarFuncionarios().getValueAt(index, 0));
        funcionarioSDAO.update(funcionarioSelecionado);
        carregarTabela();

    }

    private void excluirFuncionario() throws SQLException {
        int index = view.getTblBuscarFuncionarios().getSelectedRow();

        Funcionario funcionarioSelecionado = new Funcionario();
        FuncionarioSQLDAO funcionarioSDAO = new FuncionarioSQLDAO();

        funcionarioSelecionado.setIdFuncionario((int) view.getTblBuscarFuncionarios().getValueAt(index, 0));

        String[] options = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this.telaGenerica, "Deseja realmente excluir ?", "Excluir Funcionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (resposta == 1) {
            return;
        }
        if (resposta == 0) {

            funcionarioSDAO.delete(funcionarioSelecionado);
            carregarTabela();
        }
    }

    private void carregarTabela() throws SQLException {
        tblBFuncionarios = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Idade", "Salario", "Bonus", "Cargo"});

        view.getTblBuscarFuncionarios()
                .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListIterator<Funcionario> it = funcionarios.getFuncionarios().listIterator();

        while (it.hasNext()) {
            Funcionario funcionario = it.next();
            tblBFuncionarios.addRow(new Object[]{funcionario.getIdFuncionario(), funcionario.getNome(), funcionario.getIdade(), funcionario.getSalario(), funcionario.getTipoBonus(), funcionario.getCargo()});

        }

        view.getTblBuscarFuncionarios()
                .setModel(tblBFuncionarios);

    }

    private void buscarFuncionario(String nome) {
        tblBFuncionarios = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Idade", "Salario", "Bonus", "Cargo"});
        view.getTblBuscarFuncionarios().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListIterator<Funcionario> it = funcionarios.getFuncionarios(nome).listIterator();

        while (it.hasNext()) {
            Funcionario funcionario = it.next();
            tblBFuncionarios.addRow(new Object[]{funcionario.getIdFuncionario(), funcionario.getNome(), funcionario.getIdade(), funcionario.getSalario(), funcionario.getTipoBonus(), funcionario.getCargo()});

        }
        view.getTblBuscarFuncionarios().setModel(tblBFuncionarios);

    }

    private void configurarBtns() {
        view.getBtnVerBonus().setEnabled(false);
        view.getBtnVisualizar().setEnabled(false);

    }

    private void habilitarBtns() {
        view.getBtnVerBonus().setEnabled(true);
        view.getBtnVisualizar().setEnabled(true);

    }

    private void fechar() {
        view.dispose();
    }

}
