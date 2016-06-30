/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbiblioteca;

import database.DBUtil;
import database.Database;
import view.MainFrame;

/**
 *
 * @author Dewes
 */
public class JBiblioteca {
       
    public static void main(String[] args) {
 
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
   
