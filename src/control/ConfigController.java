/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ConfigDAO;
import dao.GenericDAO;
import database.DBUtil;
import database.Database;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

/**
 *
 * @author gabriel
 */
public class ConfigController {
    
    private static ConfigController instance;
    
    private static GenericDAO gdao;
    private static ConfigDAO cdao;
    
    public ConfigController() {
        gdao = GenericDAO.getInstance();
        cdao = ConfigDAO.getInstance();
    }
    
    public static ConfigController getInstance() {
        if (instance == null)
            instance = new ConfigController();
        return instance;
    }
    
    public boolean saveTaxaJuros(double d) {
        return cdao.saveTaxaJuros(d);
    }
    
    public boolean savePrazoDefault(int i) {
        return cdao.savePrazoDefault(i);
    }
    
    public boolean saveLastBackupDate(String date) {
        return gdao.update("app_config", "last_backup", date);
    }
    
    /*
    public String getLastBackupDate() {
        String s = gdao.get("app_config", "last_backup");
        LocalDateTime ldt = new LocalDateTime(s);
        s = ""+ldt.toDate().toLocaleString()+"";
        return s;
    }
    */
    
    public String getLastBackupToString() {
        String s = gdao.get("app_config", "last_backup");
        LocalDateTime ldt = new LocalDateTime(s);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 'ás' HH:mm:ss");
        return sdf.format(ldt.toDate());
    }
    
    public boolean setAutoBackup(boolean flag) {
        return cdao.setAutoBkp(flag);
    }
    
    public boolean isSetAutoBackup() {
        return cdao.isSetAutoBackup();
    }
    
    public boolean doDailyBackup() {
        if (cdao.isSetAutoBackup()) {
            String s = gdao.get("app_config", "last_backup");
            LocalDateTime hoje = new LocalDateTime( System.currentTimeMillis() );
            LocalDateTime lastBackup = new LocalDateTime( s );
            Period p = new Period(hoje, lastBackup);
            //System.out.println(p.getHours() +" # "+ p.getMinutes());
            if (p.getHours() < 0) {
                DBUtil.backupDatabase();
                /*
                try {  
                    Database.backupDatabase();
                    this.saveLastBackupDate("'"+hoje.toString()+"'");
                } catch (Exception ex) {
                    Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                return true;
            }    
        }
        return false;  
    }
    
    public double getAppConfigTaxaJuros() {
        return cdao.getTaxaJuros();
    }
    
    public int getDbVersion() {
        return cdao.getDBVersion();
    }
    
    public String getAppVersion() {
        return cdao.getAppVersion();
    }
    
    public boolean setDbVersion(int ver) {
        return cdao.saveDBVersion(ver);
    }
    
    public int getPrazoDefault() {
        return cdao.getPrazoDefault();
    }
}
