/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class ConfigDAO {
    
    static DBHelper helper;
    static PreparedStatement stmt;

    public ConfigDAO() {
        try {
            helper = new DBHelper();
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean saveTaxaJuros(double d) {
        String query = "UPDATE app_config SET taxa_juros="+d+"; ";
        return helper.rawSQL(query);
    }
    
    public boolean savePrazoDefault(int i) {
        String query = "UPDATE app_config SET prazo_default="+i+"; ";
        return helper.rawSQL(query);
    }
    
    public boolean saveDBVersion(int i) {
        String query = "UPDATE app_config SET db_version="+i+"; ";
        return helper.rawSQL(query);
    }
    
    public double getTaxaJuros() {
        String query = "SELECT taxa_juros FROM app_config; ";
        return helper.getDouble(query);
    }
    
    public int getPrazoDefault() {
        String query = "SELECT prazo_default FROM app_config; ";
        return helper.getInt(query);
    }
    
    public int getDBVersion() {
        String query = "SELECT db_version FROM app_config; ";
        return helper.getInt(query);
    }
    
    
}
