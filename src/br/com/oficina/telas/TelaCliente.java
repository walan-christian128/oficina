/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.telas;

import br.com.oficina.DAO.ClientesDAO;
import br.com.oficina.DAO.ConexaoModulo;
import br.com.oficina.model.Clientes;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Walan
 */
public class TelaCliente extends javax.swing.JFrame {

    private Connection con;

    public TelaCliente() {
        initComponents();
        this.con = new ConexaoModulo().getConnection();
        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(TelaLOgin.class.getResource("/br/com/oficina/icon/3605320_maintenance_mechanic_repair_spanner_support_icon.png")));
        setTitle("Cadastro de cliente");
    }

   

    public void lista() {

        ClientesDAO dao = new ClientesDAO();
        List<Clientes> lista = dao.listaClientes();
        DefaultTableModel dados = (DefaultTableModel) tblClientes.getModel();
        dados.setNumRows(0);
        for (Clientes c : lista) {
            dados.addRow(new Object[]{
                c.getIdcli(),
                c.getNomecli(),
                c.getEndereco(),
                c.getFonecli(),
                c.getEmailcli()

            });
        }
    }

    public void setarCampos() {
        int setar = tblClientes.getSelectedRow();

        txtidcli.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtcliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        txtcliEndere.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        txtcliTel.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
        txtcliEmail.setText(tblClientes.getModel().getValueAt(setar, 4).toString());

    }

    private void limpar() {
        txtidcli.setText(null);
        txtpesquisarCLI.setText(null);
        txtcliNome.setText(null);
        txtcliEndere.setText(null);
        txtcliTel.setText(null);
        txtcliEmail.setText(null);
        ((DefaultTableModel) tblClientes.getModel()).setRowCount(0);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        textField1 = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcliEndere = new javax.swing.JTextField();
        txtcliEmail = new javax.swing.JTextField();
        txtcliNome = new javax.swing.JTextField();
        txtcliTel = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtpesquisarCLI = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtidcli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Endereço:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Telefone");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        txtcliEndere.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtcliEndere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcliEndereActionPerformed(evt);
            }
        });

        txtcliEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtcliEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcliEmailActionPerformed(evt);
            }
        });

        txtcliNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtcliNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcliNomeActionPerformed(evt);
            }
        });

        try {
            txtcliTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) - #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcliTel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/add.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/update.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/read.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/delete.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Nome:");

        txtpesquisarCLI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtpesquisarCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisarCLIActionPerformed(evt);
            }
        });
        txtpesquisarCLI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisarCLIKeyPressed(evt);
            }
        });

        tblClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do cliente", "Nome:", "Edereço", "Telefone", "E-mail"
            }
        ));
        tblClientes.setFocusable(false);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblClientesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        tblClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblClientesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        txtidcli.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtidcli.setEnabled(false);
        txtidcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcliActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Codigo do Clientes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcliEndere, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcliTel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)
                        .addComponent(txtidcli, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtpesquisarCLI, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtpesquisarCLI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidcli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(txtcliEndere, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcliTel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(24, 24, 24))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        setSize(new java.awt.Dimension(835, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcliEndereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcliEndereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcliEndereActionPerformed

    private void txtcliEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcliEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcliEmailActionPerformed

    private void txtcliNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcliNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcliNomeActionPerformed

    private void txtpesquisarCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisarCLIActionPerformed
  
    }//GEN-LAST:event_txtpesquisarCLIActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        
   
       Clientes obj = new Clientes();
       obj.setNomecli(txtcliNome.getText());
       obj.setEndereco(txtcliEndere.getText());
       obj.setFonecli(txtcliTel.getText());
       obj.setEmailcli(txtcliEmail.getText());
       
       ClientesDAO dao  = new ClientesDAO();
       dao.cadastraCliente(obj);

     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtpesquisarCLIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisarCLIKeyPressed

        String nome = "%" + txtpesquisarCLI.getText() + "%";
        ClientesDAO dao = new ClientesDAO();
        List<Clientes> lista = dao.listaClientes(nome);
        DefaultTableModel dados = (DefaultTableModel) tblClientes.getModel();
        dados.setNumRows(0);
        for (Clientes c : lista) {
            dados.addRow(new Object[]{
                c.getIdcli(),
                c.getNomecli(),
                c.getEndereco(),
                c.getFonecli(),
                c.getEmailcli()

            });
        }


    }//GEN-LAST:event_txtpesquisarCLIKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Clientes obj = new Clientes();
        obj.setIdcli(Integer.parseInt(txtidcli.getText()));
        ClientesDAO dao = new ClientesDAO();
        dao.excluirCliente(obj);
        limpar();
        jButton1.setEnabled(true);
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClientesKeyPressed

    }//GEN-LAST:event_tblClientesKeyPressed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        setarCampos();
        jButton1.setEnabled(false);
    }//GEN-LAST:event_tblClientesMouseClicked

    private void tblClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblClientesAncestorAdded
        lista();
    }//GEN-LAST:event_tblClientesAncestorAdded

    private void txtidcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcliActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Clientes obj = new Clientes();
        obj.setNomecli(txtcliNome.getText());
        obj.setEndereco(txtcliEndere.getText());
        obj.setFonecli(txtcliTel.getText());
        obj.setEmailcli(txtcliEmail.getText());
        obj.setIdcli(Integer.parseInt(txtidcli.getText()));

        ClientesDAO dao = new ClientesDAO();
        dao.alterarClientes(obj);
        limpar();
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private java.awt.TextField textField1;
    private javax.swing.JTextField txtcliEmail;
    private javax.swing.JTextField txtcliEndere;
    private javax.swing.JTextField txtcliNome;
    private javax.swing.JFormattedTextField txtcliTel;
    private javax.swing.JTextField txtidcli;
    private javax.swing.JTextField txtpesquisarCLI;
    // End of variables declaration//GEN-END:variables
}
