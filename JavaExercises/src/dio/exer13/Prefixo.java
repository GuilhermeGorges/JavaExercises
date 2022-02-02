package exer.dio.exer13;
/*
Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim. Por definição, um conjunto é bom quando nenhuma palavra desse conjunto é um prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.

Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um prefixo de dbcde. Quando duas palavras são idênticas, definimos como uma sendo prefixo da outra.

Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste terá um inteiro N (1 ≤ N ≤ 10⁵), que representa a quantidade de palavras no conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo 100 letras minúsculas. A entrada termina quando N = 0 e não deve ser processada.

Saída
Para cada caso de teste, você deverá imprimir "Conjunto Bom", ou "Conjunto Ruim", conforme explicado acima.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Prefixo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int conter;
        while ((conter = Integer.parseInt(br.readLine())) != 0){
            String[] conjuntos = new String[conter];
            boolean contains = false;

            for (int i = 0; i<conter;i++){
                String word = br.readLine();
                conjuntos[i] = word;
            }
            for (String word : conjuntos){
                for (String word2 : conjuntos)
                    if (word.equalsIgnoreCase(word2)){
                    } else {
                        if (word.contains(word2)) {
                            contains = true;
                            break;
                        }
                    }
            }
            if (contains) System.out.println("Conjunto Ruim");
            else System.out.println("Conjunto Bom");

        }
    }
}
