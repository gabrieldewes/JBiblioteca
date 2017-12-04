/*
 * The MIT License
 *
 * Copyright 2016 Dewes.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.jbiblioteca.controller;

import com.jbiblioteca.api.BooksService;
import com.google.api.services.books.model.Volume;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDateTime;
import com.jbiblioteca.view.EbookFragmentPanel;
import com.jbiblioteca.view.EbooksInternalFrame;

/**
 *
 * @author Dewes
 */
public class EbookController {
    
    private static BooksService bs;
    
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
    public static List<Volume> volumesList;


    public static List<Volume> GetEbooksList(String query) {
        List<Volume> volumes = null;
        if (query.trim().length() > 2) {
            try {
                volumes = BooksService.getVolumesList(query);
            } catch (Exception ex) {
                Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return volumes;
    }

    public static void UpdateEbooksList(String query) {
        volumesList = GetEbooksList(query);
        if (volumesList != null && !volumesList.isEmpty()) {
            EbooksInternalFrame.model.clear();
            for (Volume e : volumesList) {
                EbookFragmentPanel efp = new EbookFragmentPanel(volumeToString(e));
                EbooksInternalFrame.model.add(volumesList.indexOf(e), efp);
                //EbooksInternalFrame.updateModelUI();
            }
        }
    }

    public static List<String> volumeToString(Volume v) {
        if (v != null) {
            Volume.VolumeInfo volumeInfo = v.getVolumeInfo();
            Volume.SaleInfo saleInfo = v.getSaleInfo();
            LocalDateTime ldt;
            Volume.VolumeInfo.ImageLinks links = null;
            String smallThumbLink = "";
            String title = "";
            String author = "";
            String genr = "";
            String identifier = "";
            String pageCount = "";
            String price = "";
            String rating = "";
            String publisher = "";
            String description = "";
            /* Link da thumb */
            links = volumeInfo.getImageLinks();
            if (links != null) {
                smallThumbLink = links.getSmallThumbnail();
            }
            /* Título */
            title = "" + v.getVolumeInfo().getTitle() + "";
            if (v.getVolumeInfo().getSubtitle() != null) {
                title = title.concat(" - " + v.getVolumeInfo().getSubtitle());
            }
            /* Autores */
            List<String> authors = v.getVolumeInfo().getAuthors();
            if (authors != null && !authors.isEmpty()) {
                for (int i = 0; i < authors.size(); ++i) {
                    author = authors.get(i);
                    if (i < authors.size() - 1) {
                        author = author.concat(", ");
                    }
                }
            }
            /* Editora e Data de publicação */
            if (volumeInfo.getPublisher() != null) {
                publisher = volumeInfo.getPublisher();
            }
            if (volumeInfo.getPublishedDate() != null) {
                ldt = new LocalDateTime(volumeInfo.getPublishedDate());
                publisher = publisher.concat(", " + +ldt.getDayOfMonth() + "/" + ldt.getMonthOfYear() + "/" + ldt.getYear());
            }
            /* Descrição */
            if (volumeInfo.getDescription() != null) {
                description = "Descri\u00e7\u00e3o: " + volumeInfo.getDescription() + "";
            }
            /* Gêneros */
            List<String> genrs = volumeInfo.getCategories();
            if (genrs != null && !genrs.isEmpty()) {
                genr = genr.concat("Gen\u00earo: ");
                if (volumeInfo.getMainCategory() != null) {
                    genr = genr.concat(volumeInfo.getMainCategory() + ", ");
                }
                for (int i = 0; i < genrs.size(); ++i) {
                    genr = genr.concat(genrs.get(i));
                    if (i < genrs.size() - 1) {
                        genr = genr.concat(", ");
                    }
                }
            }
            /* Número de páginas */
            if (volumeInfo.getPageCount() != null) {
                pageCount = "" + volumeInfo.getPageCount() + " p\u00e1ginas";
            }
            /* Identificadores */
            List<Volume.VolumeInfo.IndustryIdentifiers> isbn = volumeInfo.getIndustryIdentifiers();
            if (isbn != null && !isbn.isEmpty()) {
                for (Volume.VolumeInfo.IndustryIdentifiers ii : isbn) {
                    identifier = identifier.concat(ii.getType() + ": " + ii.getIdentifier() + "");
                }
            }
            /* Avaliações */
            if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
                int fullRating = (int) Math.round(volumeInfo.getAverageRating());
                rating = "Avalia\u00e7\u00e3o: ";
                for (int i = 0; i < fullRating; ++i) {
                    rating = rating.concat(" * ");
                }
                rating = rating.concat(" (" + volumeInfo.getRatingsCount() + " avalia\u00e7\u00f5es) ");
            }
            /* Informações de Venda */
            if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
                double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
                if (save > 0.0) {
                    price = price.concat("Pre\u00e7o m\u00e9dio: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount()));
                }
                price = price.concat(", na Google Books: " + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
                if (save > 0.0) {
                    price = price.concat(", voc\u00ea ganha: " + CURRENCY_FORMATTER.format(save) + " (" + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")");
                }
            }
            List<String> details = Arrays.asList(identifier, title, author, genr, rating, price, pageCount, publisher, description, smallThumbLink); // 9
            return details;
        }
        return null;
    }
    
}
