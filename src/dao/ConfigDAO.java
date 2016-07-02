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
        try {
            stmt = helper.prepareStatement(query);
            stmt.executeUpdate();
            helper.close();
            System.out.println("Save config "+ query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public double getTaxaJuros() {
        String query = "SELECT taxa_juros FROM app_config; ";
        double taxa = 0.0;
        try {
            stmt = helper.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                taxa = rs.getDouble("taxa_juros");
            helper.close();
            System.out.println("Return "+ taxa +" from query "+ query);
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taxa;
    }
    
    
}
