public class Task4 {
    public static void task4(String s) throws RuntimeException {
        if (s.length() == 0) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        
        System.out.println("А тут что-то делаем со строкой...");
        System.out.println(s);
    }    
}
