package biblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class TelaListarLivros extends JFrame {

    private JTable tabela;

    public TelaListarLivros() {

        setTitle("Lista de Livros");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = { "ID", "Título", "Autor", "Ano", "Gênero", "Disponível" };
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        carregarDados(modelo);
    }

    private void carregarDados(DefaultTableModel modelo) {
        try {
            Connection conn = ConexaoSQLServer.abrirConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_livro");

            while (rs.next()) {
                modelo.addRow(new Object[] {
                    rs.getInt("id_livro"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("ano_publicacao"),
                    rs.getString("genero"),
                    rs.getInt("disponivel")
                });
            }

            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar livros!\n" + e.getMessage());
        }
    }
}
