/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbiblioteca;

import database.DBUtil;
import database.Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            JOptionPane.showMessageDialog(null, "Já existe uma instancia aberta. ", "Atenção", JOptionPane.INFORMATION_MESSAGE);             
            System.exit(0);  
        } 

        Runnable t1 = () -> {
            try {
                Database.checkDatabase();
                DBUtil du = new DBUtil();
                du.createDDL();
            } catch (Exception e1) {}
        };
        new Thread(t1).start();
        
       MainFrame.OpenMainFrame();   
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
   
