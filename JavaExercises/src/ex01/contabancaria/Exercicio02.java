package ex01.contabancaria;

import java.util.Scanner;

public class Exercicio02 {
     public static void main(String[] args) {
        
        ContaCorrente conta = new ContaCorrente();
        Scanner scan = new Scanner(System.in);
        
        double valorDeposito;
        double valorSaque;
        boolean saqueEfetuado;
        
        conta.setNome("Elisa");
        conta.setNumeroDaConta("123456");
        conta.setAgencia("4321");
        conta.setEspecial(true);
        conta.setLimiteEspecial(500);
        conta.setSaldo(2000);
        
        System.out.println("Seja bem vindo "+ conta.getNome());
        
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
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                }
                case 3 : { // sacar 
                    System.out.println("Digite o valor do saque.");
                    valorSaque = scan.nextDouble();
                    saqueEfetuado = conta.retirarDinheiro(valorSaque);
                    if (saqueEfetuado){
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiênte.");
                    }
                    break;
                }
                case 4 : {
                    if (conta.verificaUsandoChequeEspecial()){
                        System.out.println("Está usando chegue especial.");
                    } else {
                        System.out.println("Não está usando chegue especial");
                    }
                }break; // consultar cheque especial
            } 
        } while (!exit);
        
        
        
    }   
}
