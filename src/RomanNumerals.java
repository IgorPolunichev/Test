import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RomanNumerals {
    private static final Map<Integer, Character> romanNumerals = new HashMap<>();
    private static final Set<Integer> value = romanNumerals.keySet();


    public RomanNumerals() {
        romanNumerals.put(1, '\u2160');
        romanNumerals.put(2, '\u2161');
        romanNumerals.put(3, '\u2162');
        romanNumerals.put(4, '\u2163');
        romanNumerals.put(5, '\u2164');
        romanNumerals.put(6, '\u2165');
        romanNumerals.put(7, '\u2166');
        romanNumerals.put(8, '\u2167');
        romanNumerals.put(9, '\u2168');
        romanNumerals.put(10, '\u2169');
        romanNumerals.put(50, '\u216c');
        romanNumerals.put(100, '\u216d');

    }

    public String getRomanResult(int result) {
        ArrayList<Integer> integers = new ArrayList<>(value);
        Collections.sort(integers);
        String romanResult = "";
        ArrayList<Character> d = new ArrayList<>();

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
        if (result > 0)
        d.add(romanNumerals.get(result));}
        for (Character character : d) {
            romanResult = romanResult + character.toString();
        }
        return romanResult;
    }
    public Integer getArabianNumerals(Character character) {
        int result = 0;
        for (Integer i : value) {
            if (character.equals(romanNumerals.get(i))) {
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
        Pattern pattern = Pattern.compile("^[Ⅰ,Ⅱ,Ⅲ,Ⅳ,Ⅴ,Ⅵ,Ⅶ,Ⅷ,Ⅸ,Ⅹ]");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            result = true;
        }
        return result;
    }
}
