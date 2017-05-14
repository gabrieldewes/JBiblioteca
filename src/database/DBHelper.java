package database;

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
    
    private static final String DB_DRIVER = "jdbc:sqlite:";
    public static final java.io.File DATABASE = new java.io.File(
            System.getProperty("user.home")
            + System.getProperty("file.separator")
            + ".jbiblioteca"
            + System.getProperty("file.separator")
            + "jbiblioteca_db.db");
    
    public DBHelper() throws SQLException {
        super(DB_DRIVER, DATABASE.getAbsolutePath());
    }
    
    public void onUpgrade(DBHelper db, int oldVersion, int newVersion) {
        String vers[];
        try {
            for (int i=oldVersion; i<newVersion; i++) {
                vers = DBUtil.selectScript(i);
                DBUtil.updateTabelasBanco(db, vers[0], vers[1], vers[2], vers[3]);
            }

        } catch (Exception e) {
        }
    }
 
    public boolean rawSQL(String query) {
        try {
            try (PreparedStatement stmt = this.prepareStatement(query)) {
                stmt.executeUpdate();
                System.out.println("Raw query "+ query);
            }
            //this.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public TableModel getTableModel(String query) {
        TableModel tb=null;
        try {
            try (PreparedStatement stmt = this.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                tb = DbUtils.resultSetToTableModel(rs);
                System.out.println("Return "+ tb.getRowCount() +" lines from query "+ query);
            }
            //this.close();
        } 
        catch (SQLException ex) { 
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tb;
    }
    
    public boolean rowExists(String query) {
        boolean exists = false;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) exists = true;
            System.out.println("Return "+ exists +" from query "+ query);
            //this.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }
    
    public int rawSQLreturnGenKey(String query) {
        int id=0;
        try {
            PreparedStatement stmt = this.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
            System.out.println("Return id "+ id +" from query "+ query);
            //this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int getSqliteSequence(String table) {
        int id=0;
        String query = "SELECT * FROM sqlite_sequence WHERE name='"+ table +"'; ";
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("seq");
            //this.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
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
                    System.out.println("Raw external line "+ line);
                }
            }
            //this.close();
        }
        catch (SQLException | IOException err) {
        }

    }
    
    public boolean rawLineSQL(String[] query) {
        try {
            Statement stmt = this.createStatement();
            for (String line : query) {
                stmt.executeUpdate(line);
                System.out.println("Raw line "+ line);
            }
            //this.close();
            return true;
        }
        catch (SQLException err) {
        }
        return false;
    }
    
    public String getString(String query) {
        String s=null;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s=rs.getString(1);
            System.out.println("Return "+ s +" from query "+ query);
            //this.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public int getInt(String query) {
        int s=0;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s=rs.getInt(1);
            System.out.println("Return "+ s +" from query "+ query);
            //this.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public double getDouble(String query) {
        double s=0;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                s=rs.getDouble(1);
            System.out.println("Return "+ s +" from query "+ query);
            //this.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public int rawUpdate(String query) {
        int s=0;
        try {
            PreparedStatement stmt = this.prepareStatement(query);
            s = stmt.executeUpdate();   
            System.out.println("Return "+ s +" from query "+ query);
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
}
