/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBHelper;

/**
 *
 * @author gabriel
 */
public class ConfigDAO {
    
    private static ConfigDAO instance;
    private static DBHelper helper;

    public ConfigDAO() {
        helper = DBHelper.getInstance();
    }
    
    public static ConfigDAO getInstance() {
        if (instance == null)
            instance = new ConfigDAO();
        return instance;
    }
    
    public boolean setAutoBkp(boolean flag) {
        String query = "UPDATE app_config SET auto_bkp=" + (flag ? 1 : 0) + ";";
        return helper.rawSQL(query);
    }
    
    public boolean isSetAutoBackup() {
        String query = "SELECT auto_bkp FROM app_config;";
        return helper.getBoolean(query);
    }
    
    public boolean saveTaxaJuros(double d) {
        String query = "UPDATE app_config SET taxa_juros=" + d + "; ";
        return helper.rawSQL(query);
    }
    
    public boolean savePrazoDefault(int i) {
        String query = "UPDATE app_config SET prazo_default=" + i + "; ";
        return helper.rawSQL(query);
    }
    
    public boolean saveDBVersion(int i) {
        String query = "UPDATE app_config SET db_version=" + i + ";";
        return helper.rawSQL(query);
    }
    
    public double getTaxaJuros() {
        String query = "SELECT taxa_juros FROM app_config;";
        return helper.getDouble(query);
    }
    
    public int getPrazoDefault() {
        String query = "SELECT prazo_default FROM app_config;";
        return helper.getInt(query);
    }
    
    public int getDBVersion() {
        String query = "SELECT db_version FROM app_config;";
        return helper.getInt(query);
    }
    
    public int getLastBackupInDays() {
        String query = "SELECT cast((julianday('now') - julianday(a.last_backup)) AS Integer) FROM app_config a;";
        return helper.getInt(query);
    }
}
