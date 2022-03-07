import java.util.Scanner;

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
