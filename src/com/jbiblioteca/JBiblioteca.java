package com.jbiblioteca;

import com.jbiblioteca.data.DBUtil;
import com.jbiblioteca.data.Database;
import com.jbiblioteca.view.MainFrame;

/**
 * 
 * @author Gabriel Dewes
 */
public class JBiblioteca {
    
    public static void main(String[] args) {
        
        MainFrame.OpenMainFrame();   
        Database.checkDatabase();
        // DBUtil.updateDDL(2);
        // DBUtil.dropDDL();
        // DBUtil.createDDL();
        // DBUtil.populate();
        // DBUtil.clear();

        // Database.backupDatabase();
        // Database.recoverBackupDatabase();
    }
}
   
