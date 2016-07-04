/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ConfigDAO;
import dao.GenericDAO;
import org.joda.time.LocalDateTime;

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
    
    public static boolean saveDBVers(int i) {
        cdao = new ConfigDAO();
        return cdao.saveDBVersion(i);
    }
    
    public static boolean saveLastBackupDate(String date) {
        dao = new GenericDAO();
        return dao.update("app_config", "last_backup", date);
    }
    
    public static String getLastBackupDate() {
        dao = new GenericDAO();
        String s = dao.get("app_config", "last_backup");
        LocalDateTime ldt = new LocalDateTime(s);
        s = ""+ldt.toDate().toLocaleString();
        return s;
    }
    
    public static boolean setAutoBackup(boolean flag) {
        cdao = new ConfigDAO();
        return cdao.setAutoBkp(flag);
    }
    
    public static boolean AutoBackupIsActived() {
        cdao = new ConfigDAO();
        return cdao.isSetAutoBackup();
    }
    
    public static double getAppConfigTaxaJuros() {
        cdao = new ConfigDAO();
        return cdao.getTaxaJuros();
    }
    
    public static int getVers() {
        cdao = new ConfigDAO();
        return cdao.getDBVersion();
    }
    
    public static int getPrazoDefault() {
        cdao = new ConfigDAO();
        return cdao.getPrazoDefault();
    }
}
