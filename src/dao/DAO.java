/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Dewes
 */
public interface DAO {
    public boolean save(Object obj);
    public boolean update(Object obj);
    public boolean delete(int id);
    public Object get(int id);
    public TableModel getAll(String like);
    public ArrayList<Object> getArray(String like);
    
}
