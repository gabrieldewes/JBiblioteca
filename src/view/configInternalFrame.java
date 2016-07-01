/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.DBUtil;
import database.Database;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.joda.time.LocalDate;

/**
 *
 * @author gabriel
 */
public class configInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form configInternalFrame
     */
    public configInternalFrame() {
        initComponents();
        LocalDate date = new LocalDate(System.currentTimeMillis());
        footer.setText(date.getYear() + " - Gabriel Dewes - JBiblioteca ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BackupBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        populateBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        footer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Configurações");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Preferências", jPanel2);

        BackupBtn.setText("Realizar Backup Agora");
        BackupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Restaurar arquivo de backup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reiniciar Aplicação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        populateBtn.setText("Popular para Testes");
        populateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(BackupBtn))
                        .addContainerGap(177, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(populateBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(BackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(populateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados e Backup", jPanel3);

        footer.setText("jLabel1");
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                footerMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("jBiblioteca");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(footer)
                    .addComponent(jLabel1))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sobre", jPanel4);

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

    private void BackupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupBtnActionPerformed
        Runnable t1 = () -> {
            try {
                java.io.File file = new java.io.File(
                        System.getProperty("user.home")
                        + System.getProperty("file.separator")
                        + ".jbiblioteca"
                        + System.getProperty("file.separator")
                        + "jbiblioteca_bkp.db");   
                Database.checkDatabase();
                Database.backupDatabase(file);
                JOptionPane.showMessageDialog(null, "O arquivo de backup foi salvo com êxito.");
            } catch (Exception e1) {
            }
        };
        new Thread(t1).start();
    }//GEN-LAST:event_BackupBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar todos os dados? ", "Atenção",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            DBUtil du = new DBUtil();
            du.dropDDL();
            du.createDDL();
            JOptionPane.showMessageDialog(null, "A aplicação foi reiniciada com êxito.");
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Runnable t1 = () -> {
            try {
                java.io.File file = new java.io.File(
                        System.getProperty("user.home")
                        + System.getProperty("file.separator")
                        + ".jbiblioteca"
                        + System.getProperty("file.separator")
                        + "jbiblioteca_bkp.db");   
                Database.checkDatabase();
                Database.recoverBackupDatabase(file);
                JOptionPane.showMessageDialog(null, "O arquivo de backup foi recuperado com êxito.");
            } catch (Exception e1) {
            }
        };
        new Thread(t1).start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void populateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populateBtnActionPerformed
        Runnable t1 = () -> {
            try {
                DBUtil du = new DBUtil();
                du.createDDL();
                du.populate();
                JOptionPane.showMessageDialog(null, "Os dados foram inseridos com êxito.");
            } catch (Exception e1) {
            }
        };
        new Thread(t1).start();
        
    }//GEN-LAST:event_populateBtnActionPerformed

    private void footerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("http://gabrieldewes.github.io"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(configInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_footerMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            Desktop.getDesktop().browse(new URI("http://gabrieldewes.github.io"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(configInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void footerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseEntered
        footer.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_footerMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackupBtn;
    private javax.swing.JLabel footer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton populateBtn;
    // End of variables declaration//GEN-END:variables
}
