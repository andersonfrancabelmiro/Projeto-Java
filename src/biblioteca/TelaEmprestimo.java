package biblioteca;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaEmprestimo extends JFrame {

    private JPanel panelTela;

    private JTextField txtIdLivro;
    private JTextField txtTelefone;

    public TelaEmprestimo() {

        setTitle("Empréstimo de Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 200, 400, 220);
        setResizable(false);
        setLocationRelativeTo(null);

        panelTela = new JPanel();
        panelTela.setBackground(new Color(227, 242, 253));
        panelTela.setLayout(null);
        setContentPane(panelTela);

        JLabel lblId = new JLabel("ID do Livro:");
        lblId.setBounds(30, 20, 100, 20);
        panelTela.add(lblId);

        txtIdLivro = new JTextField();
        txtIdLivro.setBounds(130, 20, 200, 20);
        panelTela.add(txtIdLivro);

        JLabel lblTel = new JLabel("Telefone:");
        lblTel.setBounds(30, 60, 100, 20);
        panelTela.add(lblTel);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(130, 60, 200, 20);
        panelTela.add(txtTelefone);

        JButton btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBackground(new Color(25, 118, 210)); 
        btnEmprestar.setForeground(Color.WHITE);
        btnEmprestar.setBounds(10, 110, 120, 30);
        panelTela.add(btnEmprestar);
        
        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emprestarLivro();
            }
        });
        
        JButton btnListalivro = new JButton("Lista de Livro");
        btnListalivro.setBackground(new Color(25, 118, 210)); 
        btnListalivro.setForeground(Color.WHITE);
        btnListalivro.setBounds(135, 110, 120, 30);
        panelTela.add(btnListalivro);
        
        btnListalivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListarLivros tela = new TelaListarLivros();
                tela.setVisible(true);
            }
        });
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(25, 118, 210)); 
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBounds(260, 110, 120, 30);
        panelTela.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMenuPrincipal tela = new TelaMenuPrincipal();
                dispose();
                tela.setVisible(true);
            }
        });
    }

    private void emprestarLivro() {
        try {
            int idLivro = Integer.parseInt(txtIdLivro.getText());
            String telefone = txtTelefone.getText();

            Livros livro = new Livros(idLivro, telefone);
            livro.setIdLivro(idLivro);
            livro.setTelefone(telefone);

            livro.emprestimo();

            txtIdLivro.setText("");
            txtTelefone.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao emprestar",
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listarLivro() {
        TelaListarLivros tela = new TelaListarLivros();
        tela.setVisible(true);
    }
    
    

    public static void main(String[] args) {
        TelaEmprestimo tela = new TelaEmprestimo();
        tela.setVisible(true);
    }
}
