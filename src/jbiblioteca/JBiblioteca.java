/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbiblioteca;

import database.Database;
import javax.swing.JOptionPane;
import view.MainFrame;

/**
 * 
 * @author Dewes
 */
public class JBiblioteca {
    
    public static void main(String[] args) {
        if (!InstanceManager.registerInstance()) {  
            JOptionPane.showMessageDialog(null, "Já existe uma instância do programa aberta. ", "JBiblioteca", JOptionPane.INFORMATION_MESSAGE);             
            System.exit(0);  
        } 
        
        MainFrame.OpenMainFrame();   
        try {
            Database.checkDatabase();
            //DBUtil.updateDDL(0);
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
            */
            //Database.backupDatabase(file);
            //Database.recoverBackupDatabase(file);
        } catch (Exception ex) {}
    }
}
   
