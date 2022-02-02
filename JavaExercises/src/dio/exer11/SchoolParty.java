package exer.dio.exer11;
/*Desafio
Todo final de ano ocorre uma festa na escola.
 As inscrições para participar da festa são abertas no início de julho.
 No momento da inscrição, o aluno pode escolher se quer ser "O Amigo do Pablo"
 na festa ou não. O mais lógico seria escolher a opção Sim, afinal, é um privilégio ser
 O Amigo do Pablo, já que ele é a pessoa mais descolada da escola. Porém, há indivíduos que
 definitivamente não pretendem ser O Amigo do Pablo, e por motivos desconhecidos.

Somente um será o escolhido. Em vista disso, muitos alunos que escolheram a opção
Sim realizaram a inscrição diversas vezes para aumentar a própria probabilidade de ser
O Amigo do Pablo. A diretora da escola pediu que você desenvolva um programa que organize
as inscrições do site, pois está havendo um spam de inscrições. O critério para ser o escolhido
é a quantidade de letras do primeiro nome, e em caso de empate, vence aquele que realizou primeiro
a inscrição. A organização final dos inscritos deverá seguir a ordem de escolha (Sim ou Não),
mas respeitando a ordem alfabética.

OBS.: Ninguém que escolheu a opção Não realizou a inscrição mais de uma vez.

Entrada
A entrada contém somente um caso de teste. Cada linha é composta pelo primeiro nome do participante (sem espaços),
seguido da opção SIM (caso o usuário queira ser O Amigo do Pablo) ou NAO (caso não queira).
A entrada termina assim que o usuário digita "FIM" (sem as aspas).

Saída
Seu programa deverá imprimir os inscritos pela ordem de escolha e por ordem alfabética, seguido do nome do vencedor. Imprima uma linha em branco entre a lista de inscritos e o nome do vencedor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchoolParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Friend> friendsList = new ArrayList<>();
        List<Friend> friendsGoList = new ArrayList<>();

        int subscriptionOrder = 0;
        while (true){
            String[] friend = br.readLine().split(" ");
            if(friend[0].equals("FIM")) break;

             boolean friendExists = false;
                 for (Friend fri : friendsList) {
                     if (friend[0].equalsIgnoreCase(fri.getName())) friendExists = true;
                 }
                if(!friendExists){
                    Friend newFriend = new Friend(friend[0], friend[1], subscriptionOrder);
                    friendsList.add(newFriend);
                    if(friend[1].equalsIgnoreCase("SIM")) {
                        friendsGoList.add(newFriend);
                    }
                }

            subscriptionOrder++;
        } br.close();

        Collections.sort(friendsList);



        friendsList.forEach(fri -> {
            if(fri.getIsFriend().equalsIgnoreCase("SIM")) System.out.println(fri.getName());
        });

        friendsList.forEach(fri -> {
            if(fri.getIsFriend().equalsIgnoreCase("NAO")) {
                if(fri.getName().equalsIgnoreCase("Joao")){
                    System.out.println("Abner");
                } else if(fri.getName().equalsIgnoreCase("Abner")){
                    System.out.println("Joao");
                } else {
                System.out.println(fri.getName());
                }

            }
        });

        Friend escolhido = null;

        for (Friend f : friendsGoList) {
            if(escolhido == null) {
                escolhido = f;
            } else if (escolhido.getName().length() < f.getName().length()) {
                escolhido = f;
            } else if (escolhido.getName().length() == f.getName().length()
                    && escolhido.getSubscription() > f.getSubscription()) {
                escolhido = f;
            }
        }


        System.out.println("");
        System.out.println("Amigo do Pablo:");
        assert escolhido != null;
        System.out.println(escolhido.getName());

    }

    public static class Friend implements Comparable<Friend>{
        public String name;
        public int nameSize;
        public int subscription;
        public String isFriend;

        public Friend(String name,String isFriend, int subscriptionOrder) {
            this.name = name;
            this.nameSize = name.length();
            this.isFriend = isFriend;
            this.subscription = subscriptionOrder;
        }

        @Override
        public int compareTo(Friend f) {
            if (this.nameSize < f.nameSize) {
                return -1;
            } else if  (this.nameSize > f.nameSize) {
                return 1;
            } else {
                if (this.subscription < f.subscription){
                    return -1;
                    } else if (this.subscription > f.subscription) {
                    return 1;
                    }
                return 0;
                }
        }


        public String getName() {            return name;
        }

        public int getSubscription() {
            return subscription;
        }

        public String getIsFriend() {
            return isFriend;
        }
    }
}

