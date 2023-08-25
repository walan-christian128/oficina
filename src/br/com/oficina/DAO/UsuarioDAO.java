
package br.com.oficina.DAO;

import br.com.oficina.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UsuarioDAO {
 
    private Connection con;

    public UsuarioDAO() {
        this.con = new ConexaoModulo().getConnection();

    }
     public void cadastraUsuario(Usuario obj) {

        String sql = "insert into tbusuario(nomeuser,foneuser,loginuser,passworduser,perfiluser)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNomeuser());
            stmt.setDouble(2, obj.getFoneuser());
            stmt.setString(3, obj.getLoginuser());
            stmt.setString(4, obj.getPassworduser());
            stmt.setString(5, obj.getPerfiluser());


            int adicionado = stmt.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "USUÁRIO CADASTRADO COM SUCESSO");
               
            }
            stmt.close();
        } catch (Exception e) {
        }

    }

    
}
