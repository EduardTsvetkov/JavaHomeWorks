import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String name = "";
        Scanner scan = new Scanner(System.in);
        while (true) { 
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
