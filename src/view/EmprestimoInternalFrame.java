/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.EmprestimoController;
import javax.swing.JOptionPane;
import static view.MainFrame.eaif;
import static view.MainFrame.eif;

/**
 *
 * @author gabriel
 */
public class EmprestimoInternalFrame extends javax.swing.JInternalFrame {

    static MainFrame mfthis;
    
    public EmprestimoInternalFrame( MainFrame mf ) {
        initComponents();
        mfthis=mf;
        updateEmprestimoTable("");
    }

    void updateEmprestimoTable(String buscar) {
        if (!"".equals(buscar)) {
            emprestimoTable.setModel(EmprestimoController.Listar(buscar));
        }
        else {
            emprestimoTable.setModel(EmprestimoController.Listar(""));
        }
        emprestimoTable.getColumnModel().getColumn(0).setMinWidth(0);
        emprestimoTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        emprestimoTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emprestimoTable = new javax.swing.JTable();
        novoEmprestimoBtn = new javax.swing.JButton();
        DelEmprestimoBtn = new javax.swing.JButton();
        DetalheBtn = new javax.swing.JButton();
        buscaEmprestimoField = new javax.swing.JTextField();
        buscaEmprestinoBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empréstimos");

        emprestimoTable.setModel(new javax.swing.table.DefaultTableModel(
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
        emprestimoTable.getTableHeader().setReorderingAllowed(false);
        emprestimoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emprestimoTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(emprestimoTable);

        novoEmprestimoBtn.setText("Novo Empréstimo");
        novoEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoEmprestimoBtnActionPerformed(evt);
            }
        });

        DelEmprestimoBtn.setText("Devolução");
        DelEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelEmprestimoBtnActionPerformed(evt);
            }
        });

        DetalheBtn.setText("Detalhes");

        buscaEmprestinoBtn.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(novoEmprestimoBtn)
                .addGap(64, 64, 64)
                .addComponent(buscaEmprestimoField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscaEmprestinoBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DelEmprestimoBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DetalheBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(novoEmprestimoBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscaEmprestimoField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscaEmprestinoBtn)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(DelEmprestimoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DetalheBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emprestimoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emprestimoTableMouseClicked
        int idx[] = emprestimoTable.getSelectedRows();
        if (idx.length > 0) {
            DelEmprestimoBtn.setEnabled(true); 
            DetalheBtn.setEnabled(true); 
        }
        else { 
            DelEmprestimoBtn.setEnabled(false); 
            DetalheBtn.setEnabled(false); 
        }
    }//GEN-LAST:event_emprestimoTableMouseClicked

    private void DelEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelEmprestimoBtnActionPerformed
        int idx[] = emprestimoTable.getSelectedRows();
        if (idx.length > 0) {
            int response = JOptionPane.showConfirmDialog(null, "Devolução de "+ emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 1) +". Continuar? ", "Atenção",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id_emprestimo = Integer.valueOf(emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 0).toString());
                if (id_emprestimo != 0) {
                    if (EmprestimoController.Apagar(id_emprestimo)) {
                        updateEmprestimoTable("");
                    }
                }
            } 
        }
        else { 
            DelEmprestimoBtn.setEnabled(false);  
        }
    }//GEN-LAST:event_DelEmprestimoBtnActionPerformed

    private void novoEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEmprestimoBtnActionPerformed
        if (eaif == null || eaif.isClosed()) {
            eaif = new EmprestimoAddInternalFrame();
            eaif.setVisible(true);
            mfthis.desktop.add(eaif);
        }
    }//GEN-LAST:event_novoEmprestimoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelEmprestimoBtn;
    private javax.swing.JButton DetalheBtn;
    private javax.swing.JTextField buscaEmprestimoField;
    private javax.swing.JButton buscaEmprestinoBtn;
    private javax.swing.JTable emprestimoTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton novoEmprestimoBtn;
    // End of variables declaration//GEN-END:variables
}
