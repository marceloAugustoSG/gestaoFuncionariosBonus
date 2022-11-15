package com.gestaoDeFuncionarios.presenter;

import com.gestaoDeFuncionarios.Adapter.FIleCSVAdapter;
import com.gestaoDeFuncionarios.Adapter.IFileAdapter;
import com.gestaoDeFuncionarios.DAO.FuncionarioSQLDAO;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.services.LerArquivo;
import com.gestaoDeFuncionarios.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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

        view.getImportData().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                escolherArquivo();
            }
        });

        view.getTxtNumFuncionarios().setText(Integer.toString(funcionarios.getFuncionarios().size()));
    }

    private void escolherArquivo() {
        LerArquivo lerArquivo = new LerArquivo();

        try {
            String arquivo = lerArquivo.escolherArquivo();
            IFileAdapter ler = new FIleCSVAdapter(arquivo);

            ArrayList<Funcionario> funcionarios = ler.read();

            funcionarios.forEach(f -> this.funcionarios.create(f));

        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error!",
                    e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fechar() {
        System.exit(0);
    }
}
