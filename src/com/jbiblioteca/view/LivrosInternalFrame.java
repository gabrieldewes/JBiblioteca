/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.view;

import com.jbiblioteca.controller.ExemplarController;
import com.jbiblioteca.controller.LivroController;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jbiblioteca.model.Livro;
import com.jbiblioteca.model.Pessoa;
import java.awt.event.KeyEvent;
import static com.jbiblioteca.view.MainFrame.exemplarAddInternalFrame;
import static com.jbiblioteca.view.MainFrame.livrosInternalFrame;

/**
 *
 * @author Dewes
 */
public final class LivrosInternalFrame extends javax.swing.JInternalFrame {
    
    private final ExemplarController exemplarController;
    private final LivroController livroController;

    static LivrosAddInternalFrame paif;
    static MainFrame mfthis;
    static ArrayList<Pessoa> pessoas;
    static ArrayList<Livro> titulos;
    
    public LivrosInternalFrame( MainFrame mf ) {
        initComponents();
        
        exemplarController = ExemplarController.getInstance();
        livroController = LivroController.getInstance();
        
        LivroTable.setAutoCreateRowSorter(true);
        ExemplarTable.setAutoCreateRowSorter(true);
        updateLivroTableModel("");
        updateExemplarTableModel("");
        mfthis = mf;
    }
    
