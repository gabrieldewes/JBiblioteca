/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.PessoaController;
import javax.swing.JOptionPane;

/**
 *
 * @author Dewes
 */
public final class PessoasInternalFrame extends javax.swing.JInternalFrame {

    static PessoasAddInternalFrame paif;
    static PessoasAttInternalFrame patif;
    static MainFrame mfthis;
    
    public PessoasInternalFrame( MainFrame mf ) {
        initComponents();
        updateTableModel("");
        mfthis = mf;
    }
    
    void updateTableModel(String buscar) {
        if (!"".equals(buscar)) {
            PessoaTable.setModel(PessoaController.Buscar(buscar));
        }
        else {
            PessoaTable.setModel(PessoaController.Listar());
        }
        PessoaTable.getColumnModel().getColumn(0).setMinWidth(0);
        PessoaTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        PessoaTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PessoaTable = new javax.swing.JTable();
        BuscaPessoaField = new javax.swing.JTextField();
        BuscaPessoaBtn = new javax.swing.JButton();
        AddPessoaBtn = new javax.swing.JButton();
        AttPessoaBtn = new javax.swing.JButton();
        DelPessoaBtn = new javax.swing.JButton();
        EmpPessoaBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pessoas");
        setInheritsPopupMenu(true);

        PessoaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        PessoaTable.getTableHeader().setReorderingAllowed(false);
        PessoaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PessoaTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PessoaTable);

        BuscaPessoaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscaPessoaFieldKeyReleased(evt);
            }
        });

        BuscaPessoaBtn.setText("Buscar");
        BuscaPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaPessoaBtnActionPerformed(evt);
            }
        });

        AddPessoaBtn.setText("Adicionar");
        AddPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPessoaBtnActionPerformed(evt);
            }
        });

        AttPessoaBtn.setText("Alterar");
        AttPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttPessoaBtnActionPerformed(evt);
            }
        });

        DelPessoaBtn.setText("Excluir");
        DelPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelPessoaBtnActionPerformed(evt);
            }
        });

        EmpPessoaBtn.setText("Empréstimo");
        EmpPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpPessoaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(EmpPessoaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AttPessoaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelPessoaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddPessoaBtn))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(BuscaPessoaField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscaPessoaBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscaPessoaField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddPessoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscaPessoaBtn))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(AttPessoaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelPessoaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmpPessoaBtn)
                        .addContainerGap(198, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPessoaBtnActionPerformed
        if (paif == null || paif.isClosed()) {
            paif = new PessoasAddInternalFrame();
            paif.setVisible(true);
            mfthis.desktop.add(paif);
        }
        
    }//GEN-LAST:event_AddPessoaBtnActionPerformed

    private void DelPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelPessoaBtnActionPerformed
        int idx[] = PessoaTable.getSelectedRows();
        if (idx.length > 0) {
            int response = JOptionPane.showConfirmDialog(null, "Apagar "+ PessoaTable.getValueAt(PessoaTable.getSelectedRow(), 2) +"?", "Atenção",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.valueOf( PessoaTable.getValueAt( PessoaTable.getSelectedRow() , 0 ).toString() );
                System.out.println("Botão mandou ID "+ id);
                if (PessoaController.Apagar(id)) {
                    updateTableModel("");
                }
            } 
        }
        else { DelPessoaBtn.setEnabled(false); }
    }//GEN-LAST:event_DelPessoaBtnActionPerformed

    private void PessoaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PessoaTableMouseClicked
        AttPessoaBtn.setEnabled(true);
        DelPessoaBtn.setEnabled(true);
    }//GEN-LAST:event_PessoaTableMouseClicked

    private void AttPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttPessoaBtnActionPerformed
        
        int idx[] = PessoaTable.getSelectedRows();
        if (idx.length > 0) {
            patif = new PessoasAttInternalFrame( Integer.parseInt( PessoaTable.getValueAt( PessoaTable.getSelectedRow() , 0).toString() ) );
            patif.setVisible(true);
            mfthis.desktop.add(patif);
        }
        else { AttPessoaBtn.setEnabled(false); }
    }//GEN-LAST:event_AttPessoaBtnActionPerformed

    private void BuscaPessoaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaPessoaFieldKeyReleased
        String search = BuscaPessoaField.getText();
        if (search.length() > 2) {
            updateTableModel(search);
        }
        else updateTableModel("");
    }//GEN-LAST:event_BuscaPessoaFieldKeyReleased

    private void BuscaPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaPessoaBtnActionPerformed
        String search = BuscaPessoaField.getText();
        if (!"".equals(search)) {
            updateTableModel(search);
        }
        else updateTableModel("");
    }//GEN-LAST:event_BuscaPessoaBtnActionPerformed

    private void EmpPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpPessoaBtnActionPerformed
        int idx[] = PessoaTable.getSelectedRows();
        if (idx.length > 0) {
            
        }
        else { EmpPessoaBtn.setEnabled(false); }
    }//GEN-LAST:event_EmpPessoaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPessoaBtn;
    private javax.swing.JButton AttPessoaBtn;
    private javax.swing.JButton BuscaPessoaBtn;
    private javax.swing.JTextField BuscaPessoaField;
    private javax.swing.JButton DelPessoaBtn;
    private javax.swing.JButton EmpPessoaBtn;
    private javax.swing.JTable PessoaTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
