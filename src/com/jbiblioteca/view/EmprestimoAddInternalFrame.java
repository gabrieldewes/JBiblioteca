/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbiblioteca.view;

import com.jbiblioteca.controller.ConfigController;
import com.jbiblioteca.controller.EmprestimoController;
import com.jbiblioteca.controller.ExemplarController;
import com.jbiblioteca.controller.PessoaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import com.jbiblioteca.model.Exemplar;
import com.jbiblioteca.model.Pessoa;
import org.joda.time.LocalDateTime;
import static com.jbiblioteca.view.MainFrame.eif;
import static com.jbiblioteca.view.MainFrame.lif;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

/**
 *
 * @author gabriel
 */
public final class EmprestimoAddInternalFrame extends javax.swing.JInternalFrame {
    
    private final ExemplarController exemplarController;
    private final PessoaController pessoaController;
    private final EmprestimoController emprestimoController;
    private final ConfigController configController;

    static List<Pessoa> pessoas;
    static List<Exemplar> exemplares;
    static List<Exemplar> filtrados;
    static List<Exemplar> selecionados;
    
    static DefaultListModel model;
    static int prazo_default;
    static boolean livroBoxHasFocus = false;
    
    public EmprestimoAddInternalFrame() {
        initComponents();
        
        exemplarController = ExemplarController.getInstance();
        pessoaController = PessoaController.getInstance();
        emprestimoController = EmprestimoController.getInstance();
        configController = ConfigController.getInstance();
        
        /* Passando valor default salvo em Opções>Preferencias>Prazo Default */
        prazo_default = configController.getPrazoDefault();
        prazoDiaSpinner.setValue(prazo_default);
        prazoPadraoRadio.setSelected(true);
        
        model = new DefaultListModel();
        livroList.setModel(model);
        
        selecionados = new ArrayList<>();
        filtrados = new ArrayList<>();
        pessoas = pessoaController.ArrayPessoa("");
        exemplares = exemplarController.ArrayExemplar(null, 0, "");
        updatePessoaBox();
        updateLivroBox();
        
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime prazo = new LocalDateTime().plusDays(prazo_default);
        String hojeToString = " "+ hoje.getDayOfMonth() +"/"+ hoje.getMonthOfYear() +"/"+ hoje.getYear() +" ";
        String prazoToString = " "+ prazo.getDayOfMonth() +"/"+ prazo.getMonthOfYear() +"/"+ prazo.getYear() +" ";
        dataInicioLabel.setText(""+ hojeToString);
        dataFimLabel.setText(""+ prazoToString);

    }
    
    void updatePessoaBox() {
        pessoaBox.removeAllItems();
        pessoas.stream().forEach((p) -> {
            pessoaBox.addItem( p.getCodigo() );
        }); 
    }
    
    void updateDataFimLabel(int plusDays) {
        LocalDateTime prazo = new LocalDateTime().plusDays(plusDays);
        String prazoToString = " "+ prazo.getDayOfMonth() +" / "+ prazo.getMonthOfYear() +" / "+ prazo.getYear() +" ";
        dataFimLabel.setText(""+ prazoToString);
    }
    
    void updateLivroBox() {
        livroBox.removeAllItems();
        exemplares.stream().forEach((e) -> {
            livroBox.addItem( e.getCodigo() );
        });
        if (exemplares.isEmpty()) {
            livroBox.addItem( "Nenhum resultado" );
        }
        
    }
    
