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
    
    static DBHelper helper;
    static PreparedStatement stmt;
    
    public ExemplarDAO() {
        try {
            helper = new DBHelper();
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        return false;
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
        Livro l=null;
        final String query = "SELECT * FROM exemplar e " +
                    " INNER JOIN livro l ON e.id_livro = l.id_livro " +
                    " WHERE e.id_exemplar=?; ";
        try {
            stmt = helper.prepareStatement(query);
            stmt.setInt(1, id);
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
                                rs.getString("titulo"),
                                rs.getString("autor"))
                    );
                }
            }
            if (e!=null)
                System.out.println("Return "+ e.toString() +" from query "+ query);
            stmt.close();
            helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    
    public boolean exists(String codigo) {
        final String query = "SELECT * FROM exemplar WHERE codigo='"+ codigo +"'; ";
        return helper.rowExists(query);
    }
    
    public TableModel list() {
        final String query = "SELECT e.id_exemplar, e.codigo AS 'Código', l.titulo AS 'Título', e.coordenada_x AS 'X', e.coordenada_y AS 'Y', e.disponivel AS 'Status' " +
                "FROM exemplar e " +
                "INNER JOIN livro l ON e.id_livro = l.id_livro "+
                "ORDER BY l.titulo ASC; ";
        return helper.getTableModel(query);
    }
    
    public TableModel listLike(String like) {
        final String query = 
                "SELECT e.id_exemplar, e.codigo AS 'Código', l.titulo AS 'Título', e.coordenada_x AS 'X', e.coordenada_y AS 'Y', e.disponivel AS 'Status' "+ 
                "FROM exemplar e "+
                    "INNER JOIN livro l ON e.id_livro = l.id_livro " +
                "WHERE l.titulo LIKE '%"+ like +"%' OR l.titulo LIKE '"+ like +"%' OR l.titulo LIKE '%"+ like +"' OR "+
                       "l.autor LIKE '%"+ like +"%' OR l.autor LIKE '"+ like +"%' OR l.autor LIKE '%"+ like +"' OR "+
                      "e.codigo LIKE '%"+ like +"%' OR e.codigo LIKE '"+ like +"%' OR e.codigo LIKE '%"+ like +"' "+
                "ORDER BY l.titulo ASC; ";
        return helper.getTableModel(query);
    }
    
    public ArrayList<Exemplar> getArray(String like) {
        String query;
        if ("".equals(like))
            query = 
                "SELECT * FROM exemplar e "
              + "INNER JOIN livro l ON e.id_livro = l.id_livro "
              + "WHERE e.disponivel='' ORDER BY l.titulo ASC; ";
        else
            query = "SELECT * FROM exemplar e "
                + " INNER JOIN livro l ON e.id_livro = l.id_livro WHERE  "
                + " l.titulo LIKE '%"+ like +"%' OR l.titulo LIKE '"+ like +"%' OR l.titulo LIKE '%"+ like +"' OR "
                + " l.autor LIKE '%"+ like +"%' OR l.autor LIKE '"+ like +"%' OR l.autor LIKE '%"+ like +"' OR "
                + " e.codigo LIKE '%"+ like +"%' OR e.codigo LIKE '"+ like +"%' OR e.codigo LIKE '%"+ like +"' "
                + " GROUP BY e.id_exemplar  HAVING e.disponivel='' ORDER BY l.titulo ASC; ";
        
        ArrayList<Exemplar> exemplares = new ArrayList<>();
        Exemplar e;
        Livro l;
        try {
            stmt = helper.prepareStatement(query);
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
                                rs.getString("titulo"), 
                                rs.getString("autor"))
                        );
                    exemplares.add(e);
                }
            } 
            System.out.println("Return "+ exemplares.size() +" items from query "+ query);
            stmt.close();
            helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
