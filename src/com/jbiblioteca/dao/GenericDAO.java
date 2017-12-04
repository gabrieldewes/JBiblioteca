/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.dao;

import com.jbiblioteca.data.DBHelper;

/**
 *
 * @author gabriel
 */
public class GenericDAO {
    
    private static GenericDAO instance;
    
    private DBHelper helper = DBHelper.getInstance();
        
    public static GenericDAO getInstance() {
        if (instance == null)
            instance = new GenericDAO();
        return instance;
    }
    
    public boolean save(String table, String column, String content) {
        String query = "INSERT INTO "+table+"("+column+") VALUES ("+content+"); ";
        return helper.rawSQL(query);
    }
    
    public boolean update(String table, String column, String content) {
        String query = "UPDATE "+table+" SET "+column+"="+content+"; ";
        return helper.rawSQL(query);
    }
    
    public boolean restrict(String table, String column, int id) {
        String restrict = "SELECT * FROM "+ table +" WHERE "+ column +"="+ id +"; ";
        return helper.rowExists(restrict);
    }
    
    public String get(String table, String column) {
        String query = "SELECT "+column+" FROM "+table+"; ";
        return helper.getString(query);
    }
    
    public boolean delete(String table, String column, int id) {
        String query = "DELETE FROM "+ table +" WHERE "+ column +"="+ id +"; ";
        return helper.rawSQL(query);
    }
    
}
