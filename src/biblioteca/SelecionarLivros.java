package biblioteca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelecionarLivros {

public static void main(String[] args) {
    try {

        Connection conn = ConexaoSQLServer.abrirConexao();

        String sql = "SELECT * FROM tbl_livro";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            System.out.println(
               rs.getInt("id_livro") + " - " +
               rs.getString("titulo") + " - " +
               rs.getString("autor") + " - " +
               rs.getString("ano_publicacao") + " - " +
               rs.getString("genero") 
            );
        }

        conn.close();

        } catch (Exception e) {

        System.err.println("Erro: " + e.getMessage());
        }
    }

}