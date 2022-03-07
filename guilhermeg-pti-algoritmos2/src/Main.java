import java.util.Scanner;

/*
## Tema
Trabalhando com Vetores

## Texto base (texto, gráficos,tabelas, imagens)
Um vetor é uma estrutura de dados que armazena uma sequência de
elementos, todos do mesmo tipo, em posições consecutivas da memória
RAM do computador. Essa estrutura permite acesso aleatório através de
um índice numérico, isto é, qualquer elemento do vetor pode ser alcançado
diretamente, sem passar pelos elementos anteriores.

## Enunciado
Escreva um programa em Java que leia uma sequência N de números inteiros
(negativos, positivos e o zero) para um vetor. No início do programa é solicitado ao
usuário (pelo teclado) qual é a quantidade de elementos que serão lidos para o vetor
e depois disso os números são lidos para o vetor.
Em seguida você deve implementar para cada um dos itens abaixo uma função:
a) Calcule e retorna o valor da maior diferença entre dois elementos distintos no
vetor.
b) Verifica se o vetor está em ordem crescente, e retorna true caso esteja e false
caso contrário.

## Orientações Gerais
Observações do professor: As funções devem ser chamadas na função main
após a leitura do vetor na ordem que aparecem acima, e para cada chamada você
deve imprimir o resultado da função na tela.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numList;
        int amount;

        System.out.println("Digite a quantidade de valores á serem adicionados ao Array: ");
        amount = scan.nextInt();

        numList = new int[amount];
        for(int i = 0;i < numList.length;i++){
            numList[i] = scan.nextInt();
        }

        System.out.println("A maior diferença entre os valores do vetor é de: " + diffCalculate(numList));
        System.out.println("Os Valores do vetor estão em ordem ascendente: " + ascendingOrderValidate(numList));
    }

    public static int diffCalculate(int[] numList){
        int biggerDiff, currentDiff;

        biggerDiff = 0;
        for(int i = 1; i < numList.length; i++){
            currentDiff = Math.abs(numList[i] - numList[i-1]);
            if(currentDiff > biggerDiff) biggerDiff = currentDiff;
        }
        return biggerDiff;
    }

    public static boolean ascendingOrderValidate(int[] numList){
        for(int i = 1; i < numList.length; i++){
            if(numList[i-1]>numList[i]) return false;
        }
        return true;
    }
}
