package biblioteca;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLWarning;
import javax.swing.*;

public class TelaCadastraLivro extends JFrame {

    private JPanel panelTela;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAno;
    private JTextField txtGenero;
    private JTextField txtDisponivel;

    public TelaCadastraLivro() {

        setTitle("Cadastro de Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 200, 450, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        panelTela = new JPanel();
       panelTela.setBackground(new Color(227, 242, 253));
        panelTela.setLayout(null);
        setContentPane(panelTela);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 20, 100, 20);
        panelTela.add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 20, 250, 20);
        panelTela.add(txtTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(30, 60, 100, 20);
        panelTela.add(lblAutor);

        txtAutor = new JTextField();
        txtAutor.setBounds(120, 60, 250, 20);
        panelTela.add(txtAutor);

        JLabel lblAno = new JLabel("Ano:");
        lblAno.setBounds(30, 100, 100, 20);
        panelTela.add(lblAno);

        txtAno = new JTextField();
        txtAno.setBounds(120, 100, 80, 20);
        panelTela.add(txtAno);

        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setBounds(30, 140, 100, 20);
        panelTela.add(lblGenero);

        txtGenero = new JTextField();
        txtGenero.setBounds(120, 140, 150, 20);
        panelTela.add(txtGenero);

        JLabel lblDisp = new JLabel("Disponível (1/0):");
        lblDisp.setBounds(30, 180, 120, 20);
        panelTela.add(lblDisp);

        txtDisponivel = new JTextField();
        txtDisponivel.setBounds(150, 180, 40, 20);
        panelTela.add(txtDisponivel);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(25, 118, 210)); 
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBounds(115, 220, 120, 30);
        panelTela.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });
        
        JButton btnVoltar = new JButton("Voltar");
        
        btnVoltar.setBackground(new Color(25, 118, 210)); 
        btnVoltar.setForeground(Color.WHITE);
        
        btnVoltar.setBounds(250, 220, 120, 30);
        panelTela.add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                TelaMenuPrincipal tela = new TelaMenuPrincipal();
                tela.setVisible(true);
                
                dispose();
            }
        });
    }

    private void cadastrarLivro() {
        try {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int ano = Integer.parseInt(txtAno.getText().isEmpty() ? "0" : txtAno.getText());            
            String genero = txtGenero.getText();
            int disponivel = Integer.parseInt(txtDisponivel.getText().isEmpty() ? "0" : txtDisponivel.getText());

            Livros livro = new Livros(titulo, autor, ano, genero, disponivel);
            livro.inserirLivros();

            txtTitulo.setText("");
            txtAutor.setText("");
            txtAno.setText("");
            txtGenero.setText("");
            txtDisponivel.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao cadastrar! ",
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        TelaCadastraLivro tela = new TelaCadastraLivro();
        tela.setVisible(true);
    }
}
