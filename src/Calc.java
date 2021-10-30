import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.AccessDeniedException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    public static void main(String[] args) {
        try (BufferedReader bi = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String inputStr = bi.readLine().trim().replaceAll("\\s+", "");
                TestExeption testExeption = new TestExeption(inputStr);
                String s = testExeption.testExp();
                if (s == null) {
                    RomanNumerals rn = new RomanNumerals();
                    MathematicalOperations mo = new MathematicalOperations();
                    String[] operand = inputStr.split("[ +,\\-,/,*,]");
                    String operationSign;

                    int result = 0;
                    if (rn.isArabian(operand[0]) && rn.isArabian(operand[1])) {
                        operationSign = inputStr.replaceAll("\\d", "");
                        int operand1 = Integer.parseInt(operand[0]);
                        int operand2 = Integer.parseInt(operand[1]);
                        result = mo.result(operand1, operand2, operationSign);
                        System.out.println(result);
                    } else if (rn.isRoman(operand[0]) && rn.isRoman(operand[1])) {
                        operationSign = inputStr.replaceAll("[A-Z]", "");
                        int operand1 = rn.getArabianNumerals(operand[0]);
                        int operand2 = rn.getArabianNumerals(operand[1]);
                        result = mo.result(operand1, operand2, operationSign);
                        if (result <= 0) {
                            throw new ArithmeticException("В римской системе нет отрицательных чисел и цыфры ноль");
                        }
                        String f = rn.getRomanResult(result);
                        System.out.println(f);
                    }
                }
                else
                {
                    throw new Exception (s);
                }
            }

        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}






