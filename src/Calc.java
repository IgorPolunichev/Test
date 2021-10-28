import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String inputStr = bi.readLine().trim().replaceAll("\\s+", "");
                Pattern pattern = Pattern.compile("^((([0-9]||[1][0])[+,\\-,/,*]([0-9]||[1][0]))||([Ⅰ,Ⅱ,Ⅲ,Ⅳ,Ⅴ,Ⅵ,Ⅶ,Ⅷ,Ⅸ,Ⅹ]" +
                        "[+,\\-,/,*][Ⅰ,Ⅱ,Ⅲ,Ⅳ,Ⅴ,Ⅵ,Ⅶ,Ⅷ,Ⅸ,Ⅹ]))$");
                Matcher matcher = pattern.matcher(inputStr);
                RomanNumerals rn = new RomanNumerals();
                MathematicalOperations mo = new MathematicalOperations();
                String[] splitStr = inputStr.split("[+,\\-,/,*]");
                String operationSign = inputStr.replaceAll("\\d", "");
                if (matcher.find()) {

                    int result;
                    if (rn.isArabian(splitStr[0]) && rn.isArabian(splitStr[1])) {
                        int operand1 = Integer.parseInt(splitStr[0]);
                        int operand2 = Integer.parseInt(splitStr[1]);
                        result = mo.result(operand1, operand2, operationSign);

                        System.out.println(result);
                    } else if (rn.isRoman(splitStr[0]) && rn.isRoman(splitStr[1])) {
                        splitStr = inputStr.split("[+,\\-,/,*]");
                        operationSign = inputStr.replaceAll("[^ +,\\-,*,/]", "");
                        Character charOperand1 = splitStr[0].charAt(0);
                        Character charOperand2 = splitStr[1].charAt(0);
                        int operand1 = rn.getArabianNumerals(charOperand1);
                        int operand2 = rn.getArabianNumerals(charOperand2);
                        result = mo.result(operand1, operand2, operationSign);
                        if (result <= 0) {
                            throw new ArithmeticException("В римской системе нет отрицательных чисел");
                        }
                        String f = rn.getRomanResult(result);
                        System.out.println(f);
                    }
                } else {
                    String[] testStr = inputStr.split("[+,\\-,/,*]");
                    if ((rn.isRoman(splitStr[0]) && rn.isArabian(splitStr[1]))
                            || (rn.isArabian(splitStr[0]) && rn.isRoman(splitStr[1])))
                    {
                        throw new ArithmeticException("Используются одновременно разные системы счисления");

                    }
                    if (testStr.length > 2)
                    {throw new ArithmeticException("Формат математической операции не удовлетворяет заданию - два" +
                            " операнда и один оператор (+, -, /, *)");}
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Строка не является математической операцией");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            } finally {
                bi.close();
            }

        }

    }


}






