package biblioteca;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaCadastrarCliente extends JFrame {

    private final JPanel panelTela;

    private final JTextField txtNome;
    private final JTextField txtTelefone;
    private final JTextField txtEmail;

    public TelaCadastrarCliente() {

        setTitle("Cadastro de Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 200, 420, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        panelTela = new JPanel();
        panelTela.setBackground(new Color(227, 242, 253));
        panelTela.setLayout(null);
        setContentPane(panelTela);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 20, 120, 20);
        panelTela.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 20, 240, 20);
        panelTela.add(txtNome);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(30, 60, 120, 20);
        panelTela.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(130, 60, 240, 20);
        panelTela.add(txtTelefone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 100, 120, 20);
        panelTela.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(130, 100, 240, 20);
        panelTela.add(txtEmail);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(25, 118, 210)); 
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBounds(80, 150, 120, 30);
        panelTela.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
        
        JButton btnVoltar = new JButton("Voltar");
                btnVoltar.setBackground(new Color(25, 118, 210)); 
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBounds(250, 150, 120, 30);
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

    private void cadastrarCliente() {
        try {
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();

            Cliente cliente = new Cliente(nome, telefone, email);

            cliente.inserirCliente();

            txtNome.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar " ,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        TelaCadastrarCliente tela = new TelaCadastrarCliente();
        tela.setVisible(true);
    }
}
