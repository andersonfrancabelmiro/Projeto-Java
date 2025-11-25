/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLWarning;
import java.util.Scanner;


public class Inserirlivros {
         public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        try {
            Connection conn = ConexaoSQLServer.abrirConexao();

            System.out.println("Digite o titulo do livro: ");
            String titulo = sc.nextLine();
            
            System.out.println("Digite o autor do livro: ");
            String autor = sc.nextLine();
            
            System.out.println("Digite o ano publicacao do livro: ");
            int ano = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Digite o genero do livro: ");
            String genero = sc.nextLine();
            
            System.out.println("Digite (1) disponivel ou (0)indisponivel ");
            int disponivel = sc.nextInt();
        
            String emprestimo = "{CALL P_inserir_livros(?,?,?,?,?)}";

            CallableStatement stmt = conn.prepareCall(emprestimo);
            
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setInt(3, ano);
            stmt.setString(4, genero);
            stmt.setInt(5, disponivel);

            
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
