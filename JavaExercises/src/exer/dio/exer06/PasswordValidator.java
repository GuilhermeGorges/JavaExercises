package exer.dio.exer06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordValidator {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String pass;
            boolean isValid;

        while ((pass = br.readLine()) != null){


            String rx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,32}$";
            isValid = pass.matches(rx);


            if(!isValid){
                System.out.println("Senha invalida.");
            } else {
                System.out.println("Senha valida.");
            }

        }


    }
}
