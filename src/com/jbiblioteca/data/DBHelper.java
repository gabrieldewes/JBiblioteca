package com.jbiblioteca.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.sqlite.SQLiteConnection;

/**
 *
 * @author Dewes
 */
public class DBHelper extends SQLiteConnection {
    private final Logger log = Logger.getLogger(DBHelper.class.getName());
    
    private static DBHelper instance;
    
    private static final String DB_DRIVER = "jdbc:sqlite:";
    private static final String DB_PATH = Database.DATABASE.getAbsolutePath();
    
    public DBHelper() throws SQLException {
        super(DB_DRIVER, DB_PATH);
    }
    
    public static DBHelper getInstance() {
        if (instance == null)
            try {
                instance = new DBHelper();
            } catch (SQLException ex) {}
        return instance;
    }
    
    public void onUpgrade(DBHelper db, int oldVersion, int newVersion) {
        String vers[];
        try {
            for (int i=oldVersion; i<=newVersion; i++) {
                vers = DBUtil.selectScript(i);
                if (vers != null)
                    this.addColumn(db, vers[0], vers[1], vers[2], vers[3]);
            }
            db.rawSQL("UPDATE app_config SET db_version=" + newVersion + ";");
        } catch (Exception e) {}
    }
    
    private void addColumn(DBHelper db, String table, String column, String type, String value) {
        try {
            db.rawSQL("ALTER TABLE " + table + " ADD " + column + " " + type + ";");
            
            if (value != null && !value.isEmpty()) {
                
                if ( type.equals("TEXT") ) {
                    value = "\'" + value + "\'";
                }
                db.rawSQL("UPDATE " + table + " SET " + column + " = " + value + ";");
            }
        } catch (Exception e) {}
    }
 
    public boolean rawSQL(String query) {
        try {
            try (PreparedStatement stmt = this.prepareStatement(query)) {
                log.log(Level.INFO, query);
                stmt.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public TableModel getTableModel(String query) {
        TableModel tb = null;
        try {
            try (PreparedStatement stmt = this.prepareStatement(query)) {
                log.log(Level.INFO, query);
                ResultSet rs = stmt.executeQuery();
                tb = DbUtils.resultSetToTableModel(rs);
            }
        } 
        catch (SQLException ex) { 
            log.log(Level.SEVERE, null, ex);
        }
        return tb;
    }
    
    public boolean rowExists(String query) {
        boolean exists = false;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) exists = true;
        } 
        catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return exists;
    }
    
    public int rawSQLreturnGenKey(String query) {
        int id = 0;
        try {
            PreparedStatement stmt = this.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            log.log(Level.INFO, query);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int getSqliteSequence(String table) {
        int id = 0;
        String query = "SELECT * FROM sqlite_sequence WHERE name='" + table + "';";
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("seq");
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void rawExternalSQL(String file) {
        try {
            Statement stmt = this.createStatement();
            String line;
            try (BufferedReader input = new BufferedReader( new FileReader( file ) )) {
                while ((line = input.readLine()) != null) {
                    stmt.executeUpdate(line);
                    log.log(Level.INFO, line);
                }
            }
        }
        catch (SQLException | IOException err) {
        }

    }
    
    public boolean rawLineSQL(String[] query) {
        try {
            Statement stmt = this.createStatement();
            for (String line : query) {
                log.log(Level.INFO, line);
                stmt.executeUpdate(line);
            }
            return true;
        }
        catch (SQLException err) {
        }
        return false;
    }
    
    public String getString(String query) {
        String s = null;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s = rs.getString(1);
        } 
        catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public int getInt(String query) {
        int s = 0;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s = rs.getInt(1);
        } 
        catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public double getDouble(String query) {
        double s = 0;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s = rs.getDouble(1);
        } 
        catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public boolean getBoolean(String query) {
        boolean s = false;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s = rs.getBoolean(1);
        } 
        catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public int rawUpdate(String query) {
        int s = 0;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            log.log(Level.INFO, query);
            s = stmt.executeUpdate();   
        } 
        catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
}
