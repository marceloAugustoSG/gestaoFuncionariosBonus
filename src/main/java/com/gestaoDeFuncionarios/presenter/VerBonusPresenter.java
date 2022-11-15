package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.view.VerBonusView;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.presenter.tabelas.TabelaVerBonusPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VerBonusPresenter extends StateViews {

    private VerBonusView view;
    private TabelaVerBonusPresenter tblBonusFuncionario;
    private Funcionario funcionario;

    public VerBonusPresenter(Funcionario funcionario) throws SQLException {
        this.view = new VerBonusView();
        this.funcionario = funcionario;

        view.getTxtNomeFuncionario().setText(funcionario.getNome());
        String colunas[] = {"Data do Calculo", "Cargo", "Tipo do Bonus", "Valor do Bônus"};
        tblBonusFuncionario = new TabelaVerBonusPresenter(funcionario, colunas);
        carregarTabela();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
    }

    private void carregarTabela() {
        tblBonusFuncionario.addRow(this.funcionario);

        view.getTblVerBonusFuncionario().setModel(tblBonusFuncionario);

    }

    @Override
    public void manterFuncionarioStateView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visualizarFuncionarioStateView(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void fechar() {
        view.dispose();
    }

}
