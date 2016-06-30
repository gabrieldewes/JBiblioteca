/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBHelper;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class GenericDAO {
    
    static DBHelper helper;
    
    public GenericDAO() {
        try {
            helper = new DBHelper();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean restrict(String table, String column, int id) {
        String restrict = "SELECT * FROM "+ table +" WHERE "+ column +"="+ id +"; ";
        return helper.rowExists(restrict);
    }
    
    public boolean delete(String table, String column, int id) {
        String query = "DELETE FROM "+ table +" WHERE "+ column +"="+ id +"; ";
        return helper.rawSQL(query);
    }
    
}
