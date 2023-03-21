public class Checker {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");  //проверяет число с возможным минусом
    }

    public static boolean isNotEmpty(String string) {
        if (string.length() == 0) {
            // String cannot be parsed, it is null or empty
            return false;
        } else {
            return true;
        }
    }
    public static boolean isReal(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //проверяет число c возможным минусом и десятичной точкой
    }

    public static boolean isCorrectValue(String string){
        if (Double.parseDouble(string) >= 0 && Double.parseDouble(string) <= 100){
            return true;
        }else {
            return false;
        }
    }
}