    void updateLivroTableModel(String buscar) {
        if (!"".equals(buscar)) {
            LivroTable.setModel(livroController.Buscar(buscar));
        }
        else {
            LivroTable.setModel(livroController.Listar());
        }
        LivroTable.getColumnModel().getColumn(0).setMinWidth(0);
        LivroTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        LivroTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    void updateExemplarTableModel(String buscar) {
        if (!"".equals(buscar)) {
            ExemplarTable.setModel(exemplarController.Buscar(buscar));
        }
        else {
            ExemplarTable.setModel(exemplarController.Listar());
        }
        ExemplarTable.getColumnModel().getColumn(0).setMinWidth(0);
        ExemplarTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        ExemplarTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LivroTable = new javax.swing.JTable();
        BuscaLivroField = new javax.swing.JTextField();
        BuscaLivroBtn = new javax.swing.JButton();
        AddLivroBtn = new javax.swing.JButton();
        AttLivroBtn = new javax.swing.JButton();
        DelLivroBtn = new javax.swing.JButton();
        AddExemplarLivroBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ExemplarTable = new javax.swing.JTable();
        BuscaExemplarField = new javax.swing.JTextField();
        BuscaExemplarBtn = new javax.swing.JButton();
        AddExemplarBtn = new javax.swing.JButton();
        AttExemplarBtn = new javax.swing.JButton();
        DelExemplarBtn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Livros");
        setInheritsPopupMenu(true);

        LivroTable.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        LivroTable.setModel(new javax.swing.table.DefaultTableModel(
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
        LivroTable.getTableHeader().setReorderingAllowed(false);
        LivroTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LivroTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(LivroTable);

        BuscaLivroField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BuscaLivroField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscaLivroFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscaLivroFieldKeyReleased(evt);
            }
        });

        BuscaLivroBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BuscaLivroBtn.setText("Buscar");
        BuscaLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaLivroBtnActionPerformed(evt);
            }
        });

        AddLivroBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AddLivroBtn.setText("Cadastrar Título");
        AddLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLivroBtnActionPerformed(evt);
            }
        });

        AttLivroBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AttLivroBtn.setText("Alterar");
        AttLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttLivroBtnActionPerformed(evt);
            }
        });

        DelLivroBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DelLivroBtn.setText("Excluir");
        DelLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelLivroBtnActionPerformed(evt);
            }
        });

        AddExemplarLivroBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AddExemplarLivroBtn.setText("Novo exemplar");
        AddExemplarLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddExemplarLivroBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(DelLivroBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AttLivroBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addComponent(AddLivroBtn))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AddExemplarLivroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(BuscaLivroField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscaLivroBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuscaLivroBtn)
                            .addComponent(BuscaLivroField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddLivroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(AttLivroBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddExemplarLivroBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelLivroBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Títulos", jPanel1);

        ExemplarTable.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        ExemplarTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ExemplarTable.getTableHeader().setReorderingAllowed(false);
        ExemplarTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExemplarTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ExemplarTable);

        BuscaExemplarField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BuscaExemplarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscaExemplarFieldKeyReleased(evt);
            }
        });

        BuscaExemplarBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BuscaExemplarBtn.setText("Buscar");
        BuscaExemplarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaExemplarBtnActionPerformed(evt);
            }
        });

        AddExemplarBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AddExemplarBtn.setText("Cadastrar Novo");
        AddExemplarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddExemplarBtnActionPerformed(evt);
            }
        });

        AttExemplarBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AttExemplarBtn.setText("Alterar");
        AttExemplarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttExemplarBtnActionPerformed(evt);
            }
        });

        DelExemplarBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DelExemplarBtn.setText("Excluir");
        DelExemplarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelExemplarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AttExemplarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelExemplarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddExemplarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(BuscaExemplarField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscaExemplarBtn)
                        .addContainerGap(156, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AddExemplarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(AttExemplarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DelExemplarBtn)
                        .addGap(0, 202, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuscaExemplarBtn)
                            .addComponent(BuscaExemplarField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Exemplares", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddLivroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLivroBtnActionPerformed
        paif = new LivrosAddInternalFrame();
        paif.setVisible(true);
        mfthis.desktop.add(paif);
        try {
                paif.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(LivrosInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_AddLivroBtnActionPerformed

    private void DelLivroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelLivroBtnActionPerformed
        int idx[] = LivroTable.getSelectedRows();
        if (idx.length > 0) {
            JLabel titulo = new JLabel();
            titulo.setFont(new Font("Dialog", Font.BOLD, 14));
            JLabel exemplares = new JLabel();
            exemplares.setFont(new Font("Dialog", Font.BOLD, 14));
            Object[] message = {
                "Título:", titulo,
                "Total de Exemplares: ", exemplares,
                "Tem certeza que deseja excluir?"
            };
            titulo.setText( LivroTable.getValueAt(LivroTable.getSelectedRow(), 1).toString() );
            exemplares.setText( LivroTable.getValueAt(LivroTable.getSelectedRow(), 3).toString() );
            int response = JOptionPane.showConfirmDialog(null, message, "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.valueOf( LivroTable.getValueAt( LivroTable.getSelectedRow() , 0 ).toString() );
                if (livroController.Apagar(id)) {
                    updateLivroTableModel("");
                    updateExemplarTableModel("");
                }
            } 
        }
        else { DelLivroBtn.setEnabled(false); }
    }//GEN-LAST:event_DelLivroBtnActionPerformed

    private void LivroTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LivroTableMouseClicked
        AttLivroBtn.setEnabled(true);
        DelLivroBtn.setEnabled(true);
        AddExemplarLivroBtn.setEnabled(true);
    }//GEN-LAST:event_LivroTableMouseClicked

    private void AttLivroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttLivroBtnActionPerformed
        
        int idx[] = LivroTable.getSelectedRows();
        if (idx.length > 0) {
            JTextField tituloField = new JTextField();
            JTextField autorField = new JTextField();
            Object[] message = {
                "Título:", tituloField,
                "Autor:", autorField
            };
            
            int id = Integer.valueOf( LivroTable.getValueAt(LivroTable.getSelectedRow(), 0).toString() );
            Livro ex = livroController.Pegar(id);
            tituloField.setText( ex.getTitulo() );
            autorField.setText( ex.getAutor() );
            
            int option = 1;
            while (option != JOptionPane.OK_CANCEL_OPTION) {
                option = JOptionPane.showConfirmDialog(null, message, "Alterar Livro", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String titulo = tituloField.getText();
                    String autor = autorField.getText();
                    String isbn=null;
                    if (livroController.Alterar(ex, isbn, titulo, autor)) {
                        option = JOptionPane.OK_CANCEL_OPTION;
                        if (livrosInternalFrame != null) {
                            livrosInternalFrame.updateLivroTableModel("");
                            livrosInternalFrame.updateExemplarTableModel("");
                        }
                    }
                }
            }
        }
        else { AttLivroBtn.setEnabled(false); }
    }//GEN-LAST:event_AttLivroBtnActionPerformed

    private void BuscaLivroFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaLivroFieldKeyReleased
        /*String search = BuscaLivroField.getText();
        if (search.length() > 2) {
            updateLivroTableModel(search);
        }
        else updateLivroTableModel("");*/
    }//GEN-LAST:event_BuscaLivroFieldKeyReleased

    private void BuscaLivroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaLivroBtnActionPerformed
        String search = BuscaLivroField.getText();
        if (!"".equals(search)) {
            updateLivroTableModel(search);
        }
        else updateLivroTableModel("");
    }//GEN-LAST:event_BuscaLivroBtnActionPerformed

    private void AddExemplarLivroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddExemplarLivroBtnActionPerformed
        int idx[] = LivroTable.getSelectedRows();
        if (idx.length > 0) {
            JLabel titulo = new JLabel();
            titulo.setFont(new Font("Dialog", Font.BOLD, 14));
            JTextField codigoField = new JTextField();
            JTextField xField = new JTextField();
            JTextField yField = new JTextField();
            Object[] message = {
                "Título: ", titulo,
                "Código único:", codigoField,
                "Corredor:", xField,
                "Prateleira:", yField
            };
            
            int id = Integer.valueOf( LivroTable.getValueAt(LivroTable.getSelectedRow(), 0).toString() );
            Livro l = livroController.Pegar(id);
            titulo.setText( l.getTitulo() );
            
            int option = 1;
            while (option != JOptionPane.OK_CANCEL_OPTION) {
                option = JOptionPane.showConfirmDialog(null, message, "Novo Exemplar", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String codigo = codigoField.getText();
                    String x = xField.getText();
                    String y = yField.getText();
                    if (exemplarController.Salvar(l.getId_livro(), codigo, x, y)) {
                        option = JOptionPane.OK_CANCEL_OPTION;
                        if (livrosInternalFrame != null) {
                            livrosInternalFrame.updateLivroTableModel("");
                            livrosInternalFrame.updateExemplarTableModel("");
                        }
                    }
                }
            }
        }
        else { AddExemplarLivroBtn.setEnabled(false); }
    }//GEN-LAST:event_AddExemplarLivroBtnActionPerformed

    private void ExemplarTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExemplarTableMouseClicked
        AttExemplarBtn.setEnabled(true);
        DelExemplarBtn.setEnabled(true);
    }//GEN-LAST:event_ExemplarTableMouseClicked

    private void BuscaExemplarFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaExemplarFieldKeyReleased
        String search = BuscaExemplarField.getText();
        if (search.length() > 2) {
            updateExemplarTableModel(search);
        }
        else updateExemplarTableModel("");
    }//GEN-LAST:event_BuscaExemplarFieldKeyReleased

    private void BuscaExemplarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaExemplarBtnActionPerformed
        String search = BuscaExemplarField.getText();
        if (!"".equals(search)) {
            updateExemplarTableModel(search);
        }
        else updateExemplarTableModel("");
    }//GEN-LAST:event_BuscaExemplarBtnActionPerformed

    private void AddExemplarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddExemplarBtnActionPerformed
            /*JComboBox titulo = new JComboBox();
            JTextField codigoField = new JTextField();
            JTextField xField = new JTextField();
            JTextField yField = new JTextField();
            Object[] message = {
                "Selecione o Título: ", titulo,
                "Código único:", codigoField,
                "Corredor:", xField,
                "Prateleira:", yField
            };
            
            titulos = LivroController.ArrayLivro();
            titulos.stream().forEach((l) -> {
                titulo.addItem( l.getTitulo() );
            });
            int id_livro=0;
            int option = 1;
            while (option != JOptionPane.OK_CANCEL_OPTION) {
                option = JOptionPane.showConfirmDialog(null, message, "Novo Exemplar", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    for (Livro t:titulos) {
                        if (t.getTitulo().equals( titulo.getSelectedItem().toString() )) {
                            id_livro = t.getId_livro();
                        }
                    }
                    String codigo = codigoField.getText();
                    String x = xField.getText();
                    String y = yField.getText();
                    if (ExemplarController.Salvar(id_livro, codigo, x, y)) {
                        option = JOptionPane.OK_CANCEL_OPTION;
                        if (lif != null) {
                            lif.updateLivroTableModel("");
                            lif.updateExemplarTableModel("");
                        }
                    }
                }
            }*/
        if (exemplarAddInternalFrame == null || exemplarAddInternalFrame.isClosed()) {
            exemplarAddInternalFrame = new ExemplarAddInternalFrame();
            exemplarAddInternalFrame.setVisible(true);
            mfthis.desktop.add(exemplarAddInternalFrame);
        }
        else
            try {
                if (exemplarAddInternalFrame.isIcon())
                    exemplarAddInternalFrame.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            exemplarAddInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddExemplarBtnActionPerformed

    private void AttExemplarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttExemplarBtnActionPerformed
        int idx[] = ExemplarTable.getSelectedRows();
         if (idx.length > 0) {
            JLabel titulo = new JLabel();
            titulo.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField codigo = new JTextField();
            codigo.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField corredor = new JTextField();
            corredor.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField prateleira = new JTextField();
            prateleira.setFont(new Font("Dialog", Font.PLAIN, 14));
            Object[] message = {
                "Código: ", codigo,
                "Corredor:", corredor,
                "Prateleira:", prateleira
            };
            titulo.setText( ExemplarTable.getValueAt(ExemplarTable.getSelectedRow(), 2).toString() );
            codigo.setText( ExemplarTable.getValueAt(ExemplarTable.getSelectedRow(), 1).toString() );
            corredor.setText( ExemplarTable.getValueAt(ExemplarTable.getSelectedRow(), 3).toString() );
            prateleira.setText( ExemplarTable.getValueAt(ExemplarTable.getSelectedRow(), 4).toString() );
            int option=1;
            while (option != JOptionPane.OK_CANCEL_OPTION) {
                int response = JOptionPane.showConfirmDialog(null, message, "Alterar Exemplar",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.OK_OPTION) {
                    int id = Integer.valueOf( ExemplarTable.getValueAt( ExemplarTable.getSelectedRow() , 0 ).toString() );
                    if (exemplarController.Alterar(
                            id, codigo.getText().trim(), 
                            corredor.getText().trim(), prateleira.getText().trim())) {
                        updateLivroTableModel("");
                        updateExemplarTableModel("");
                        option = JOptionPane.OK_CANCEL_OPTION;
                    }
                }
                else option = JOptionPane.OK_CANCEL_OPTION;
            }
        }
        else { 
            AttExemplarBtn.setEnabled(false); 
        }
    }//GEN-LAST:event_AttExemplarBtnActionPerformed

    private void DelExemplarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelExemplarBtnActionPerformed
        int idx[] = ExemplarTable.getSelectedRows();
         if (idx.length > 0) {
            JLabel titulo = new JLabel();
            titulo.setFont(new Font("Dialog", Font.BOLD, 14));
            JLabel codigo = new JLabel();
            codigo.setFont(new Font("Dialog", Font.BOLD, 14));
            Object[] message = {
                "Título:", titulo,
                "Código: ", codigo,
                "Tem certeza que deseja excluir?"
            };
            titulo.setText( ExemplarTable.getValueAt(ExemplarTable.getSelectedRow(), 2).toString() );
            codigo.setText( ExemplarTable.getValueAt(ExemplarTable.getSelectedRow(), 1).toString() );
            int response = JOptionPane.showConfirmDialog(null, message, "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                int id = Integer.valueOf( ExemplarTable.getValueAt( ExemplarTable.getSelectedRow() , 0 ).toString() );
                if (exemplarController.Apagar(id)) {
                    updateLivroTableModel("");
                    updateExemplarTableModel("");
                }
            } 
        }
        else { 
            DelExemplarBtn.setEnabled(false);
        }
    }//GEN-LAST:event_DelExemplarBtnActionPerformed

    private void BuscaLivroFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaLivroFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String search = BuscaLivroField.getText();
            updateLivroTableModel(search);
        }
    }//GEN-LAST:event_BuscaLivroFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddExemplarBtn;
    private javax.swing.JButton AddExemplarLivroBtn;
    private javax.swing.JButton AddLivroBtn;
    private javax.swing.JButton AttExemplarBtn;
    private javax.swing.JButton AttLivroBtn;
    private javax.swing.JButton BuscaExemplarBtn;
    private javax.swing.JTextField BuscaExemplarField;
    private javax.swing.JButton BuscaLivroBtn;
    private javax.swing.JTextField BuscaLivroField;
    private javax.swing.JButton DelExemplarBtn;
    private javax.swing.JButton DelLivroBtn;
    private javax.swing.JTable ExemplarTable;
    private javax.swing.JTable LivroTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
