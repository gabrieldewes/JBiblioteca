/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EmprestimoDAO;
import dao.ExemplarDAO;
import dao.GenericDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Emprestimo;
import model.Exemplar;
import org.joda.time.LocalDateTime;

/**
 *
 * @author gabriel
 */
public class EmprestimoController {
    
    static EmprestimoDAO dao;
    static GenericDAO gendao;
    
    public static boolean Salvar(int id_pessoa, ArrayList<Exemplar> exemplares, LocalDateTime inicio, LocalDateTime fim) {
        if (!exemplares.isEmpty()) {
            if (id_pessoa != 0) {
                gendao=new GenericDAO();
                if (!gendao.restrict("emprestimo", "id_pessoa", id_pessoa)) {
                    ArrayList<Integer> id_exemplar = new ArrayList<>();
                    exemplares.stream().forEach((e) -> {
                        id_exemplar.add(e.getId_exemplar());
                    });
                    Emprestimo e = new Emprestimo(0, id_pessoa, id_exemplar, inicio, fim);
                    dao = new EmprestimoDAO();
                    int id = dao.save(e);
                    if (id != 0) {
                        e.setId_emprestimo(id);
                        dao = new EmprestimoDAO();
                        if (dao.saveForeignBatch(e)) {
                            Runnable t1 = () -> {
                                try {
                                    ExemplarDAO edao = new ExemplarDAO();
                                    edao.setSituation(id_exemplar, "Alugado");
                                } catch (Exception e1) {
                                }
                            };
                            new Thread(t1).start();
                            return true;
                        }
                    }
                } else JOptionPane.showMessageDialog(null, "Esta pessoa possui empréstimos pendentes. ", "Atenção", JOptionPane.WARNING_MESSAGE);   
            } else JOptionPane.showMessageDialog(null, "Selecione uma pessoa. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Selecione ao menos um exemplar. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public static Emprestimo Pegar(int id) {
        dao = new EmprestimoDAO();
        return dao.get(id);
    }
    
    public static boolean Apagar(int id_emprestimo) {
        dao = new EmprestimoDAO();
        Emprestimo e = dao.get(id_emprestimo);
        if (e != null) {
            dao = new EmprestimoDAO();
            if (dao.deleteForeign(id_emprestimo)) {
                dao = new EmprestimoDAO();
                if (dao.delete(id_emprestimo)) {
                    Runnable t1 = () -> {
                        try {
                            ExemplarDAO edao = new ExemplarDAO();
                            edao.setSituation(e.getId_exemplar(), "");
                        } catch (Exception e1) {
                        }
                    };
                    new Thread(t1).start();
                    return true;
                } else JOptionPane.showMessageDialog(null, "Erro ao apagar empréstimo. Tente novamente. ", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Erro ao apagar empréstimo. Tente novamente", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Ocorreu um erro interno. Não retornou empréstimo para o ID "+ id_emprestimo +".", "Atenção", JOptionPane.WARNING_MESSAGE);
           
        return false;
    }    
    public static TableModel Listar(String busca) {
        TableModel tb;
        dao = new EmprestimoDAO();
        if (!"".equals(busca)) {
            tb = dao.list(busca);
            for (int i=0; i<tb.getRowCount(); i++){
                String data = tb.getValueAt(i, 3).toString();
                LocalDateTime ldt = new LocalDateTime(data);
                tb.setValueAt(""+ldt.getDayOfMonth()+"/"+ldt.getMonthOfYear()+"/"+ldt.getYear()+"", i, 3);
            }
        }
        else {
            tb = dao.list("");
            for (int i=0; i<tb.getRowCount(); i++){
                String data = tb.getValueAt(i, 3).toString();
                LocalDateTime ldt = new LocalDateTime(data);
                tb.setValueAt(""+ldt.getDayOfMonth()+"/"+ldt.getMonthOfYear()+"/"+ldt.getYear()+"", i, 3);
            }
        }
        return tb;
    }
    
    
}
