import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class calc {

    static List<String> getData() {
        String userString;
        Scanner iScanner = new Scanner(System.in);
        do {
            System.out.println("Введите пример (операнды и оператор через пробел) ");
            System.out.println("например 2 + 7 или 4 * 3");
            userString = iScanner.nextLine(); 
        } while (!userString.matches("-?\\d+(\\.\\d+)? [+\\-*/] -?\\d+(\\.\\d+)?"));
        iScanner.close();
        // result = userString.split(" ");
        List<String> result = new  ArrayList<String>(Arrays.asList(userString.split(" ")));

        return result;
    }





    public static void main(String[] args) {
        List<String> userData = getData();
        double a = Double.parseDouble(userData.get(0));
        double b = Double.parseDouble(userData.get(2));
        String sign = userData.get(1);
        double total;
        switch (sign) {
            case "+":
                total = a + b;
                break;
            case "-":
                total = a - b;
                break;
            case "*":
                total = a * b;
                break;                
            case "/":

                total = a / b;
                break;  
            default:
                total = 0;
                break;                  

        }
        System.out.printf("%f %s %f = %f", a, sign, b, total);
    }
}
