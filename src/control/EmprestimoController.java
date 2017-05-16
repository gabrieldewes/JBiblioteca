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
                if (!genericDao.restrict("emprestimo", "id_pessoa", id_pessoa)) {
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
                } else JOptionPane.showMessageDialog(null, "Esta pessoa possui empréstimos pendentes. ", "Atenção", JOptionPane.WARNING_MESSAGE);   
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
                } else JOptionPane.showMessageDialog(null, "Erro ao executar devolução de empréstimo. Tente novamente. ", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Erro ao executar devolução de empréstimo. Tente novamente", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else JOptionPane.showMessageDialog(null, "Ocorreu um erro interno. Não retornou empréstimo para o ID "+ id_emprestimo +".", "Atenção", JOptionPane.WARNING_MESSAGE);
           
        return false;
    }  
    
    public TableModel Listar(String busca) {
        TableModel tb;
        if (!"".equals(busca)) {
            tb = UpdateTablemodel(emprestimoDao.list(busca));
        }
        else {
            tb = UpdateTablemodel(emprestimoDao.list(""));
        }
        return tb;
    }
    
    private TableModel UpdateTablemodel( TableModel tb ) {
        LocalDateTime hoje = new LocalDateTime(System.currentTimeMillis());
        for (int i=0; i<tb.getRowCount(); i++){
            String in = tb.getValueAt(i, 3).toString();
            String out = tb.getValueAt(i, 4).toString();
            LocalDateTime inicio = new LocalDateTime(in);
            LocalDateTime fim = new LocalDateTime(out);
            tb.setValueAt(""+inicio.getDayOfMonth()+"/"+inicio.getMonthOfYear()+"/"+inicio.getYear()+"", i, 3);
            tb.setValueAt(""+fim.getDayOfMonth()+"/"+fim.getMonthOfYear()+"/"+fim.getYear()+"", i, 4);

            Period p = new Period(hoje, fim);
            int dias = p.getDays();
            int horas = p.getHours();
            int month = p.getMonths();
            //System.out.println(dias+":"+horas+" :: ENTRE AS DATAS "+fim.toString()+" :: "+hoje.toString());
            if (dias < 1) {
                if (dias == 0) {
                    tb.setValueAt("Atraso "+horas*-1+"h", i, 5); 
                    if (horas > 0)
                        tb.setValueAt("Restam "+horas+"h", i, 5);     
                }
                else
                    tb.setValueAt("Atraso "+dias*-1+"d:"+horas*-1+"h", i, 5); 

            }
            /*else 
                if (month >= 0)
                    tb.setValueAt("Restam "+dias+"d:"+horas+"h", i, 5); 
                else
                    tb.setValueAt("Restam "+month+" meses", i, 5); */
        }
        return tb;
    }
        
}
