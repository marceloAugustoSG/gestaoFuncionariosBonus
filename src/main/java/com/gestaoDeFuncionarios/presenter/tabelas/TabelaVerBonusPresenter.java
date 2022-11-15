package com.gestaoDeFuncionarios.presenter.tabelas;

import com.gestaoDeFuncionarios.model.Funcionario;
import java.time.LocalDate;
import javax.swing.table.AbstractTableModel;

public class TabelaVerBonusPresenter extends AbstractTableModel {

    private String colunas[];
    private Funcionario funcionario;

    public TabelaVerBonusPresenter(Funcionario funcionario, String[] colunas) {
        this.colunas = colunas;
        this.funcionario = funcionario;

    }

    @Override
    public int getRowCount() {
        return funcionario.getBonusRecebidos().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return LocalDate.now();
            case 1:
                return funcionario.getCargo();
            case 2:
                return "Bonus padrão";
            case 3:
                return "R$ 0";
        }
        return null;
    }

    public void addRow(Funcionario f) {

        this.fireTableDataChanged();

    }

    public Funcionario selectRow(int index) {
        // return funcionarios.getFuncionarios().get(index);
        return null;
        // }
    }
}
