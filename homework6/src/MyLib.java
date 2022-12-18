
import java.util.Scanner;

public class MyLib {

//    public LinkedList<Object> list = new LinkedList<>();

    /**
    * Метод получает ответ от пользователя да или нет
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
    * Метод проверяет, является ли строка числом (со знаком или без, с десятичной точкой или без)
    * @param str - строка (String)
    * @return - true или false (boolean)
    */    
        public static boolean isNumeric(String str) {
            return str.matches("-?\\d+(\\.\\d+)?");  //проверяет число ()
        }
    
    /**
    * Метод проверяет, является ли строка ЦЕЛЫМ числом (со знаком или без)
    * @param str - строка (String)
    * @return - true или false (boolean)
    */
    public static boolean isInteger(String str) {
            return str.matches("-?\\d+");  //проверяет число с возможным минусом
    }    

}
         

