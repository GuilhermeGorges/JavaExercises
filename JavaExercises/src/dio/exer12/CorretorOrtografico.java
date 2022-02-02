package exer.dio.exer12;
/*Desafio
A nutricionista Juliana Alcantra é uma excelente profissional de sua área. Em determinado dia, ela foi entrevistada ao vivo para um jornal da cidade. No entanto, ficou um pouco nervosa na hora, e diante da situação, sua fala ficou um pouco distorcida, repetindo o final de cada palavra após dizer a mesma. Para que isso não aconteça novamente, ela precisa da sua ajuda para escrever um programa que omita a parte repetida, de modo que as palavras sejam pronunciadas como deveriam ser.

Escreva um programa que, dada uma palavra errada, a mesma seja corrigida.

Entrada
Haverá diversos casos de teste. Cada caso de teste é formado por uma palavra, de, no máximo, 30 caracteres, dita da forma errada. A entrada termina com fim de arquivo.

Saída
Para cada caso de teste, escreva a palavra devidamente corrigida. Analise os exemplos para verificar o padrão, de modo a consertar todos os casos.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CorretorOrtografico {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while ((word = br.readLine()) != null) {
            int wordLength = word.length();
            int errorLength = (int) Math.floor(wordLength / 2);
            int zero = 0;

            if(wordLength == 1) System.out.println(word);
            else if (errorLength > 0){
                for (int i = errorLength; i > 0; i--){
                    if (word.substring(wordLength-i, wordLength).equals(word.substring(wordLength-(2*i),wordLength-i))){
                        zero = i;
                        System.out.println(word.substring(0,(wordLength-zero)));
                    } else if (errorLength == 1){
                        System.out.println(word);
                    }
                }
                if (errorLength>1 && zero == 0) System.out.println(word);
            }
        } br.close();
    }
}
