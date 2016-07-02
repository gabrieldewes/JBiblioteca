/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.GenericDAO;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import dao.PessoaDAO;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author Dewes
 */
public class PessoaController {
    
    static PessoaDAO dao;
    
    public static boolean Salvar(int id_turma, String codigo, String nome, String cargo) {
        if (!"".equals(nome) ) {
            if (!"".equals(codigo)) {
                if (!"".equals(cargo)) {
                    if (!PessoaController.Existe(codigo)) {
                        Pessoa p = new Pessoa(0, id_turma, codigo.replace(" ", ""), nome.trim(), cargo.trim());
                        dao = new PessoaDAO();
                        return dao.save(p);
                    } else JOptionPane.showMessageDialog(null, "Este código já esta cadastrado. ", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Cargo precisa ser selecionado. ", "Atenção", JOptionPane.WARNING_MESSAGE);   
            } else JOptionPane.showMessageDialog(null, "Código não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Nome não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Alterar(Pessoa ex, int id_turma, String codigo, String nome, String cargo) {
        if (!"".equals(nome) ) {
            if (!"".equals(codigo)) {
                Pessoa p = new Pessoa( ex.getId_pessoa(), id_turma, codigo.replace(" ", ""), nome.trim(), cargo.trim() );
                if (!ex.equals(p)) {
                    if (!ex.getCodigo().equals( codigo )) {
                        if (!PessoaController.Existe(codigo)) {
                            dao = new PessoaDAO();
                            return dao.update(p);
                        } else JOptionPane.showMessageDialog(null, "Este código já esta cadastrado. ", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        dao = new PessoaDAO();
                        return dao.update(p);
                    }
                } else return true;
            } else JOptionPane.showMessageDialog(null, "Código não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Nome não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Apagar(int id) {
        GenericDAO gendao = new GenericDAO();
        if (!gendao.restrict("emprestimo", "id_pessoa", id)) {
            dao = new PessoaDAO();
            return dao.delete(id);
        }
        else JOptionPane.showMessageDialog(null, "Não pode apagar uma pessoa com empréstimos pendentes. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static TableModel Listar() {
        dao = new PessoaDAO();
        return dao.list();
    }
    
    public static TableModel Buscar(String str) {
        dao = new PessoaDAO();
        return dao.listLike(str);
    }
    
    public static Pessoa Pegar(int id) {
        dao = new PessoaDAO();
        return dao.get(id);
    }
    
    public static boolean Existe(String codigo) {
        dao = new PessoaDAO();
        return dao.exists(codigo);
    }
    
    public static ArrayList<Pessoa> ArrayPessoa(String like) {
        dao = new PessoaDAO();
        return dao.getArray(like);
    }
    
}
