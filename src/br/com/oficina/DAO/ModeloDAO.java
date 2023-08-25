package br.com.oficina.DAO;

import br.com.oficina.model.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ModeloDAO {

    private Connection con;

    public ModeloDAO() {
        this.con = new ConexaoModulo().getConnection();

    }

    public void cadastraModelo(Modelo mod) {

        String sql = "insert into tbmodelo(descricacao,potencia,fabricante,ano)values (?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, mod.getDescricacao());
            stmt.setString(2, mod.getPotencia());
            stmt.setString(3, mod.getFabricante());
            stmt.setString(4, mod.getAno());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "MODELO CADASTRADO COM SUCESSO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro no sql ");
        }

    }

    public List<Modelo> consultaModelo(String descricacao) {
        String sql = "select * from tbmodelo where descricacao like ?";
        try {
            List<Modelo> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, descricacao);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Modelo mod = new Modelo();
                mod.setId(rs.getInt("id"));
                mod.setDescricacao(rs.getString("descricacao"));
                mod.setPotencia(rs.getString("potencia"));
                mod.setFabricante(rs.getString("fabricante"));
                mod.setAno(rs.getString("ano"));

                list.add(mod);

            }
            return list;
        } catch (Exception e) {

            return null;
        }

    }

    public List<Modelo> listaModelo() {
        String sql = "select * from tbmodelo";
        try {
            List<Modelo> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Modelo mod = new Modelo();
                mod.setId(rs.getInt("id"));
                mod.setDescricacao(rs.getString("descricacao"));
                mod.setPotencia(rs.getString("potencia"));
                mod.setFabricante(rs.getString("fabricante"));
                mod.setAno(rs.getString("ano"));

                list.add(mod);

            }
            return list;
        } catch (Exception e) {

            return null;
        }

    }

    public void alterarModelo(Modelo mod) {
        int alt = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA ALTERAR ESSE MODELO ?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (alt == JOptionPane.YES_OPTION) {
            String sql = "update tbmodelo set descricacao=?,potencia=?,fabricante=?,ano=? where id=? ";
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, mod.getDescricacao());
                stmt.setString(2, mod.getPotencia());
                stmt.setString(3, mod.getFabricante());
                stmt.setString(4, mod.getAno());
                stmt.setInt(5, mod.getId());

                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "MODELO ALTERADO COM SUCESSO");

            } catch (Exception e) {
            }

        }

    }

    public Modelo pesquisarModelo(String numOS) {
        Modelo mod = null;
        String sql = "SELECT * FROM tbmodelo WHERE id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, numOS);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                mod = new Modelo();
                mod.setId(rs.getInt("id"));
                mod.setDescricacao(rs.getString("descricacao"));
                mod.setPotencia(rs.getString("potencia"));
                mod.setFabricante(rs.getString("fabricante"));
                mod.setAno(rs.getString("ano"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mod;
    }
     public Modelo pesquisarModeloo(String nome) {
        Modelo mod = null;
        String sql = "SELECT * FROM tbmodelo WHERE descricacao like ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                mod = new Modelo();
                mod.setId(rs.getInt("id"));
                mod.setDescricacao(rs.getString("descricacao"));
                mod.setPotencia(rs.getString("potencia"));
                mod.setFabricante(rs.getString("fabricante"));
                mod.setAno(rs.getString("ano"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mod;
    }
}
