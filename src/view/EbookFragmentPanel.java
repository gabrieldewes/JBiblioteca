/*
 * The MIT License
 *
 * Copyright 2016 gabriel.
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
package view;

import com.google.api.services.books.model.Volume;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.joda.time.LocalDateTime;

/**
 *
 * @author gabriel
 */
public class EbookFragmentPanel extends javax.swing.JPanel {
    
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
    private static String infoLink;

    /**
     * Creates new form EbookFragmentPanel
     * @param v
     */
    public EbookFragmentPanel(Volume v) {
        initComponents();
        if (v != null) {
            
            infoLink = v.getVolumeInfo().getInfoLink();
            System.out.println("Renderizando JPanel para "+ v.getVolumeInfo().getTitle());
            try {
                Volume.VolumeInfo.ImageLinks links = v.getVolumeInfo().getImageLinks();
                if (links != null && !links.isEmpty()) {
                    URL url = new URL(links.getSmallThumbnail());
                    Image image = ImageIO.read(url);
                    if (image != null)
                        imageLabel.setIcon(new ImageIcon(image));
                }
            } catch (MalformedURLException ex) {
                System.out.println("MalformedURLException "+ex.getMessage());
                Logger.getLogger(EbookFragmentPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("IOException "+ex.getMessage());
                Logger.getLogger(EbookFragmentPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Volume.VolumeInfo volumeInfo = v.getVolumeInfo();
            Volume.SaleInfo saleInfo = v.getSaleInfo();
            LocalDateTime ldt;
            String title="";
            String author="";
            String genr="";
            String identifier="";
            String pageCount="";
            String price="";
            String rating="";
            String publisher="";
            String description="";

            title = ""+v.getVolumeInfo().getTitle()+"";
            if (v.getVolumeInfo().getSubtitle() != null)
                title = title.concat(" - "+ v.getVolumeInfo().getSubtitle());
            java.util.List<String> authors = v.getVolumeInfo().getAuthors();
            if (authors != null && !authors.isEmpty()) {
                for (int i = 0; i < authors.size(); ++i) {
                    author = authors.get(i);
                    if (i < authors.size() - 1) {
                        author = author.concat(", ");
                    }
                }
            }

            if (volumeInfo.getPublisher() != null)
                publisher = volumeInfo.getPublisher();
            if (volumeInfo.getPublishedDate() != null) {
                ldt = new LocalDateTime( volumeInfo.getPublishedDate());
                publisher = publisher.concat(", "+ +ldt.getDayOfMonth()+"/"+ldt.getMonthOfYear()+"/"+ldt.getYear());
            }

            if (volumeInfo.getDescription() != null)
                description = "Descrição: "+ volumeInfo.getDescription() +"";

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

            if (volumeInfo.getPageCount() != null)
                pageCount = ""+volumeInfo.getPageCount()+" páginas";

            java.util.List<Volume.VolumeInfo.IndustryIdentifiers> isbn = volumeInfo.getIndustryIdentifiers();
            if (isbn != null && !isbn.isEmpty()) {
                for (Volume.VolumeInfo.IndustryIdentifiers ii:isbn) {
                    identifier = identifier.concat(ii.getType()+": "+ ii.getIdentifier()+"");
                }
            }
            if (volumeInfo.getRatingsCount() != null && volumeInfo.getRatingsCount() > 0) {
                int fullRating = (int) Math.round(volumeInfo.getAverageRating());
                rating = "Avaliação: ";
                for (int i = 0; i < fullRating; ++i) {
                    rating = rating.concat(" * ");
                }
                rating = rating.concat(" (" + volumeInfo.getRatingsCount() + " avaliações) ");
            }
            if (saleInfo != null && "FOR_SALE".equals(saleInfo.getSaleability())) {
                double save = saleInfo.getListPrice().getAmount() - saleInfo.getRetailPrice().getAmount();
                if (save > 0.0) {
                    price = price.concat("Preço médio: " + CURRENCY_FORMATTER.format(saleInfo.getListPrice().getAmount()));
                }
                price = price.concat(" Na Google Books: "
                    + CURRENCY_FORMATTER.format(saleInfo.getRetailPrice().getAmount()));
                if (save > 0.0) {
                    price = price.concat(" Você ganha: " + CURRENCY_FORMATTER.format(save) + " ("
                        + PERCENT_FORMATTER.format(save / saleInfo.getListPrice().getAmount()) + ")");
                }
            }
            titleLabel.setText(title);
            authorLabel.setText(author);
            //if (!"".equals(identifier))
            genrLabel.setText(genr);
            pageLabel.setText(pageCount);
            pageLabel.setText(pageCount);
            ratingLabel.setText(rating);
            publisherLabel.setText(publisher);
            //if (!"".equals(description))
                
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        genrLabel = new javax.swing.JLabel();
        pageLabel = new javax.swing.JLabel();
        publisherLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imageLabelMouseEntered(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        titleLabel.setText("Sem Título");

        authorLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        authorLabel.setText("Sem Autor");

        genrLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        genrLabel.setText("Sem Gênero");

        pageLabel.setText("Sem Páginas");

        publisherLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        publisherLabel.setText("Sem Editora");

        ratingLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ratingLabel.setText("Sem Avaliação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ratingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genrLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ratingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherLabel))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseEntered
        imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_imageLabelMouseEntered

    private void imageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseClicked
        if (infoLink != null && !"".equals(infoLink)) {
            try {
                Desktop.getDesktop().browse(new URI(infoLink));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(ConfigInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_imageLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel genrLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
