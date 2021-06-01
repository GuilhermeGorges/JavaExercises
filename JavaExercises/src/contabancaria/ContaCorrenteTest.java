
package contabancaria;

import java.util.Scanner;

public class ContaCorrenteTest {
    public static void main(String[] args) {
        
        ContaCorrente conta = new ContaCorrente();
        Scanner scan = new Scanner(System.in);
        
        double valorDeposito;
        double valorSaque;
        
        conta.nome = "Jesus";
        conta.numeroDaConta = "123456";
        conta.agencia = "4321";
        conta.especial = true;
        conta.limiteEspecial = 500;
        conta.saldo = 2000;
        
        System.out.println("Seja bem vindo "+ conta.nome);
        
        boolean exit = false;
        do{
            System.out.println("Digite uma das opções: ");
            System.out.println("[0] SAIR");
            System.out.println("[1] SALDO");
            System.out.println("[2] DEPOSITO");
            System.out.println("[3] SAQUE");
            System.out.println("[4] CONSULTAR CHEQUE ESPECIAL");
            int opcao = scan.nextInt();
            switch(opcao){
                case 0 : exit = true; break; // sair 
                case 1 : conta.consultarSaldo(); break; // consultar saldo 
                case 2 : { // depositar
                    System.out.println("Digite o valor do deposito:");
                    valorDeposito = scan.nextDouble();
                    conta.depositos(valorDeposito);
                    break;
                }
                case 3 : { // sacar 
                    System.out.println("Digite o valor do saque.");
                    valorSaque = scan.nextDouble();
                    conta.retirarDinheiro(valorSaque);
                    break;
                }
                case 4 : conta.verificaUsandoChequeEspecial();break; // consultar cheque especial
            } 
        } while (!exit);
        
        
        
    }
}
