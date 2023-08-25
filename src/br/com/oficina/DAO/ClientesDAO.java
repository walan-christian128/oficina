/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.DAO;

import br.com.oficina.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adm_walan.costa
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        this.con = new ConexaoModulo().getConnection();

    }
    public void cadastraCliente(Clientes obj) {
    String sql = "insert into tbcliente(nomecli,endereco,fonecli,emailcli)values(?,?,?,?)";
    try {
        ConexaoModulo conexaoModulo = new ConexaoModulo();
        Connection con = conexaoModulo.getConnection();
        
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, obj.getNomecli());
        stmt.setString(2, obj.getEndereco());
        stmt.setString(3, obj.getFonecli());
        stmt.setString(4, obj.getEmailcli());

        int adicionado = stmt.executeUpdate();
        if (adicionado > 0) {
            JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO ");
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NÃO CADASTRADO");
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        // Adicione um diálogo de erro ou mensagem adequada para o usuário.
    } finally {
        // Fechar a conexão no bloco finally para garantir que ela seja liberada.
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


    public Clientes visualizarClientes(String nome) {
        try {

            String sql = "select * from tbcliente where nomecli like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            while (rs.next()) {

                obj.setIdcli(rs.getInt("idcli"));
                obj.setNomecli(rs.getString("nomecli"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setFonecli(rs.getString("fonecli"));
                obj.setEmailcli(rs.getString("emailcli"));

            }
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);

        }
        return null;

    }

    public List<Clientes> listaClientes(String nome) {
        try {
            List<Clientes> lista = new ArrayList<>();
            String sql = "select * from tbcliente where nomecli like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            while (rs.next()) {

                obj.setIdcli(rs.getInt("idcli"));
                obj.setNomecli(rs.getString("nomecli"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setFonecli(rs.getString("fonecli"));
                obj.setEmailcli(rs.getString("emailcli"));
                lista.add(obj);

            }
           return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
                return null;
        }
       

    }

    public List<Clientes> listaClientes() {
        try {
            List<Clientes> lista = new ArrayList<>();
            String sql = "select * from tbcliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();
                obj.setIdcli(rs.getInt("idcli"));
                obj.setNomecli(rs.getString("nomecli"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setFonecli(rs.getString("fonecli"));
                obj.setEmailcli(rs.getString("emailcli"));

                lista.add(obj);

            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

    public void alterarClientes(Clientes obj) {
        try {
            String sql = "update tbcliente set nomecli=?,endereco=?,fonecli=?,emailcli=? where idcli = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNomecli());
            stmt.setString(2, obj.getEndereco());
            stmt.setString(3, obj.getFonecli());
            stmt.setString(4, obj.getEmailcli());
            stmt.setInt(5, obj.getIdcli());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "CLIENTE ALTERADO COM SUCESSO");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "HOUVE UM ERRO CONFIRA O SQL" + erro);
        }

    }

    public void excluirCliente(Clientes obj) {
        int confirma = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXCLUIR O CLIENTE?", "ATENÇÃO", JOptionPane.YES_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            try {
                String sql = "delete from tbclientes where idcli =?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, obj.getIdcli());
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "CLIENTE EXCLUINDO COM SUCESSSO");

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "HOUVE UM ERRO" + erro);
            }
        }

    }
     public Clientes retornaCliente(int idCli) {
	try {
    	String sql = "SELECT * FROM tbcliente WHERE idcli = ?";
    	PreparedStatement stmt = con.prepareStatement(sql);
    	stmt.setInt(1, idCli);
    	ResultSet rs = stmt.executeQuery();
   	 
    	if (rs.next()) {
        	Clientes cli = new Clientes();
        	cli.setIdcli(rs.getInt("idcli"));
        	// Defina outros atributos de 'cli' aqui, conforme necessário
        	return cli;
    	} else {
        	return null; // Retorna nulo se o cliente não for encontrado
    	}
	} catch (Exception e) {
    	throw new RuntimeException(e);
	}
}


}
