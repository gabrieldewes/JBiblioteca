/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ConfigController;
import control.ExemplarController;
import control.LivroController;
import database.Database;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Livro;
import org.joda.time.LocalDateTime;
import static view.LivrosInternalFrame.titulos;

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
    static ConfigInternalFrame cif;

    public MainFrame() {
        initComponents();
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        associadosMenu = new javax.swing.JMenu();
        verPessoasMenuItem = new javax.swing.JMenuItem();
        cadastrarMenuItem = new javax.swing.JMenuItem();
        LivrosMenu = new javax.swing.JMenu();
        verLivrosMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        addLivroMenuItem = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        verEmprestimosMenuItem = new javax.swing.JMenuItem();
        novoEmprestimoMenuItem = new javax.swing.JMenuItem();
        configMenu = new javax.swing.JMenu();
        configMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBiblioteca");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jMenu1.setText("Turmas");

        jMenuItem2.setText("Ver e Editar Turmas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

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

        jMenuBar1.add(associadosMenu);

        LivrosMenu.setText("Títulos e Exemplares");

        verLivrosMenuItem.setText("Ver Todos");
        verLivrosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verLivrosMenuItemActionPerformed(evt);
            }
        });
        LivrosMenu.add(verLivrosMenuItem);
        LivrosMenu.add(jSeparator3);

        addLivroMenuItem.setText("Novo Título");
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

        verEmprestimosMenuItem.setText("Ver Empréstimos");
        verEmprestimosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEmprestimosMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(verEmprestimosMenuItem);

        novoEmprestimoMenuItem.setText("Novo Empréstimo");
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
        if (paif == null || paif.isClosed()) {
            paif = new PessoasAddInternalFrame();
            paif.setVisible(true);
            desktop.add(paif);
        }
        try {
            paif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        try {
            pif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verPessoasMenuItemActionPerformed

    private void novoEmprestimoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEmprestimoMenuItemActionPerformed
        if (eaif == null || eaif.isClosed()) {
            eaif = new EmprestimoAddInternalFrame();
            eaif.setVisible(true);
            desktop.add(eaif);
        }
        
        try {
                eaif.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        try {
            lif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verLivrosMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JComboBox titulo = new JComboBox();
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
            }
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
        try {
            eif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verEmprestimosMenuItemActionPerformed

    private void addLivroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLivroMenuItemActionPerformed
        if (laif == null || laif.isClosed()) {
            laif = new LivrosAddInternalFrame();
            laif.setVisible(true);
            desktop.add(laif);
        }
        try {
            laif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addLivroMenuItemActionPerformed

    private void configMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMenuItemActionPerformed

        if (cif == null || cif.isClosed()) {
            cif = new ConfigInternalFrame();
            cif.setVisible(true);
            desktop.add(cif);
        }
        try {
            cif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_configMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
        
        try {
            tif.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, 
            "Deseja realmente encerrar?", "JBiblioteca", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            ConfigController.doDailyBackup();  
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem novoEmprestimoMenuItem;
    private javax.swing.JMenuItem verEmprestimosMenuItem;
    private javax.swing.JMenuItem verLivrosMenuItem;
    private javax.swing.JMenuItem verPessoasMenuItem;
    // End of variables declaration//GEN-END:variables
}
