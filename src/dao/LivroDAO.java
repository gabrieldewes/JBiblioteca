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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import model.Livro;

/**
 *
 * @author gabriel
 */
public class LivroDAO {
    private final Logger log = Logger.getLogger(LivroDAO.class.getName());
    
    private static LivroDAO instance;
    
    private final DBHelper helper;
    private PreparedStatement stmt;
    
    public LivroDAO() {
        helper = DBHelper.getInstance();
    }
    
    public static LivroDAO getInstance() {
        if (instance == null)
            instance = new LivroDAO();
        return instance;
    }
    
    public int save(Livro l) {
        String query = "INSERT INTO livro (isbn, titulo, autor) VALUES ("
                + "'"+ l.getIsbn()+"', "
                + "'"+ l.getTitulo() +"', "
                + "'"+ l.getAutor() +"'); ";
        return helper.rawSQLreturnGenKey(query);
    }
    
    public boolean update(Livro l) {
        String query = "UPDATE livro SET "
                + "isbn='"+ l.getIsbn()+"', "
                + "titulo='"+ l.getTitulo() +"', "
                + "autor='"+ l.getAutor()+"' WHERE id_livro="+ l.getId_livro() +"; ";
        return helper.rawSQL(query);
    }
    
    public boolean delete(int id) {
        final String query = "DELETE FROM livro WHERE id_livro="+ id +"; ";
        return helper.rawSQL(query);
    }
    
    public Livro get(int id) {
        Livro l=null;
        final String query = "SELECT * FROM livro WHERE id_livro=?; ";
        try {
            stmt = helper.prepareStatement(query);
            stmt.setInt(1, id);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    l = new Livro( 
                        rs.getInt("id_livro"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"));
                }
            } 
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public boolean exists(String titulo) {
        final String query = "SELECT * FROM livro WHERE titulo='"+ titulo +"'; ";
        return helper.rowExists(query);
    }
    
    public TableModel list() {
        final String query = 
                "SELECT l.id_livro, l.titulo AS 'Título', l.autor AS 'Autor', COUNT(ex.id_exemplar) AS 'Exemplares' "+
                "FROM livro l " +
                "LEFT JOIN exemplar ex ON ex.id_livro = l.id_livro GROUP BY l.id_livro ORDER BY l.titulo ASC; ";
        return helper.getTableModel(query);
    }
    
    public TableModel listLike(String str) {
        String query = 
                "SELECT l.id_livro, l.titulo AS 'Título', l.autor AS 'Autor', COUNT(ex.id_exemplar) AS 'Exemplares' "+
                "FROM livro l " +
                "LEFT JOIN exemplar ex ON ex.id_livro = l.id_livro " +
                "WHERE titulo LIKE '%"+ str +"%' OR titulo LIKE '"+ str +"%' OR titulo LIKE '%"+ str +"' OR " +
                       "autor LIKE '%"+ str +"%' OR autor LIKE '"+ str +"%' OR autor LIKE '%"+ str +"' " + 
                "GROUP BY l.id_livro ORDER BY l.titulo ASC; ";
        return helper.getTableModel(query);
    }
    
    public ArrayList<Livro> getArray(String like){
        String query;
        if (!"".equals(like) || like != null)
            query = 
                "SELECT *"+
                "FROM livro l " +
                "LEFT JOIN exemplar ex ON ex.id_livro = l.id_livro " +
                "WHERE titulo LIKE '%"+ like +"%' OR titulo LIKE '"+ like +"%' OR titulo LIKE '%"+ like +"' OR " +
                       "autor LIKE '%"+ like +"%' OR autor LIKE '"+ like +"%' OR autor LIKE '%"+ like +"' " + 
                "GROUP BY l.id_livro ORDER BY l.titulo ASC; ";
        else
            query = "SELECT * FROM livro; ";
                
        ArrayList<Livro> livros = new ArrayList<>();
        Livro l;
        try {
            stmt = helper.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    l = new Livro( 
                        rs.getInt("id_livro"),
                        rs.getString("isbn"),  
                        rs.getString("titulo"),  
                        rs.getString("autor"));
                    livros.add(l);
                }
            } 
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return livros;
    }
    
}
