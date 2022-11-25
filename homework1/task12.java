// 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
// 2. Вывести все простые числа от 1 до 1000


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class task12 {

/**
* Метод считает факториал
* @param n - целое число (int)
* @return - факториал указанного числа (double)
*/    
    static double getFactorial(int n) {
        if(n==1)return 1;
        return n * getFactorial(n-1);
    }

/**
* Метод считает "треугольное число"
* @param n - целое число (int)
* @return - "треугольное число" указанного числа (long)
*/ 
    static long getTriangleNumber(int n) {
        if(n==1)return 1;
        return n + getTriangleNumber(n-1);
    }    

/**
* Метод создает список простых чисел от 1 до n
* @param n - целое число
* @return - список простых чисел
*/     
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
        String userString;
        Scanner iScanner = new Scanner(System.in);
        do {
            System.out.printf("Введите целое число: ");
            userString = iScanner.nextLine();            
        } while (!mylib.isInteger(userString));
        iScanner.close();

        int number = Integer.parseInt(userString);
        System.out.printf("Факториал числа %d равен  ", number);
        System.out.println(getFactorial(number));
        System.out.printf("'Треугольное' число числа %d равно  ", number);
        System.out.println(getTriangleNumber(number));
        System.out.println("Простые числа от 1 до 1000:");
        System.out.println(getPrimeNumbers(1000));
    }
    
}
