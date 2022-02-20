package dio.exer24;
/*
Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas necessárias.

Entrada
O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).

Saída
Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial, conforme exemplo fornecido.

Obs: Utilize ponto (.) para separar a parte decimal.
 */

import java.util.Scanner;

public class MoneyCalc {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num;
        int quociente, resto;
        int[] notas = {100, 50,20,10,5,2};
        int[] moedas = {100, 50, 25, 10,5, 1};

        num = sc.nextDouble();

        resto = (int) (num * 100.0 + 0.5);

        System.out.println("NOTAS:");

        for (int nota : notas){
            quociente = resto / (nota * 100);
            System.out.println(quociente + " nota(s) de R$ " + nota + ".00");
            resto = resto % (nota * 100);
        }

        System.out.println("MOEDAS:");

        for (int moeda : moedas) {
            quociente = resto / moeda;
            float moedaDec = (float) moeda / 100;
            System.out.print(quociente + " moeda(s) de R$ ");
            System.out.printf("%.2f", moedaDec);
            System.out.println();
            resto = resto % moeda;
        }

        sc.close();
    }
}
