/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.PessoaController;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static view.MainFrame.talif;
import static view.MainFrame.tif;


/**
 *
 * @author Dewes
 */
public final class PessoasInternalFrame extends javax.swing.JInternalFrame {
    
    private final PessoaController pessoaController;

    static PessoasAddInternalFrame paif;
    static PessoasAttInternalFrame patif;
    static TurmasAttLoteInternalFrame atif;
    static MainFrame mfthis;
    
    public PessoasInternalFrame( MainFrame mf ) {
        initComponents();
        
        pessoaController = PessoaController.getInstance();
        
        PessoaTable.setAutoCreateRowSorter(true);
        updateTableModel("");
        mfthis = mf;
    }
    
    void updateTableModel(String buscar) {
        if (!"".equals(buscar)) {
            PessoaTable.setModel(pessoaController.Buscar(buscar));
        }
        else {
            PessoaTable.setModel(pessoaController.Listar());
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
        turmasBtn = new javax.swing.JButton();
        btnAlterarTurmas = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pessoas");
        setInheritsPopupMenu(true);

        PessoaTable.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
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

        BuscaPessoaField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BuscaPessoaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscaPessoaFieldKeyReleased(evt);
            }
        });

        BuscaPessoaBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BuscaPessoaBtn.setText("Buscar");
        BuscaPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaPessoaBtnActionPerformed(evt);
            }
        });

        AddPessoaBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AddPessoaBtn.setText("Adicionar Nova");
        AddPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPessoaBtnActionPerformed(evt);
            }
        });

        AttPessoaBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AttPessoaBtn.setText("Alterar");
        AttPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttPessoaBtnActionPerformed(evt);
            }
        });

        DelPessoaBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DelPessoaBtn.setText("Excluir");
        DelPessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelPessoaBtnActionPerformed(evt);
            }
        });

        turmasBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        turmasBtn.setText("Ver Turmas");
        turmasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmasBtnActionPerformed(evt);
            }
        });

        btnAlterarTurmas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAlterarTurmas.setText("Alterar Turmas");
        btnAlterarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTurmasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(AttPessoaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DelPessoaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(turmasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterarTurmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddPessoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(BuscaPessoaField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscaPessoaBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddPessoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscaPessoaBtn)
                    .addComponent(BuscaPessoaField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(AttPessoaBtn)
                        .addGap(12, 12, 12)
                        .addComponent(DelPessoaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(turmasBtn)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarTurmas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        try {
            paif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PessoasInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_AddPessoaBtnActionPerformed

    private void DelPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelPessoaBtnActionPerformed
        int idx[] = PessoaTable.getSelectedRows();
        if (idx.length > 0) {
            JLabel nome = new JLabel();
            nome.setFont(new Font("Dialog", Font.BOLD, 14));
            JLabel codigo = new JLabel();
            codigo.setFont(new Font("Dialog", Font.BOLD, 14));
            Object[] message = {
                "Nome:", nome,
                "Código: ", codigo,
                "Tem certeza que deseja excluir?"
            };
            nome.setText( PessoaTable.getValueAt(PessoaTable.getSelectedRow(), 2).toString() );
            codigo.setText( PessoaTable.getValueAt(PessoaTable.getSelectedRow(), 1).toString() );
            int response = JOptionPane.showConfirmDialog(null, message, "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.valueOf( PessoaTable.getValueAt( PessoaTable.getSelectedRow() , 0 ).toString() );
                System.out.println("Botão mandou ID "+ id);
                if (pessoaController.Apagar(id)) {
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
            if (patif == null || patif.isClosed()) {
                patif = new PessoasAttInternalFrame( Integer.parseInt( PessoaTable.getValueAt( PessoaTable.getSelectedRow() , 0).toString() ) );
                patif.setVisible(true);
                mfthis.desktop.add(patif);
            }
            try {
                patif.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(PessoasInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else { AttPessoaBtn.setEnabled(false); }
    }//GEN-LAST:event_AttPessoaBtnActionPerformed

    private void BuscaPessoaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaPessoaFieldKeyReleased
        /*String search = BuscaPessoaField.getText();
        if (search.length() > 3) {
            updateTableModel(search);
        }
        else updateTableModel("");*/
    }//GEN-LAST:event_BuscaPessoaFieldKeyReleased

    private void BuscaPessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaPessoaBtnActionPerformed
        String search = BuscaPessoaField.getText();
        if (!"".equals(search)) {
            updateTableModel(search);
        }
        else updateTableModel("");
    }//GEN-LAST:event_BuscaPessoaBtnActionPerformed

    private void turmasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmasBtnActionPerformed
        if (tif == null || tif.isClosed()) {
            tif = new TurmasInternalFrame();
            tif.setVisible(true);
            mfthis.desktop.add(tif);
        }
        else 
            try {
                if (tif.isIcon())
                    tif.setIcon(false);
            } 
            catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            tif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_turmasBtnActionPerformed

    private void btnAlterarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTurmasActionPerformed
        if (talif == null || talif.isClosed()) {
            talif = new TurmasAttLoteInternalFrame();
            talif.setVisible(true);
            mfthis.desktop.add(talif);
        }
        try {
            talif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TurmasAttLoteInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarTurmasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPessoaBtn;
    private javax.swing.JButton AttPessoaBtn;
    private javax.swing.JButton BuscaPessoaBtn;
    private javax.swing.JTextField BuscaPessoaField;
    private javax.swing.JButton DelPessoaBtn;
    private javax.swing.JTable PessoaTable;
    private javax.swing.JButton btnAlterarTurmas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton turmasBtn;
    // End of variables declaration//GEN-END:variables
}
