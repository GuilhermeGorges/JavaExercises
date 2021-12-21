package exer.dio.exer14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counter;
        BigDecimal result, num;
        String[] numberOperator;
        String operator;

        result = new BigDecimal("1");
        counter = Integer.parseInt(br.readLine());

        for (int i = 0; i < counter; i++){
            numberOperator = br.readLine().split(" ");
            num = new BigDecimal(numberOperator[0]);
            operator = numberOperator[1];
            result = calcula(num, result, operator);
        } br.close();

        System.out.println(result.setScale(0, RoundingMode.DOWN));
        
    }



    public static BigDecimal calcula(BigDecimal num, BigDecimal result, String operator){
        BigDecimal resultado = new BigDecimal(0);
        if (operator.equalsIgnoreCase("*")){
            resultado = result.multiply(num);
        }
        if (operator.equalsIgnoreCase("/")){
            resultado = result.divide(num, MathContext.DECIMAL128);
        }
        return resultado;
    }
}
