package dio.exer25;

/*
Números em ponto flutuante podem ser bastante extensos para mostrar.
Nesses casos, é conveniente usar a notação científica.

Você deve escrever um programa que, dado um número em ponto flutuante, mostre este número na notação científica: sempre mostre o sinal da mantissa; sempre mostre 4 casas decimais na mantissa; use o caractere 'E' para separar a mantissa do expoente; sempre mostre o sinal do expoente; e mostre o expoente com pelo menos 2 dígitos.

Entrada
A entrada é um número em ponto flutuante de dupla precisão X (de acordo com o padrão IEEE 754-2008). Nunca haverá um número com mais de 110 caracteres nem com mais de 6 casas decimais.

Saída
A saída é o número X em uma única linha na notação científica detalhada acima. Veja os exemplos abaixo.
 */

import java.io.IOException;
import java.util.Scanner;

public class ScientificNotationNumber {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        double numero = scan.nextDouble();

        int cont = 0;

        if (numero >= 1 && numero < 10) {
            System.out.printf("+%.4f%s", numero, "E+00");
        } else if (numero > 0 && numero < 1) {
            while (numero< 1) {
                cont += 1;
                numero *= 10;
                if (cont < 10) {
                    System.out.printf("+%.4f%s%d", numero, "E-0", cont);
                } else {
                    System.out.printf("+%.4f%s%d", numero, "E-", cont);
                }
            }
        } else if (numero >= 10) {
            while (numero >= 10) {
                cont += 1;
                numero /= 10;
                if (cont < 10) {
                    System.out.printf("+%.4f%s%d", numero, "E+0", cont);
                } else {
                    System.out.printf("+%.4f%s%d", numero, "E+", cont);
                }
            }
        } else if (numero < -1 && numero > -10) {
            System.out.printf("-%.4f%s", Math.abs(numero), "E+00");
        } else if (numero < 0 && numero > -1) {
            numero = Math.abs(numero);
            while (numero< 1) {
                cont += 1;
                numero *= 10;
                if (cont< 10) {
                    System.out.printf("-%.4f%s%d", numero, "E-0", cont);
                } else {
                    System.out.printf("-%.4f%s%d", numero, "E-", cont);
                }
            }
        } else if (numero <= -10) {
            numero = Math.abs(numero);
            while (numero >= 10) {
                cont += 1;
                numero /= 10;
                if (cont < 10) {
                    System.out.printf("-%.4f%s%d", numero, "E+0", cont);
                } else {
                    System.out.printf("-%.4f%s%d", numero, "E+", cont);
                }
            }
        } else if (numero == 0.0) {
            String numStr = String.valueOf(numero);
            if (numStr.charAt(0) == '-') {
                System.out.printf("%.4f%s", numero, "E+00");
            } else {
                System.out.printf("+%.4f%s", numero, "E+00");
            }
        }
    }
}
