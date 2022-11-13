package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.view.CalcularSalarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CalcularSalarioPresenter {

    private CalcularSalarioView view;
    private FuncionarioSQLDAO funcionarios;
    private DefaultTableModel tblBFuncionarios;
    private CalcularSalarioView telaGenerica;

    public CalcularSalarioPresenter(FuncionarioSQLDAO funcionarios) throws SQLException {
        view = new CalcularSalarioView();
        this.funcionarios = funcionarios;
        carregarTabela();
        view.getTblCalcularSalarioFuncionario().setModel(tblBFuncionarios);
        view.getTblCalcularSalarioFuncionario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }
    
    private void carregarTabela() throws SQLException {
        tblBFuncionarios = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Idade", "Salario", "Bonus", "Cargo"});
        view.getTblCalcularSalarioFuncionario().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListIterator<Funcionario> it = funcionarios.getFuncionarios().listIterator();
        while (it.hasNext()) {
            Funcionario funcionario = it.next();
            tblBFuncionarios.addRow(new Object[]{funcionario.getIdFuncionario(), funcionario.getNome(), funcionario.getIdade(), funcionario.getSalario(), funcionario.getTipoBonus(), funcionario.getCargo()});
        }
        view.getTblCalcularSalarioFuncionario().setModel(tblBFuncionarios);
    }

    private void fechar() {
        view.dispose();
    }

}
