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
package com.jbiblioteca.view;

import com.jbiblioteca.controller.EbookController;
import com.jbiblioteca.controller.LivroController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import static com.jbiblioteca.view.MainFrame.lif;

/**
 *
 * @author Dewes
 */
public final class EbooksInternalFrame extends javax.swing.JInternalFrame {

    public static DefaultListModel model;
    
    public EbooksInternalFrame() {
        initComponents();   
        //ebooksList.setCellRenderer(new MyCellRenderer());
        ebooksList.setCellRenderer(new PanelRenderer());
        
        model = new DefaultListModel();
        //EbookController.UpdateEbooksList("");
        ebooksList.setModel(model);
               
        
    }   
    
    public static void updateModelUI() {
        Runnable t1 = () -> {
            EbookFragmentPanel panel = (EbookFragmentPanel) model.get(0);
            panel.updateUI();
            model.set(0, panel);
        };
        new Thread(t1).start();
        
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
                .addComponent(searchGoogleBooksField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGoogleBooksBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ebooksListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ebooksListMouseClicked
        if (ebooksList.getSelectedIndex() > -1) {
            saveEbookBtn.setEnabled(true);
            int index = ebooksList.getSelectedIndex();
            System.out.println("Volume at "+index+": "+ EbookController.volumesList.get(index).getVolumeInfo().getTitle() );
        }
        else {
            saveEbookBtn.setEnabled(false);
        }
    }//GEN-LAST:event_ebooksListMouseClicked

    private void saveEbookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEbookBtnActionPerformed
        if (ebooksList.getSelectedIndex() > -1) {
            saveEbookBtn.setEnabled(true);
            int index = ebooksList.getSelectedIndex(); 
            JTextField title2 = new JTextField();
            title2.setFont(new Font("Dialog", Font.BOLD, 14));
            JTextField author = new JTextField();
            author.setFont(new Font("Dialog", Font.BOLD, 14));
            JTextField codigoField = new JTextField();
            codigoField.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField xField = new JTextField();
            xField.setFont(new Font("Dialog", Font.PLAIN, 14));
            JTextField yField = new JTextField();
            xField.setFont(new Font("Dialog", Font.PLAIN, 14));
            Object[] message = {
                "",
                "Título: ", title2,
                "Autor(a): ", author,
                "\n",
                "Catalogação de Exemplar:",
                "",
                "Código único:", codigoField,
                "Corredor:", xField,
                "Prateleira:", yField
            };
            String final_author="";
            java.util.List<String> authors = EbookController.volumesList.get(index).getVolumeInfo().getAuthors();
            if (authors != null && !authors.isEmpty()) {
                for (int i = 0; i < authors.size(); ++i) {
                    final_author = authors.get(i);
                    if (i < authors.size() - 1) {
                        final_author = final_author.concat(", ");
                    }
                }
            }
            
            title2.setText(EbookController.volumesList.get(index).getVolumeInfo().getTitle());
            author.setText(final_author);
            int option = 1;
            while (option != JOptionPane.OK_CANCEL_OPTION) {
                option = JOptionPane.showConfirmDialog(null, message, "Novo Título", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String titulo = title2.getText();
                    String autor = author.getText();
                    String codigo = codigoField.getText();
                    codigo = codigo.replace(" ", "");
                    String x = xField.getText();
                    String y = yField.getText();
                    if (LivroController.getInstance().Salvar(codigo.trim(), "",  titulo.trim(), autor.trim(), x.trim(), y.trim())) {
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
            EbookController.UpdateEbooksList( isbn );
            ebooksList.ensureIndexIsVisible(0);
        }
    }//GEN-LAST:event_searchGoogleBooksBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JList<JPanel> ebooksList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveEbookBtn;
    private javax.swing.JButton searchGoogleBooksBtn;
    private javax.swing.JTextField searchGoogleBooksField;
    // End of variables declaration//GEN-END:variables
}
class PanelRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel renderer=null;
        try {
           renderer = (JPanel) value;
        }
         catch (Exception ex) {
             System.out.println("Exception "+ ex.getMessage());
         }
        renderer.setBackground(isSelected ? Color.DARK_GRAY : list.getBackground());
        return renderer;
    }
}


