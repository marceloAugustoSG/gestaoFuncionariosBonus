package com.gestaoDeFuncionarios.view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BuscarFuncionarioView extends javax.swing.JFrame {
    
    public BuscarFuncionarioView() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(this.getParent());
    }
    
    public JButton getBtnBuscar() {
        return btnBuscar;
    }
    
    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }
    
    public JButton getBtnFechar() {
        return btnFechar;
    }
    
    public void setBtnFechar(JButton btnFechar) {
        this.btnFechar = btnFechar;
    }
    
    public JButton getBtnNovo() {
        return btnNovo;
    }
    
    public void setBtnNovo(JButton btnNovo) {
        this.btnNovo = btnNovo;
    }
    
    public JButton getBtnVerBonus() {
        return btnVerBonus;
    }
    
    public void setBtnVerBonus(JButton btnVerBonus) {
        this.btnVerBonus = btnVerBonus;
    }
    
    public JButton getBtnVisualizar() {
        return btnVisualizar;
    }
    
    public void setBtnVisualizar(JButton btnVisualizar) {
        this.btnVisualizar = btnVisualizar;
    }
    
    public JTable getTblBuscarFuncionarios() {
        return tblBuscarFuncionarios;
    }
    
    public void setTblBuscarFuncionarios(JTable tblBuscarFuncionarios) {
        this.tblBuscarFuncionarios = tblBuscarFuncionarios;
    }
    
    public JTextField getTxtBuscarFuncionario() {
        return txtBuscarFuncionario;
    }
    
    public void setTxtBuscarFuncionario(JTextField txtBuscarFuncionario) {
        this.txtBuscarFuncionario = txtBuscarFuncionario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarFuncionario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarFuncionarios = new javax.swing.JTable();
        btnVisualizar = new javax.swing.JButton();
        btnVerBonus = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Buscar Funcionário");

        jLabel1.setText("Nome");

        btnBuscar.setText("Buscar");

        tblBuscarFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBuscarFuncionarios.setEditingColumn(0);
        tblBuscarFuncionarios.setEditingRow(0);
        jScrollPane1.setViewportView(tblBuscarFuncionarios);

        btnVisualizar.setText("Visualizar");

        btnVerBonus.setText("Ver bônus");

        btnNovo.setText("Novo");

        btnFechar.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(txtBuscarFuncionario)
                .addGap(15, 15, 15)
                .addComponent(btnBuscar)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(btnNovo)
                .addGap(15, 15, 15)
                .addComponent(btnVerBonus)
                .addGap(15, 15, 15)
                .addComponent(btnVisualizar)
                .addGap(15, 15, 15))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFechar, btnNovo, btnVerBonus, btnVisualizar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFechar)
                    .addComponent(btnNovo)
                    .addComponent(btnVerBonus)
                    .addComponent(btnVisualizar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVerBonus;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBuscarFuncionarios;
    private javax.swing.JTextField txtBuscarFuncionario;
    // End of variables declaration//GEN-END:variables
}
