package biblioteca;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaDevolucao extends JFrame {

    private JPanel panelTela;
    private JTextField txtIdLivro;

    public TelaDevolucao() {

        setTitle("Devolução de Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 200, 400, 180);
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

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setBackground(new Color(25, 118, 210)); 
        btnDevolver.setForeground(Color.WHITE);
        btnDevolver.setBounds(70, 70, 120, 30);
        panelTela.add(btnDevolver);

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLivro();
            }
        });
        
                JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(25, 118, 210)); 
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBounds(200, 70, 120, 30);
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

    private void devolverLivro() {
        try {
            int idLivro = Integer.parseInt(txtIdLivro.getText().isEmpty() ? "0" : txtIdLivro.getText());

            Livros livro = new Livros(idLivro);
            livro.setIdLivro(idLivro);

            livro.devolucao();

            txtIdLivro.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Erro ao devolver " ,
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        TelaDevolucao tela = new TelaDevolucao();
        tela.setVisible(true);
    }
}
