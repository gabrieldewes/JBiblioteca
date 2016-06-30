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
        } else JOptionPane.showMessageDialog(null, "Erro interno. O livro selecionado retornou ID 0.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Alterar(Exemplar e) {
        dao = new ExemplarDAO();
        return dao.update(e);
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
    
    public static ArrayList<Exemplar> ArrayExemplar(String like) {
        dao = new ExemplarDAO();
        return dao.getArray(like);
    }
    
}
