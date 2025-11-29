package biblioteca;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLWarning;
import java.util.Scanner;

public class Livros {
    private int     idLivro;
    private String  titulo;
    private String  autor;
    private int     ano;
    private String  genero;
    private int     disponivel;
    
    //Atributo de cliente
    private String telefone;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }    
    
        public Livros(int idlivro, String telefone) { 
    }
    
    public Livros(String tituloMetodo, int anoMetodo, String autorMetodo, String generoMetodo, int disponivelMetodo){
        
    }

    public Livros(String titulo, String autor, int ano, String genero, int disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.disponivel = disponivel;
    }
    

    
    public void inserirLivros(){
        try{
            Connection conn = ConexaoSQLServer.abrirConexao();

            String emprestimo = "{CALL P_inserir_livros(?,?,?,?,?)}";

            CallableStatement stmt = conn.prepareCall(emprestimo);

            stmt.setString(1, this.getTitulo());
            stmt.setString(2, this.getAutor());
            stmt.setInt(3, this.getAno());
            stmt.setString(4, this.getGenero());
            stmt.setInt(5, this.getDisponivel());


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
    
    
    
    public void emprestimo(){
                
        try{
            Connection conn = ConexaoSQLServer.abrirConexao();            
            String emprestimo = "{CALL P_emprestimo(?,?)}";

            CallableStatement stmt = conn.prepareCall(emprestimo);
            
            stmt.setInt(1, this.idLivro);
            stmt.setString(2, this.telefone);
            
            stmt.execute();
            
            SQLWarning warning = stmt.getWarnings();
            System.out.println( warning.getMessage());
        
            conn.close();
        } catch (Exception e) {

            // Caso aconteça algum erro (SQL, conexão, etc.), mostra a mensagem no console
            System.err.println("Erro: " + e.getMessage());
        }  
        
    }
    
    
}
