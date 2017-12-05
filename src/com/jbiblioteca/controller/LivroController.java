/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.controller;

import com.jbiblioteca.dao.ExemplarDAO;
import com.jbiblioteca.dao.GenericDAO;
import com.jbiblioteca.dao.LivroDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import com.jbiblioteca.model.Exemplar;
import com.jbiblioteca.model.Livro;

/**
 *
 * @author gabriel
 */
public class LivroController {
    
    private static LivroController instance;
           
    private static LivroDAO livroDao;
    private static ExemplarDAO exemplarDao;
    
    public LivroController() {
        livroDao = LivroDAO.getInstance();
        exemplarDao = ExemplarDAO.getInstance();
    }
    
    public static LivroController getInstance() {
        if (instance == null)
            instance = new LivroController();
        return instance;
    }
    
    public boolean Salvar(String codigo, String isbn, String titulo, String autor, String x, String y) {
        if (!"".equals(titulo)) {
            if (!"".equals(codigo)) {
                if (!Existe(titulo)) {
                    if (!exemplarDao.exists(codigo)) {
                        Livro l = new Livro(0, isbn, titulo.trim(), autor.trim());
                        Exemplar e = new Exemplar(0, 0, codigo.replace(" ", ""), "", x.trim(), y.trim());
                        int id = livroDao.save(l);
                        e.setIdLivro(id);
                        if (e.getIdLivro() != 0)
                            return exemplarDao.save(e);
                        else JOptionPane.showMessageDialog(null, "Não foi possível salvar. Tente novamente", "Atenção", JOptionPane.WARNING_MESSAGE);
                    } else JOptionPane.showMessageDialog(null, "Este código já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Este título já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Código não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Título não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Alterar(Livro ex, String isbn, String titulo, String autor) {
        if (!"".equals(titulo)) {
            if (!ex.equals( new Livro(ex.getId_livro(), isbn, titulo, autor) )) {
                if (!ex.getTitulo().equals(titulo)) {
                    if (!Existe(titulo)) {
                        ex.setAutor(autor);
                        ex.setTitulo(titulo);
                        return livroDao.update(ex);
                    } else JOptionPane.showMessageDialog(null, "Este título já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    ex.setAutor(autor);
                    return livroDao.update(ex);
                }
            } else return true;
        } else JOptionPane.showMessageDialog(null, "Título não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Apagar(int id) {
        if (!exemplarDao.checkExemplarEmprestimoByLivro(id)) {
            if (exemplarDao.delete("id_livro", id)) {
                return livroDao.delete(id);
            }
            
        } else JOptionPane.showMessageDialog(null, "Este título possui exemplares com empréstimos pendentes.", "Atenção", JOptionPane.WARNING_MESSAGE);
      return false;  
    }
    
    public TableModel Listar() {
        return livroDao.list();
    }
    
    public TableModel Buscar(String str) {
        return livroDao.listLike(str);
    }
    
    public Livro Pegar(int id) {
        return livroDao.get(id);
    }
    
    public boolean Existe(String codigo) {
        return livroDao.exists(codigo);
    }
    
    public List<Livro> ArrayLivro(String like) {
        return livroDao.getArray(like);
    }
    
}