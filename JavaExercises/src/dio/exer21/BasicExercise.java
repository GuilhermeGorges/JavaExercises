package exer.dio.exer18;
/*
Leia quatro valores inteiros A, B, C e D. A seguir,
calcule e mostre a diferença do produto de A e B pelo produto de C e D segundo a fórmula:
 DIFERENCA = (A * B - C * D).

Entrada
O arquivo de entrada contém 4 valores inteiros.

Saída
Imprima a mensagem DIFERENCA com todas as letras maiúsculas, conforme exemplo abaixo,
com um espaço em branco antes e depois da igualdade. */
import java.util.Scanner;

public class BasicExercise {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int quantidadePares = 0;
        for (int i = 0; i < 5; i++) {
            int n = scan.nextInt();
            if ((n%2)==0) quantidadePares++;
        }
        System.out.printf("%d valores pares\n", quantidadePares);
    }
}