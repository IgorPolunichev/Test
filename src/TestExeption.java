public class TestExeption extends Exception {
    private String string;
    String throwable = null;

    TestExeption(String str) {
        this.string = str;
    }

    public String testExp() {
        RomanNumerals romanNumerals = new RomanNumerals();

        String[] splitStr = string.split("[ +,\\-,/,*,]");
        if (splitStr.length == 1)
        {
            throwable = "Строка не является математической операцией";
        }
        else if (splitStr.length > 3)
        {
            throwable = "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        }
        else if (splitStr.length == 2)
        {

            if ((romanNumerals.isRoman(splitStr[0]) && romanNumerals.isArabian(splitStr[1]))
                    || (romanNumerals.isArabian(splitStr[0]) && romanNumerals.isRoman(splitStr[1])))
            {
                throwable = "Используются одновременно разные системы счисления";
            }
            else if (romanNumerals.isArabian(splitStr[0]) && romanNumerals.isArabian(splitStr[1]))
            {
                if (Double.parseDouble(splitStr[0]) % 1 != 0 || Double.parseDouble(splitStr[1]) % 1 != 0 )
                {throwable = "На вход принимаются числа ТОЛЬКО ЦЕЛЫЕ ЧИСЛА от 1 до 10";}

                else  if (Integer.parseInt(splitStr[0]) > 10 || Integer.parseInt(splitStr[1]) > 10)
                {
                    throwable = "На вход принимаются числа от 1 до 10";
                }
            }
            else if ((romanNumerals.romanNumeralsAfterTen(splitStr[0]) > 10 && romanNumerals.romanNumeralsAfterTen(splitStr[1]) < 10)
                    || (romanNumerals.romanNumeralsAfterTen(splitStr[1]) > 10 && romanNumerals.romanNumeralsAfterTen(splitStr[0]) < 10))
            {
                throwable = "На вход принимаются числа от 1 до 10";
            }

            else if ((romanNumerals.isRoman(splitStr[0]) && !romanNumerals.isRoman(splitStr[1]))
                    || (!romanNumerals.isRoman(splitStr[1]) && romanNumerals.isRoman(splitStr[0])))
            {
                throwable = "Строка не является математической операцией";
            }
            else if (((romanNumerals.isArabian(splitStr[0]) && !romanNumerals.isArabian(splitStr[1]))
                    || (!romanNumerals.isArabian(splitStr[1]) && romanNumerals.isArabian(splitStr[0]))))
            {
                throwable = "Строка не является математической операцией";
            }

        }


        return throwable;
    }
}
//        RomanNumerals romanNumerals = new RomanNumerals();
//        if (matcher.find())
//        {
//            throwable = "Вы ввели буквы а не цифры";
//        }
//        else if (splitStr.length > 2)
//        {
//            throwable = "Формат математической операции не удовлетворяет заданию - два" +
//                    " операнда и один оператор (+, -, /, *)";
//        }
//        else if ((romanNumerals.isRoman(splitStr[0]) && romanNumerals.isArabian(splitStr[1]))
//                    || (romanNumerals.isArabian(splitStr[0]) && romanNumerals.isRoman(splitStr[1])))
//            {
//                throwable = "Используются одновременно разные системы счисления";
//
//            }
//        else if (Integer.parseInt(splitStr[0]) > 10 && Integer.parseInt(splitStr[1]) > 10)
//        {
//            throwable = "Калькулятор работает только с числами от 0 до 10";
//        }
//        return throwable;

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


