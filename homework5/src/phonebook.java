import java.util.HashMap;
import java.util.Scanner;

public class phonebook {

    public static boolean getAnswer(String str) {
        
        String inputString = "";
        System.out.println(str);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите: 'Y' если да, 'N' если нет):  ");
            inputString = scanner.nextLine().strip().toUpperCase();           
            
            if (inputString.equals("Y")) {
                scanner.close();
                return true;
            } else if (inputString.equals("N")) {
                scanner.close();
                return false;
            } else {
                System.out.printf("Вы ввели %s .\n", inputString);
            }

        }
                
    }


    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();
        HashMap<String, String> phoneNumbers = new HashMap<>();
        
        System.out.println("Заполняем телефонную книгу.");
        String phoneType;
        String phone;
        boolean flag = true; // getAnswer("Вводим данные нового человека?");
        String name = "";
        Scanner scan = new Scanner(System.in);
        while (flag) { 
            System.out.print("Введите ФИО: ");
            name = scan.nextLine();
            if (name.equals("NO")) {
                scan.close();
                break;
            }
            System.out.println(name);
        }
        scan.close();


        
    }
}
