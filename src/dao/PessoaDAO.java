/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import database.DBHelper;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author Dewes
 */
public class PessoaDAO {
    
    private static DBHelper helper;
    private static PreparedStatement stmt;
    
    public PessoaDAO() {
        try {
            helper = new DBHelper();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean save(Pessoa p) {
        final String query = "INSERT INTO pessoa (codigo, nome, cargo, id_turma) VALUES "
                + "('"+ p.getCodigo() +"', "
                + "'"+ p.getNome() +"', "
                + "'"+ p.getCargo() +"', "
                + p.getId_turma() +"); ";
        return helper.rawSQL(query);
    }
    
    public boolean update(Pessoa p) {
        final String update = "UPDATE pessoa SET " + 
                "nome='"+ p.getNome() +
                "', codigo='"+ p.getCodigo() +
                "', cargo='"+ p.getCargo() +
                "', id_turma="+ p.getId_turma()+
                " WHERE id_pessoa="+ p.getId_pessoa() +"; ";
        return helper.rawSQL(update);
    }
    
    public boolean delete(int id) {
        final String query = "DELETE FROM pessoa WHERE id_pessoa="+ id +"; ";
        return helper.rawSQL(query);
    }
    
    public Pessoa get(int id) {
        final String query = "SELECT * FROM pessoa WHERE id_pessoa=?; ";
        Pessoa p = null;
        try {
            stmt = helper.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    p = new Pessoa( 
                        rs.getInt("id_pessoa"), 
                        rs.getInt("id_turma"),
                        rs.getString("codigo"),
                        rs.getString("nome"), 
                        rs.getString("cargo"));
                }
            }
            if (p!=null) 
                System.out.println("Return "+ p.toString() +" from query "+ query);
            stmt.close();
            helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public boolean exists(String codigo) {
        final String query = "SELECT * FROM pessoa WHERE codigo='"+ codigo +"'; ";
        return helper.rowExists(query);
    }
    
    public TableModel list() {
        final String query = "SELECT p.id_pessoa, p.codigo AS 'Código', p.nome AS 'Nome', t.nome as 'Turma', p.cargo as 'Cargo' FROM pessoa p "
                + " LEFT JOIN turma t ON p.id_turma = t.id_turma ORDER BY p.nome ASC; ";
        return helper.getTableModel(query);
    }
    
    public TableModel listLike(String str) {
        String query = "SELECT p.id_pessoa, p.codigo AS 'Código', p.nome AS 'Nome', t.nome as 'Turma', p.cargo as 'Cargo' "
                + "FROM pessoa p "
                + "LEFT JOIN turma t ON p.id_turma = t.id_turma WHERE "
                + "p.nome LIKE '%"+ str +"%' OR p.nome LIKE '"+ str +"%' OR p.nome LIKE '%"+ str +"' OR "
                + "p.codigo LIKE '%"+ str +"%' OR p.codigo LIKE '"+ str +"%' OR p.codigo LIKE '%"+ str +"' OR "
                + "t.nome LIKE '%"+ str +"%' OR t.nome LIKE '"+ str +"%' OR t.nome LIKE '%"+ str +"' OR "
                + "p.cargo LIKE '%"+ str +"%' OR p.cargo LIKE '"+ str +"%' OR p.cargo LIKE '%"+ str +"' "
                + "ORDER BY p.nome ASC; ";
        
        return helper.getTableModel(query);
    }
    
    public ArrayList<Pessoa> getArray(String str) {
        String query;
        if ("".equals(str))
            query = "SELECT * FROM pessoa WHERE id_pessoa NOT IN (SELECT id_pessoa FROM emprestimo); ";
        else
            query = "SELECT * FROM pessoa p "
                + " LEFT JOIN turma t ON p.id_turma = t.id_turma WHERE "
                + " p.nome LIKE '%"+ str +"%' OR p.nome LIKE '"+ str +"%' OR p.nome LIKE '%"+ str +"' OR "
                + " p.codigo LIKE '%"+ str +"%' OR p.codigo LIKE '"+ str +"%' OR p.codigo LIKE '%"+ str +"' OR "
                + " t.nome LIKE '%"+ str +"%' OR t.nome LIKE '"+ str +"%' OR t.nome LIKE '%"+ str +"' "
                + "AND id_pessoa NOT IN (SELECT id_pessoa FROM emprestimo) ORDER BY p.nome ASC; ";
        
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Pessoa p;
        try {
            stmt = helper.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    p = new Pessoa( 
                        rs.getInt("id_pessoa"),
                        rs.getInt("id_turma"),  
                        rs.getString("codigo"), 
                        rs.getString("nome"),
                        rs.getString("cargo"));
                    pessoas.add(p);
                }
            } 
            System.out.println("Return "+ pessoas.size() +" items from query "+ query);
            stmt.close();
            helper.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoas;
    }
    
}
