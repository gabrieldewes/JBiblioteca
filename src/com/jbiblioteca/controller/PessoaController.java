/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.controller;

import com.jbiblioteca.dao.GenericDAO;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import com.jbiblioteca.dao.PessoaDAO;
import java.util.ArrayList;
import com.jbiblioteca.model.Pessoa;

/**
 *
 * @author Dewes
 */
public class PessoaController {
    
    private static PessoaController instance;
    
    private static PessoaDAO pessoaDao;
    
    public PessoaController() {
        pessoaDao = PessoaDAO.getInstance();
    }
    
    public static PessoaController getInstance() {
        if (instance == null)
            instance = new PessoaController();
        return instance;
    }
    
    public boolean Salvar(int id_turma, String codigo, String nome) {
        if (!"".equals(nome) ) {
            if (!"".equals(codigo)) {
                if (!this.Existe(codigo)) {
                    Pessoa p = new Pessoa(0, id_turma, codigo.replace(" ", ""), nome.trim());
                    return pessoaDao.save(p);
                } else JOptionPane.showMessageDialog(null, "Este código já esta cadastrado. ", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Código não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Nome não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Alterar(Pessoa ex, int id_turma, String codigo, String nome) {
        if (!"".equals(nome) ) {
            if (!"".equals(codigo)) {
                Pessoa p = new Pessoa( ex.getId_pessoa(), id_turma, codigo.replace(" ", ""), nome.trim() );
                if (!ex.equals(p)) {
                    if (!ex.getCodigo().equals( codigo )) {
                        if (!this.Existe(codigo)) {
                            return pessoaDao.update(p);
                        } else JOptionPane.showMessageDialog(null, "Este código já esta cadastrado. ", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        return pessoaDao.update(p);
                    }
                } else return true;
            } else JOptionPane.showMessageDialog(null, "Código não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Nome não pode estar em branco. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Apagar(int id) {
        GenericDAO gendao = new GenericDAO();
        if (!gendao.restrict("emprestimo", "id_pessoa", id)) {
            return pessoaDao.delete(id);
        }
        else JOptionPane.showMessageDialog(null, "Não pode apagar uma pessoa com empréstimos pendentes. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public TableModel Listar() {
        return pessoaDao.list();
    }
    
    public TableModel Buscar(String str) {
        return pessoaDao.listLike(str);
    }
    
    public Pessoa Pegar(int id) {
        return pessoaDao.get(id);
    }
    
    public boolean Existe(String codigo) {
        return pessoaDao.exists(codigo);
    }
    
    public ArrayList<Pessoa> ArrayPessoa(String like) {
        return pessoaDao.getArray(like);
    }
    
}
