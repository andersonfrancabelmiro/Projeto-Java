/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Scanner;

public class Emprestimo {
        public static void main(String[] args) {
             Scanner sc = new Scanner (System.in);
        try {
        
            // Abre a conexão com o SQL Server usando o método da sua classe ConexaoSQLServer
            Connection conn = ConexaoSQLServer.abrirConexao();

            System.out.println("Digite o id do livro: ");
            int idlivro = sc.nextInt();
            
            System.out.println("Digite o id do clinte: ");
            int idcliente = sc.nextInt();
        
            String emprestimo = "{CALL P_emprestimo(?,?)}";

            CallableStatement stmt = conn.prepareCall(emprestimo);
            
            stmt.setInt(1, idlivro);
            stmt.setInt(2, idcliente);
            
            stmt.execute();
            
            SQLWarning warning = stmt.getWarnings();
            System.out.println( warning.getMessage());
        
            conn.close();

        } catch (Exception e) {

            // Caso aconteça algum erro (SQL, conexão, etc.), mostra a mensagem no console
            System.err.println("Erro: " + e.getMessage());
            }
        }
}
