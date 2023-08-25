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

/**
 *
 * @author Walan
 */
public class itenOSDAO {

    private Connection con;

    public itenOSDAO() {
        this.con = new ConexaoModulo().getConnection();

    }

    public void cadastraIntesOs(intesOS obj) {

        String sql = "insert into intesos(id_prod,qtd_os,id_os)values(?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getProduto().getIdprod());
            stmt.setInt(2, obj.getQtd_os());
            stmt.setInt(3, obj.getOs().getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }

    }

    public List<intesOS> listaIntensOrdem(int id) {
        try {
            List<intesOS> lista = new ArrayList<>();
            String sql = "select o.id,o.data,o.tipo,o.status,o.id_modelo,o.servico_executado,o.valor,it.qtd_os,p.descricaoprod,p.preco from tbitensos as it"
                    + "inner join tbprodutos as p on (it.idprod = p.idprod)"
                    + "inner join tbos as o on (it.iditen = o.id)"
                    + "where o.id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                intesOS item = new intesOS();
                Produtos prod = new Produtos();
                Modelo mod = new Modelo();
                OS os = new OS();
                os.setId(rs.getInt("o.id"));
                os.setData(rs.getString("o.data"));
                os.setStatus(rs.getString("o.status"));
                mod.setId(rs.getInt("o.id_modelo"));
                os.setServico_executado(rs.getString("o.servico_executado"));
                os.setValor(rs.getDouble("o.servico_executado"));
                item.setQtd_os(rs.getInt("it.qtd_os"));
                prod.setDescricaoprod(rs.getString("p.descricaoprod"));
                prod.setPreco(rs.getDouble("p.descricao"));
                
                item.setProduto(prod);
                
                lista.add(item);
            
            }
            
            return lista;
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "ERRO!" + e);
        }
             return null;
    }
}
