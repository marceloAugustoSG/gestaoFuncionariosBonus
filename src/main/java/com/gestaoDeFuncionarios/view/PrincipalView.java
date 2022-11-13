package com.gestaoDeFuncionarios.view;

import com.gestaoDeFuncionarios.collection.FuncionarioCollection;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PrincipalView extends javax.swing.JFrame {

 

    public PrincipalView() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(this.getParent());
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    public JMenuItem getmOpBuscar() {
        return mOpBuscar;
    }

    public void setmOpBuscar(JMenuItem mOpBuscar) {
        this.mOpBuscar = mOpBuscar;
    }

    public JMenuItem getmOpCadastrar() {
        return mOpCadastrar;
    }

    public void setmOpCadastrar(JMenuItem mOpCadastrar) {
        this.mOpCadastrar = mOpCadastrar;
    }

    public JMenuItem getmOpCalcularSalario() {
        return mOpCalcularSalario;
    }

    public void setmOpCalcularSalario(JMenuItem mOpCalcularSalario) {
        this.mOpCalcularSalario = mOpCalcularSalario;
    }

    public JMenuItem getmOpTrocarMecanismoLog() {
        return mOpTrocarMecanismoLog;
    }

    public void setmOpTrocarMecanismoLog(JMenuItem mOpTrocarMecanismoLog) {
        this.mOpTrocarMecanismoLog = mOpTrocarMecanismoLog;
    }

    public JMenu getMbFerramentas() {
        return mbFerramentas;
    }

    public void setMbFerramentas(JMenu mbFerramentas) {
        this.mbFerramentas = mbFerramentas;
    }

    public JMenu getMbFuncionario() {
        return mbFuncionario;
    }

    public void setMbFuncionario(JMenu mbFuncionario) {
        this.mbFuncionario = mbFuncionario;
    }

    public JMenu getMbSalario() {
        return mbSalario;
    }

    public void setMbSalario(JMenu mbSalario) {
        this.mbSalario = mbSalario;
    }

    public JLabel getTxtNumFuncionarios() {
        return txtNumFuncionarios;
    }

    public void setTxtNumFuncionarios(JLabel txtNumFuncionarios) {
        this.txtNumFuncionarios = txtNumFuncionarios;
    }

    public JLabel getTxtTxt() {
        return txtTxt;
    }

    public void setTxtTxt(JLabel txtTxt) {
        this.txtTxt = txtTxt;
    }

    public JLabel getTxtVersao() {
        return txtVersao;
    }

    public void setTxtVersao(JLabel txtVersao) {
        this.txtVersao = txtVersao;
    }

    public JMenuItem getmOpSair() {
        return mOpSair;
    }

    public void setmOpSair(JMenuItem mOpSair) {
        this.mOpSair = mOpSair;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNumFuncionarios = new javax.swing.JLabel();
        txtTxt = new javax.swing.JLabel();
        txtXML = new javax.swing.JLabel();
        txtVersao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbFuncionario = new javax.swing.JMenu();
        mOpCadastrar = new javax.swing.JMenuItem();
        mOpBuscar = new javax.swing.JMenuItem();
        mbSalario = new javax.swing.JMenu();
        mOpCalcularSalario = new javax.swing.JMenuItem();
        mbFerramentas = new javax.swing.JMenu();
        mOpTrocarMecanismoLog = new javax.swing.JMenuItem();
        mOpSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtNumFuncionarios.setText("0");

        txtTxt.setText("TXT");

        txtXML.setText("XML");

        txtVersao.setText("v 1.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtVersao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(txtXML)
                .addGap(30, 30, 30)
                .addComponent(txtTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(txtNumFuncionarios)
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtNumFuncionarios, txtTxt, txtVersao, txtXML});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumFuncionarios)
                    .addComponent(txtTxt)
                    .addComponent(txtXML)
                    .addComponent(txtVersao))
                .addGap(15, 15, 15))
        );

        mbFuncionario.setText("Funcionario");

        mOpCadastrar.setText("Cadastrar");
        mOpCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mOpCadastrarActionPerformed(evt);
            }
        });
        mbFuncionario.add(mOpCadastrar);

        mOpBuscar.setText("Buscar");
        mbFuncionario.add(mOpBuscar);

        jMenuBar1.add(mbFuncionario);

        mbSalario.setText("Salário");

        mOpCalcularSalario.setText("Calcular Salário");
        mbSalario.add(mOpCalcularSalario);

        jMenuBar1.add(mbSalario);

        mbFerramentas.setText("Ferramentas");

        mOpTrocarMecanismoLog.setText("Trocar mecanismos de logs");
        mbFerramentas.add(mOpTrocarMecanismoLog);

        mOpSair.setText("Sair");
        mbFerramentas.add(mOpSair);

        jMenuBar1.add(mbFerramentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 230, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mOpCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mOpCadastrarActionPerformed

    }//GEN-LAST:event_mOpCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mOpBuscar;
    private javax.swing.JMenuItem mOpCadastrar;
    private javax.swing.JMenuItem mOpCalcularSalario;
    private javax.swing.JMenuItem mOpSair;
    private javax.swing.JMenuItem mOpTrocarMecanismoLog;
    private javax.swing.JMenu mbFerramentas;
    private javax.swing.JMenu mbFuncionario;
    private javax.swing.JMenu mbSalario;
    private javax.swing.JLabel txtNumFuncionarios;
    private javax.swing.JLabel txtTxt;
    private javax.swing.JLabel txtVersao;
    private javax.swing.JLabel txtXML;
    // End of variables declaration//GEN-END:variables
}
