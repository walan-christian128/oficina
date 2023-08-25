/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.DAO;

import br.com.oficina.model.Clientes;
import br.com.oficina.model.Modelo;
import br.com.oficina.model.OS;
import br.com.oficina.model.Produtos;
import br.com.oficina.model.intesOS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OSDAO {

    private Connection con;

    public OSDAO() {
        this.con = new ConexaoModulo().getConnection();

    }

    public OS pesquisaOS(String id) {
        try {
            String sql = "SELECT "
                    + "                os.id, "
                    + "                date_format(os.data,'%d/%m/%Y') as data,"
                    + "                os.status,"
                    + "                modelo.descricacao, "
                    + "                os.tecnico, "
                    + "                os.descricao_cliente, "
                    + "                os.servico_executado, "
                    + "                os.id_cliente,       "
                    + "                os.valor, "
                    + "	               os.tipo "
                    + "                from os "
                    + "                inner join tbmodelo modelo on modelo.id = os.id_modelo "
                    + "                inner join tbcliente cli on cli.idcli = os.id_cliente "
                    + "		 where os.id = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            OS obj = new OS();

            if (rs.next()) {
                obj.setId(rs.getInt("os.id"));
                obj.setData(rs.getString("data"));
                obj.setStatus(rs.getString("os.status"));
                Modelo mod = new Modelo();
                mod.setDescricacao(rs.getString("modelo.descricacao"));
                obj.setModelo(mod);

                obj.setTecnico(rs.getString("os.tecnico"));
                obj.setDescricao_cliente(rs.getString("os.descricao_cliente"));
                obj.setServico_executado(rs.getString("os.servico_executado"));

                Clientes cli = new Clientes();
                cli.setIdcli(rs.getInt("os.id_cliente"));
                obj.setCliente(cli);

                obj.setValor(rs.getDouble("os.valor"));
                obj.setTipo(rs.getString("os.tipo"));
                return obj;
            } else {
                JOptionPane.showMessageDialog(null, "ORDEM NÃO CADASTRADA");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cadstrarOs(OS os) {
        try {
            String sql = "insert into os(status, id_modelo, tecnico, descricao_cliente, servico_executado, valor, id_cliente, tipo) values(?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, os.getStatus());
            stmt.setInt(2, os.getModelo().getId());
            stmt.setString(3, os.getTecnico());
            stmt.setString(4, os.getDescricao_cliente());
            stmt.setString(5, os.getServico_executado());
            stmt.setDouble(6, os.getValor());

            stmt.setInt(7, os.getCliente().getIdcli());

            stmt.setString(8, os.getTipo());

            stmt.execute();

            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public int retornaultimaOS() {
        int idOS = 0;
        try {
            String sql = "select max(id)id from os ";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                OS os = new OS();
                os.setId(rs.getInt("id"));
                idOS = os.getId();
            }
            return idOS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Clientes> retornaClienteOS(String id) {
        try {
            List<Clientes> lista = new ArrayList<>();
            String sql = "select cli.idcli, cli.nomecli, cli.endereco,cli.fonecli,cli.emailcli from tbcliente cli "
                    + "inner join os os on cli.idcli = os.id_cliente "
                    + "where os.id = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setIdcli(rs.getInt("idcli"));
                cli.setNomecli(rs.getString("nomecli"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setFonecli(rs.getString("fonecli"));
                cli.setEmailcli(rs.getString("emailcli"));

                lista.add(cli);

            }
            return lista;

        } catch (Exception e) {
            return null;
        }

    }
      public List<Produtos> retornaProdutosOS(String idOS) {
        String sql = "SELECT  prod.idprod,prod.descricaoprod,prod.preco,iet.qtd_os "
                    + "FROM tbproduto prod "
                    + "inner join intesos iet on prod.idprod = iet.id_prod "
                    + "inner join OS os       on iet.id_os   = os.id "
                    + "where os.id = ?";
        try {
            List<Produtos> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, idOS);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
            Produtos prod = new Produtos();
             prod.setIdprod(rs.getInt("prod.idprod"));
             prod.setDescricaoprod(rs.getString("prod.descricaoprod"));
             prod.setPreco(rs.getDouble("prod.preco"));
             
             intesOS iet = new intesOS();
             iet.setQtd_os(rs.getInt("iet.qtd_os"));
             
             lista.add(prod);
             
            }
            
            return lista;
           
        } catch (Exception e) {
                

            return null;
             
        }
        
        
        

    }

}
