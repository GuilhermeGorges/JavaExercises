package exer.dio.exer03;
/*
Nas férias de Dezembro, várias escolas se organizam e levam seus alunos para um acampamento de férias por uma semana.
Nestes acampamentos os alunos são divididos em cabanas coletivos por gênero e idade, sempre com um adulto que,
além de dormir com o grupo no cabana, também são responsáveis por criar e executar várias atividades, como por exemplo jogos, excursões, Gincanas Noturnas, etc.

No primeiro dia foi realizada uma gincana em que a atividade constituia em agrupar os alunos em um círculo
(organizado no sentido anti-horário) do qual seriam retiradas uma a uma até que sobrasse apenas um aluno, que seria o vencedor.

No momento em que entra no círculo, cada aluno recebe uma pequena ficha que contém um valor de 1 a 500.
Depois que o círculo é formado, conta-se, iniciando no aluno que está ao lado da primeira que entrou no círculo, o número correspondente à ficha que o primeiro detém.
O aluno onde o número contado cair, deve ser retirado do grupo, e a contagem inicia novamente segundo a ficha do aluno que acabou de ser eliminado.
Para ficar mais interessante, quando o valor que consta na ficha é par, a contagem é feita no sentido horário e quando o valor que consta na ficha é ímpar, a contagem é feita no sentido anti-horário.

Desenvolva um programa para que no próximo evento o responsável pela brincadeira saiba previamente qual criança irá ser a vencedora de cada grupo, com base nas informações fornecidas.

Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste contém um inteiro N (1 ≤ N ≤ 100),
indicando a quantidade de alunos que farão parte de cada círculo. Em seguida, as N linhas de cada caso de teste conterão duas informações,
o Nome e o Valor (1 ≤ Valor ≤ 500) que consta na ficha de cada aluno, separados por um espaço, na ordem de entrada na formação do círculo inicial.

OBS: O Nome de cada aluno não deverá ultrapassar 30 caracteres e contém apenas letras maiúsculas e minúsculas, sem acentos,
e o caractere “_”. O final da entrada é indicado pelo número zero.

Saída
Para cada caso de teste, deve-se apresentar a mensagem Vencedor(a): xxxxxx, com um espaço após o sinal ":" indicando qual
é o aluno do grupo que venceu a brincadeira.
*/


import java.util.ArrayList;
import java.util.Scanner;

public class GincanaAcampamento {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int contador = scan.nextInt();
        while(contador!= 0){
            ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
            for (int i = 0; i < contador; i++){
                String nome = scan.next();
                int valor = scan.nextInt();
                Aluno aluno = new Aluno(nome, valor);
                listaAluno.add(aluno);
            }
            int alunoContagem = listaAluno.get(1).getValor();

            for(int i = 0; i<contador; i++) {
                int alunoEliminado = 0;
                if (alunoContagem % 2 == 0) {
                    for (int j = 0; j<alunoContagem; j++){

                        int x = (listaAluno.get(x)++);

                    }
                } else {
                    for (int j = alunoContagem; j> 0; j--){

                    }
                }
                alunoContagem = alunoEliminado;
            }

            contador = scan.nextInt();
            if (contador == 0) break;
        }



    }
    public static class Aluno{

        public String nome;
        public int valor;

        public Aluno(String nome, int valor) {
            this.nome = nome;
            this.valor = valor;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
    }
}


