/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.view;

import com.jbiblioteca.controller.ConfigController;
import com.jbiblioteca.controller.EmprestimoController;
import com.jbiblioteca.controller.ExemplarController;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.jbiblioteca.model.Emprestimo;
import com.jbiblioteca.model.Exemplar;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import static com.jbiblioteca.view.MainFrame.eaif;
import static com.jbiblioteca.view.MainFrame.lif;

/**
 *
 * @author gabriel
 */
public class EmprestimoInternalFrame extends javax.swing.JInternalFrame {
    
    private final EmprestimoController emprestimoController;
    private final ConfigController configController;
    private final ExemplarController exemplarController;

    static MainFrame mfthis;
    static double juros_dia;
    static int prazo_default;
    
    public EmprestimoInternalFrame( MainFrame mf ) {
        initComponents();
        
        emprestimoController = EmprestimoController.getInstance();
        configController = ConfigController.getInstance();
        exemplarController = ExemplarController.getInstance();
        
        emprestimoTable.setAutoCreateRowSorter(true);
        mfthis=mf;
        updateEmprestimoTable("");
        livroList.setModel(new DefaultListModel());
        
        prazo_default = configController.getPrazoDefault();
        juros_dia = configController.getAppConfigTaxaJuros();
    }

    final void updateEmprestimoTable(String buscar) {
        if (!"".equals(buscar)) {
            emprestimoTable.setModel(emprestimoController.Listar(buscar));
        }
        else {
            emprestimoTable.setModel(emprestimoController.Listar(""));
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
        DevolveEmprestimoBtn = new javax.swing.JButton();
        buscaEmprestimoField = new javax.swing.JTextField();
        buscaEmprestinoBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        livroList = new javax.swing.JList<>();
        RenovaEmprestimoBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empréstimos");

        emprestimoTable.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
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
        emprestimoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        emprestimoTable.getTableHeader().setReorderingAllowed(false);
        emprestimoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emprestimoTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(emprestimoTable);

        novoEmprestimoBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        novoEmprestimoBtn.setText("Novo Empréstimo");
        novoEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoEmprestimoBtnActionPerformed(evt);
            }
        });

        DevolveEmprestimoBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DevolveEmprestimoBtn.setText("Devolução");
        DevolveEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevolveEmprestimoBtnActionPerformed(evt);
            }
        });

        buscaEmprestimoField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscaEmprestimoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaEmprestimoFieldKeyReleased(evt);
            }
        });

        buscaEmprestinoBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscaEmprestinoBtn.setText("Buscar");
        buscaEmprestinoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaEmprestinoBtnActionPerformed(evt);
            }
        });

        livroList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );

        RenovaEmprestimoBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        RenovaEmprestimoBtn.setText("Renovar");
        RenovaEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenovaEmprestimoBtnActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DevolveEmprestimoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RenovaEmprestimoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(DevolveEmprestimoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RenovaEmprestimoBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
            DevolveEmprestimoBtn.setEnabled(true); 
            RenovaEmprestimoBtn.setEnabled(true); 
            int id_emprestimo = Integer.valueOf(emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 0).toString());
            ArrayList<Exemplar> exemplares = exemplarController.ArrayExemplar("el.id_emprestimo", id_emprestimo, null);
            DefaultListModel model = new DefaultListModel();
            exemplares.stream().forEach((e) -> {
                model.addElement(e.getCodigo() +" - "+ e.getL().getTitulo());
            });            
            livroList.setModel(model);
        }
        else { 
            DevolveEmprestimoBtn.setEnabled(false); 
            RenovaEmprestimoBtn.setEnabled(false); 
        }
    }//GEN-LAST:event_emprestimoTableMouseClicked

    private void DevolveEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolveEmprestimoBtnActionPerformed
        int idx[] = emprestimoTable.getSelectedRows();
        if (idx.length > 0) {
                        
            int id_emprestimo = Integer.valueOf(emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 0).toString());
            
            if (id_emprestimo != 0) {
                Emprestimo e = emprestimoController.Pegar(id_emprestimo);
                LocalDateTime hoje = LocalDateTime.now();
                LocalDateTime fim = new LocalDateTime( e.getData_fim());
                int dias = Days.daysBetween(hoje, fim).getDays();
                dias = dias * -1;
                double total = 0.0;
                int response;
                System.out.println("DIAS "+ dias);
                if (dias > 0) {
                    for (int i=0; i<dias; i++) {
                        total += juros_dia;
                    }
                }
                
                JLabel nome = new JLabel();
                nome.setFont(new Font("Dialog", Font.BOLD, 14));
                JLabel juros = new JLabel();
                juros.setFont(new Font("Dialog", Font.BOLD, 14));
                JLabel total_ex = new JLabel();
                total_ex.setFont(new Font("Dialog", Font.BOLD, 14));
                Object[] message = {
                    "Locatário:", nome,
                    "Total de Exemplares: ", total_ex,
                    "Total de Juros:", juros,
                    "Prosseguir com devolução?"
                };
                nome.setText( emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 1).toString() );
                juros.setText(""+ NumberFormat.getCurrencyInstance().format(total) );
                total_ex.setText(""+e.getId_exemplar().size());
                
                response = JOptionPane.showConfirmDialog(null, message, "Devolução", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) { 
                    if (emprestimoController.Apagar(id_emprestimo)) {
                        updateEmprestimoTable("");
                        if (lif != null)
                            lif.updateExemplarTableModel("");
                        
                        livroList.setModel(new DefaultListModel());
                    }                              
                } 
            }
        }
        else { 
            DevolveEmprestimoBtn.setEnabled(false);  
        }
    }//GEN-LAST:event_DevolveEmprestimoBtnActionPerformed

    private void novoEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEmprestimoBtnActionPerformed
        if (eaif == null || eaif.isClosed()) {
            eaif = new EmprestimoAddInternalFrame();
            eaif.setVisible(true);
            mfthis.desktop.add(eaif);
        }
        try {
            eaif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(EmprestimoInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_novoEmprestimoBtnActionPerformed

    private void buscaEmprestinoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaEmprestinoBtnActionPerformed
        String search = buscaEmprestimoField.getText();
        if (!"".equals(search)) {
            updateEmprestimoTable(search);
        }
        else updateEmprestimoTable("");
    }//GEN-LAST:event_buscaEmprestinoBtnActionPerformed

    private void buscaEmprestimoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaEmprestimoFieldKeyReleased
        /*String search = buscaEmprestimoField.getText();
        if (search.length() > 3) {
            updateEmprestimoTable(search);
        }
        else updateEmprestimoTable("");*/
    }//GEN-LAST:event_buscaEmprestimoFieldKeyReleased

    private void RenovaEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenovaEmprestimoBtnActionPerformed
        int idx[] = emprestimoTable.getSelectedRows();
        if (idx.length > 0) {
            int id_emprestimo = Integer.valueOf(emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 0).toString());
            if (id_emprestimo != 0) {
                Emprestimo e = emprestimoController.Pegar(id_emprestimo);
                LocalDateTime hoje = LocalDateTime.now();
                LocalDateTime fim = new LocalDateTime( e.getData_fim());
                int dias = Days.daysBetween(hoje, fim).getDays();  
                dias = dias * -1;
                double total = 0.0;
                int response;
                if (dias > 0) {
                    for (int i=0; i<dias; i++) {
                        total += juros_dia;
                    }
                }
                JLabel nome = new JLabel();
                nome.setFont(new Font("Dialog", Font.BOLD, 14));
                JLabel juros = new JLabel();
                juros.setFont(new Font("Dialog", Font.BOLD, 14));
                JLabel total_ex = new JLabel();
                total_ex.setFont(new Font("Dialog", Font.BOLD, 14));
                JSpinner diaSpinner = new JSpinner(new SpinnerNumberModel() );
                diaSpinner.setFont(new Font("Dialog", Font.BOLD, 18));
                diaSpinner.setValue(prazo_default);
                Object[] message = {
                    "Locatário:", nome,
                    "Total de Exemplares: ", total_ex,
                    "Total de Juros:", juros,
                    "Dias p/ Devolução:", diaSpinner,
                    "Prosseguir com renovação?"
                };
                nome.setText( emprestimoTable.getValueAt(emprestimoTable.getSelectedRow(), 1).toString() );
                juros.setText(""+ NumberFormat.getCurrencyInstance().format(total) );
                total_ex.setText(""+e.getId_exemplar().size());
                
                response = JOptionPane.showConfirmDialog(null, message, "Renovação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) { 
                    int plus_days = Integer.valueOf( diaSpinner.getValue().toString() );
                    if (plus_days < 0)
                        plus_days = plus_days * -1;
                    
                    // System.out.println(""+plus_days);
                    if (plus_days > 0) {
                        if (emprestimoController.Renovar(id_emprestimo, plus_days)) {
                            updateEmprestimoTable("");
                            JOptionPane.showMessageDialog(null, "Empréstimo renovado por mais "+ plus_days + " dia" + (plus_days == 1 ? "." : "s."));
                            livroList.setModel(new DefaultListModel());
                        }
                    }                             
                } 
            }
        }
        else
            RenovaEmprestimoBtn.setEnabled(false);  
    }//GEN-LAST:event_RenovaEmprestimoBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DevolveEmprestimoBtn;
    private javax.swing.JButton RenovaEmprestimoBtn;
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
