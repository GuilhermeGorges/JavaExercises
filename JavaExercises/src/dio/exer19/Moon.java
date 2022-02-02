package exer.dio.exer18;
/*
Jade ganhou de presente de aniversário um telescópio e ficou muito feliz, pois adora olhar a lua à noite.
Ela sempre foi uma estudante muito boa, e só analizando a lua por duas noites seguidas,
já consegue identificar as mudanças que ocorreram na iluminação e o percentual
aproximado da lua que está iluminada.



Você, que é amigo da Jade e estuda Computação, resolveu fazer um pequeno programa que,
baseado nesta avaliação que ela fez nas duas últimas noites, informa a fase na qual a lua se encontra.
Se a porção visível da lua no momento estiver entre 0 e 2%, por exemplo, é lua nova,
se for entre 3 e 96% é lua crescente,
se for entre 97 e 100% é lua cheia e
se for entre 96 e 3% (diminuindo) é lua minguante.

Entrada
A entrada é composta por uma única linha contendo dois valores inteiros. O primeiro valor corresponde ao percentual observado por Jade na noite de dois dias atrás. O segundo valor corresponde ao percentual observado por jade na noite anterior.

Saída
Baseado nos dois percentuais observados por Jade, imprima na tela a fase na qual a lua se encontrava na noite anterior, conforme o exemplo abaixo. Não esqueça de imprimir o caractere de fim de linha após a saída :).
 */
import java.util.Scanner;

public class Moon {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int start = leitor.nextInt();
        int end = leitor.nextInt();


        if (start >= 0 && end <= 2) {
            System.out.println("nova");
        } else if (end > start && end <= 96) {
            System.out.println("crescente");
        } else if (start >= end && end <= 96) {
            System.out.println("minguante");
        } else {
            System.out.println("cheia");
        }

    }
}
}