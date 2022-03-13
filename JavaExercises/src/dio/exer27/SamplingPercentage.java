package dio.exer27;
/*
Maria acabou de iniciar seu curso de graduação na faculdade de medicina e precisa de sua ajuda para organizar os experimentos de um laboratório o qual ela é responsável. Ela quer saber no final do ano, quantas cobaias foram utilizadas no laboratório e o percentual de cada tipo de cobaia utilizada.

Este laboratório em especial utiliza três tipos de cobaias: sapos, ratos e coelhos. Para obter estas informações, ela sabe exatamente o número de experimentos que foram realizados, o tipo de cobaia utilizada e a quantidade de cobaias utilizadas em cada experimento.

Entrada
A primeira linha de entrada contém um valor inteiro N que indica os vários casos de teste que vem a seguir. Cada caso de teste contém um inteiro Quantia (1 ≤ Quantia ≤ 15) que representa a quantidade de cobaias utilizadas e um caractere Tipo ('C', 'R' ou 'S'), indicando o tipo de cobaia (R:Rato S:Sapo C:Coelho).

Saída
Apresente o total de cobaias utilizadas, o total de cada tipo de cobaia utilizada e o percentual de cada uma em relação ao total de cobaias utilizadas, sendo que o percentual deve ser apresentado com dois dígitos após o ponto.
 */
import java.util.Scanner;

public class SamplingPercentage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char character;
        int count, quantidade, rato=0, coelho=0, sapo=0, total = 0;
        double mediaCoelhos, mediaRatos, mediaSapos;
        count = scan.nextInt();

        for(int i = 0; i < count; i++) {
            quantidade = scan.nextInt();
            character = scan.next().toUpperCase().charAt(0);

            total += quantidade;
            if (character == 'C') coelho += quantidade;
            if (character == 'R') rato += quantidade;
            if (character == 'S') sapo += quantidade;
        }

        mediaCoelhos = calcPercent(coelho, total);
        mediaRatos = calcPercent(rato, total);
        mediaSapos = calcPercent(sapo, total);


        System.out.println("Total: "+total+" cobaias");
        System.out.println("Total de coelhos: "+coelho);
        System.out.println("Total de ratos: "+rato);
        System.out.println("Total de sapos: "+sapo);
        System.out.println(String.format("Percentual de coelhos: %.2f",mediaCoelhos) + " %");
        System.out.println(String.format("Percentual de ratos: %.2f",mediaRatos) + " %");
        System.out.println(String.format("Percentual de sapos: %.2f",mediaSapos) + " %");

    }

    public static double calcPercent(int qtd, double total){
        return (100/total)*qtd;
    }
}
