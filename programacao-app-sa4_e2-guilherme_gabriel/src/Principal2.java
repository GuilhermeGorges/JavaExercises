import dao.ProdutoDAO;
import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal2 {
    public static void main(String[] args) {

        int opcao;
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        Scanner scan = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        listaProdutos = produtoDAO.read();
        for(int i = 0; i < listaProdutos.size(); i++){
            System.out.println("ID: " + listaProdutos.get(i).getId()+" | Nome: "+ listaProdutos.get(i).getNome()+" | Preço: "+ listaProdutos.get(i).getPreco());
        }


        opcao = 0;
        while (opcao != 4) {
            System.out.println("SELECIONE UMA DAS OPÇÕES ABAIXO");
            System.out.println("1 - Cadastrar Produto\n2 - Visualizar Venda\n3 - Concluir Venda\n4 - Sair");
            opcao = scan.nextInt();

            switch (opcao){
                case 1 -> {




                }




            }

        }
            System.out.println("Digite o id do produto que deseja excluir");
        produto.setId(scan.nextInt());
        System.out.print("Digite o id do produto que deseja alterar: ");
        produto.setId(scan.nextInt());
        System.out.println("Digite o nome produto que deseja adicionar na venda:");
        produto.setNome(scan.next());
        System.out.println("Digite o preço do produto que deseja adicionar na venda:");
        produto.setPreco(scan.nextDouble());
        System.out.println("Digite a quantidade de estoque:");
        produto.setQuantidadeEstoque(scan.nextInt());
        produtoDAO.create(produto);

    }
}
