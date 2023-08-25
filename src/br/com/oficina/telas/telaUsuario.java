/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.telas;

import br.com.oficina.DAO.ConexaoModulo;
import br.com.oficina.DAO.UsuarioDAO;
import br.com.oficina.model.Usuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Walan
 */
public class telaUsuario extends javax.swing.JFrame {

    private Connection con;

    public telaUsuario() {

        initComponents();
        this.con = new ConexaoModulo().getConnection();
        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(TelaLOgin.class.getResource("/br/com/oficina/icon/3605320_maintenance_mechanic_repair_spanner_support_icon.png")));
        setTitle("Cadastro de usuário");
    }

    public void consultarUsuario() {
        String sql = "select * from tbusuario where iduser = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, txtId.getText());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                txtNome.setText(rs.getString(2));
                txtfone.setText(rs.getString(3));
                txtlogin.setText(rs.getString(4));
                txtsenha.setText(rs.getString(5));
                cbxperfil.setSelectedItem(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "USUÁRIO NÃO CADASTRADO");
                txtNome.setText(null);
                txtfone.setText(null);
                txtlogin.setText(null);
                txtsenha.setText(null);
                cbxperfil.setSelectedItem(null);
            }

        } catch (Exception e) {
        }

    }

  

    public void atualizarUsuario() {
        String sql = "update tbusuario set usuario=?,fone=?,login=?,senha=?,tipo_usuario=? where iduser=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, txtNome.getText());
            stmt.setString(2, txtfone.getText());
            stmt.setString(3, txtlogin.getText());
            stmt.setString(4, txtsenha.getText());
            stmt.setString(5, cbxperfil.getSelectedItem().toString());
            stmt.setString(6, txtId.getText());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "USUÁRIO ALTERADO COM SUCESSSO");
            txtNome.setText(null);
            txtfone.setText(null);
            txtlogin.setText(null);
            txtsenha.setText(null);
            cbxperfil.setSelectedItem(null);
            txtId.setText(null);
        } catch (Exception e) {
        }

    }

    public void apagarUsuario() {

        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA REMOVER ESSE USUÁRIO", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {

            String sql = "delete from tbusuario where iduser =?";

            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, txtId.getText());
                stmt.execute();
                JOptionPane.showMessageDialog(null, "USUÁRIO APAGADO COM SUCESSO");
                txtNome.setText(null);
                txtId.setText(null);
                txtfone.setText(null);
                txtlogin.setText(null);
                txtsenha.setText(null);
                cbxperfil.setSelectedItem(null);

            } catch (Exception e) {
            }
        }
    
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtlogin = new javax.swing.JTextField();
        txtsenha = new javax.swing.JTextField();
        cbxperfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtfone = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnpesquisar = new javax.swing.JButton();
        btnatualizar = new javax.swing.JButton();
        btnapagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Login");

        jLabel4.setText("Perfil");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Senha");

        txtNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtlogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtsenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cbxperfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbxperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADM", "USER" }));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Fone:");

        txtfone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/add.png"))); // NOI18N
        btnadd.setToolTipText("Adicionar ");
        btnadd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadd.setPreferredSize(new java.awt.Dimension(80, 80));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnpesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/read.png"))); // NOI18N
        btnpesquisar.setToolTipText("Pesquisar ");
        btnpesquisar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnpesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpesquisar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
            }
        });

        btnatualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/update.png"))); // NOI18N
        btnatualizar.setToolTipText("Atualizar");
        btnatualizar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnatualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnatualizar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatualizarActionPerformed(evt);
            }
        });

        btnapagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/delete.png"))); // NOI18N
        btnapagar.setToolTipText("Apagar");
        btnapagar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnapagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnapagar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnapagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnadd, btnapagar, btnatualizar, btnpesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbxperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnapagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnadd, btnapagar, btnatualizar, btnpesquisar});

        setSize(new java.awt.Dimension(628, 458));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       Usuario user = new Usuario();
         user.setNomeuser(txtNome.getText());
         user.setFoneuser(Double.parseDouble(txtfone.getText()));
         user.setLoginuser(txtlogin.getText());
         user.setPassworduser(txtsenha.getText());
         user.setPerfiluser(cbxperfil.getSelectedItem().toString());
         
         UsuarioDAO dao = new UsuarioDAO();
         
         dao.cadastraUsuario(user);
          txtNome.setText(null);
          txtId.setText(null);
          txtfone.setText(null);
          txtlogin.setText(null);
          txtsenha.setText(null);
          cbxperfil.setSelectedItem(null);
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarActionPerformed
        apagarUsuario();
    }//GEN-LAST:event_btnapagarActionPerformed

    private void btnatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatualizarActionPerformed
        atualizarUsuario();
    }//GEN-LAST:event_btnatualizarActionPerformed

    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
        consultarUsuario();
    }//GEN-LAST:event_btnpesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnapagar;
    private javax.swing.JButton btnatualizar;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.JComboBox<String> cbxperfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtfone;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtsenha;
    // End of variables declaration//GEN-END:variables
}
