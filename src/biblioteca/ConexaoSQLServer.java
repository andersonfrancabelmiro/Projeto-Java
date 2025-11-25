/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anderson F Belmiro
 */
public class ConexaoSQLServer {
    //private static final String SERVIDOR = "//TBS0676769W11-1\\SQLEXPRESS:1433";
     private static final String SERVIDOR = "//ANDERSON\\SQLEXPRESS:1433";
    private static final String BANCO_DE_DADOS = "biblioteca_marcao";

    private static final String CONNECTION_URL =
            "jdbc:sqlserver:" + SERVIDOR +
            ";databaseName=" + BANCO_DE_DADOS +
            ";integratedSecurity=true;" +
            "trustServerCertificate=true;" +
            "encrypt=true;";

    // Método para abrir conexão
    public static Connection abrirConexao() throws SQLException {
        Connection conn = DriverManager.getConnection(CONNECTION_URL);
        System.out.println("Conexao estabelecida com sucesso!!");
        return conn;
    }
}
