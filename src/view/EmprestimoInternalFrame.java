/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.EmprestimoController;
import control.ExemplarController;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Exemplar;
import static view.MainFrame.eaif;
import static view.MainFrame.lif;

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
        livroList.setModel(new DefaultListModel());
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
        buscaEmprestimoField = new javax.swing.JTextField();
        buscaEmprestinoBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        livroList = new javax.swing.JList<>();

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

        buscaEmprestinoBtn.setText("Buscar");

        livroList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(livroList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(novoEmprestimoBtn)
                        .addGap(64, 64, 64)
                        .addComponent(buscaEmprestimoField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaEmprestinoBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(DelEmprestimoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))))
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
                        .addComponent(DelEmprestimoBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emprestimoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emprestimoTableMouseClicked
        int idx[] = emprestimoTable.getSelectedRows();
        if (idx.length > 0) {
            DelEmprestimoBtn.setEnabled(true); 
            //DetalheBtn.setEnabled(true); 
            int id_emprestimo = Integer.valueOf(emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 0).toString());
            ArrayList<Exemplar> exemplares = ExemplarController.ArrayExemplar("el.id_emprestimo", id_emprestimo, null);
            DefaultListModel model = new DefaultListModel();
            for (Exemplar e:exemplares) {
                model.addElement(e.getCodigo() +" - "+ e.getL().getTitulo());
            }            
            livroList.setModel(model);
        }
        else { 
            DelEmprestimoBtn.setEnabled(false); 
            //DetalheBtn.setEnabled(false); 
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
                        if (lif != null)
                            lif.updateExemplarTableModel("");
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
            try {
                eaif.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(EmprestimoInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_novoEmprestimoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelEmprestimoBtn;
    private javax.swing.JTextField buscaEmprestimoField;
    private javax.swing.JButton buscaEmprestinoBtn;
    private javax.swing.JTable emprestimoTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> livroList;
    private javax.swing.JButton novoEmprestimoBtn;
    // End of variables declaration//GEN-END:variables
}
