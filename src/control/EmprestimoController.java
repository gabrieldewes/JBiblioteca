/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EmprestimoDAO;
import dao.ExemplarDAO;
import dao.GenericDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Emprestimo;
import model.Exemplar;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

/**
 *
 * @author gabriel
 */
public class EmprestimoController {
    
    private static EmprestimoController instance;
    
    private static EmprestimoDAO emprestimoDao;
    private static ExemplarDAO exemplarDao;
    private static GenericDAO genericDao;
    
    public EmprestimoController() {
        emprestimoDao = EmprestimoDAO.getInstance();
        exemplarDao = ExemplarDAO.getInstance();
        genericDao = GenericDAO.getInstance();
    }
    
    public static EmprestimoController getInstance() {
        if (instance == null) 
            instance = new EmprestimoController();
        return instance;
    }
    
    public boolean Salvar(int id_pessoa, List<Exemplar> exemplares, LocalDateTime inicio, LocalDateTime fim) {
        if (!exemplares.isEmpty()) {
            if (id_pessoa != 0) {
                
                boolean pessoaPossuiEmpPendente = genericDao.restrict("emprestimo", "id_pessoa", id_pessoa);
                boolean prosseguir;
                
                if (pessoaPossuiEmpPendente) {
                    int result = JOptionPane
                            .showConfirmDialog(null, 
                                    "Esta pessoa possui empréstimos pendentes.\r\n\r\nDeseja prosseguir com empréstimo?", 
                                    "Atenção", 
                                    JOptionPane.WARNING_MESSAGE, 
                                    JOptionPane.OK_CANCEL_OPTION);
                    
                    prosseguir = result == JOptionPane.OK_OPTION;
                } else {
                    prosseguir = true;
                }
                
                if (prosseguir) {
                    ArrayList<Integer> id_exemplar = new ArrayList<>();
                    exemplares.stream().forEach((e) -> {
                        id_exemplar.add(e.getId_exemplar());
                    });
                    Emprestimo e = new Emprestimo(0, id_pessoa, id_exemplar, inicio, fim);
                    int id = emprestimoDao.save(e);
                    if (id != 0) {
                        e.setId_emprestimo(id);
                        if (emprestimoDao.saveForeignBatch(e)) {
                            try {
                                exemplarDao = ExemplarDAO.getInstance();
                                exemplarDao.setSituation(id_exemplar, "Alugado");
                            } catch (Exception e1) {}
                            return true;
                        }
                    }
                }      
            
            } else JOptionPane.showMessageDialog(null, "Selecione uma pessoa. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Selecione ao menos um exemplar. ", "Atenção", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean Renovar(int id, int plus_days) {
        Emprestimo e = emprestimoDao.get(id);
        if (e != null) {
            LocalDateTime hoje = new LocalDateTime( System.currentTimeMillis() );
            LocalDateTime fim = new LocalDateTime( e.getData_fim() );
            int dias = Days.daysBetween(hoje, fim).getDays();
            dias=dias*-1;
            if (dias > 0)
                e.setData_fim(hoje.plusDays(plus_days));
            else
                e.setData_fim(fim.plusDays(plus_days));
            return emprestimoDao.update(e);
        }
        return false;
    }
    
    public Emprestimo Pegar(int id) {
        return emprestimoDao.get(id);
    }
    
    public boolean Apagar(int id_emprestimo) {
        Emprestimo e = emprestimoDao.get(id_emprestimo);
        if (e != null) {
            if (emprestimoDao.deleteForeign(id_emprestimo)) {
                if (emprestimoDao.delete(id_emprestimo)) {
                    try {
                        exemplarDao = ExemplarDAO.getInstance();
                        exemplarDao.setSituation(e.getId_exemplar(), "");
                    } catch (Exception e1) {}
                    return true;
                } else JOptionPane.showMessageDialog(null, "Ocorreu um erro ao prosseguir com devolução do empréstimo.\r\nTente novamente ou contate o desenvolvedor caso o erro persistir.", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Ocorreu um erro ao prosseguir com devolução do empréstimo.\r\nTente novamente ou contate o desenvolvedor caso o erro persistir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Ocorreu um erro interno. Não retornou empréstimo para o ID "+ id_emprestimo +".", "Atenção", JOptionPane.WARNING_MESSAGE);
           
        return false;
    }  
    
    public TableModel Listar(String busca) {
        TableModel tb;
        if (!"".equals(busca)) {
            tb = humanReadableDates(emprestimoDao.list(busca));
        }
        else {
            tb = humanReadableDates(emprestimoDao.list(""));
        }
        return tb;
    }
    
    private TableModel humanReadableDates( TableModel tb ) {
        for (int i=0; i<tb.getRowCount(); i++) {
            String in = tb.getValueAt(i, 3).toString();
            String out = tb.getValueAt(i, 4).toString();
            int diff = Integer.valueOf(tb.getValueAt(i, 5).toString());
            
            LocalDateTime dateIn = new LocalDateTime(in);
            LocalDateTime dateToOut = new LocalDateTime(out);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            tb.setValueAt(sdf.format(dateIn.toDate()), i, 3);
            tb.setValueAt(sdf.format(dateToOut.toDate()), i, 4);
            tb.setValueAt(getStringDiff(diff), i, 5);
        }
        return tb;
    }
    
    private String getStringDiff(int diff) {
        if (diff == 0) {
            return "Vence hoje";
        }
        if (diff > 0) {
            return "Atraso " + diff + (diff == 1 || diff == -1 ? " dia" : " dias");
        }
        if (diff < 0) {
            return "Restam " + (diff * -1) + (diff == 1 || diff == -1 ? " dia" : " dias");
        }
        return "";
    }
        
}
