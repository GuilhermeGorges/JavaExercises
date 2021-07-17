package ex20.contabancaria;

public class ContaCorrente {

    private String nome;
    private String numeroDaConta;
    private String agencia;
    private boolean especial;
    private double limiteEspecial;
    private double valorEspecialUsado;
    private double saldo;

    public ContaCorrente() {
    }

    public ContaCorrente(String nome, String numeroDaConta, String agencia, boolean especial, double limiteEspecial, double valorEspecialUsado, double saldo) {
        this.nome = nome;
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.especial = especial;
        this.limiteEspecial = limiteEspecial;
        this.valorEspecialUsado = valorEspecialUsado;
        this.saldo = saldo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numeroDaConta
     */
    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    /**
     * @param numeroDaConta the numeroDaConta to set
     */
    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the especial
     */
    public boolean isEspecial() {
        return especial;
    }

    /**
     * @param especial the especial to set
     */
    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    /**
     * @return the limiteEspecial
     */
    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    /**
     * @param limiteEspecial the limiteEspecial to set
     */
    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    /**
     * @return the valorEspecialUsado
     */
    public double getValorEspecialUsado() {
        return valorEspecialUsado;
    }

    /**
     * @param valorEspecialUsado the valorEspecialUsado to set
     */
    public void setValorEspecialUsado(double valorEspecialUsado) {
        this.valorEspecialUsado = valorEspecialUsado;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean retirarDinheiro(double valorSaque) {
        if (saldo >= valorSaque) {
            saldo -= valorSaque;
            return true;
        } else {
            if (especial) {
                double limite = limiteEspecial + saldo;
                if (limite >= valorSaque) {
                    saldo -= valorSaque;
                    valorEspecialUsado += (valorSaque - saldo);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void depositos(double valorDeposito) {
        saldo += valorDeposito;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual R$ " + saldo);
    }

    public boolean verificaUsandoChequeEspecial() {
        return saldo < 0;

    }

}
