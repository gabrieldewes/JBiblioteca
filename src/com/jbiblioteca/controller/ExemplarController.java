/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.controller;

import com.jbiblioteca.dao.ExemplarDAO;
import com.jbiblioteca.dao.GenericDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import com.jbiblioteca.model.Exemplar;

/**
 *
 * @author gabriel
 */
public class ExemplarController {
    
    private static ExemplarController instance;
    
    private static ExemplarDAO exemplarDao;
    private static GenericDAO genericDao;
    
    public ExemplarController() {
        exemplarDao = ExemplarDAO.getInstance();
        genericDao = GenericDAO.getInstance();
    }
    
    public static ExemplarController getInstance() {
        if (instance == null)
            instance = new ExemplarController();
        return instance;
    }
    
    public boolean Salvar(int id_l, String codigo, String x, String y) {
        if (id_l != 0) {
            if (!"".equals(codigo)) {
                if (!Existe(codigo)) {
                    Exemplar e = new Exemplar(0, id_l, codigo.replace(" ", ""), "", x.trim(), y.trim());
                    return exemplarDao.save(e);
                } else JOptionPane.showMessageDialog(null, "Este código já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Código não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Não há livros cadastrados!", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Alterar(int id, String codigo, String corredor, String prateleira) {
        if (!"".equals(codigo)) {
            if (id != 0) {
                Exemplar ex = Pegar(id);
                Exemplar e = new Exemplar(id, ex.getIdLivro(), codigo, ex.getDisponivel(), corredor, prateleira);
                if (ex.equals(e))
                    return true;
                if (codigo.equals(ex.getCodigo())) {
                    return exemplarDao.update(e);
                }
                else
                    if (!Existe(codigo)) {
                        return exemplarDao.update(e);   
                    } else JOptionPane.showMessageDialog(null, "Este código já está cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Nenhum exemplar selecionado! ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Código não pode ser em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Apagar(int id) {
        if (!genericDao.restrict("emprestimo_livro", "id_exemplar", id)) {
            return exemplarDao.delete("id_exemplar", id);
        } else JOptionPane.showMessageDialog(null, "Este exemplar possui empréstimos pendentes.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public TableModel Listar() {
        return exemplarDao.list();
    }
    
    public TableModel Buscar(String str) {
        return exemplarDao.listLike(str);
    }
    
    public Exemplar Pegar(int id) {
        return exemplarDao.get(id);
    }
    
    public boolean Existe(String codigo) {
        return exemplarDao.exists(codigo);
    }
    
    public ArrayList<Exemplar> ArrayExemplar(String column, int id, String like) {
        return exemplarDao.getArray(column, id, like);
    }
    
}