    public void updateLivroFiltradoBox() {
        livroBox.removeAllItems();
        filtrados.stream().forEach((e) -> {
            livroBox.addItem( e.getCodigo() );
        });
        if (filtrados.isEmpty()) {
            livroBox.addItem( "Nenhum resultado" );
        }
        
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
        jPanel4 = new javax.swing.JPanel();
        removerLivroList = new javax.swing.JButton();
        limparLivroList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        livroList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscaLivroField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addListLivroBtn = new javax.swing.JButton();
        livroBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dataInicioLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prazoDiaSpinner = new javax.swing.JSpinner();
        prazoSemanaRadio = new javax.swing.JRadioButton();
        prazoMesRadio = new javax.swing.JRadioButton();
        prazoPadraoRadio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        dataFimLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        salvarEmprestimoBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        loadLabel = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Novo Empréstimo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pessoa  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        pessoaLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pessoaLabel.setText("Código, nome ou turma:");

        buscaPessoaField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscaPessoaField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscaPessoaFieldMouseClicked(evt);
            }
        });
        buscaPessoaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscaPessoaFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaPessoaFieldKeyReleased(evt);
            }
        });

        pessoaBox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        pessoaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        escolhePessoaBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        escolhePessoaBtn.setText("Selecionar");
        escolhePessoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolhePessoaBtnActionPerformed(evt);
            }
        });

        codigoLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        codigoLabel.setText("Selecione o código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pessoaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buscaPessoaField)
                                .addGap(6, 6, 6)))
                        .addComponent(escolhePessoaBtn)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoLabel)
                            .addComponent(pessoaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pessoaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaPessoaField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escolhePessoaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pessoaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Livros  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        removerLivroList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        removerLivroList.setText("Remover");
        removerLivroList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerLivroListActionPerformed(evt);
            }
        });

        limparLivroList.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Código, título, autor:");

        buscaLivroField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        buscaLivroField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscaLivroFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaLivroFieldKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Selecione o código: ");

        addListLivroBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addListLivroBtn.setText("Adicionar à lista");
        addListLivroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListLivroBtnActionPerformed(evt);
            }
        });

        livroBox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        livroBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        livroBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                livroBoxFocusGained(evt);
            }
        });
        livroBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livroBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buscaLivroField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(livroBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addListLivroBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaLivroField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livroBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addListLivroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removerLivroList)
                    .addComponent(limparLivroList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(removerLivroList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limparLivroList)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Devolução  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Data de Início");

        dataInicioLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dataInicioLabel.setText("jLabel4");

        jLabel4.setText("Dias para Devolução:");

        prazoDiaSpinner.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        prazoDiaSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        prazoSemanaRadio.setText("Semana");
        prazoSemanaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prazoSemanaRadioActionPerformed(evt);
            }
        });

        prazoMesRadio.setText("Mês");
        prazoMesRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prazoMesRadioActionPerformed(evt);
            }
        });

        prazoPadraoRadio.setText("Padrão");
        prazoPadraoRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prazoPadraoRadioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Encerramento");

        dataFimLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dataFimLabel.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(prazoDiaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(prazoSemanaRadio)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(prazoMesRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prazoPadraoRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(3, 3, 3)
                        .addComponent(dataFimLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dataInicioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataFimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prazoPadraoRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(prazoMesRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prazoSemanaRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prazoDiaSpinner))
                .addContainerGap())
        );

        salvarEmprestimoBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        salvarEmprestimoBtn.setText("  Salvar  Empréstimo");
        salvarEmprestimoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarEmprestimoBtnActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(salvarEmprestimoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarEmprestimoBtn)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loadLabel)
                .addGap(213, 213, 213))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaPessoaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaPessoaFieldKeyReleased
        
    }//GEN-LAST:event_buscaPessoaFieldKeyReleased

    private void escolhePessoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolhePessoaBtnActionPerformed
        if (pessoaBox.getSelectedIndex() != -1) {
            String codigo = pessoaBox.getSelectedItem().toString();
            if (!"".equals(codigo) && codigo != null) {
                if (!pessoas.isEmpty()) {
                    for (Pessoa p : pessoas) {
                        if (codigo.equals(p.getCodigo())) {
                            buscaPessoaField.setText(p.getNome());
                            escolhePessoaBtn.setEnabled(false);
                            pessoaLabel.setText("Selecionado: ");
                            codigoLabel.setText("Código: ");
                            pessoaBox.setEnabled(false);
                            break;
                        }
                    }
                }
            }
        }
        else JOptionPane.showMessageDialog(null, "Não há pessoas cadastradas! . ", "Atenção", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_escolhePessoaBtnActionPerformed

    private void limparLivroListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparLivroListActionPerformed
        if (model.getSize() > 0) {
            model.removeAllElements();
            livroList.setModel(model);
            selecionados.clear(); 
            exemplares = exemplarController.ArrayExemplar(null, 0, "");
            updateLivroBox();
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
                    exemplares.add(s);
                    updateLivroBox();
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

    private void salvarEmprestimoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarEmprestimoBtnActionPerformed
       if (model.getSize() > 0 && !selecionados.isEmpty()) {
           if (pessoaBox.getSelectedIndex() > -1) {
               salvarEmprestimoBtn.setEnabled(false);
               String codigo_pessoa = pessoaBox.getSelectedItem().toString();
               Pessoa locador = new Pessoa(0,0,null,null);
               for (Pessoa p:pessoas) {
                   if (codigo_pessoa.equals(p.getCodigo())) {
                       locador = p;
                       pessoas.remove(p);
                       break;
                   }
               }
               int plus_days = Integer.valueOf(prazoDiaSpinner.getValue().toString());
               LocalDateTime inicio = new LocalDateTime(System.currentTimeMillis());
               LocalDateTime fim = inicio.plusDays(plus_days);
               if (emprestimoController.Salvar(locador.getId_pessoa(), selecionados, inicio, fim)) {
                    if (eif != null)
                        eif.updateEmprestimoTable("");
                    if (lif != null)
                        lif.updateExemplarTableModel("");
                    exemplares.removeAll(selecionados);
                    updateLivroBox();
                    updatePessoaBox();
                    selecionados.clear();
                    model = new DefaultListModel();
                    prazoDiaSpinner.setValue(prazo_default);
                    livroList.setModel(model);
                   
                    salvarEmprestimoBtn.setEnabled(true);
                    pessoaLabel.setText("Código, nome, turma:");
                    buscaPessoaField.setText("");
                    buscaLivroField.setText("");
                    codigoLabel.setText("Selecione o Código:");
                    escolhePessoaBtn.setEnabled(true);
                    pessoaBox.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "Empréstimo salvo com êxito.");
               }
               else salvarEmprestimoBtn.setEnabled(true);
           } else JOptionPane.showMessageDialog(null, "Selecione uma pessoa. ", "Atenção", JOptionPane.WARNING_MESSAGE);
       } else JOptionPane.showMessageDialog(null, "Selecione ao menos um exemplar. ", "Atenção", JOptionPane.WARNING_MESSAGE);

       
    }//GEN-LAST:event_salvarEmprestimoBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prazoMesRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prazoMesRadioActionPerformed
        prazoDiaSpinner.setValue(30);
        prazoSemanaRadio.setSelected(false);
        prazoPadraoRadio.setSelected(false);
        updateDataFimLabel(30);
    }//GEN-LAST:event_prazoMesRadioActionPerformed

    private void prazoSemanaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prazoSemanaRadioActionPerformed
        prazoDiaSpinner.setValue(7);
        prazoMesRadio.setSelected(false);
        prazoPadraoRadio.setSelected(false);
        updateDataFimLabel(7);
    }//GEN-LAST:event_prazoSemanaRadioActionPerformed

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
                        int i = insertItemList(e.getCodigo() +" - "+ e.getLivro().getTitulo());
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

    private void prazoPadraoRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prazoPadraoRadioActionPerformed
        prazoDiaSpinner.setValue(prazo_default);
        prazoSemanaRadio.setSelected(false);
        prazoMesRadio.setSelected(false);
        updateDataFimLabel(prazo_default);
    }//GEN-LAST:event_prazoPadraoRadioActionPerformed

    private void livroBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livroBoxActionPerformed

        if (livroBoxHasFocus && evt.getActionCommand().equals("comboBoxChanged")) {            
            String codSelecionado  = ((String) ((JComboBox) evt.getSource()).getSelectedItem());
            
            for (Exemplar ex : exemplares) {
                
                if (ex.getCodigo().equals(codSelecionado)) {
                    buscaLivroField.setText(ex.getLivro().getTitulo());
                    break;
                }
            }
        }
    }//GEN-LAST:event_livroBoxActionPerformed

    private void buscaLivroFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaLivroFieldKeyTyped
        
    }//GEN-LAST:event_buscaLivroFieldKeyTyped

    private void buscaLivroFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaLivroFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String str = buscaLivroField.getText();
            if (!"".equals(str.trim()) && !str.isEmpty()) {
                filtrados = exemplarController.ArrayExemplar(null, 0, str);
                updateLivroFiltradoBox();
                livroBoxHasFocus = false;
            }
        }
    }//GEN-LAST:event_buscaLivroFieldKeyPressed

    private void livroBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_livroBoxFocusGained
        livroBoxHasFocus = true;
    }//GEN-LAST:event_livroBoxFocusGained

    private void buscaPessoaFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaPessoaFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String str = buscaPessoaField.getText();
            pessoas = pessoaController.ArrayPessoa(str);
            updatePessoaBox();
        }
    }//GEN-LAST:event_buscaPessoaFieldKeyPressed

    private void buscaPessoaFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscaPessoaFieldMouseClicked
        escolhePessoaBtn.setEnabled(true);
        pessoaLabel.setText("Código, nome ou turma:");
        codigoLabel.setText("Selecione o código:");
        pessoaBox.setEnabled(true);
    }//GEN-LAST:event_buscaPessoaFieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addListLivroBtn;
    private javax.swing.JTextField buscaLivroField;
    private javax.swing.JTextField buscaPessoaField;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel dataFimLabel;
    private javax.swing.JLabel dataInicioLabel;
    private javax.swing.JButton escolhePessoaBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparLivroList;
    private javax.swing.JComboBox<String> livroBox;
    private javax.swing.JList<String> livroList;
    private javax.swing.JLabel loadLabel;
    private javax.swing.JComboBox<String> pessoaBox;
    private javax.swing.JLabel pessoaLabel;
    private javax.swing.JSpinner prazoDiaSpinner;
    private javax.swing.JRadioButton prazoMesRadio;
    private javax.swing.JRadioButton prazoPadraoRadio;
    private javax.swing.JRadioButton prazoSemanaRadio;
    private javax.swing.JButton removerLivroList;
    private javax.swing.JButton salvarEmprestimoBtn;
    // End of variables declaration//GEN-END:variables
}
