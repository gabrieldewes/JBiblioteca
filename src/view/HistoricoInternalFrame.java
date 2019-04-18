/*
 * The MIT License
 *
 * Copyright 2019 gabri.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package view;

import control.EmprestimoController;
import control.ExemplarController;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Exemplar;

/**
 *
 * @author gabri
 */
public class HistoricoInternalFrame extends javax.swing.JInternalFrame {
    
    private final EmprestimoController emprestimoController;
    private final ExemplarController exemplarController;

    /**
     * Creates new form HistoricoInternalFrame
     */
    public HistoricoInternalFrame() {
        initComponents();
        emprestimoController = EmprestimoController.getInstance();
        exemplarController = ExemplarController.getInstance();
        historicoTable.setAutoCreateRowSorter(true);
        livroList.setModel(new DefaultListModel());
        updateHistoricoTable("");
    }
    
    final void updateHistoricoTable(String buscar) {
        if (!"".equals(buscar)) {
            historicoTable.setModel(emprestimoController.ListarHistorico(buscar));
        }
        else {
            historicoTable.setModel(emprestimoController.ListarHistorico(""));
        }
        historicoTable.getColumnModel().getColumn(0).setMinWidth(0);
        historicoTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        historicoTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historicoTable = new javax.swing.JTable();
        buscaHistoricoField = new javax.swing.JTextField();
        buscaHistoricoBtn = new javax.swing.JButton();
        apagarHistoricoBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        livroList = new javax.swing.JList<>();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Histórico de empréstimos");

        historicoTable.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        historicoTable.setModel(new javax.swing.table.DefaultTableModel(
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
        historicoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        historicoTable.getTableHeader().setReorderingAllowed(false);
        historicoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historicoTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(historicoTable);

        buscaHistoricoField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscaHistoricoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaHistoricoFieldKeyReleased(evt);
            }
        });

        buscaHistoricoBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscaHistoricoBtn.setText("Buscar");
        buscaHistoricoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaHistoricoBtnActionPerformed(evt);
            }
        });

        apagarHistoricoBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        apagarHistoricoBtn.setText("Apagar");
        apagarHistoricoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarHistoricoBtnActionPerformed(evt);
            }
        });

        livroList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        livroList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(livroList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(apagarHistoricoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buscaHistoricoField, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscaHistoricoBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaHistoricoField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscaHistoricoBtn))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(apagarHistoricoBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
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

    private void historicoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historicoTableMouseClicked
        int idx[] = historicoTable.getSelectedRows();
        if (idx.length > 0) {
            apagarHistoricoBtn.setEnabled(true); 
            int id_emprestimo = Integer.valueOf(historicoTable.getValueAt(historicoTable.getSelectedRow(), 0).toString());
            ArrayList<Exemplar> exemplares = exemplarController.ArrayExemplar("el.id_emprestimo", id_emprestimo, null);
            DefaultListModel model = new DefaultListModel();
            exemplares.stream().forEach((e) -> {
                model.addElement(e.getCodigo() +" - "+ e.getL().getTitulo());
            });            
            livroList.setModel(model);
        }
        else { 
            apagarHistoricoBtn.setEnabled(false); 
        }
    }//GEN-LAST:event_historicoTableMouseClicked

    private void buscaHistoricoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaHistoricoFieldKeyReleased
        /*String search = buscaEmprestimoField.getText();
        if (search.length() > 3) {
            updateEmprestimoTable(search);
        }
        else updateEmprestimoTable("");*/
    }//GEN-LAST:event_buscaHistoricoFieldKeyReleased

    private void buscaHistoricoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaHistoricoBtnActionPerformed
        String search = buscaHistoricoField.getText();
        if (!"".equals(search)) {
            updateHistoricoTable(search);
        }
        else updateHistoricoTable("");
    }//GEN-LAST:event_buscaHistoricoBtnActionPerformed

    private void apagarHistoricoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarHistoricoBtnActionPerformed
        int idx[] = historicoTable.getSelectedRows();
        if (idx.length > 0) {
            
            JLabel nome = new JLabel();
            nome.setFont(new Font("Dialog", Font.BOLD, 14));
            Object[] message = {
                "Tem certeza que deseja excluir o empréstimo histórico?", nome
            };
            nome.setText( historicoTable.getValueAt(historicoTable.getSelectedRow(), 2).toString() );

            int response = JOptionPane.showConfirmDialog(null, message, "Apagar empréstimo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id_emprestimo = Integer.valueOf(historicoTable.getValueAt(historicoTable.getSelectedRow(), 0).toString());
                if (id_emprestimo != 0) {
                    if (emprestimoController.Apagar(id_emprestimo)) {
                        updateHistoricoTable("");
                        JOptionPane.showMessageDialog(null, "Empréstimo historico excluído.");
                        livroList.setModel(new DefaultListModel());
                    }
                }
            }
        }
    }//GEN-LAST:event_apagarHistoricoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apagarHistoricoBtn;
    private javax.swing.JButton buscaHistoricoBtn;
    private javax.swing.JTextField buscaHistoricoField;
    private javax.swing.JTable historicoTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> livroList;
    // End of variables declaration//GEN-END:variables
}