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
package view;

import com.google.api.services.books.model.Volume;
import control.ExemplarController;
import control.LivroController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import model.Livro;
import static view.MainFrame.lif;

/**
 *
 * @author Dewes
 */
public final class EbooksInternalFrame extends javax.swing.JInternalFrame {

    private static ArrayList<Volume> ebooks;
    private static String infoLink;
    
    public EbooksInternalFrame() {
        initComponents();
        ebooksList.setCellRenderer(new MyCellRenderer());
        ebooks = LivroController.ArrayEbook("água para elefantes");
        ebooksList.setModel(LivroController.UpdateList(ebooks));
    }    

    void updateTextArea(Volume v) {
        if (v != null) {
            infoLink = v.getVolumeInfo().getInfoLink();
            String content = LivroController.volumeToString(v);
            contentTextArea.setText(content.trim());  
            contentTextArea.setEditable(false);
            contentTextArea.setFont( new Font("Dialog", Font.PLAIN, 14) );
            contentTextArea.setLineWrap(true);
            contentTextArea.setCaretPosition(0);
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ebooksList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        searchGoogleBooksField = new javax.swing.JTextField();
        searchGoogleBooksBtn = new javax.swing.JButton();
        saveEbookBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contentTextArea = new javax.swing.JTextArea();
        infoLinkField = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Livros em Google Books");

        ebooksList.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ebooksList.setModel(new DefaultListModel());
        ebooksList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ebooksListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ebooksList);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        searchGoogleBooksField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchGoogleBooksField.setText("Busque por títulos, autores ou gêneros...");
        searchGoogleBooksField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGoogleBooksFieldMouseClicked(evt);
            }
        });
        searchGoogleBooksField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchGoogleBooksFieldKeyTyped(evt);
            }
        });

        searchGoogleBooksBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchGoogleBooksBtn.setText("Buscar");
        searchGoogleBooksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGoogleBooksBtnActionPerformed(evt);
            }
        });

        saveEbookBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        saveEbookBtn.setText("Salvar Título");
        saveEbookBtn.setToolTipText("Salva um título com os detalhes do ebook");
        saveEbookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEbookBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Google Books");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGoogleBooksField, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGoogleBooksBtn)
                .addGap(114, 114, 114)
                .addComponent(saveEbookBtn)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchGoogleBooksField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchGoogleBooksBtn)
                    .addComponent(saveEbookBtn)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentTextArea.setColumns(20);
        contentTextArea.setRows(5);
        jScrollPane2.setViewportView(contentTextArea);

        infoLinkField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        infoLinkField.setText("Mais informações no site");
        infoLinkField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoLinkFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoLinkFieldMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLinkField)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLinkField)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ebooksListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ebooksListMouseClicked
        if (ebooksList.getSelectedIndex() > -1) {
            saveEbookBtn.setEnabled(true);
            int index = ebooksList.getSelectedIndex();
            //System.out.println("Volume at "+index+": "+ ebooks.get(index).getVolumeInfo().getTitle());
            updateTextArea(ebooks.get(index));
        }
        else {
            saveEbookBtn.setEnabled(false);
        }
    }//GEN-LAST:event_ebooksListMouseClicked

    private void infoLinkFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLinkFieldMouseEntered
        infoLinkField.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_infoLinkFieldMouseEntered

    private void infoLinkFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLinkFieldMouseClicked
        if (infoLink != null) {
            try {
                Desktop.getDesktop().browse(new URI(infoLink));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(ConfigInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_infoLinkFieldMouseClicked

    private void saveEbookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEbookBtnActionPerformed
        if (ebooksList.getSelectedIndex() > -1) {
            saveEbookBtn.setEnabled(true);
            int index = ebooksList.getSelectedIndex();
            System.out.println("Volume at "+index+": "+ ebooks.get(index).getVolumeInfo().getTitle()); 
            
            JLabel title = new JLabel();
            title.setFont(new Font("Dialog", Font.BOLD, 14));
            JLabel author = new JLabel();
            author.setFont(new Font("Dialog", Font.BOLD, 14));
            JTextField codigoField = new JTextField();
            codigoField.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField xField = new JTextField();
            xField.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField yField = new JTextField();
            xField.setFont(new Font("Dialog", Font.PLAIN, 14));
            Object[] message = {
                "",
                "Título: ", title,
                "Autor(a): ", author,
                "\n",
                "Catalogação de Exemplar:",
                "",
                "Código único:", codigoField,
                "Corredor:", xField,
                "Prateleira:", yField
            };
            
            title.setText(ebooks.get(index).getVolumeInfo().getTitle());
            author.setText(ebooks.get(index).getVolumeInfo().getAuthors().get(0));
            int option = 1;
            while (option != JOptionPane.OK_CANCEL_OPTION) {
                option = JOptionPane.showConfirmDialog(null, message, "Novo Título", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String titulo = title.getText();
                    String autor = author.getText();
                    String codigo = codigoField.getText();
                    codigo = codigo.replace(" ", "");
                    String x = xField.getText();
                    String y = yField.getText();
                    if (LivroController.Salvar(codigo.trim(), "",  titulo.trim(), autor.trim(), x.trim(), y.trim())) {
                        option = JOptionPane.OK_CANCEL_OPTION;
                        if (lif != null) {
                            lif.updateLivroTableModel("");
                            lif.updateExemplarTableModel("");
                        }
                    }
                }
                else 
                    option = JOptionPane.OK_CANCEL_OPTION;
            }
        }
        else {
            saveEbookBtn.setEnabled(false);
        }
    }//GEN-LAST:event_saveEbookBtnActionPerformed

    private void searchGoogleBooksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGoogleBooksBtnActionPerformed
        String isbn = searchGoogleBooksField.getText();
        if (isbn.trim() != null && isbn.trim().length() > 2) {
            ebooks = LivroController.ArrayEbook(isbn);
            if (ebooks != null) {
                contentTextArea.setText("");
                ebooksList.setModel(LivroController.UpdateList(ebooks));
            }
            else {
                contentTextArea.setText("Sem conexão.");
            }
        }
    }//GEN-LAST:event_searchGoogleBooksBtnActionPerformed

    private void searchGoogleBooksFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGoogleBooksFieldMouseClicked
        if (searchGoogleBooksField.getText().equals("Busque por títulos, autores ou gêneros..."))
            searchGoogleBooksField.setText("");
    }//GEN-LAST:event_searchGoogleBooksFieldMouseClicked

    private void searchGoogleBooksFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGoogleBooksFieldKeyTyped
        if (searchGoogleBooksField.getText().equals("Busque por títulos, autores ou gêneros..."))
            searchGoogleBooksField.setText("");
    }//GEN-LAST:event_searchGoogleBooksFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea contentTextArea;
    private javax.swing.JList<JPanel> ebooksList;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel infoLinkField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveEbookBtn;
    private javax.swing.JButton searchGoogleBooksBtn;
    private javax.swing.JTextField searchGoogleBooksField;
    // End of variables declaration//GEN-END:variables
}
class MyCellRenderer implements ListCellRenderer {

    private final JPanel p;
    private final JTextArea ta;

    public MyCellRenderer() {
        p = new JPanel();
        p.setLayout(new BorderLayout());
        ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setFont(new Font("Dialog", Font.PLAIN, 14));
        p.add(ta, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean hasFocus) {
        if (isSelected) {
            p.setForeground(list.getSelectionForeground());
            p.setBackground(Color.DARK_GRAY);
        } 
        else {
            p.setForeground(list.getForeground());
            p.setBackground(list.getBackground());
        }
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ta.setText((String) value);
        return p;

    }
}


