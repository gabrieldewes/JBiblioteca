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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;
import model.Exemplar;
import model.Livro;
import org.joda.time.LocalDateTime;
import view.EbookFragmentPanel;
import view.EbooksInternalFrame;

/**
 *
 * @author gabriel
 */
public class LivroController {
    
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
    
    public static java.util.List<Volume> volumesList;
   
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
    
    public static List<Livro> ArrayLivro(String like) {
        dao = new LivroDAO();
        return dao.getArray(like);
    }
    
    public static List<Volume> GetEbooksList(String query) {
        List<Volume> volumes=null;
        if (query.trim().length() > 2) {
            try {
                volumes = BooksService.getVolumesList(query);
            } catch (Exception ex) {
                Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return volumes;
    }
    
    public static List<String> volumeToString(Volume v) {
        if (v != null) {            
            Volume.VolumeInfo volumeInfo = v.getVolumeInfo();
            Volume.SaleInfo saleInfo = v.getSaleInfo();
            LocalDateTime ldt;
            Volume.VolumeInfo.ImageLinks links=null;    
            String smallThumbLink="";
            String title="";
            String author="";
            String genr="";
            String identifier="";
            String pageCount="";
            String price="";
            String rating="";
            String publisher="";
            String description="";
            
            /* Link da thumb */
            links = volumeInfo.getImageLinks();
            if (links != null)
                smallThumbLink = links.getSmallThumbnail();
            
            /* Título */
            title = ""+v.getVolumeInfo().getTitle()+"";
            if (v.getVolumeInfo().getSubtitle() != null)
                title = title.concat(" - "+ v.getVolumeInfo().getSubtitle());
            
            /* Autores */ 
            java.util.List<String> authors = v.getVolumeInfo().getAuthors();
            if (authors != null && !authors.isEmpty()) {
                for (int i = 0; i < authors.size(); ++i) {
                    author = authors.get(i);
                    if (i < authors.size() - 1) {
                        author = author.concat(", ");
                    }
                }
            }
            
            /* Editora e Data de publicação */
            if (volumeInfo.getPublisher() != null)
                publisher = volumeInfo.getPublisher();
            if (volumeInfo.getPublishedDate() != null) {
                ldt = new LocalDateTime( volumeInfo.getPublishedDate());
                publisher = publisher.concat(", "+ +ldt.getDayOfMonth()+"/"+ldt.getMonthOfYear()+"/"+ldt.getYear());
            }
            
            /* Descrição */
            if (volumeInfo.getDescription() != null)
                description = "Descrição: "+ volumeInfo.getDescription() +"";
            
            /* Gêneros */
            java.util.List<String> genrs = volumeInfo.getCategories();
            if (genrs != null && !genrs.isEmpty()) {
                genr = genr.concat("Genêro: ");
                if (volumeInfo.getMainCategory() != null)
                    genr = genr.concat(volumeInfo.getMainCategory() +", ");
                for (int i = 0; i < genrs.size(); ++i) {
                    genr = genr.concat(genrs.get(i));
                    if (i < genrs.size() - 1) {
                        genr = genr.concat(", ");
                    }
                }
            }
            
            /* Número de páginas */
            if (volumeInfo.getPageCount() != null)
                pageCount = ""+volumeInfo.getPageCount()+" páginas";
            
            /* Identificadores */
            java.util.List<Volume.VolumeInfo.IndustryIdentifiers> isbn = volumeInfo.getIndustryIdentifiers();
            if (isbn != null && !isbn.isEmpty()) {
                for (Volume.VolumeInfo.IndustryIdentifiers ii:isbn) {
                    identifier = identifier.concat(ii.getType()+": "+ ii.getIdentifier()+"");
                }
            }

            /* Avaliações */
            if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
                int fullRating = (int) Math.round(volumeInfo.getAverageRating());
                rating = "Avaliação: ";
                for (int i = 0; i < fullRating; ++i) {
                    rating = rating.concat(" * ");
                }
                rating = rating.concat(" (" + volumeInfo.getRatingsCount() + " avaliações) ");
            }

            /* Informações de Venda */
            if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
                double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
                if (save > 0.0) {
                    price = price.concat("Preço médio: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount()));
                }
                price = price.concat(", na Google Books: "
                    + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
                if (save > 0.0) {
                    price = price.concat(", você ganha: " + CURRENCY_FORMATTER.format(save) + " ("
                        + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")");
                }
            }
            List<String> details = Arrays.asList(
                    identifier,      // 0
                    title,           // 1
                    author,          // 2
                    genr,            // 3
                    rating,          // 4
                    price,           // 5
                    pageCount,       // 6
                    publisher,       // 7
                    description,     // 8
                    smallThumbLink); // 9
            
            return details;
        }
        return null;
    }
    
    public static void UpdateEbooksList(String query) {
        volumesList = GetEbooksList(query);                                   
        if (volumesList != null && !volumesList.isEmpty()) {
            EbooksInternalFrame.model.clear();
            for (Volume e:volumesList) {               
                EbookFragmentPanel efp = new EbookFragmentPanel(volumeToString(e));
                EbooksInternalFrame.model.add( volumesList.indexOf(e), efp );

            }
        }
    }
}
