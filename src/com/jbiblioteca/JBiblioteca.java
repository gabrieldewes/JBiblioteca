package com.jbiblioteca;

import com.jbiblioteca.data.DBUtil;
import com.jbiblioteca.view.MainFrame;

/**
 * 
 * @author Gabriel Dewes
 */
public class JBiblioteca {
    
    public static void main(String[] args) {
        
        MainFrame.OpenMainFrame();   
        DBUtil.checkDatabase();
        DBUtil.updateDDL(4);
        // DBUtil.dropDDL();
        // DBUtil.createDDL();
        // DBUtil.populate();
        // DBUtil.clear();

        // Database.backupDatabase();
        // Database.recoverBackupDatabase();
    }
}
   
