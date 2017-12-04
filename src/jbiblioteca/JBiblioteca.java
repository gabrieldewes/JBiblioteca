package jbiblioteca;

import database.DBUtil;
import database.Database;
import javax.swing.JOptionPane;
import view.MainFrame;

/**
 * 
 * @author Gabriel Dewes
 */
public class JBiblioteca {
    
    public static void main(String[] args) {
        /*if (!InstanceManager.registerInstance()) {  
            JOptionPane.showMessageDialog(null, "Já existe uma instância do programa aberta. ", "JBiblioteca", JOptionPane.INFORMATION_MESSAGE);             
            System.exit(0);  
        }*/ 
        
        MainFrame.OpenMainFrame();   
        try {
            Database.checkDatabase();
            // DBUtil.updateDDL(2);
            // DBUtil.dropDDL();
            // DBUtil.createDDL();
            // DBUtil.populate();
            // DBUtil.clear();

            // Database.backupDatabase();
            // Database.recoverBackupDatabase();
        } catch (Exception ex) {}
    }
}
   
