package com.jbiblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import com.jbiblioteca.data.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.jbiblioteca.model.Turma;

/**
 *
 * @author Dewes
 */
public class TurmaDAO /*implements DAO<Turma>*/ {
    private final Logger log = Logger.getLogger(TurmaDAO.class.getName());
    
    public static TurmaDAO instance;
    
    private static DBHelper helper;
    private static PreparedStatement stmt;
    
    public TurmaDAO() {
        helper = DBHelper.getInstance();
    }
    
    public static TurmaDAO getInstance() {
        if (instance == null)
            instance = new TurmaDAO();
        return instance;
    }
    
    public boolean save(Turma t) {
        String query = "INSERT INTO turma (nome,ano) VALUES ('"+ t.getNome() +"', ''); ";
        return helper.rawSQL(query);
    }
    
    public boolean update(Turma t) {
        String query = "UPDATE turma SET nome = '"+ t.getNome() +"' WHERE id_turma = '"+ t.getId_turma() +"'; ";
        return helper.rawSQL(query);
    }
    
    public int updateLote(int turmaDeId, int turmaParaId) {
        String query = "UPDATE pessoa SET id_turma = "+ turmaParaId +" WHERE id_turma = "+ turmaDeId +";";
        return helper.rawUpdate(query);
    }
    
    public boolean restrict(int id) {
        String restrict = "SELECT id_turma FROM pessoa WHERE id_turma="+ id +"; ";
        return helper.rowExists(restrict);
    }
    
    //@Override
    public boolean delete(int id) {
        String query = "DELETE FROM turma WHERE id_turma="+ id +"; ";
        return helper.rawSQL(query);
    } 
    
    public Turma get(int id) {
        final String select = "SELECT * FROM turma WHERE id_turma=?; ";
        Turma t=null;
        ResultSet rs;
        try {
            stmt = helper.prepareStatement(select);
            stmt.setInt(1, id);
            log.log(Level.INFO, select);
            rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    t = new Turma( 
                        rs.getInt("id_turma"),  
                        rs.getString("nome") );
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    public TableModel list() {
        String query = "SELECT t.id_turma, t.nome AS 'Nome' FROM turma t; ";
        return helper.getTableModel(query);
    }
    
    public TableModel listLike(String str) {
        String query = "SELECT t.id_turma, t.nome AS 'Nome' FROM turma t WHERE "
                + " t.nome LIKE '%"+ str +"%' OR t.nome LIKE '"+ str +"%' OR t.nome LIKE '%"+ str +"'; ";
        return helper.getTableModel(query);
    }
    
    public ArrayList<Turma> getArray() {
        final String query = "SELECT * FROM turma; ";
        ArrayList<Turma> turmas = new ArrayList<>();
        Turma t;
        try {
            stmt = helper.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    t = new Turma( 
                        rs.getInt("id_turma"),  
                        rs.getString("nome") );
                    turmas.add(t);
                }
            } 
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return turmas;
    }
    
}
