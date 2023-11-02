import entitie.*;
import entities.enuns.StatusDaOrdem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EnderecoSalvoPrincipal endPrincipal = new EnderecoSalvoPrincipal("Avenida João sem Nome - " , "Centro - ",
                135645-000);
        System.out.println("DADOS DO CLIENTE ");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Sobrenome: ");
        String sobrenome = sc.next();
        System.out.print("Data de nascimento: ");
        Date dataNascimento = sdf.parse(sc.next());
        System.out.print("CPF: ");
        String cpf = sc.next();
        //System.out.print("Endereço para entrega(Principal): \n" + endPrincipal);

        Cliente c = new Cliente(nome, sobrenome, dataNascimento, cpf);
        System.out.println("----------------------------------------------------------");
        System.out.print("Status: ");
        StatusDaOrdem status = StatusDaOrdem.valueOf(sc.next());
        Ordem ordem = new Ordem(new Date(), status, c, endPrincipal);

        System.out.print("Quantos produtos serão adicionados: ");
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++){
            System.out.println("Produto #" + (i) + ": ");
            System.out.print("Nome produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preço produto: ");
            double precoProduto = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nomeProduto, precoProduto);
            ItensDoPedido it = new ItensDoPedido(quantidade, precoProduto, produto);

            ordem.addItem(it);
        }
       // JFrame frame = new JFrame();
        System.out.println("----------------------------------------------------------");
        //JOptionPane.showMessageDialog(frame, ordem.toString(), "Resultado do Pedido", JOptionPane
        // .INFORMATION_MESSAGE);
        System.out.println(ordem);

        sc.close();
    }
}