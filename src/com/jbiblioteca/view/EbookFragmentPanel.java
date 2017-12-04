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
package com.jbiblioteca.view;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author gabriel
 */
public class EbookFragmentPanel extends javax.swing.JPanel {
    
    private static String infoLink;

    /**
     * 
     * @param details
     */
    
    
    /*
    imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    if (infoLink != null && !"".equals(infoLink)) {
        try {
            Desktop.getDesktop().browse(new URI(infoLink));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(ConfigInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    public EbookFragmentPanel(List<String> details) {
        initComponents();
        if (details != null && !details.isEmpty()) {
            infoLink = details.get(9);
            titleLabel.setText(details.get(1));
            authorLabel.setText(details.get(2));
            genrLabel.setText(details.get(3));
            pageLabel.setText(details.get(6));
            ratingLabel.setText(details.get(4));
            publisherLabel.setText(details.get(7));
            
            
            if (details.get(9) != null && !"".equals( details.get(9) )) {
                Runnable t1 = () -> {
                    Image image;
                    try {
                        URL url = new URL(details.get(9));
                        image = ImageIO.read(url);
                        final ImageIcon imageIcon = new ImageIcon(image); 
                        imageLabel.setIcon(imageIcon);
                        System.out.println("Thumb baixada para "+ details.get(1));
                        try {
                            EbooksInternalFrame.updateModelUI();                               
                        } catch (Exception ex) {
                            System.out.println("Exception: "+ ex.getMessage());
                        }
                        
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(EbooksInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(EbooksInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                };
                new Thread(t1).start();                           
            }
            else imageLabel.setText("Sem Miniatura");
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
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(genrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(publisherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorLabel)
                        .addGap(12, 12, 12)
                        .addComponent(genrLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ratingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherLabel)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel authorLabel;
    public static javax.swing.JLabel genrLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel pageLabel;
    public static javax.swing.JLabel publisherLabel;
    public static javax.swing.JLabel ratingLabel;
    public static javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}