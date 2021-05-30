package javaexercises;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        char[][] ticTacToe = new char [3][3];
        
        System.out.println("Player 1 = X");
        System.out.println("Player 2 = O");
        
        boolean endGame = false;
        int match = 1;
        char signal;
        int row = 0, column = 0;
        
        while(!endGame){
        
            if (match%2 == 1 ){// jogador 1 
                System.out.println("It's player one's turn. please choose a row and a column (1-3).");
                signal = 'X';
            } else {
                System.out.println("It's player one's turn. please choose a row and a column (1-3).");
                signal = 'O';
            }
            
            boolean validRow = false;
            while(!validRow){
                System.out.println("Choose a row (1, 2 or 3)");
                row = scan.nextInt();
                if(row >=1 && row<=3){
                    validRow = true;
                } else {
                    System.out.println("Invalid row, try again.");
                }
            }            
            
            boolean validColumn = false;
            while(!validColumn){
                System.out.println("Choose a column (1, 2 ou 3)");
                column = scan.nextInt();
                if(column >=1 && column<=3){
                    validColumn = true;
                } else {
                    System.out.println("Invalid column, try again.");
                }
            }
            
            row--;
            column--;
            
            if (ticTacToe[row][column] == 'X' || ticTacToe[row][column] == 'O'){
                System.out.println("Position already used, try again. ");
            } else {
                ticTacToe[row][column] = signal;
                match++;
            }
            
            // print board
            for (int i =0; i < ticTacToe.length; i++){
                for (int j =0; j < ticTacToe[i].length; j++){
                    System.out.print(ticTacToe[i][j] + " | ");
                }
                System.out.println();
            }
            
            // winner check
            
            if ((ticTacToe[0][0] == 'X' && ticTacToe[0][1] == 'X' && ticTacToe[0][2] == 'X') || // linha 1
                (ticTacToe[1][0] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[1][2] == 'X') || // linha 2
                (ticTacToe[2][0] == 'X' && ticTacToe[2][1] == 'X' && ticTacToe[2][2] == 'X') || // linha 3
                (ticTacToe[0][0] == 'X' && ticTacToe[1][0] == 'X' && ticTacToe[2][0] == 'X') || // coluna 1      
                (ticTacToe[0][1] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][1] == 'X') || // coluna 2
                (ticTacToe[0][2] == 'X' && ticTacToe[1][2] == 'X' && ticTacToe[2][2] == 'X') || // coluna 3
                (ticTacToe[0][2] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][0] == 'X') || // diagonal 1 
                (ticTacToe[0][0] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][2] == 'X')){  // diagonal 2
                endGame = true;
                System.out.println("Congratulations, player 1 won!!");
            } else if ((ticTacToe[0][0] == 'O' && ticTacToe[0][1] == 'O' && ticTacToe[0][2] == 'O') || // linha 1
                (ticTacToe[1][0] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[1][2] == 'O') || // linha 2
                (ticTacToe[2][0] == 'O' && ticTacToe[2][1] == 'O' && ticTacToe[2][2] == 'O') || // linha 3
                (ticTacToe[0][0] == 'O' && ticTacToe[1][0] == 'O' && ticTacToe[2][0] == 'O') || // coluna 1      
                (ticTacToe[0][1] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[2][1] == 'O') || // coluna 2
                (ticTacToe[0][2] == 'O' && ticTacToe[1][2] == 'O' && ticTacToe[2][2] == 'O') || // coluna 3
                (ticTacToe[0][2] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[2][0] == 'O') || // diagonal 1 
                (ticTacToe[0][0] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[2][2] == 'O')){  // diagonal 2
                endGame = true;
                System.out.println("Congratulations, player 2 won!!");
            } else if (match > 9) {
                endGame = true;
                System.out.println("Nobody won that match.");
            }
        }
    }
}
