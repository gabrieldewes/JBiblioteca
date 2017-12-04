/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.controller;

import javax.swing.table.TableModel;
import com.jbiblioteca.dao.TurmaDAO;
import java.util.ArrayList;
import com.jbiblioteca.model.Turma;

/**
 *
 * @author Dewes
 */
public class TurmaController {
    
    public static TurmaController instance;
    
    private static TurmaDAO turmaDao;
        
    public TurmaController() {
        turmaDao = TurmaDAO.getInstance();
    }
    
    public static TurmaController getInstance() {
        if (instance == null)
            instance = new TurmaController();
        return instance;
    }
    
    public TableModel Listar() {
        TableModel tb = turmaDao.list();
        return tb;
    }
    
    public TableModel ListarBusca(String busca) {
        TableModel tb = turmaDao.listLike(busca);
        return tb;
    }
    
    public boolean Salvar(String nome) {
        if ( !"".equals(nome) ) {
            Turma t = new Turma(0, nome);
            if (turmaDao.save(t)) {
                return true;
            }
            else {System.out.println("Não salvou. ");}
        }
        else {System.out.println("Campos nulos no controller de turmas. ");}
        return false;
    }
    
    public boolean Alterar(Turma t) {
        return turmaDao.update(t);
    }
    
    public boolean Apagar(int id) {
        if (!turmaDao.restrict(id)) {
            return turmaDao.delete(id);
        }
        return false;
    }
    
    public Turma Pegar(int id) {
        return turmaDao.get(id);
    }
    
    public ArrayList<Turma> ArrayTurma() {
        return turmaDao.getArray();
    }
    
    public int AlterarTurmaLote(int turmaDeId, int turmaParaId) {
        return turmaDao.updateLote(turmaDeId, turmaParaId);
    }
    
}
