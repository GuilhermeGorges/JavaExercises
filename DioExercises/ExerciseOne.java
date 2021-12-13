/*
Crie um programa onde você receberá valores inteiros não negativos como entrada.

Ordene estes valores de acordo com o seguinte critério:

Primeiro os Pares
Depois os Ímpares
Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.

Entrada
A primeira linha de entrada contém um único inteiro positivo N (1 < N < 10000) Este é o número de linhas de entrada que vem logo a seguir. As próximas N linhas terão, cada uma delas, um valor inteiro não negativo.

Saída
Exiba todos os valores lidos na entrada segundo a ordem apresentada acima. Cada número deve ser impresso em uma linha, conforme exemplo de saída abaixo.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cont = scan.nextInt();
        ArrayList<Integer> numListPar = new ArrayList<>();
        ArrayList<Integer> numListImpar = new ArrayList<>();
        int[] numListConcat = new int[cont];

        for (int i = 0; i< cont; i++){
            int num = scan.nextInt();
            if(num%2==0){
                numListPar.add(num);
            } else {
                numListImpar.add(num);
            }
        }

        Collections.sort(numListPar);
        Collections.sort(numListImpar);

        int contador = 0;

        while(contador<numListPar.size()){
            numListConcat[contador] = numListPar.get(contador);
            contador++;
        }

        int contador2 = numListImpar.size();
        while(contador2>0){
            numListConcat[contador] = numListImpar.get(contador2-1);
            contador++;
            contador2--;

        }

        for(int num : numListConcat){
            System.out.println(num);
        }

    }
}
