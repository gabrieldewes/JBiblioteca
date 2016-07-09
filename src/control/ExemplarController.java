/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ExemplarDAO;
import dao.GenericDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Exemplar;

/**
 *
 * @author gabriel
 */
public class ExemplarController {
    
    static ExemplarDAO dao;
    static GenericDAO gendao;
    
    public static boolean Salvar(int id_l, String codigo, String x, String y) {
        if (id_l != 0) {
            if (!"".equals(codigo)) {
                if (!Existe(codigo)) {
                    Exemplar e = new Exemplar(0, id_l, codigo.replace(" ", ""), "", x.trim(), y.trim());
                    dao = new ExemplarDAO();
                    return dao.save(e);
                } else JOptionPane.showMessageDialog(null, "Este código já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Código não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Não há livros cadastrados!", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Alterar(int id, String codigo, String corredor, String prateleira) {
        if (!"".equals(codigo)) {
            if (id != 0) {
                Exemplar ex = Pegar(id);
                Exemplar e = new Exemplar(id, ex.getId_livro(), codigo, ex.getDisponivel(), corredor, prateleira);
                if (ex.equals(e))
                    return true;
                if (codigo.equals(ex.getCodigo())) {
                    dao = new ExemplarDAO();
                    return dao.update(e);
                }
                else
                    if (!Existe(codigo)) {
                        dao = new ExemplarDAO();
                        return dao.update(e);   
                    } else JOptionPane.showMessageDialog(null, "Este código já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Nenhum exemplar selecionado! ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Código não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Apagar(int id) {
        gendao = new GenericDAO();
        if (!gendao.restrict("emprestimo_livro", "id_exemplar", id)) {
            dao = new ExemplarDAO();
            return dao.delete("id_exemplar", id);
        } else JOptionPane.showMessageDialog(null, "Este exemplar possui empréstimos pendentes.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static TableModel Listar() {
        dao = new ExemplarDAO();
        return dao.list();
    }
    
    public static TableModel Buscar(String str) {
        dao = new ExemplarDAO();
        return dao.listLike(str);
    }
    
    public static Exemplar Pegar(int id) {
        dao = new ExemplarDAO();
        return dao.get(id);
    }
    
    public static boolean Existe(String codigo) {
        dao = new ExemplarDAO();
        return dao.exists(codigo);
    }
    
    public static ArrayList<Exemplar> ArrayExemplar(String column, int id, String like) {
        dao = new ExemplarDAO();
        return dao.getArray(column, id, like);
    }
    
}
