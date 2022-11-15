package com.gestaoDeFuncionarios.presenter.tabelas;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaBuscarPresenter extends AbstractTableModel {

    private String colunas[];
    private FuncionarioSQLDAO funcionarios;

    public TabelaBuscarPresenter(FuncionarioSQLDAO funcionarios, String[] colunas) {
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
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {

            case 0:
                return funcionarios.getFuncionarios().get(linha).getNome();
            case 1:
                return funcionarios.getFuncionarios().get(linha).getIdade();
            case 2:
                return funcionarios.getFuncionarios().get(linha).getCargo();
            case 3:
                return funcionarios.getFuncionarios().get(linha).getSalarioBase();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void addRow(Funcionario f) {
        this.funcionarios.getFuncionarios().add(f);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.funcionarios.delete(funcionarios.getFuncionario(linha));
        this.fireTableRowsDeleted(linha, linha);
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {

        switch (coluna) {

            case 1:
                funcionarios.getFuncionarios().get(linha).setNome((String) valor);
                break;
            case 2:
                funcionarios.getFuncionarios().get(linha).setIdade(Integer.parseInt((String) valor));
                break;
            case 3:
                funcionarios.getFuncionarios().get(linha).setCargo((String) valor);
                break;
            case 4:
                funcionarios.getFuncionarios().get(linha).setSalarioBase(Double.parseDouble((String) valor));
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public Funcionario selectRow(int index) {
        return funcionarios.getFuncionarios().get(index);

    }

}
