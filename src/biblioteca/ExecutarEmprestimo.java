/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author anderson.fbelmiro
 */
public class ExecutarEmprestimo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Digite o id do livro: ");
        int idlivro = sc.nextInt();
        sc.nextLine();
            
        System.out.println("Digite o telefone do Cliente: ");
        String telefone = sc.nextLine();
        
        Livros livro = new Livros(idlivro,telefone);
        livro.setIdLivro(idlivro);
        livro.setTelefone(telefone);

        livro.emprestimo();

        sc.close();
            
    }

}
