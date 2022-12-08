import java.util.HashMap;
import java.util.Scanner;

public class phonebook {

    public static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();


    /**
    * Метод получает ответ от пользователя да или нет
    * @param scanner - сканер, созданный в основной программе (Scanner)    
    * @param str - строка с вопросом (String)
    * @return - true или false (boolean)
    */   
    public static boolean getAnswer(Scanner scanner, String str) {
        
        String inputString = "";
        System.out.println(str);
        
        while (true) {
            System.out.print("Введите: 'Y' если да, 'N' если нет):  ");
            inputString = scanner.nextLine().strip().toUpperCase();           
            
            if (inputString.equals("Y")) {
                return true;
            } else if (inputString.equals("N")) {
                return false;
            } else {
                System.out.printf("Вы ввели %s .\n", inputString);
            }

        }
                
    }

    /**
    * Метод заполняет глобальный телефонный справочник (HashMap<String, HashMap<String, String>>)
    * @param scanner - сканер, созданный в основной программе (Scanner)    
    */   
    public static void putPhones(Scanner scan) {
        
        String phoneType;
        String phone;
        String name;

        while (getAnswer(scan, "Вводим данные нового человека?")) { 
            HashMap<String, String> phoneNumbers = new HashMap<>();
            System.out.print("Введите ФИО: ");
            name = scan.nextLine().toUpperCase();
            System.out.print("Введите номер телефона: ");
            phone = scan.nextLine();
            System.out.print("Введите тип телефона (мобильный, рабочий, факс и т.п.): ");
            phoneType = scan.nextLine();
            phoneNumbers.put(phone, phoneType);
            System.out.printf(" %s добавлен телефон %s как %s .\n", name, phone, phoneType);
            while (getAnswer(scan, "Добавить еще один номер?")) {
                System.out.print("Введите номер телефона: ");
                phone = scan.nextLine();
                System.out.print("Введите тип телефона (мобильный, рабочий, факс и т.п.): ");
                phoneType = scan.nextLine();                        
                System.out.printf(" %s добавлен телефон %s как %s .\n", name, phone, phoneType);
                phoneNumbers.put(phone, phoneType);
            }
            System.out.println();
            phoneBook.put(name, phoneNumbers);
        }
    }


    /**
    * Метод выводит в консоль глобальный телефонный справочник (HashMap<String, HashMap<String, String>>)
    * @param scanner - сканер, созданный в основной программе (Scanner)    
    */   
    public static void getPhones(Scanner scan) {

        for (HashMap.Entry<String, HashMap<String, String>> extSet : phoneBook.entrySet()) {
 
            HashMap<String, String> num = new HashMap<>();
            // Printing all elements of a Map
            System.out.println();
            System.out.println(extSet.getKey());
            num = extSet.getValue();
            for (HashMap.Entry<String, String> intSet : num.entrySet()) {
                System.out.println(intSet.getKey() + " - "
                + intSet.getValue());
            }    
        }
    }


    /**
    * Метод создает и выводит на экран телефонный справочник
    */ 
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Заполняем телефонную книгу.");
        Scanner mainScanner = new Scanner(System.in, "Cp866");
        putPhones(mainScanner);

        getPhones(mainScanner);

        mainScanner.close();
        System.out.println();
    }
}