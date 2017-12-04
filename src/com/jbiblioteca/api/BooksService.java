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
package com.jbiblioteca.api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volume.VolumeInfo.IndustryIdentifiers;
import com.google.api.services.books.model.Volumes;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dewes
 */
public class BooksService {

    private static final String APPLICATION_NAME = "Dewes-JBiblioteca-1.0";

    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
    
    public static java.util.List<Volume> getVolumesList(String query) {
        Volumes volumes = getVolumes(query);
        if (volumes != null)
            return volumes.getItems();
        return null;
        
    }
    
    private static Volumes getVolumes(String query) {
        try {
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
            System.out.println("Query Google Books: [" + query + "]");
            List volumesList = books.volumes().list(query);
            Volumes volumes = volumesList.execute();
            if (volumes != null) {
                if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
                    System.out.println("No matches found.");
                    return null;
                }
                return volumes;
            }
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(BooksService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Verifique a conexão com a Internet.", "JBiblioteca", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(BooksService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static void queryGoogleBooks(String query) throws Exception {
        Volumes volumes = getVolumes(query);
        for (Volume volume : volumes.getItems()) {
            Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
            Volume.SaleInfo saleInfo = volume.getSaleInfo();
            System.out.println("==========");
            // ISBN
            java.util.List<IndustryIdentifiers> isbn = volumeInfo.getIndustryIdentifiers();
            if (isbn != null && !isbn.isEmpty()) {
                for (IndustryIdentifiers ii:isbn) {
                    System.out.println(""+  ii.getType()+": "+ ii.getIdentifier());
                }
            }
            // Title.
            System.out.println("Title: " + volumeInfo.getTitle());
            // Author(s).
            java.util.List<String> authors = volumeInfo.getAuthors();
            if (authors != null && !authors.isEmpty()) {
                System.out.print("Author(s): ");
                for (int i = 0; i < authors.size(); ++i) {
                    System.out.print(authors.get(i));
                    if (i < authors.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
            // Description (if any).
            if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
                System.out.println("Description: " + volumeInfo.getDescription());
            }
            // Ratings (if any).
            if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
                int fullRating = (int) Math.round(volumeInfo.getAverageRating());
                System.out.print("User Rating: ");
                for (int i = 0; i < fullRating; ++i) {
                    System.out.print("*");
                }
                System.out.println(" (" + volumeInfo.getRatingsCount() + " rating(s))");
            }
            // Price (if any).
            if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
                double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
                if (save > 0.0) {
                    System.out.print("List: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount())
                    + "  ");
                }
                System.out.print("Google eBooks Price: "
                    + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
                if (save > 0.0) {
                    System.out.print("  You Save: " + CURRENCY_FORMATTER.format(save) + " ("
                        + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")");
                }
                System.out.println();
            }
            
            // Access status.
            String accessViewStatus = volume.getAccessInfo().getAccessViewStatus();
            String message = "Informações adicionais e eBook disponíveis em:";
            if ("FULL_PUBLIC_DOMAIN".equals(accessViewStatus)) {
                message = "This public domain book is available for free from Google eBooks at:";
            } 
            else if ("SAMPLE".equals(accessViewStatus)) {
                message = "Avaliação gratuita deste livro do Google eBooks em:";
            }
            System.out.println(message);
            // Link para Google eBooks.
            System.out.println(volumeInfo.getInfoLink());
        }
        System.out.println("==========");
        System.out.println(
                volumes.getTotalItems() + " total results at http://books.google.com/ebooks?q="
                + URLEncoder.encode(query, "UTF-8"));
    }
    
    public static void main(String[] args) {
        String args2 = "Casseta e planeta";
        try {
            try {
                queryGoogleBooks(args2); 
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } catch (Throwable t) {
        }
        System.exit(0);
    }  
}