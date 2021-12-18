package exer.dio.exer07;
/*
Pedra-papel-tesoura-lagarto-Spock é uma expansão do clássico método de seleção em jogo de pedra-papel-tesoura.
Atua sob o mesmo princípio básico, mas inclui outras duas armas adicionais:
o lagarto (formado pela mão igual a uma boca de fantoche)
e Spock (formada pela saudação dos vulcanos em Star Trek).
Isso reduz as chances de uma rodada terminar em um empate.
O jogo foi inventado por Sam Kass e Karen Bryla, como "Rock Paper Scissors Lizard Spock".
As regras de vantagem são as seguintes:

Tesoura corta papel
Papel cobre pedra
Pedra derruba lagarto
Lagarto adormece Spock
Spock derrete tesoura
Tesoura prende lagarto
Lagarto come papel
Papel refuta Spock
Spock vaporiza pedra
Pedra quebra tesoura
Um dia, duas amigas, Fernanda e Marcia, decidiram apostar quem pagaria um almoço para o outro,
com esta brincadeira. Sua missão será fazer um algoritmo que, baseado no que eles escolherem,
informe quem irá ganhar ou se dará empate.

Entrada
Haverá diversos casos de teste. O primeiro número a ser lido será um inteiro,
representando a quantidade de casos de teste. Cada caso de teste tem duas palavras,
representando a escolha de Fernanda e de Marcia, respectivamente.

Saída
Para cada caso de teste, imprima quem venceu, ou se houve empate.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PedraPapelTesouraLagartoSpock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numPartidas = Integer.parseInt(br.readLine());
        String winner;
        List<String> inputList = new ArrayList<>();
        for(int i = 0; i < numPartidas; i++){
            String[] input = br.readLine().split(" ");
            int fernanda = stringToNum(input[0]);
            int marcia = stringToNum(input[1]);
            winner = winner(game(fernanda, marcia));
            System.out.println(winner);
        }
    }

    public static int stringToNum(String s){
        switch (s){
            case "pedra" : return 0;
            case "papel" : return 1;
            case "tesoura" : return 2;
            case "lagarto" : return 3;
            case "spock" : return 4;
            default: return 5;
        }
    }

    public static int game(int p1, int p2){
        int playerWinner = 2;
        if (p1==p2) return 2;
        if ((p1==2 && p2==1)
                || (p1==1 && p2==0)
                || (p1==0 && p2==3)
                || (p1==3 && p2==4)
                || (p1==4 && p2==2)
                || (p1==2 && p2==3)
                || (p1==3 && p2==1)
                || (p1==1 && p2==4)
                || (p1==4 && p2==0)
                || (p1==0 && p2==2)) playerWinner = 0;
        if ((p1==1 && p2==2)
                || (p1==0 && p2==1)
                || (p1==3 && p2==0)
                || (p1==4 && p2==3)
                || (p1==2 && p2==4)
                || (p1==3 && p2==2)
                || (p1==1 && p2==3)
                || (p1==4 && p2==1)
                || (p1==0 && p2==4)
                || (p1==2 && p2==0)) playerWinner = 1;
        return playerWinner;
    }

    public static String winner(int winner){
        if(winner == 0) return "Fernanda";
        if(winner == 1) return "Marcia";
        return "empate";
    }

}
