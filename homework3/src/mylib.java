  
public class mylib {

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
 