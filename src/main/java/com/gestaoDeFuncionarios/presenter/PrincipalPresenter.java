package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalPresenter {
    
    private PrincipalView view;
    private FuncionarioSQLDAO funcionarios;
    
    public PrincipalPresenter() {
        view = new PrincipalView();
        this.funcionarios = new FuncionarioSQLDAO();
        
        view.getmOpCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterFuncionarioPresenter(funcionarios);
            }
        });
        
        view.getmOpBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    new BuscarFuncionarioPresenter(funcionarios);
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        view.getmOpCalcularSalario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CalcularSalarioPresenter(funcionarios);
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        view.getmOpSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        view.getmOpTrocarMecanismoLog().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        view.getTxtNumFuncionarios().setText(Integer.toString(funcionarios.getFuncionarios().size()));
    }
    
    private void fechar() {
        System.exit(0);
    }
}
