/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.view;

import com.jbiblioteca.controller.ConfigController;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dewes
 */
public class MainFrame extends javax.swing.JFrame {
    
    static PessoasInternalFrame pessoasInternalFrame;
    static PessoasAddInternalFrame pessoasAddInternalFrame;
    static PessoasAttInternalFrame pessoasAttInternalFrame;
    static TurmasInternalFrame turmasInternalFrame;
    static LivrosInternalFrame livrosInternalFrame;
    static LivrosAddInternalFrame livrosAddInternalFrame;
    static EmprestimoAddInternalFrame emprestimoAddInternalFrame;
    static EmprestimoInternalFrame emprestimoInternalFrame;
    static ConfigInternalFrame configInternalFrame;
    static EbooksInternalFrame ebooksInternalFrame;
    static ExemplarAddInternalFrame exemplarAddInternalFrame;
    static TurmasAttLoteInternalFrame turmasAttLoteInternalFrame;
    static HistoricoInternalFrame historicoInternalFrame;

    public MainFrame() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("jbiblioteca.png")).getImage());
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        associadosMenu = new javax.swing.JMenu();
        cadastrarMenuItem = new javax.swing.JMenuItem();
        addLivroMenuItem = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        verLivrosMenuItem = new javax.swing.JMenuItem();
        verPessoasMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        historicoEmprestimosMenu = new javax.swing.JMenu();
        novoEmprestimoMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        verEmprestimosMenuItem = new javax.swing.JMenuItem();
        verHistoricoMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        configMenuItem = new javax.swing.JMenuItem();
        ebooksMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBiblioteca");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        setForeground(java.awt.Color.darkGray);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenu1.setText("Arquivo");

        associadosMenu.setText("Novo");

        cadastrarMenuItem.setText("Pessoa");
        cadastrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMenuItemActionPerformed(evt);
            }
        });
        associadosMenu.add(cadastrarMenuItem);

        addLivroMenuItem.setText("Título");
        addLivroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLivroMenuItemActionPerformed(evt);
            }
        });
        associadosMenu.add(addLivroMenuItem);

        jMenuItem3.setText("Exemplar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        associadosMenu.add(jMenuItem3);

        jMenu1.add(associadosMenu);
        jMenu1.add(jSeparator2);

        verLivrosMenuItem.setText("Livros");
        verLivrosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verLivrosMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(verLivrosMenuItem);

        verPessoasMenuItem.setText("Pessoas");
        verPessoasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPessoasMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(verPessoasMenuItem);

        jMenuItem2.setText("Turmas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        historicoEmprestimosMenu.setText("Empréstimos");

        novoEmprestimoMenuItem.setText("Novo");
        novoEmprestimoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoEmprestimoMenuItemActionPerformed(evt);
            }
        });
        historicoEmprestimosMenu.add(novoEmprestimoMenuItem);
        historicoEmprestimosMenu.add(jSeparator3);

        verEmprestimosMenuItem.setText("Pendentes");
        verEmprestimosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEmprestimosMenuItemActionPerformed(evt);
            }
        });
        historicoEmprestimosMenu.add(verEmprestimosMenuItem);

        verHistoricoMenuItem.setText("Histórico");
        verHistoricoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verHistoricoMenuItemActionPerformed(evt);
            }
        });
        historicoEmprestimosMenu.add(verHistoricoMenuItem);

        jMenuBar1.add(historicoEmprestimosMenu);

        aboutMenu.setText("Sobre");

        configMenuItem.setText("Configurações");
        configMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(configMenuItem);

        ebooksMenuItem.setText("Referências Online");
        ebooksMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebooksMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(ebooksMenuItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        desktop.getAccessibleContext().setAccessibleParent(desktop);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarMenuItemActionPerformed
        if (pessoasAddInternalFrame == null || pessoasAddInternalFrame.isClosed()) {
            pessoasAddInternalFrame = new PessoasAddInternalFrame();
            pessoasAddInternalFrame.setVisible(true);
            desktop.add(pessoasAddInternalFrame);
        }
        try {
            pessoasAddInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cadastrarMenuItemActionPerformed

    private void verPessoasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPessoasMenuItemActionPerformed
        if (pessoasInternalFrame == null || pessoasInternalFrame.isClosed()) {
            pessoasInternalFrame = new PessoasInternalFrame(this);
            pessoasInternalFrame.setVisible(true);
            desktop.add(pessoasInternalFrame);
        }
        else
            try {
                if (pessoasInternalFrame.isIcon())
                    pessoasInternalFrame.setIcon(false);
                
            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            pessoasInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verPessoasMenuItemActionPerformed

    private void novoEmprestimoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEmprestimoMenuItemActionPerformed
        if (emprestimoAddInternalFrame == null || emprestimoAddInternalFrame.isClosed()) {
            emprestimoAddInternalFrame = new EmprestimoAddInternalFrame();
            emprestimoAddInternalFrame.setVisible(true);
            desktop.add(emprestimoAddInternalFrame);
        }
        
        try {
                emprestimoAddInternalFrame.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_novoEmprestimoMenuItemActionPerformed

    private void verLivrosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verLivrosMenuItemActionPerformed
        if (livrosInternalFrame == null || livrosInternalFrame.isClosed()) {
            livrosInternalFrame = new LivrosInternalFrame(this);
            livrosInternalFrame.setVisible(true);
            desktop.add(livrosInternalFrame);
        }
        else
            try {
                if (livrosInternalFrame.isIcon())
                    livrosInternalFrame.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            livrosInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verLivrosMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        /*JComboBox titulo = new JComboBox();
            JTextField codigoField = new JTextField();
            JTextField xField = new JTextField();
            JTextField yField = new JTextField();
            Object[] message = {
                "Selecione o Título: ", titulo,
                "Código único:", codigoField,
                "Coordenada X:", xField,
                "Coordenada Y:", yField
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
            desktop.add(exemplarAddInternalFrame);
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
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void verEmprestimosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEmprestimosMenuItemActionPerformed
        if (emprestimoInternalFrame == null || emprestimoInternalFrame.isClosed()) {
            emprestimoInternalFrame = new EmprestimoInternalFrame(this);
            emprestimoInternalFrame.setVisible(true);
            desktop.add(emprestimoInternalFrame);
        }
        else
            try {
                if (emprestimoInternalFrame.isIcon())
                    emprestimoInternalFrame.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            emprestimoInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verEmprestimosMenuItemActionPerformed

    private void addLivroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLivroMenuItemActionPerformed
        if (livrosAddInternalFrame == null || livrosAddInternalFrame.isClosed()) {
            livrosAddInternalFrame = new LivrosAddInternalFrame();
            livrosAddInternalFrame.setVisible(true);
            desktop.add(livrosAddInternalFrame);
        }
        try {
            livrosAddInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addLivroMenuItemActionPerformed

    private void configMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMenuItemActionPerformed

        if (configInternalFrame == null || configInternalFrame.isClosed()) {
            configInternalFrame = new ConfigInternalFrame();
            configInternalFrame.setVisible(true);
            desktop.add(configInternalFrame);
        }
        try {
            configInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_configMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, 
            "Deseja realmente encerrar?", "JBiblioteca", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                ConfigController.getInstance().doDailyBackup();  
                System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void ebooksMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebooksMenuItemActionPerformed
        if (ebooksInternalFrame == null || ebooksInternalFrame.isClosed()) {
            ebooksInternalFrame = new EbooksInternalFrame();
            ebooksInternalFrame.setVisible(true);
            desktop.add(ebooksInternalFrame);
        }
        else 
            try {
                if (ebooksInternalFrame.isIcon())
                    ebooksInternalFrame.setIcon(false);
            } 
            catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ebooksInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ebooksMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (turmasInternalFrame == null || turmasInternalFrame.isClosed()) {
            turmasInternalFrame = new TurmasInternalFrame();
            turmasInternalFrame.setVisible(true);
            desktop.add(turmasInternalFrame);
        }
        else 
            try {
                if (turmasInternalFrame.isIcon())
                    turmasInternalFrame.setIcon(false);
            } 
            catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            turmasInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void verHistoricoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verHistoricoMenuItemActionPerformed
        if (historicoInternalFrame == null || historicoInternalFrame.isClosed()) {
            historicoInternalFrame = new HistoricoInternalFrame(this);
            historicoInternalFrame.setVisible(true);
            desktop.add(historicoInternalFrame);
        }
        else
            try {
                if (historicoInternalFrame.isIcon())
                    historicoInternalFrame.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            historicoInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verHistoricoMenuItemActionPerformed

    public static void OpenMainFrame() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem addLivroMenuItem;
    private javax.swing.JMenu associadosMenu;
    private javax.swing.JMenuItem cadastrarMenuItem;
    private javax.swing.JMenuItem configMenuItem;
    public javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem ebooksMenuItem;
    private javax.swing.JMenu historicoEmprestimosMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem novoEmprestimoMenuItem;
    private javax.swing.JMenuItem verEmprestimosMenuItem;
    private javax.swing.JMenuItem verHistoricoMenuItem;
    private javax.swing.JMenuItem verLivrosMenuItem;
    private javax.swing.JMenuItem verPessoasMenuItem;
    // End of variables declaration//GEN-END:variables
}
