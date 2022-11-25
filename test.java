
/**

* Метод возвращает максимальное значение

* из двух переданных аргументов

* @param a - первый параметр

* @param b - второй параметр

* @return - максимальный из параметров

*/




 

public class test {

    static void sayHi() {
        System.out.println("hi!");
    }

    static int sum(int a, int b) {
        return a+b;
    }  

    static double factor(int n) {
        if(n==1)return 1;
        return n * factor(n-1);
    }

    public static void main(String[] args) {
        sayHi(); // hi!
        System.out.println(sum(1, 3)); // 4
        System.out.println(factor(5)); // 120.0

        boolean x = mylib.isDigit(null);
        System.out.println(x);
    }
}    
