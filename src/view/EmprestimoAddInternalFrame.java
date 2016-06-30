/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.EmprestimoController;
import control.ExemplarController;
import control.PessoaController;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Exemplar;
import model.Pessoa;
import org.joda.time.LocalDateTime;
import static view.MainFrame.eif;
import static view.MainFrame.lif;

/**
 *
 * @author gabriel
 */
public class EmprestimoAddInternalFrame extends javax.swing.JInternalFrame {

    static ArrayList<Pessoa> pessoas;
    static ArrayList<Exemplar> exemplares;
    static ArrayList<Exemplar> filtrados;
    static ArrayList<Exemplar> selecionados;
    
    static DefaultListModel model;
    static LocalDateTime ldt;
    
    public EmprestimoAddInternalFrame() {
        initComponents();
        model = new DefaultListModel();
        livroList.setModel(model);
        
        selecionados = new ArrayList<>();
        filtrados = new ArrayList<>();
        pessoas = PessoaController.ArrayPessoa("");
        exemplares = ExemplarController.ArrayExemplar("");
        updatePessoaBox();
        updateLivroBox();
        
        ldt = new LocalDateTime( System.currentTimeMillis() );
        String date = " "+ ldt.getDayOfMonth() +"/"+ ldt.getMonthOfYear() +"/"+ ldt.getYear() +" ";
        dataLabel.setText(""+ date);

    }
    
    public void updatePessoaBox() {
        pessoaBox.removeAllItems();
        pessoas.stream().forEach((p) -> {
            pessoaBox.addItem( p.getCodigo() );
        });
        
    }
    
    public void updateLivroBox() {
        livroBox.removeAllItems();
        exemplares.stream().forEach((e) -> {
            livroBox.addItem( e.getCodigo() );
        });
        
    }
    
    public void updateLivroFiltradoBox() {
        livroBox.removeAllItems();
        filtrados.stream().forEach((e) -> {
            livroBox.addItem( e.getCodigo() );
        });
        
    }
    
    public int insertItemList(String item) {
        model.addElement( item );
        livroList.setModel(model);
        //System.out.println("LIST INDEX ADICIONAR "+ model.indexOf(item));
        return model.indexOf(item);
    }
    
    public void removeItemList(int index) {
        model.removeElementAt(index);
        livroList.setModel(model);
        //System.out.println("LIST INDEX REMOVER "+ index);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        pessoaLabel = new javax.swing.JLabel();
        buscaPessoaField = new javax.swing.JTextField();
        pessoaBox = new javax.swing.JComboBox<>();
        escolhePessoaBtn = new javax.swing.JButton();
        codigoLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscaLivroField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        livroBox = new javax.swing.JComboBox<>();
        addListLivroBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        removerLivroList = new javax.swing.JButton();
        limparLivroList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        livroList = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        salvarEmprestimoBtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Novo Empréstimo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("  Pessoa  "));

        pessoaLabel.setText("Código, nome, turma...");

        buscaPessoaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaPessoaFieldKeyReleased(evt);
            }
        });

        pessoaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        escolhePessoaBtn.setText("Selecionar");
        escolhePessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolhePessoaBtnActionPerformed(evt);
            }
        });

        codigoLabel.setText("Selecione o código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscaPessoaField)
                    .addComponent(pessoaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pessoaLabel)
                    .addComponent(codigoLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 123, Short.MAX_VALUE)
                        .addComponent(escolhePessoaBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pessoaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscaPessoaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codigoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pessoaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(escolhePessoaBtn)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("  Livros  "));

        jLabel1.setText("Título, autor, código...");

        buscaLivroField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaLivroFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("Selecione o código: ");

        livroBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addListLivroBtn.setText("Adicionar à lista");
        addListLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListLivroBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 151, Short.MAX_VALUE)
                        .addComponent(addListLivroBtn))
                    .addComponent(buscaLivroField)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(livroBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscaLivroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(livroBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addListLivroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("  Livros Selecionados  "));

        removerLivroList.setText("Remover");
        removerLivroList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerLivroListActionPerformed(evt);
            }
        });

        limparLivroList.setText("Limpar");
        limparLivroList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparLivroListActionPerformed(evt);
            }
        });

        livroList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        livroList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        livroList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                livroListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(livroList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removerLivroList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limparLivroList)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removerLivroList)
                    .addComponent(limparLivroList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jButton3.setText("ver ArrayList");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("  Devolução  "));

        jLabel3.setText("Data de Início");

        dataLabel.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        dataLabel.setText("jLabel4");

        jLabel4.setText("Dias para Devolução:");

        jSpinner1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jRadioButton1.setText("Semana");

        jRadioButton2.setText("Mês");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2))
                            .addComponent(jLabel3)
                            .addComponent(dataLabel))
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataLabel)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        salvarEmprestimoBtn.setText("  Salvar  ");
        salvarEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarEmprestimoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvarEmprestimoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(salvarEmprestimoBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaPessoaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaPessoaFieldKeyReleased
        escolhePessoaBtn.setEnabled(true);
        pessoaLabel.setText("Código, nome, turma...");
        codigoLabel.setText("Selecione o Código: ");
        pessoaBox.setEnabled(true);
        String str = buscaPessoaField.getText();
        if (!"".equals(str) && str.length() > 2) {
            pessoas = PessoaController.ArrayPessoa(str);
            updatePessoaBox();
        }
        else {
            pessoas = PessoaController.ArrayPessoa("");
            updatePessoaBox();
        }
    }//GEN-LAST:event_buscaPessoaFieldKeyReleased

    private void escolhePessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolhePessoaBtnActionPerformed
        String codigo = pessoaBox.getSelectedItem().toString();
        if (!"".equals(codigo) && codigo != null) {
            for (Pessoa p:pessoas) {
                if (codigo.equals(p.getCodigo())) {
                    buscaPessoaField.setText(p.getNome());
                    escolhePessoaBtn.setEnabled(false);
                    pessoaLabel.setText("Escolhido: ");
                    codigoLabel.setText("Código: ");
                    pessoaBox.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_escolhePessoaBtnActionPerformed

    private void buscaLivroFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaLivroFieldKeyReleased
        filtrados = ExemplarController.ArrayExemplar("");
        String str = buscaLivroField.getText();
        if (!"".equals(str) && str.length() > 3) {
            filtrados = ExemplarController.ArrayExemplar(str);
            updateLivroFiltradoBox();
        }
        else {
            updateLivroBox();
        }
    }//GEN-LAST:event_buscaLivroFieldKeyReleased

    private void addListLivroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addListLivroBtnActionPerformed
        boolean add=false;
        if (livroBox.getSelectedItem() != null) {
            String codigo = livroBox.getSelectedItem().toString();
            if (!selecionados.isEmpty()) {
                for (Exemplar s:selecionados) {
                    if (s.getCodigo().equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "Exemplar já está selecionado. ", "Atenção", JOptionPane.WARNING_MESSAGE);
                        //System.out.println("Livro ja esta na lista "+ s.toString());
                        add=false;
                        break;
                    }
                    else add=true;
                }
            }
            else add=true;
            if (add) {
                for (Exemplar e:exemplares) {
                    if (e.getCodigo().equals(codigo)) {
                        int i = insertItemList(e.getCodigo() +" - "+ e.getL().getTitulo());
                        selecionados.add(i, e);
                        exemplares.remove(e);
                        updateLivroBox();
                        //System.out.println(" INDEX "+ selecionados.indexOf(e) +" - ADICIONAR "+ e.toString() );
                        break;
                    }
                }
            }
            
        }
    }//GEN-LAST:event_addListLivroBtnActionPerformed

    private void limparLivroListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparLivroListActionPerformed
        if (model.getSize() > 0) {
            model.removeAllElements();
            livroList.setModel(model);
            selecionados.clear(); 
            //System.out.println(" LISTA VAZIA? "+ selecionados.isEmpty() );
        }
        else limparLivroList.setEnabled(false);
    }//GEN-LAST:event_limparLivroListActionPerformed

    private void removerLivroListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerLivroListActionPerformed
        if (livroList.getSelectedIndex() > -1) {
            int index = livroList.getSelectedIndex();
            removeItemList( index );
            for (Exemplar s:selecionados) {
                if (selecionados.indexOf(s) == index) {
                    selecionados.remove( s );
                    //System.out.println(" INDEX "+ selecionados.indexOf(s) +" - REMOVER "+ s.toString() );
                    break;
                }
            }
        }
        else removerLivroList.setEnabled(false);
    }//GEN-LAST:event_removerLivroListActionPerformed

    private void livroListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livroListMouseClicked
        if (livroList.getSelectedIndex() > -1) {
            limparLivroList.setEnabled(true);
            removerLivroList.setEnabled(true);
        }
        else {
            limparLivroList.setEnabled(false);
            removerLivroList.setEnabled(false);
        }
    }//GEN-LAST:event_livroListMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        selecionados.stream().forEach((e) -> {
            System.out.println("INDEX "+ selecionados.indexOf(e) +" - "+ e.toString());
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void salvarEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarEmprestimoBtnActionPerformed
       if (model.getSize() > 0 && !selecionados.isEmpty()) {
           if (pessoaBox.getSelectedIndex() > -1) {
               salvarEmprestimoBtn.setEnabled(false);
               String codigo_pessoa = pessoaBox.getSelectedItem().toString();
               Pessoa alugador=new Pessoa(0,0,null,null,null);
               for (Pessoa p:pessoas) {
                   if (codigo_pessoa.equals(p.getCodigo())) {
                       alugador=p;
                       pessoas.remove(p);
                       break;
                   }
               }
               if (EmprestimoController.Salvar(alugador.getId_pessoa(), selecionados, ldt, null)) {
                   Runnable t1 = () -> {
                        if (eif != null)
                            eif.updateEmprestimoTable("");
                        if (lif != null)
                            lif.updateExemplarTableModel("");
                        exemplares.removeAll(selecionados);
                        updateLivroBox();
                        updatePessoaBox();
                        selecionados.clear();
                        model = new DefaultListModel();
                        livroList.setModel(model);
                    };
                    new Thread(t1).start();
                   
                    salvarEmprestimoBtn.setEnabled(true);
                    //pessoaBox.setSelectedIndex(0);
                    pessoaLabel.setText("Código, nome, turma...");
                    buscaPessoaField.setText("");
                    buscaLivroField.setText("");
                    //livroBox.setSelectedIndex(0);
                    codigoLabel.setText("Selecione o Código:");
                    escolhePessoaBtn.setEnabled(true);
                    pessoaBox.setEnabled(true);
               }
               else salvarEmprestimoBtn.setEnabled(true);
           } else JOptionPane.showMessageDialog(null, "Selecione uma pessoa. ", "Atenção", JOptionPane.WARNING_MESSAGE);
       } else JOptionPane.showMessageDialog(null, "Selecione ao menos um exemplar. ", "Atenção", JOptionPane.WARNING_MESSAGE);

       
    }//GEN-LAST:event_salvarEmprestimoBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addListLivroBtn;
    private javax.swing.JTextField buscaLivroField;
    private javax.swing.JTextField buscaPessoaField;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JButton escolhePessoaBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton limparLivroList;
    private javax.swing.JComboBox<String> livroBox;
    private javax.swing.JList<String> livroList;
    private javax.swing.JComboBox<String> pessoaBox;
    private javax.swing.JLabel pessoaLabel;
    private javax.swing.JButton removerLivroList;
    private javax.swing.JButton salvarEmprestimoBtn;
    // End of variables declaration//GEN-END:variables
}