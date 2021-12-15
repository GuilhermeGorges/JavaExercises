package exer.dio.exer06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class PasswordValidator {
    public static void main(String[] args) throws IOException {
        String pass = new String();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //insira sua resolução aqui
        pass = br.readLine();


        if (pass.equalsIgnoreCase(pass.toLowerCase())
                || pass.equalsIgnoreCase(pass.toUpperCase())
                || containsSpecialChar(pass) || hasNumber(pass)
                || pass.length() < 6 || pass.length() > 32) { //complete o if de acordo com suas variaveis
            System.out.println("Senha invalida.");
        } else {
            System.out.println("Senha valida.");


        }
    }
    public static boolean containsSpecialChar(String senha) {
        if (senha.contains(" ") || senha.contains(".")
                || senha.contains("~") || senha.contains("'")
                || senha.contains("`") || senha.contains("^")) {
            return true;
        }
        return false;
    }

    private static boolean hasNumber(String pass) {
        for (int i = 0; i < 10; i++) {
            String num = Integer.toString(i);
            if (pass.contains(num)) return false;
        }
        return true;
    }
}