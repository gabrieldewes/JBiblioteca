/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.table.TableModel;
import dao.TurmaDAO;
import java.util.ArrayList;
import model.Turma;

/**
 *
 * @author Dewes
 */
public class TurmaController {
    
    static TurmaDAO dao;
    
    public TurmaController() {
        //dao = new TurmaDAO();
    }
    
    public static TableModel Listar() {
        dao = new TurmaDAO();
        TableModel tb = dao.list();
        return tb;
    }
    
    public static TableModel ListarBusca(String busca) {
        dao = new TurmaDAO();
        TableModel tb = dao.listLike(busca);
        return tb;
    }
    
    public static boolean Salvar(String nome, String ano) {
        if ( ! ("".equals(nome) && "".equals(ano)) ) {
            dao = new TurmaDAO();
            Turma t = new Turma(0, nome, ano);
            if (dao.save(t)) {
                return true;
            }
            else {System.out.println("Não salvou. ");}
        }
        else {System.out.println("Campos nulos no controller de turmas. ");}
        return false;
    }
    
    public static boolean Alterar(Turma t) {
        dao = new TurmaDAO();
        return dao.update(t);
    }
    
    public static boolean Apagar(int id) {
        dao = new TurmaDAO();
        if (!dao.restrict(id)) {
            dao = new TurmaDAO();
            return dao.delete(id);
        }
        return false;
    }
    
    public static Turma Pegar(int id) {
        dao = new TurmaDAO();
        return dao.get(id);
    }
    
    public static ArrayList<Turma> ArrayTurma() {
        dao = new TurmaDAO();
        return dao.getArray();
    }
    
}
