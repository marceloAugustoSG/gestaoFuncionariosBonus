package com.gestaoDeFuncionarios.presenter.tabelas;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.time.LocalDate;
import javax.swing.table.AbstractTableModel;

public class TabelaCalculoSalarioPresenter extends AbstractTableModel {

    private String[] colunas;
    private FuncionarioSQLDAO funcionarios;

    public TabelaCalculoSalarioPresenter(String[] colunas, FuncionarioSQLDAO funcionarios) {
        this.colunas = colunas;
        this.funcionarios = funcionarios;
    }

    @Override
    public int getRowCount() {

        return funcionarios.getFuncionarios().size();
    }

    @Override
    public int getColumnCount() {

        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    public void addRow(Funcionario f) {
        this.funcionarios.getFuncionarios().add(f);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return funcionarios.getFuncionarios().get(linha).getNome();
            case 1:
                return LocalDate.now();
            case 2:
                return funcionarios.getFuncionarios().get(linha).getSalarioBase();
            case 3:
                String bonus = null;
                for (Funcionario f : funcionarios.getFuncionarios()) {

                    return bonus;
                }

            case 4:
                return funcionarios.getFuncionarios().get(linha).getSalario();
        }
        return null;
    }
}
