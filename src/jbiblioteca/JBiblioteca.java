/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbiblioteca;

import database.DBUtil;
import database.Database;
import java.io.IOException;
import javax.swing.JOptionPane;
import view.MainFrame;

/**
 * 
 * @author Dewes
 */
public class JBiblioteca {
    static MainFrame mf;
    public static void main(String[] args) throws IOException {
        if (!InstanceManager.registerInstance()) {  
            JOptionPane.showMessageDialog(null, "Já existe uma instancia aberta. ", "JBiblioteca", JOptionPane.INFORMATION_MESSAGE);             
            System.exit(0);  
        } 
        
        MainFrame.OpenMainFrame();   
        Runnable t1 = () -> {
            try {
                Database.checkDatabase();
                DBUtil.createDDL();
            } catch (Exception e1) {}
        };
        new Thread(t1).start();
        /*
        java.io.File file = new java.io.File(
                        System.getProperty("user.home")
                        + System.getProperty("file.separator")
                        + ".jbiblioteca"
                        + System.getProperty("file.separator")
                        + "jbiblioteca_bkp.db");

        //Database.backupDatabase(file);
        //Database.recoverBackupDatabase(file);

        //DBUtil du = new DBUtil();
        //du.dropDDL();
        //du.createDDL();
        //du.populate();
        //du.clear();
        */
    }
}
   
