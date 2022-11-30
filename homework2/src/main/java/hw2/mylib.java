package hw2;
public class mylib {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //проверяет число ()
    }

    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");  //проверяет число с возможным минусом
    }    
}
 