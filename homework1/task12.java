// 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
// 2. Вывести все простые числа от 1 до 1000


package homework1;

import java.util.ArrayList;
import java.util.List;

public class task12 {

    static int getFactorial(int n) {
        if(n==1)return 1;
        return n * getFactorial(n-1);
    }


    static int getTriangleNumber(int n) {
        if(n==1)return 1;
        return n + getTriangleNumber(n-1);
    }    

    static List<Integer> getPrimeNumbers(int n) {
        List<Integer> result = new ArrayList<Integer>();
        boolean flag;
        for (int i = 2; i <= n; i++) {
            flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;                    
                }
            }
            if (flag) {
                result.add(i);
            }
        }

        return result;
        
    }
    
    
    
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
        System.out.println(getTriangleNumber(5));
        System.out.println(getPrimeNumbers(1000));
    }
    
}
