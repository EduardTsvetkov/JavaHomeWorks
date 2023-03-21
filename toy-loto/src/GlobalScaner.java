import java.util.Scanner;

public class GlobalScaner {
    private static Scanner scanner;

    public static Scanner getInput() {
      if (scanner == null)
        scanner = new Scanner(System.in);
      return scanner;
    }
  
    public static void closeInput() {
      if (scanner != null)
        scanner.close();
    }    
}