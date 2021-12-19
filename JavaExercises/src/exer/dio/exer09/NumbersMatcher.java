package exer.dio.exer09;
/*
Desafio
Neste desafio sua tarefa será ler vários números e em seguida dizer quantas vezes cada número aparece, ou seja,
 deve-se escrever cada um dos valores distintos que aparecem na entrada por ordem crescente de valor.

Entrada
A primeira linha de entrada contem um único inteiro N, que indica a quantidade de valores que serão lidos
para X (1 ≤ N ≤ 2000) logo em seguida. Com certeza cada número não aparecerá mais do que 20 vezes na entrada de dados.

Saída
Imprima a saída de acordo com o exemplo fornecido abaixo, indicando quantas vezes cada um deles aparece na entrada
por ordem crescente de valor.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumbersMatcher {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int values = scr.nextInt();
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < values; i++) {
            int num = scr.nextInt();
            if(numbers.containsKey(num)) {
                int cont = numbers.get(num);
                numbers.put(num, ++cont);
            } else {
                numbers.put(num, 1);
            }
        }

        numbers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " aparece " + e.getValue() + " vez(es)"));
    }
}
