import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestExeption {
    private String string;

    TestExeption(String str) {
        this.string = str;
    }

    public String testExp() {
        Pattern pattern = Pattern.compile("[a-zA-Z].+");
        Matcher matcher = pattern.matcher(string);
        String[] splitStr = string.split("[ +,\\-,/,*,]");
        String throwable = null;
        RomanNumerals romanNumerals = new RomanNumerals();
        if (matcher.find())
        {
            throwable = "Вы ввели буквы а не цифры";
        }
        else if (splitStr.length > 2)
        {
            throwable = "Формат математической операции не удовлетворяет заданию - два" +
                    " операнда и один оператор (+, -, /, *)";
        }
        else if ((romanNumerals.isRoman(splitStr[0]) && romanNumerals.isArabian(splitStr[1]))
                    || (romanNumerals.isArabian(splitStr[0]) && romanNumerals.isRoman(splitStr[1])))
            {
                throwable = "Используются одновременно разные системы счисления";

            }
        else if (Integer.parseInt(splitStr[0]) > 10 && Integer.parseInt(splitStr[1]) > 10)
        {
            throwable = "Калькулятор работает только с числами от 0 до 10";
        }
        return throwable;

//        { +,\-,/,*,
//            String[] testStr = inputStr.split("");
//            if ((rn.isRoman(splitStr[0]) && rn.isArabian(splitStr[1]))
//                    || (rn.isArabian(splitStr[0]) && rn.isRoman(splitStr[1])))
//            {
//                throw new ArithmeticException("Используются одновременно разные системы счисления");
//
//            }
//            if (inputStr.contains())
//            {throw new ArithmeticException("Формат математической операции не удовлетворяет заданию - два" +
//                    " операнда и один оператор (+, -, /, *)");}}

    }
}
