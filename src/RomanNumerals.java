import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Map<Integer, String> romanNumerals = new HashMap<>();
    private static final Set<Integer> value = romanNumerals.keySet();


    public RomanNumerals() {
        romanNumerals.put(1, "I");
        romanNumerals.put(2, "II");
        romanNumerals.put(3, "III");
        romanNumerals.put(4, "IV");
        romanNumerals.put(5, "V");
        romanNumerals.put(6, "VI");
        romanNumerals.put(7, "VII");
        romanNumerals.put(8, "VIII");
        romanNumerals.put(9, "IX");
        romanNumerals.put(10, "X");
        romanNumerals.put(50, "L");
        romanNumerals.put(100, "C");


    }

    public String getRomanResult(int result) {
        ArrayList<Integer> integers = new ArrayList<>(value);
        Collections.sort(integers);
        String romanResult = "";
        ArrayList<String> d = new ArrayList<>();
        if (result >= 1 && result <= 10)
        {d.add(romanNumerals.get(result));}
        else if (result > 10 && result < 40)
        {
            while (result > 10)
            {result -= 10;
            d.add(romanNumerals.get(10));}
            d.add(romanNumerals.get(result));
        }
        else if (result > 39 && result < 90)
        {
            if (result < 50)
            {d.add(romanNumerals.get(10));
            result = result + 10 - 50;
            d.add(romanNumerals.get(result));}
            else if (result > 49)
            {d.add(romanNumerals.get(50));
            result = result - 50;
            while (result >= 10)
            {d.add(romanNumerals.get(10));
            result -= 10;}
            if (result < 10 && result !=0)
            {d.add(romanNumerals.get(result));}
            }
        }
        else  if (result > 89 && result < 101)
        {d.add(romanNumerals.get(100));
        result = 100 - result;
        if (result > 0 && result <= 10)
        {

            d.add(0 ,romanNumerals.get(10));

            result = result - 10;
        if (result > 0)
        {
            d.add(romanNumerals.get(result));
        }
        }
        }
        for (String character : d) {
            romanResult = romanResult + character;
        }
        return romanResult;

    }
    public Integer getArabianNumerals(String operand) {
        int result = 0;
        for (Integer i : value) {
            if (operand.equals(romanNumerals.get(i))) {
                result = i;
                break;
            }
        }
        return result;
    }
    public boolean isArabian(String str) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^[0-9]{1,2}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            result = true;
        }

        return result;
    }
    public boolean isRoman (String str)
    {
        boolean result = false;

        if (romanNumerals.containsValue(str)) {
            result = true;
        }
        return result;
    }
}
