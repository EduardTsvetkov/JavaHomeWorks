public class mylib {

/**
* Метод проверяет представляет ли строка число
* (целое или с плавающей запятой)
* @param str - строка для проверки, является ли она числом (String)
* @return - true или false в зависимости число или нет (boolean)
*/    
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //проверяет число c возможным минусом и десятичной точкой
    }


/**
* Метод проверяет представляет ли строка ЦЕЛОЕ число
* @param str - строка для проверки, является ли она целым числом (String)
* @return - true или false в зависимости число или нет (boolean)
*/       
    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");  //проверяет число с возможным минусом
    }    
}
 