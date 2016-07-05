/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbiblioteca;

import control.ConfigController;
import database.DBUtil;
import database.Database;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.MainFrame;

/**
 * 
 * @author Dewes
 */
public class JBiblioteca {
    public static void main(String[] args) throws IOException {
        if (!InstanceManager.registerInstance()) {  
            JOptionPane.showMessageDialog(null, "Já existe uma instancia aberta. ", "JBiblioteca", JOptionPane.INFORMATION_MESSAGE);             
            System.exit(0);  
        } 
        
        MainFrame.OpenMainFrame();   
        Runnable t1 = () -> {
            try {
                Database.checkDatabase();
                //DBUtil.updateDDL(1, 2);
                //DBUtil.dropDDL();
                //DBUtil.createDDL();
                //DBUtil.populate();
                //DBUtil.clear();
                /*
                java.io.File file = new java.io.File(
                                System.getProperty("user.home")
                                + System.getProperty("file.separator")
                                + ".jbiblioteca"
                                + System.getProperty("file.separator")
                                + "jbiblioteca_bkp.db");

                //Database.backupDatabase(file);
                //Database.recoverBackupDatabase(file);
                */ 
            } catch (Exception e1) {}
        };
        new Thread(t1).start();
    }
}
   
