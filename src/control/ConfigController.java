/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ConfigDAO;
import dao.GenericDAO;
import database.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

/**
 *
 * @author gabriel
 */
public class ConfigController {
    
    static GenericDAO dao;
    static ConfigDAO cdao;
    
    public static boolean saveTaxaJuros(double d) {
        cdao = new ConfigDAO();
        return cdao.saveTaxaJuros(d);
    }
    
    public static boolean savePrazoDefault(int i) {
        cdao = new ConfigDAO();
        return cdao.savePrazoDefault(i);
    }
    
    public static boolean saveLastBackupDate(String date) {
        dao = new GenericDAO();
        return dao.update("app_config", "last_backup", date);
    }
    
    public static String getLastBackupDate() {
        dao = new GenericDAO();
        String s = dao.get("app_config", "last_backup");
        LocalDateTime ldt = new LocalDateTime(s);
        s = ""+ldt.toDate().toLocaleString()+"";
        return s;
    }
    
    public static boolean setAutoBackup(boolean flag) {
        cdao = new ConfigDAO();
        return cdao.setAutoBkp(flag);
    }
    
    public static boolean isSetAutoBackup() {
        cdao = new ConfigDAO();
        return cdao.isSetAutoBackup();
    }
    
    public static boolean doDailyBackup() {
        cdao = new ConfigDAO();
        if (cdao.isSetAutoBackup()) {
            dao = new GenericDAO();
            String s = dao.get("app_config", "last_backup");
            LocalDateTime hoje = new LocalDateTime( System.currentTimeMillis() );
            LocalDateTime last_bkp = new LocalDateTime( s );
            Period p = new Period(hoje, last_bkp);
            //System.out.println(p.getHours() +" # "+ p.getMinutes());
            if (p.getDays() < 0) {
                java.io.File file = new java.io.File(
                        System.getProperty("user.home")+ System.getProperty("file.separator")
                        + ".jbiblioteca"+ System.getProperty("file.separator")+ "jbiblioteca_bkp.db");
                try {  
                    Database.backupDatabase(file);
                    ConfigController.saveLastBackupDate("'"+hoje.toString()+"'");
                } catch (Exception ex) {
                    Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }    
        }
        return false;  
    }
    
    public static double getAppConfigTaxaJuros() {
        cdao = new ConfigDAO();
        return cdao.getTaxaJuros();
    }
    
    public static int getDbVersion() {
        cdao = new ConfigDAO();
        return cdao.getDBVersion();
    }
    
    public static boolean setDbVersion(int ver) {
        cdao = new ConfigDAO();
        return cdao.saveDBVersion(ver);
    }
    
    public static int getPrazoDefault() {
        cdao = new ConfigDAO();
        return cdao.getPrazoDefault();
    }
}
