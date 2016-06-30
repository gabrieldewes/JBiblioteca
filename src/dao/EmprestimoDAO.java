/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.ExemplarDAO.helper;
import database.DBHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import model.Emprestimo;
import org.joda.time.LocalDateTime;

/**
 *
 * @author gabriel
 */
public class EmprestimoDAO {
    
    static DBHelper helper;
    static PreparedStatement stmt;

    public EmprestimoDAO() {
        try {
            helper = new DBHelper();
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int save(Emprestimo e) {
        String query = "INSERT INTO emprestimo (id_pessoa, data_inicio, data_fim) VALUES ("
                + "'"+ e.getId_pessoa()+"', "
                + "'"+ e.getData_inicio()+"', "
                + " "+ e.getData_fim()+"); ";
        return helper.rawSQLreturnGenKey(query);
    }
    
    public boolean saveForeignBatch(Emprestimo e) {
        String query = "INSERT INTO emprestimo_livro (id_emprestimo, id_exemplar) VALUES ";
        ArrayList id = e.getId_exemplar();
        String[] query_batch = new String[id.size()];
        for (int i=0; i< id.size(); i++) {
            StringBuilder sb = new StringBuilder(query);
            sb.append(" (").append( e.getId_emprestimo() ).append(", ").append( id.get(i) ).append("); ");
            query_batch[i] = sb.toString();
        }
        return helper.rawLineSQL(query_batch);
    }
    
    public boolean delete(int id) {
        final String query = "DELETE FROM emprestimo WHERE id_emprestimo="+ id +"; ";
        return helper.rawSQL(query);
    }
    
    public boolean deleteForeign(int id) {
        final String query = "DELETE FROM emprestimo_livro WHERE id_emprestimo="+ id +"; ";
        return helper.rawSQL(query);
    }
    
    public Emprestimo get(int id) {
        String query = 
                "SELECT * FROM emprestimo e " +
                    "INNER JOIN emprestimo_livro el ON el.id_emprestimo = e.id_emprestimo " +
                    "INNER JOIN exemplar ex ON ex.id_exemplar = el.id_exemplar " +
                    "INNER JOIN pessoa p ON p.id_pessoa = e.id_pessoa " +
                    "WHERE e.id_emprestimo="+ id +"; ";
        Emprestimo e=null;
        ArrayList<Integer> ids = new ArrayList<>();
        int id_emprestimo=0;
        int id_pessoa=0;
        LocalDateTime data_inicio=null;
        LocalDateTime data_fim=null;
        try {
            stmt = helper.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    id_emprestimo = rs.getInt("id_emprestimo");
                    id_pessoa = rs.getInt("id_pessoa");
                    data_inicio = new LocalDateTime ( rs.getString("data_inicio") );
                    data_fim = new LocalDateTime ( rs.getString("data_fim") );
                    ids.add( rs.getInt("id_exemplar") );
                }
                e = new Emprestimo(id_emprestimo, id_pessoa, ids, data_inicio, data_fim);
            }
            if (e!=null) 
                System.out.println("Return "+ e.toString() +" from query "+ query);
            stmt.close();
            helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public TableModel list(String like) {
        String query;
        if (!"".equals(like))
            query = 
                "SELECT e.id_emprestimo, p.nome AS 'Locador', e.data_inicio AS 'Data' COUNT(el.id_exemplar) AS 'Total de Exemplares' FROM emprestimo e " +
                    "INNER JOIN emprestimo_livro el ON el.id_emprestimo = e.id_emprestimo " +
                    "INNER JOIN exemplar ex ON ex.id_exemplar = el.id_exemplar " +
                    "INNER JOIN pessoa p ON p.id_pessoa = e.id_pessoa " +
                    "GROUP BY e.id_emprestimo; ";
        else
            query = 
                "SELECT e.id_emprestimo, p.nome AS 'Locador', p.codigo AS 'Código', e.data_inicio AS 'Data', COUNT(el.id_exemplar) AS 'Total de Exemplares' FROM emprestimo e " +
                    "INNER JOIN emprestimo_livro el ON el.id_emprestimo = e.id_emprestimo " +
                    "INNER JOIN exemplar ex ON ex.id_exemplar = el.id_exemplar " +
                    "INNER JOIN pessoa p ON p.id_pessoa = e.id_pessoa " +
                    "GROUP BY e.id_emprestimo; ";
        return helper.getTableModel(query);
    }



}
