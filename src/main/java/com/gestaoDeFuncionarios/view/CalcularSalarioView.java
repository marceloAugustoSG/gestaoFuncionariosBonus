package com.gestaoDeFuncionarios.view;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

public class CalcularSalarioView extends javax.swing.JFrame {
    
    public CalcularSalarioView() {
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
    
    public JButton getBtnCalcular() {
        return btnCalcular;
    }
    
    public void setBtnCalcular(JButton btnCalcular) {
        this.btnCalcular = btnCalcular;
    }
    
    public JButton getBtnFechar() {
        return btnFechar;
    }
    
    public void setBtnFechar(JButton btnFechar) {
        this.btnFechar = btnFechar;
    }
    
    public JButton getBtnListarTodos() {
        return btnListarTodos;
    }
    
    public void setBtnListarTodos(JButton btnListarTodos) {
        this.btnListarTodos = btnListarTodos;
    }
    
    public JTable getTblCalcularSalarioFuncionario() {
        return tblCalcularSalarioFuncionario;
    }
    
    public void setTblCalcularSalarioFuncionario(JTable tblCalcularSalarioFuncionario) {
        this.tblCalcularSalarioFuncionario = tblCalcularSalarioFuncionario;
    }
    
    public JFormattedTextField getTxtDataBusca() {
        return txtDataBusca;
    }
    
    public void setTxtDataBusca(JFormattedTextField txtDataBusca) {
        this.txtDataBusca = txtDataBusca;
    }
    
    public JFormattedTextField getTxtDataCalculo() {
        return txtDataCalculo;
    }
    
    public void setTxtDataCalculo(JFormattedTextField txtDataCalculo) {
        this.txtDataCalculo = txtDataCalculo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDataBusca = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalcularSalarioFuncionario = new javax.swing.JTable();
        btnCalcular = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDataCalculo = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cálculo de Salários");

        try {
            txtDataBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnBuscar.setText("Buscar");

        btnListarTodos.setText("Listar Todos");

        tblCalcularSalarioFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionário", "Data", "Salário Base(R$)", "Bônus", "Salário"
            }
        ));
        jScrollPane1.setViewportView(tblCalcularSalarioFuncionario);

        btnCalcular.setText("Calcular");

        btnFechar.setText("Fechar");

        jLabel1.setText("Data do Cálculo");

        try {
            txtDataCalculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtDataBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListarTodos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(txtDataCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnCalcular)))
                .addGap(15, 15, 15))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscar, btnListarTodos});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCalcular, btnFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnListarTodos))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFechar)
                    .addComponent(jLabel1)
                    .addComponent(txtDataCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCalcularSalarioFuncionario;
    private javax.swing.JFormattedTextField txtDataBusca;
    private javax.swing.JFormattedTextField txtDataCalculo;
    // End of variables declaration//GEN-END:variables
}
