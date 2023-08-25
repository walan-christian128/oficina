/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.telas;

import br.com.oficina.DAO.ConexaoModulo;
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
public class TelaLOgin extends javax.swing.JFrame {

    private Connection con;

    public TelaLOgin() {
        initComponents();
        this.con = new ConexaoModulo().getConnection();
        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(TelaLOgin.class.getResource("/br/com/oficina/icon/home.png")));
        setTitle("Oficina_login_wt");
        if (con != null) {
            jlstatus.setIcon(new javax.swing.ImageIcon(
                    getClass().getResource("/br/com/oficina/icon/49574_accept_database_icon.png")));
        } else {
            jlstatus.setIcon(new javax.swing.ImageIcon(
                    getClass().getResource("/br/com/oficina/icon/49610_database_from_remove_icon.png")));

        }
    }

    public void Logar() {
        //Metodo de login simples 
        try {
            String sql = "select * from tbusuario where login =? and senha =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, jtxusuario.getText());
            stmt.setString(2, jtxsenha.getText());

            ResultSet rs = stmt.executeQuery();

            //validação de ususario e senha correto 
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "USUARIO LOGADO COM SUCESSO ");

            } else {

                JOptionPane.showMessageDialog(null, "USUARIO E/OU SENHA INVALIDA");
            }
            //Condições de habilitar funcões do menu 
            if (rs.getString("tipo_usuario").equals("ADM")) {

                TelaPrinciapl tela = new TelaPrinciapl();
                tela.usuarioLogado = rs.getString("usuario");
                tela.setVisible(true);
            } else if (rs.getString("tipo_usuario").equals("USER")) {

                TelaPrinciapl tela = new TelaPrinciapl();
                tela.usuarioLogado = rs.getString("usuario");
                tela.menCadUsu.setEnabled(false);
                tela.relSer.setEnabled(false);
                tela.menREL.setEnabled(false);
                tela.setVisible(true);

            }

        } catch (Exception e) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlstatus = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxusuario = new javax.swing.JTextField();
        jtxsenha = new javax.swing.JPasswordField();
        Entrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel1.setText("Usuario:");

        jlstatus.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel3.setText("Nome da empresa");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel4.setText("Senha:");

        jtxusuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtxusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxusuarioActionPerformed(evt);
            }
        });

        jtxsenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        Entrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Entrar.setText("Entrar");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxusuarioActionPerformed

    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
        Logar();
        this.dispose();
    }//GEN-LAST:event_EntrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLOgin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLOgin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLOgin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLOgin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLOgin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlstatus;
    private javax.swing.JPasswordField jtxsenha;
    private javax.swing.JTextField jtxusuario;
    // End of variables declaration//GEN-END:variables
}
