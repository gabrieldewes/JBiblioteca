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
import model.Exemplar;
import model.Livro;

/**
 *
 * @author gabriel
 */
public class ExemplarDAO {
    private final Logger log = Logger.getLogger(ExemplarDAO.class.getName());
    
    private static ExemplarDAO instance;
    
    private final DBHelper helper;
    private PreparedStatement stmt;
    
    public ExemplarDAO() {
        helper = DBHelper.getInstance();
    }
    
    public static ExemplarDAO getInstance() {
        if (instance == null) 
            instance = new ExemplarDAO();
        return instance;
    }
    
    public boolean save(Exemplar e) {
        String query = "INSERT INTO exemplar (codigo, disponivel, coordenada_x, coordenada_y, id_livro) VALUES ("
                + "'"+ e.getCodigo() +"', "
                + "'"+ e.getDisponivel() +"', "
                + "'"+ e.getCoordenada_x() +"', "
                + "'"+ e.getCoordenada_y() +"', "
                + " "+ e.getId_livro() +"); ";
        return helper.rawSQL(query);
    }
    
    public boolean update(Exemplar e) {
        String query = "UPDATE exemplar SET "
                + "codigo='"+ e.getCodigo() +"', "
                + "coordenada_x='"+ e.getCoordenada_x() +"', "
                + "coordenada_y='"+ e.getCoordenada_y() +"' WHERE id_exemplar="+ e.getId_exemplar() +"; ";
        return helper.rawSQL(query);
    }
    
    public boolean delete(String column, int id) {
        final String query = "DELETE FROM exemplar WHERE "+ column +"="+ id +"; ";
        return helper.rawSQL(query);
    }
    
    public boolean checkExemplarEmprestimoByLivro(int id_livro) {
        String query = 
                "SELECT * " +
                "FROM exemplar e " +
                "INNER JOIN livro l ON e.id_livro = l.id_livro " +
                "INNER JOIN emprestimo_livro el ON el.id_exemplar = e.id_exemplar " +
                "WHERE l.id_livro="+ id_livro +"; ";
        return helper.rowExists(query);
    }
    
    public Exemplar get(int id) {
        Exemplar e=null;
        final String query = "SELECT * FROM exemplar e " +
                    " INNER JOIN livro l ON e.id_livro = l.id_livro " +
                    " WHERE e.id_exemplar=?; ";
        try {
            stmt = helper.prepareStatement(query);
            stmt.setInt(1, id);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    e = new Exemplar( 
                        rs.getInt("id_exemplar"), 
                        rs.getInt("id_livro"), 
                        rs.getString("codigo"),
                        rs.getString("disponivel"),
                        rs.getString("coordenada_x"),
                        rs.getString("coordenada_y"),
                            new Livro(
                                rs.getInt("id_livro"), 
                                rs.getString("isbn"),
                                rs.getString("titulo"),
                                rs.getString("autor"))
                    );
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    
    public boolean exists(String codigo) {
        final String query = "SELECT * FROM exemplar WHERE codigo='"+ codigo +"'; ";
        return helper.rowExists(query);
    }
    
    public TableModel list() {
        final String query = "SELECT e.id_exemplar, e.codigo AS 'Código', l.titulo AS 'Título', e.coordenada_x AS 'Corredor', e.coordenada_y AS 'Prateleira', e.disponivel AS 'Status' " +
                "FROM exemplar e " +
                "INNER JOIN livro l ON e.id_livro = l.id_livro "+
                "ORDER BY l.titulo ASC; ";
        return helper.getTableModel(query);
    }
    
    public TableModel listLike(String like) {
        final String query = 
                "SELECT e.id_exemplar, e.codigo AS 'Código', l.titulo AS 'Título', e.coordenada_x AS 'Corredor', e.coordenada_y AS 'Prateleira', e.disponivel AS 'Status' "+ 
                "FROM exemplar e "+
                    "INNER JOIN livro l ON e.id_livro = l.id_livro " +
                "WHERE l.titulo LIKE '%"+ like +"%' OR l.titulo LIKE '"+ like +"%' OR l.titulo LIKE '%"+ like +"' OR "+
                       "l.autor LIKE '%"+ like +"%' OR l.autor LIKE '"+ like +"%' OR l.autor LIKE '%"+ like +"' OR "+
                      "e.codigo LIKE '%"+ like +"%' OR e.codigo LIKE '"+ like +"%' OR e.codigo LIKE '%"+ like +"' "+
                "ORDER BY l.titulo ASC; ";
        return helper.getTableModel(query);
    }
    
    public ArrayList<Exemplar> getArray(String column, int id, String like) {
        String query;
        if (!"".equals(column) && id != 0)
            query = "SELECT * FROM exemplar e "
                    + "INNER JOIN livro l ON e.id_livro = l.id_livro "
                    + "INNER JOIN emprestimo_livro el ON e.id_exemplar = el.id_exemplar "
                    + "WHERE "+ column +"="+ id +" ORDER BY e.codigo ASC; ";
        else if ("".equals(like))
            query = 
                "SELECT * FROM exemplar e "
              + "INNER JOIN livro l ON e.id_livro = l.id_livro "
              + "WHERE id_exemplar NOT IN (SELECT id_exemplar FROM emprestimo_livro) ORDER BY e.codigo ASC; ";
        else if (!"".equals(like))
            query = "SELECT * FROM exemplar e "
                + "INNER JOIN livro l ON e.id_livro = l.id_livro WHERE "
                + "e.codigo LIKE '%"+ like +"%' OR e.codigo LIKE '"+ like +"%' OR e.codigo LIKE '%"+ like +"' OR "
                + "l.titulo LIKE '%"+ like +"%' OR l.titulo LIKE '"+ like +"%' OR l.titulo LIKE '%"+ like +"' OR "
                + "l.autor LIKE '%"+ like +"%' OR l.autor LIKE '"+ like +"%' OR l.autor LIKE '%"+ like +"' "
                + "GROUP BY e.id_exemplar HAVING e.disponivel='' ORDER BY e.codigo ASC; ";
        else
            query = "SELECT * FROM exemplar";
        
        ArrayList<Exemplar> exemplares = new ArrayList<>();
        Exemplar e;
        Livro l;
        try {
            stmt = helper.prepareStatement(query);
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    e = new Exemplar( 
                        rs.getInt("id_exemplar"),
                        rs.getInt("id_livro"),  
                        rs.getString("codigo"), 
                        rs.getString("disponivel"), 
                        rs.getString("coordenada_x"),
                        rs.getString("coordenada_y"),
                            l = new Livro(
                                rs.getInt("id_livro"), 
                                rs.getString("isbn"),
                                rs.getString("titulo"), 
                                rs.getString("autor"))
                        );
                    exemplares.add(e);
                }
            } 
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return exemplares;
    }
    
    public boolean setSituation(ArrayList<Integer> ids, String situation) {
        String query = "UPDATE exemplar SET disponivel='"+ situation +"' WHERE id_exemplar=";
        String[] query_batch = new String[ids.size()];
        for (int i=0; i< ids.size(); i++) {
            StringBuilder sb = new StringBuilder(query);
            sb.append( ids.get(i) ).append(";");
            query_batch[i] = sb.toString();
        }
        return helper.rawLineSQL(query_batch);
    }
    
    
}
