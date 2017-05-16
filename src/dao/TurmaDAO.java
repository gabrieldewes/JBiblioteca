package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import database.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Turma;

/**
 *
 * @author Dewes
 */
public class TurmaDAO /*implements DAO<Turma>*/ {
    
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
        String query = "INSERT INTO turma (nome,ano) VALUES ('"+ t.getNome() +"', '"+ t.getAno() +"'); ";
        return helper.rawSQL(query);
    }
    
    public boolean update(Turma t) {
        String query = "UPDATE turma SET nome = '"+ t.getNome() +"', ano = '"+ t.getAno() +"' WHERE id_turma = '"+ t.getId_turma() +"'; ";
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
    
    //@Override
    public Turma get(int id) {
        final String select = "SELECT * FROM turma WHERE id_turma=?; ";
        Turma t=null;
        ResultSet rs;
        try {
            stmt = helper.prepareStatement(select);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    t = new Turma( 
                        rs.getInt("id_turma"),  
                        rs.getString("nome"), 
                        rs.getString("ano") );
                }
            }
            else {
                System.out.println("Não encontrou nada com o ID "+ id);
            } 
            stmt.close();
            //helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    public TableModel list() {
        String query = "SELECT * FROM turma; ";
        return helper.getTableModel(query);
    }
    
    public TableModel listLike(String str) {
        String query = "SELECT * FROM turma WHERE "
                + " nome LIKE '%"+ str +"%' OR nome LIKE '"+ str +"%' OR nome LIKE '%"+ str +"' OR "
                + " ano LIKE '%"+ str +"%' OR ano LIKE '"+ str +"%' OR ano LIKE '%"+ str +"'; ";
        return helper.getTableModel(query);
    }
    
    public ArrayList<Turma> getArray() {
        final String query = "SELECT * FROM turma; ";
        ArrayList<Turma> turmas = new ArrayList<>();
        Turma t;
        try {
            stmt = helper.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    t = new Turma( 
                        rs.getInt("id_turma"),  
                        rs.getString("nome"), 
                        rs.getString("ano") );
                    turmas.add(t);
                }
            } 
            System.out.println("Return "+ turmas.size() +" items from query "+ query);
            stmt.close();
            //helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turmas;
    }
    
}
