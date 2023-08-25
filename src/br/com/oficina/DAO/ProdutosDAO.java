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
package br.com.oficina.DAO;

import br.com.oficina.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walan
 */
public class ProdutosDAO {

    private Connection con;

    public ProdutosDAO() {
        con = new ConexaoModulo().getConnection();

    }

    public void cadastrarProduto(Produtos obj) {
         
        String sql = "insert into tbproduto(descricaoprod,preco,qtd)values(?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricaoprod());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd());

            stmt.execute();
            stmt.close();
        } catch (Exception e) {
        }

    }

    public List<Produtos> pesquisarProdutos() {
        String sql = "select * from tbproduto";
        try {
            List<Produtos> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                obj.setIdprod(rs.getInt("idprod"));
                obj.setDescricaoprod(rs.getString("descricaoprod"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd(rs.getInt("qtd"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro" + e);
        }
        return null;
    }

    public void atualizarEstoque(Produtos obj) {

        String sql = "update tbproduto set descricaoprod=?,preco=?,qtd=? where idprod = ?";
        int confirma = JOptionPane.showConfirmDialog(null, "DESEJA RELAMENTE ALTERA ESSE PRODUTO", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, obj.getDescricaoprod());
                stmt.setDouble(2, obj.getPreco());
                stmt.setInt(3, obj.getQtd());
                stmt.setInt(4, obj.getIdprod());

                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "PRODUTO ALTERADO COM SUCESSO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public List<Produtos> pesquisarProdutos(String descricao) {
        String sql = "select * from tbproduto where descricaoprod like ?";

        try {
            List<Produtos> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setIdprod(rs.getInt("idprod"));
                prod.setDescricaoprod(rs.getString("descricaoprod"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQtd(rs.getInt("qtd"));

                lista.add(prod);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!" + e);
            return null;
        }

    }

    public Produtos consultarProdutos(String descricao) {
        String sql = "select * from tbproduto where descricaoprod like ?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao);
            ResultSet rs = stmt.executeQuery();
            Produtos prod = new Produtos();
            if (rs.next()) {

                prod.setIdprod(rs.getInt("idprod"));
                prod.setDescricaoprod(rs.getString("descricaoprod"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQtd(rs.getInt("qtd"));

            }
            return prod;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!" + e);
            return null;
        }

    }

    public void apagarProduto(Produtos obj) {
        String sql = "delete from tbproduto where idprod = ?";

        int confirma = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA APAGAR ESSE PRODUTO", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {

            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, obj.getIdprod());
                stmt.execute();
                stmt.close();

                JOptionPane.showMessageDialog(null, "PRODUTO APAGADO COM SUCESSO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public void cadastraProduto(Produtos obj) {
        String sql = "insert into tbproduto(descricaoprod,preco,qtd)values(?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricaoprod());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SECESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void baixaEstoque(int idprod, int qtdNova) {
        try {
            String sql = "update tbproduto set qtd=? where idprod = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, qtdNova);
            stmt.setInt(2, idprod);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro" + e);
        }

    }

    public int retornaEstoqueAtual(int idprod) {
        try {
            int qtd = 0;
            String sql = "select qtd from tbproduto where idprod = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idprod);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                qtd = (rs.getInt("qtd"));
            }
            return qtd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void adicionarEstoque(int idprod, int qtdNova) {
        try {
            String sql = "update tbproduto set qtd=? where idprod = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtdNova);
            stmt.setInt(2, idprod);

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro" + e);
        }

    }
}
