package exer.dio.exer04;

/*Desafio
Crie um algoritmo para ordenar um conjunto de palavras pelo seu tamanho. Seu programa deve receber um conjunto de
palavras e retornar este mesmo conjunto ordenado pelo tamanho das palavras decrescente, se o tamanho das palavras for igual,
deve-se ordernar por ordem alfabética.

Entrada
A primeira linha da entrada possui um único inteiro N, que indica o número de casos de teste. Cada caso de teste poderá
conter de 1 a 50 palavras inclusive, e cada uma das palavras poderá conter entre 1 e 50 caracteres inclusive. Os caracteres
poderão ser espaços, letras, ou números.

Saída
A saída deve conter o conjunto de palavras da entrada ordenado pelo tamanho das palavras e caso o tamanho das palavras
for igual, deve-se ordernar por ordem alfabética.. Um espaço em branco deve ser impresso entre duas palavras.

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoTamanho {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testNumber = Integer.parseInt(scan.next());
        List<List<ClassWord>> ordenedList = new ArrayList<>();
        scan.nextLine();

        for(int i = 0; i<testNumber; i++){
            List<ClassWord> wordList = new ArrayList<>();

            String words = scan.nextLine();
            String[] wordsStriped = words.split(" ");
            for (String word : wordsStriped){
                int size = word.length();
                ClassWord classWord = new ClassWord(word, size);
                wordList.add(classWord);
            }
            Collections.sort(wordList);
            ordenedList.add(wordList);
        }
        for(int i = 0; i < ordenedList.size(); i++){
            for(int j = 0; j < ordenedList.get(i).size(); j++) {
                System.out.print(ordenedList.get(i).get(j).getWord() + " ");
            }
            System.out.println(" ");
        }
    }


    public static class ClassWord implements Comparable<ClassWord> {
        public String word;
        public int size;


        public ClassWord(String word, int size) {
            this.word = word;
            this.size = size;
        }

        @Override
        public int compareTo(ClassWord cw) {
            if (this.size > cw.size) {
                return -1;
            }
            if (this.size < cw.size) {
                return 1;
            }
            return 0;
        }



        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
