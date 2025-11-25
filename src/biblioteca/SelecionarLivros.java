package biblioteca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelecionarLivros {

public static void main(String[] args) {
    try {

        // Abre a conexão com o SQL Server usando o método da sua classe ConexaoSQLServer
        Connection conn = ConexaoSQLServer.abrirConexao();

        // Comando SQL que será executado no banco de dados
        String sql = "SELECT * FROM tbl_livro";

        // Cria um objeto Statement para enviar comandos SQL ao servidor
        Statement stmt = conn.createStatement();

        // Executa o comando SQL e retorna os resultados dentro de um ResultSet
        ResultSet rs = stmt.executeQuery(sql);

        // Percorre linha por linha do resultado retornado pelo SELECT
        while (rs.next()) {

            // Imprime na tela o ID e o título do livro recuperado do banco
            System.out.println(
               rs.getInt("id_livro") + " - " +
               rs.getString("titulo") + " - " +
               rs.getString("autor") + " - " +
               rs.getString("ano_publicacao") + " - " +
               rs.getString("genero") 
            );
        }

        // Fecha a conexão com o banco de dados
        conn.close();

        } catch (Exception e) {

        // Caso aconteça algum erro (SQL, conexão, etc.), mostra a mensagem no console
        System.err.println("Erro: " + e.getMessage());
        }
    }

}
