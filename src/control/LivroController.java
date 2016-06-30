/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ExemplarDAO;
import dao.GenericDAO;
import dao.LivroDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Exemplar;
import model.Livro;

/**
 *
 * @author gabriel
 */
public class LivroController {
    
    static LivroDAO dao;
    static ExemplarDAO edao;
    static GenericDAO gendao;
    
    public static boolean Salvar(String codigo, String titulo, String autor, String x, String y) {
        if (!"".equals(titulo)) {
            if (!"".equals(codigo)) {
                if (!Existe(titulo)) {
                    if (!ExemplarController.Existe(codigo)) {
                        Livro l = new Livro(0, titulo.trim(), autor.trim());
                        Exemplar e = new Exemplar(0, 0, codigo.replace(" ", ""), "", x.trim(), y.trim());
                        dao = new LivroDAO();
                        int id = dao.save(l);
                        e.setId_livro(id);
                        edao = new ExemplarDAO();
                        if (e.getId_livro() != 0)
                            return edao.save(e);
                        else JOptionPane.showMessageDialog(null, "Não foi possível salvar. Tente novamente", "Atenção", JOptionPane.WARNING_MESSAGE);
                    } else JOptionPane.showMessageDialog(null, "Este código já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Este título já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Código não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Título não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Alterar(Livro ex, String titulo, String autor) {
        if (!"".equals(titulo)) {
            if (!ex.equals( new Livro(ex.getId_livro(), titulo, autor) )) {
                if (!ex.getTitulo().equals(titulo)) {
                    if (!Existe(titulo)) {
                        ex.setAutor(autor);
                        ex.setTitulo(titulo);
                        dao = new LivroDAO();
                        return dao.update(ex);
                    } else JOptionPane.showMessageDialog(null, "Este título já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    ex.setAutor(autor);
                    dao = new LivroDAO();
                    return dao.update(ex);
                }
            } else return true;
        } else JOptionPane.showMessageDialog(null, "Título não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static boolean Apagar(int id) {
        edao = new ExemplarDAO();
        if (!edao.checkExemplarEmprestimoByLivro(id)) {
            edao = new ExemplarDAO();
            if (edao.delete("id_livro", id)) {
                dao = new LivroDAO();
                return dao.delete(id);
            }
            
        } else JOptionPane.showMessageDialog(null, "Este título possui exemplares com empréstimos pendentes.", "Atenção", JOptionPane.WARNING_MESSAGE);
      return false;  
    }
    
    public static TableModel Listar() {
        dao = new LivroDAO();
        return dao.list();
    }
    
    public static TableModel Buscar(String str) {
        dao = new LivroDAO();
        return dao.listLike(str);
    }
    
    public static Livro Pegar(int id) {
        dao = new LivroDAO();
        return dao.get(id);
    }
    
    public static boolean Existe(String codigo) {
        dao = new LivroDAO();
        return dao.exists(codigo);
    }
    
    public static ArrayList<Livro> ArrayLivro() {
        dao = new LivroDAO();
        return dao.getArray();
    }
    
    
}
