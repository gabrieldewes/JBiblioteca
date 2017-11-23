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
import model.Emprestimo;
import org.joda.time.LocalDateTime;

/**
 *
 * @author gabriel
 */
public class EmprestimoDAO {
    private final Logger log = Logger.getLogger(EmprestimoDAO.class.getName());
    
    private static EmprestimoDAO instance;
    
    private final DBHelper helper;
    private PreparedStatement stmt;

    public EmprestimoDAO() {
        helper = DBHelper.getInstance();
    }
    
    public static EmprestimoDAO getInstance() {
        if (instance == null)
            instance = new EmprestimoDAO();
        return instance;
    }
    
    public int save(Emprestimo e) {
        String query = "INSERT INTO emprestimo (id_pessoa, data_inicio, data_fim) VALUES ("
                + "'"+ e.getId_pessoa()+"', "
                + "'"+ e.getData_inicio()+"', "
                + " '"+ e.getData_fim()+"'); ";
        return helper.rawSQLreturnGenKey(query);
    }
    
    public boolean update(Emprestimo e) {
        String query = "UPDATE emprestimo "
                + "SET id_pessoa="+ e.getId_pessoa()+", "
                + "data_inicio='"+ e.getData_inicio()+"', "
                + "data_fim='"+ e.getData_fim()+"' "
                + "WHERE id_emprestimo="+ e.getId_emprestimo() +"; ";
        return helper.rawSQL(query);
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
            log.log(Level.INFO, query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    id_emprestimo = rs.getInt("id_emprestimo");
                    id_pessoa = rs.getInt("id_pessoa");
                    data_inicio = new LocalDateTime( rs.getString("data_inicio") );
                    data_fim = new LocalDateTime( rs.getString("data_fim") );
                    ids.add( rs.getInt("id_exemplar") );
                }
                e = new Emprestimo(id_emprestimo, id_pessoa, ids, data_inicio, data_fim);
            }                
            stmt.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public TableModel list(String like) {
        String query;
        if (!"".equals(like))
            query = 
                "SELECT e.id_emprestimo, p.nome AS 'Locador', p.codigo AS 'Código', e.data_inicio AS 'Data de Início', e.data_fim as 'Data p/ Devolução', situation as 'Situação', COUNT(el.id_exemplar) AS 'Total de Exemplares' "+
                    "FROM emprestimo e " +
                    "INNER JOIN emprestimo_livro el ON el.id_emprestimo = e.id_emprestimo " +
                    "INNER JOIN exemplar ex ON ex.id_exemplar = el.id_exemplar " +
                    "INNER JOIN pessoa p ON p.id_pessoa = e.id_pessoa " +
                    "WHERE "+
                    "p.nome LIKE '%"+ like +"%' OR p.nome LIKE '"+ like +"%' OR p.nome LIKE '%"+ like +"' OR "+
                    "p.codigo LIKE '%"+ like +"%' OR p.codigo LIKE '"+ like +"%' OR p.codigo LIKE '%"+ like +"' OR "+
                    "ex.codigo LIKE '%"+ like +"%' OR ex.codigo LIKE '"+ like +"%' OR ex.codigo LIKE '%"+ like +"'" +
                    "GROUP BY e.id_emprestimo ";
        else
            query = 
                "SELECT e.id_emprestimo, p.nome AS 'Locador', p.codigo AS 'Código', e.data_inicio AS 'Data de Início', e.data_fim as 'Data p/ Devolução', situation as 'Situação', COUNT(el.id_exemplar) AS 'Total de Exemplares' "+
                    "FROM emprestimo e " +
                    "INNER JOIN emprestimo_livro el ON el.id_emprestimo = e.id_emprestimo " +
                    "INNER JOIN exemplar ex ON ex.id_exemplar = el.id_exemplar " +
                    "INNER JOIN pessoa p ON p.id_pessoa = e.id_pessoa " +
                    "GROUP BY e.id_emprestimo " +
                    "ORDER BY date(e.data_fim) ASC;";
        return helper.getTableModel(query);
    }

    

}
