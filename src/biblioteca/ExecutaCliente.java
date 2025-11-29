
package biblioteca;
import java.util.Scanner;

public class ExecutaCliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        
        System.out.println("Digite seu nome : ");
        String nome = sc.nextLine();

        System.out.println("Digite o telefone: ");
        String telefone = sc.nextLine();

        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        
        Cliente c = new Cliente(nome, telefone, email);
        c.inserirCliente();
        
    }
    
}
