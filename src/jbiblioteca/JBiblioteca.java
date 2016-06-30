/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbiblioteca;

import database.DBHelper;
import database.DBUtil;
import database.Database;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MainFrame;

/**
 *
 * @author Dewes
 */
public class JBiblioteca {
       
    public static void main(String[] args) {
 
        try { 
            MainFrame.OpenMainFrame();
            
            java.io.File file = new java.io.File(
                            System.getProperty("user.home")
                            + System.getProperty("file.separator")
                            + ".jbiblioteca"
                            + System.getProperty("file.separator")
                            + "jbiblioteca_bkp.db");
            
            Database.checkDatabase();
            //Database.backupDatabase(file
            //Database.recoverBackupDatabase(file);
            
            //DBUtil du = new DBUtil();
            //du.dropDDL();
            //du.createDDL();
            //du.populate();
            //du.clear();
        } catch (SQLException ex) {
            Logger.getLogger(JBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
