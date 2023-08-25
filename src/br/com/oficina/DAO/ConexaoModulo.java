package br.com.oficina.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoModulo {

    //Metodo de conexao//
 public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/oficina","walan","359483wa@");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
 
  }
    
}
