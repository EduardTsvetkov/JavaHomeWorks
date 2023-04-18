import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-= 1 =-");  
        // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
        // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
        // приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
        String num = "";
        while (true) {
            System.out.print("Введите число типа float или exit для выхода: ");
            num = scanner.nextLine();
            try {
                System.out.printf("Вы введели: %f\n", Task1.task1(num));
            } 
            catch (BadDataException e) {
                System.out.println(e.getMessage());
            }    
            catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }    
        }


        System.out.println("-= 2 =-");
        // Если необходимо, исправьте данный код
        // try {
        //     int d = 0;
        //     double catchedRes1 = intArray[8] / d;
        //     System.out.println("catchedRes1 = " + catchedRes1);
        //  } catch (ArithmeticException e) {
        //     System.out.println("Catching exception: " + e);
        //  }     
        
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int d = 0;
        int ind = 10;
        try {
            double catchedRes1 = intArray[ind] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {  // на случай если в массиве нет индекса 8
            System.out.println("ArrayIndexOutOfBoundsException: " + e);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e);
        }       


        System.out.println("-= 3 =-");
        // Дан следующий код, исправьте его там, где требуется...

        task3();

        System.out.println("-= 4 =-");
        // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
        // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        String inputString = "";
        // scanner.nextLine();
        while (true) {
            // scanner.nextLine();
            System.out.println("Введите строку (пустая строка приведет к выходу из программы):");
            inputString = scanner.nextLine();
            try {
                Task4.task4(inputString);     
                System.out.println();         
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    scanner.close();    
    }


    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}