/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.TurmaController;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dewes
 */
public class MainFrame extends javax.swing.JFrame {
    
    static PessoasInternalFrame pif;
    static PessoasAddInternalFrame paif;
    static PessoasAttInternalFrame patif;
    static TurmasInternalFrame tif;
    static LivrosInternalFrame lif;
    static LivrosAddInternalFrame laif;
    static EmprestimoAddInternalFrame eaif;
    static EmprestimoInternalFrame eif;

    public MainFrame() {
        initComponents();
    }
    
    public void updateTableModel() {
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        associadosMenu = new javax.swing.JMenu();
        verPessoasMenuItem = new javax.swing.JMenuItem();
        cadastrarMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        turmasMenuItem = new javax.swing.JMenuItem();
        LivrosMenu = new javax.swing.JMenu();
        verLivrosMenuItem = new javax.swing.JMenuItem();
        addLivroMenuItem = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        verEmprestimosMenuItem = new javax.swing.JMenuItem();
        novoEmprestimoMenuItem = new javax.swing.JMenuItem();
        configMenu = new javax.swing.JMenu();
        configMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JBiblioteca");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setForeground(java.awt.Color.darkGray);

        desktop.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        associadosMenu.setText("Pessoas");

        verPessoasMenuItem.setText("Ver Pessoas");
        verPessoasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPessoasMenuItemActionPerformed(evt);
            }
        });
        associadosMenu.add(verPessoasMenuItem);

        cadastrarMenuItem.setText("Nova Pessoa");
        cadastrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarMenuItemActionPerformed(evt);
            }
        });
        associadosMenu.add(cadastrarMenuItem);
        associadosMenu.add(jSeparator2);

        turmasMenuItem.setText("Ver e Editar Turmas");
        turmasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmasMenuItemActionPerformed(evt);
            }
        });
        associadosMenu.add(turmasMenuItem);

        jMenuBar1.add(associadosMenu);

        LivrosMenu.setText("Livros e Exemplares");

        verLivrosMenuItem.setText("Ver Todos");
        verLivrosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verLivrosMenuItemActionPerformed(evt);
            }
        });
        LivrosMenu.add(verLivrosMenuItem);

        addLivroMenuItem.setText("Novo Livro");
        addLivroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLivroMenuItemActionPerformed(evt);
            }
        });
        LivrosMenu.add(addLivroMenuItem);

        jMenuItem3.setText("Novo Exemplar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        LivrosMenu.add(jMenuItem3);

        jMenuBar1.add(LivrosMenu);

        jMenu4.setText("Empréstimos");

        verEmprestimosMenuItem.setText("Ver Todos");
        verEmprestimosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEmprestimosMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(verEmprestimosMenuItem);

        novoEmprestimoMenuItem.setText("Novo empréstimo");
        novoEmprestimoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoEmprestimoMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(novoEmprestimoMenuItem);

        jMenuBar1.add(jMenu4);

        configMenu.setText("Opções");

        configMenuItem.setText("Configurações");
        configMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configMenuItemActionPerformed(evt);
            }
        });
        configMenu.add(configMenuItem);

        jMenuBar1.add(configMenu);

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
        paif = new PessoasAddInternalFrame();
        paif.setVisible(true);
        desktop.add(paif);
    }//GEN-LAST:event_cadastrarMenuItemActionPerformed

    private void verPessoasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPessoasMenuItemActionPerformed
        if (pif == null || pif.isClosed()) {
            pif = new PessoasInternalFrame(this);
            pif.setVisible(true);
            desktop.add(pif);
        }
        else
            try {
                if (pif.isIcon())
                    pif.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_verPessoasMenuItemActionPerformed

    private void turmasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmasMenuItemActionPerformed
        if (tif == null || tif.isClosed()) {
            tif = new TurmasInternalFrame();
            tif.setVisible(true);
            desktop.add(tif);
        }
        else 
            try {
                if (tif.isIcon())
                    tif.setIcon(false);
            } 
            catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_turmasMenuItemActionPerformed

    private void novoEmprestimoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEmprestimoMenuItemActionPerformed
        eaif = new EmprestimoAddInternalFrame();
        eaif.setVisible(true);
        desktop.add(eaif);
    }//GEN-LAST:event_novoEmprestimoMenuItemActionPerformed

    private void verLivrosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verLivrosMenuItemActionPerformed
        if (lif == null || lif.isClosed()) {
            lif = new LivrosInternalFrame(this);
            lif.setVisible(true);
            desktop.add(lif);
        }
        else
            try {
                if (lif.isIcon())
                    lif.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_verLivrosMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void verEmprestimosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEmprestimosMenuItemActionPerformed
        if (eif == null || eif.isClosed()) {
            eif = new EmprestimoInternalFrame(this);
            eif.setVisible(true);
            desktop.add(eif);
        }
        else
            try {
                if (eif.isIcon())
                    eif.setIcon(false);

            } 
            catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_verEmprestimosMenuItemActionPerformed

    private void addLivroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLivroMenuItemActionPerformed
        laif = new LivrosAddInternalFrame();
        laif.setVisible(true);
        desktop.add(laif);
    }//GEN-LAST:event_addLivroMenuItemActionPerformed

    private void configMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMenuItemActionPerformed
        configInternalFrame cif = new configInternalFrame();
        cif.setVisible(true);
        desktop.add(cif);
    }//GEN-LAST:event_configMenuItemActionPerformed

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
    private javax.swing.JMenu LivrosMenu;
    private javax.swing.JMenuItem addLivroMenuItem;
    private javax.swing.JMenu associadosMenu;
    private javax.swing.JMenuItem cadastrarMenuItem;
    private javax.swing.JMenu configMenu;
    private javax.swing.JMenuItem configMenuItem;
    public javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem novoEmprestimoMenuItem;
    private javax.swing.JMenuItem turmasMenuItem;
    private javax.swing.JMenuItem verEmprestimosMenuItem;
    private javax.swing.JMenuItem verLivrosMenuItem;
    private javax.swing.JMenuItem verPessoasMenuItem;
    // End of variables declaration//GEN-END:variables
}
