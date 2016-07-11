/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import api.BooksService;
import com.google.api.services.books.model.Volume;
import dao.ExemplarDAO;
import dao.GenericDAO;
import dao.LivroDAO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Exemplar;
import model.Livro;
import org.joda.time.LocalDateTime;
import view.EbookFragmentPanel;

/**
 *
 * @author gabriel
 */
public class LivroController {
    
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
    
    static LivroDAO dao;
    static ExemplarDAO edao;
    static GenericDAO gendao;
    static BooksService bs;
    
    public static boolean Salvar(String codigo, String isbn, String titulo, String autor, String x, String y) {
        if (!"".equals(titulo)) {
            if (!"".equals(codigo)) {
                if (!Existe(titulo)) {
                    if (!ExemplarController.Existe(codigo)) {
                        Livro l = new Livro(0, isbn, titulo.trim(), autor.trim());
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
    
    public static boolean Alterar(Livro ex, String isbn, String titulo, String autor) {
        if (!"".equals(titulo)) {
            if (!ex.equals( new Livro(ex.getId_livro(), isbn, titulo, autor) )) {
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
    
    public static ArrayList<Livro> ArrayLivro(String like) {
        dao = new LivroDAO();
        return dao.getArray(like);
    }
    
    public static ArrayList<Volume> ArrayEbook(String query) {
        ArrayList<Volume> volumes=null;
        if (query.trim().length() > 2) {
            try {
                volumes = BooksService.getQueryGoogleBooks(query);
            } catch (Exception ex) {
                Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return volumes;
    }
    
    public static String volumeToString(Volume v) {
        Volume.VolumeInfo volumeInfo = v.getVolumeInfo();
        Volume.SaleInfo saleInfo = v.getSaleInfo();
        LocalDateTime ldt;
        Volume.VolumeInfo.ImageLinks links=null;
        String title="";
        String author="";
        String genr="";
        String identifier="";
        String pageCount="";
        String price="";
        String rating="";
        String total_ratings="";
        String publisher="";
        String description="";
        
        title = ""+v.getVolumeInfo().getTitle()+"";
        if (v.getVolumeInfo().getSubtitle() != null)
            title = title.concat(" - "+ v.getVolumeInfo().getSubtitle());
        title = title.concat("\n");
        java.util.List<String> authors = v.getVolumeInfo().getAuthors();
        if (authors != null && !authors.isEmpty()) {
            for (int i = 0; i < authors.size(); ++i) {
                author = author.concat("\n"+ authors.get(i));
                if (i < authors.size() - 1) {
                    author = author.concat(", ");
                }
            }
        }
        author = author.concat("\n");
        
        links = volumeInfo.getImageLinks();
        
        if (volumeInfo.getPublisher() != null)
            publisher = "\nEditora: "+ volumeInfo.getPublisher();
        if (volumeInfo.getPublishedDate() != null) {
            ldt = new LocalDateTime( volumeInfo.getPublishedDate());
            publisher = publisher.concat("\nPublicado em "+ +ldt.getDayOfMonth()+"/"+ldt.getMonthOfYear()+"/"+ldt.getYear());
        }
        
        if (volumeInfo.getDescription() != null)
            description = "\n\nDescrição: \n"+ volumeInfo.getDescription() +"\n";
        
        java.util.List<String> genrs = volumeInfo.getCategories();
        if (genrs != null && !genrs.isEmpty()) {
            genr = genr.concat("\nGenêro: ");
            if (volumeInfo.getMainCategory() != null)
                genr = genr.concat(volumeInfo.getMainCategory() +", ");
            for (int i = 0; i < genrs.size(); ++i) {
                genr = genr.concat(genrs.get(i));
                if (i < genrs.size() - 1) {
                    genr = genr.concat(", ");
                }
            }
            genr = genr.concat("\n");
        }
        
        if (volumeInfo.getPageCount() != null)
            pageCount = "\n"+volumeInfo.getPageCount()+" páginas\n";

        java.util.List<Volume.VolumeInfo.IndustryIdentifiers> isbn = volumeInfo.getIndustryIdentifiers();
        if (isbn != null && !isbn.isEmpty()) {
            for (Volume.VolumeInfo.IndustryIdentifiers ii:isbn) {
                identifier = identifier.concat(ii.getType()+": "+ ii.getIdentifier()+"\n");
            }
        }
        if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
            int fullRating = (int) Math.round(volumeInfo.getAverageRating());
            rating = "\nAvaliação: ";
            for (int i = 0; i < fullRating; ++i) {
                rating = rating.concat(" * ");
            }
            total_ratings = "\n(" + volumeInfo.getRatingsCount() + " avaliações)\n";
        }
        if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
            double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
            if (save > 0.0) {
                price = price.concat("\nPreço médio: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount())+" ");
            }
            price = price.concat("\nGoogle Books: "
                + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
            if (save > 0.0) {
                price = price.concat("\nVocê ganha: " + CURRENCY_FORMATTER.format(save) + " ("
                    + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")\n");
            }
        }
        String content="";
        if (!"".equals(title))
            content = content.concat(title);
        if (!"".equals(author))
            content = content.concat(author);
        /*if (!"".equals(identifier))
            content = content.concat(identifier);
        if (!"".equals(genr))
            content = content.concat(genr);
        if (!"".equals(pageCount))
            content = content.concat(pageCount);
        if (!"".equals(price))
            content = content.concat(price);
        if (!"".equals(rating))
            content = content.concat(rating);
        if (!"".equals(total_ratings))
            content = content.concat(total_ratings);
        if (!"".equals(publisher))
            content = content.concat(publisher);
        if (!"".equals(description))
            content = content.concat(description);*/
        
        return content;
    }
    
    public static DefaultListModel UpdateList(ArrayList<Volume> list, DefaultListModel model) {
        if (list != null && !list.isEmpty()) {
            model.clear();
            for (Volume e:list) {
                EbookFragmentPanel efp = new EbookFragmentPanel(e);
                model.add(list.indexOf(e), efp);

                //String content = volumeToString(e);
                //model.add(list.indexOf(e), content);
            }
            return model;
        }
        else System.out.println("List empty? "+list.isEmpty()+" at LivroController");
        return model;
    }
}
