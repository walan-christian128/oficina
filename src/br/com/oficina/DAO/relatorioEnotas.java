/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class relatorioEnotas {

    private Connection con;

    public relatorioEnotas() {
        this.con = new ConexaoModulo().getConnection();
    }

    public void imprimirOrdem(String layout, int idOS, String numOS) throws SQLException, ClassNotFoundException, JRException {

        JasperDesign desenho = JRXmlLoader.load(layout);
        JasperReport relatorio = JasperCompileManager.compileReport(desenho);

        String sql = "SELECT oficina.tbclientes.nomecli,"
                + "oficina.tbclientes.enderecocli,"
                + "oficina.tbclientes.fonecli,"
                + "oficina.tbclientes.emailcli,"
                + "oficina.tbos.idOS,"
                + "oficina.tbos.data_os,"
                + "oficina.tbos.tipo,"
                + "oficina.tbos.situacao,"
                + "oficina.tbos.modelo,"
                + "oficina.tbos.descricao_cliente,"
                + "oficina.tbos.servico_executado,"
                + "oficina.tbos.executador,"
                + "oficina.tbos.valor"
                + "FROM oficina.tbos"
                + "INNER JOIN oficina.tbclientes ON "
                + "oficina.tbos.idcli = oficina.tbclientes.idcli"
                + "where tbos.idOS = '" + idOS + "'";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

//implementação da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

//executa o relatório
        Map parametros = new HashMap();
        parametros.put("id_os", new Integer(8));
        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, jrRS);

//exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        viewer.show();

    }

    public static void main(String[] args) throws SQLException {

        relatorioEnotas rl = new relatorioEnotas();

        try {
            rl.imprimirOrdem("src/br/com/oficina/model/Rel/Oficina.jrxml",8,"8");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(relatorioEnotas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(relatorioEnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
