/*
 * The MIT License
 *
 * Copyright 2023 Walan.
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
package br.com.oficina.telas;

import br.com.oficina.DAO.ConexaoModulo;
import br.com.oficina.DAO.ProdutosDAO;
import br.com.oficina.model.Produtos;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walan
 */
public class ControleEstoque extends javax.swing.JFrame {

    private Connection con;
    DefaultTableModel addOSpecas;
    
    public ControleEstoque() {
        initComponents();
        this.con = new ConexaoModulo().getConnection();
        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(TelaLOgin.class.getResource("/br/com/oficina/icon/3605320_maintenance_mechanic_repair_spanner_support_icon.png")));
        setTitle("Controle de estoque");

    }

    private void cadastrarProduto() {
        Produtos prod = new Produtos();
        prod.setDescricaoprod(txtdescricao.getText());
        prod.setPreco(Double.parseDouble(txtpreco.getText().replace(",", ".")));
        prod.setQtd(Integer.parseInt(txtqtd.getText()));
        
        ProdutosDAO dao = new ProdutosDAO();
        dao.cadastraProduto(prod);
        limparCampos();

    }

    private void limparCampos() {
        txtID.setText(null);
        txtdescricao.setText(null);
        txtpreco.setText(null);
        txtqtd.setText(null);
        btncadastrar.setEnabled(true);

    }

    private void listarProdutos() {
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.pesquisarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tblProdutos.getModel();
        dados.setNumRows(0);
        for (Produtos p : lista) {
            dados.addRow(new Object[]{
                p.getIdprod(),
                p.getDescricaoprod(),
                p.getPreco(),
                p.getQtd()

            });
        }

    }

    private void alterarEstoque() {
        
        
        Produtos prod = new Produtos();
        ProdutosDAO dao = new ProdutosDAO();

        prod.setDescricaoprod(txtdescricao.getText());
        prod.setPreco(Double.parseDouble(txtpreco.getText().replace(",", ".")));
        prod.setQtd(Integer.parseInt(txtqtd.getText()));
        prod.setIdprod(Integer.parseInt(txtID.getText()));

        dao.atualizarEstoque(prod);
        limparCampos();

    }

    private void apagarProduto() {
        Produtos prod = new Produtos();
        prod.setIdprod(Integer.parseInt(txtID.getText()));

        ProdutosDAO dao = new ProdutosDAO();
        dao.apagarProduto(prod);
        limparCampos();

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtqtd = new javax.swing.JTextField();
        txtdescricao = new javax.swing.JTextField();
        txtpreco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btncadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Controle de estoque ");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Codigo:");

        btnExcluir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Quantidade:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Descrição:");

        txtpesquisa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyPressed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtqtd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtdescricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtpreco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Nome:");

        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setText("Pesquisar");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Preço", "Quantidade No Estoque "
            }
        ));
        tblProdutos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblProdutosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton3.setText("Pesquisar");

        btncadastrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btncadastrar.setText("Cadastrar");
        btncadastrar.setToolTipText("Novo");
        btncadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAtualizar.setText("Atualizar ");
        btnAtualizar.setToolTipText("Alterar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Preço:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(97, 97, 97))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(261, 261, 261)))
                        .addGap(263, 263, 263))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(566, Short.MAX_VALUE)
                    .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(250, 250, 250)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtualizar, btnExcluir, btncadastrar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(btncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(691, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(931, 671));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        apagarProduto();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        cadastrarProduto();
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        alterarEstoque();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblProdutosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblProdutosAncestorAdded
        listarProdutos();
    }//GEN-LAST:event_tblProdutosAncestorAdded

    private void txtpesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyPressed

        String descricao = "%" + txtpesquisa.getText() + "%";
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.pesquisarProdutos(descricao);
        DefaultTableModel dados = (DefaultTableModel) tblProdutos.getModel();
        dados.setNumRows(0);
        for (Produtos p : lista) {
            dados.addRow(new Object[]{
                p.getIdprod(),
                p.getDescricaoprod(),
                p.getPreco(),
                p.getQtd()

            });
        }
    }//GEN-LAST:event_txtpesquisaKeyPressed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        txtID.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString());
        txtdescricao.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1).toString());
        txtpreco.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 2).toString());
        txtqtd.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 3).toString());
        Produtos prod = new Produtos();

        ProdutosDAO dao = new ProdutosDAO();
        prod = dao.consultarProdutos(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1).toString());
        btncadastrar.setEnabled(false);
    }//GEN-LAST:event_tblProdutosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtpreco;
    private javax.swing.JTextField txtqtd;
    // End of variables declaration//GEN-END:variables
}
