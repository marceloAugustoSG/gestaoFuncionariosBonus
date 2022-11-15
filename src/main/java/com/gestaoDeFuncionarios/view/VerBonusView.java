package com.gestaoDeFuncionarios.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VerBonusView extends javax.swing.JFrame {
    
    public VerBonusView() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(this.getParent());
    }
    
    public JButton getBtnFechar() {
        return btnFechar;
    }
    
    public void setBtnFechar(JButton btnFechar) {
        this.btnFechar = btnFechar;
    }
    
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }
    
    public JTable getTblVerBonusFuncionario() {
        return tblVerBonusFuncionario;
    }
    
    public void setTblVerBonusFuncionario(JTable tblVerBonusFuncionario) {
        this.tblVerBonusFuncionario = tblVerBonusFuncionario;
    }
    
    public JLabel getTxtNomeFuncionario() {
        return txtNomeFuncionario;
    }
    
    public void setTxtNomeFuncionario(JLabel txtNomeFuncionario) {
        this.txtNomeFuncionario = txtNomeFuncionario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNomeFuncionario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVerBonusFuncionario = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ver Bônus");

        txtNomeFuncionario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomeFuncionario.setText("Nome do Funcionário");

        tblVerBonusFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVerBonusFuncionario);

        btnFechar.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNomeFuncionario)
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFechar)
                .addContainerGap(500, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtNomeFuncionario)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnFechar)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVerBonusFuncionario;
    private javax.swing.JLabel txtNomeFuncionario;
    // End of variables declaration//GEN-END:variables
}
