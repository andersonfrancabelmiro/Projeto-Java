package biblioteca;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaMenuPrincipal extends JFrame {

    private final JPanel panelTela;

    public TelaMenuPrincipal() {

        setTitle("Menu Principal - Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 400, 320);
        setResizable(false);
        setLocationRelativeTo(null);

        panelTela = new JPanel();
        panelTela.setLayout(null);
        panelTela.setBackground(new Color(227, 242, 253));
        setContentPane(panelTela);

        JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
        lblTitulo.setBounds(140, 20, 200, 20);
        panelTela.add(lblTitulo);
        
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarCliente.setBackground(new Color(25, 118, 210)); 
        btnCadastrarCliente.setForeground(Color.WHITE);
        btnCadastrarCliente.setBounds(100, 60, 200, 30);
        panelTela.add(btnCadastrarCliente);

        btnCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarCliente tela = new TelaCadastrarCliente();
                tela.setVisible(true);
            }
        });


        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        btnCadastrarLivro.setBackground(new Color(25, 118, 210)); 
        btnCadastrarLivro.setForeground(Color.WHITE);
        btnCadastrarLivro.setBounds(100, 110, 200, 30);
        panelTela.add(btnCadastrarLivro);

        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastraLivro tela = new TelaCadastraLivro();
                tela.setVisible(true);
            }
        });

        JButton btnEmprestimo = new JButton("Emprestar Livro");
        btnEmprestimo.setBackground(new Color(25, 118, 210)); 
        btnEmprestimo.setForeground(Color.WHITE);
        btnEmprestimo.setBounds(100, 160, 200, 30);
        panelTela.add(btnEmprestimo);

        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEmprestimo tela = new TelaEmprestimo();
                tela.setVisible(true);
            }
        });

        JButton btnDevolucao = new JButton("Devolver Livro");
        btnDevolucao.setBackground(new Color(25, 118, 210)); 
        btnDevolucao.setForeground(Color.WHITE);
        btnDevolucao.setBounds(100, 210, 200, 30);
        panelTela.add(btnDevolucao);

        btnDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDevolucao tela = new TelaDevolucao();
                tela.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        TelaMenuPrincipal menu = new TelaMenuPrincipal();
        menu.setVisible(true);
    }
}
