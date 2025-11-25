/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLWarning;
import java.util.Scanner;

/**
 *
 * @author Anderson F Belmiro
 */
public class Inserircliente {
        public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        try {
            Connection conn = ConexaoSQLServer.abrirConexao();

            System.out.println("Digite seu nome : ");
            String nome = sc.nextLine();
            
            System.out.println("Digite o telefone: ");
            String telefone = sc.nextLine();
            
            System.out.println("Digite o email: ");
            String email = sc.nextLine();
        
            String inserirclientes = "{CALL P_inserir_clientes(?,?,?)}";
            CallableStatement stmt = conn.prepareCall(inserirclientes);
            
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);

            stmt.execute();
            
            //inserir printpara retorno no java
            SQLWarning warning = stmt.getWarnings();
            System.out.println( warning.getMessage());
        
            conn.close();

        } catch (Exception e) {

            // Caso aconteça algum erro (SQL, conexão, etc.), mostra a mensagem no console
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
