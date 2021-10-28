import java.util.HashMap;
import java.util.Map;

public class MathematicalOperations {


    public int result(int a, int b, String sign) {
        int result = 0;
        switch (sign) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;

        }
        return result;
    }


}
