package contabancaria;

public class ContaCorrente {
    
    String nome;
    String numeroDaConta;
    String agencia;
    boolean especial;
    double limiteEspecial;
    double valorEspecialUsado;
    double saldo;
    

    
    boolean retirarDinheiro(double valorSaque){
        if (saldo >= valorSaque){
            saldo -= valorSaque;
            System.out.println("Saque efetuado com sucesso.");
            System.out.println("Saldo atual R$ "+saldo);
            return true;
        } else {
            if (especial){
                double limite = limiteEspecial + saldo;
                if (limite >= valorSaque){
                    valorEspecialUsado += (valorSaque-saldo);
                    saldo -= valorSaque;                    
                    System.out.println("Saque efetuado com sucesso. Limite especial utilizado.");
                    System.out.println("Saldo atual R$ "+saldo);
                    return true;
                } else {
                    System.out.println("Saldo insuficiente!");
                    System.out.println("Saldo atual R$ "+saldo);
                    return false;
                }
            } else {               
                System.out.println("Saldo insuficiente!");
                System.out.println("Saldo atual R$ "+saldo);
                return false;
            }
        }
    }
    
    void depositos (double valorDeposito){
        saldo += valorDeposito;
        System.out.println("Deposito realizado com sucesso");
        System.out.println("Saldo atual R$ "+saldo);
    }
    
    void consultarSaldo(){
        System.out.println("Saldo atual R$ "+saldo); 
    }
    
    
    void verificaUsandoChequeEspecial() {
        if (valorEspecialUsado == 0){
            System.out.println("Não esta usando cheque especial");
            System.out.println("O limite atual é de R$ "+(limiteEspecial - valorEspecialUsado));
        } else {
            System.out.println("Esta usando o cheque especial");
            System.out.println("O limite atual é de R$ "+(limiteEspecial - valorEspecialUsado));
        }
        
    }
    
   
}
