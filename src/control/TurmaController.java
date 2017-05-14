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
    
    public static TurmaController INSTANCE = new TurmaController();
    
    private TurmaDAO dao = TurmaDAO.INSTANCE;
        
    public TurmaController() {}
    
    public TableModel Listar() {
        TableModel tb = dao.list();
        return tb;
    }
    
    public TableModel ListarBusca(String busca) {
        TableModel tb = dao.listLike(busca);
        return tb;
    }
    
    public boolean Salvar(String nome, String ano) {
        if ( ! ("".equals(nome) && "".equals(ano)) ) {
            Turma t = new Turma(0, nome, ano);
            if (dao.save(t)) {
                return true;
            }
            else {System.out.println("Não salvou. ");}
        }
        else {System.out.println("Campos nulos no controller de turmas. ");}
        return false;
    }
    
    public boolean Alterar(Turma t) {
        return dao.update(t);
    }
    
    public boolean Apagar(int id) {
        if (!dao.restrict(id)) {
            dao = new TurmaDAO();
            return dao.delete(id);
        }
        return false;
    }
    
    public Turma Pegar(int id) {
        return dao.get(id);
    }
    
    public ArrayList<Turma> ArrayTurma() {
        return dao.getArray();
    }
    
    public int AlterarTurmaLote(int turmaDeId, int turmaParaId) {
        return dao.updateLote(turmaDeId, turmaParaId);
    }
    
}
