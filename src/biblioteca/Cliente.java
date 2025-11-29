/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLWarning;

/**
 *
 * @author anderson.fbelmiro
 */
public class Cliente {
                
    private String nome;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String nomeTela, String telefoneTela, String emailTela) {
        this.nome = nomeTela;
        this.telefone = telefoneTela;
        this.email = emailTela;
    }
    
    public void inserirCliente(){
        try{
            Connection conn = ConexaoSQLServer.abrirConexao();
            
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
        }catch(Exception e) {

            // Caso aconteça algum erro (SQL, conexão, etc.), mostra a mensagem no console
            System.err.println("Erro: " + e.getMessage());
            
        }           
         
    }
    
}
