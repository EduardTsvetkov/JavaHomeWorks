

import java.util.HashMap;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws Exception {
        Scanner mainScanner = new Scanner(System.in, "Cp866");
        HashMap<String, HashMap<String, String>> catalog = new HashMap<>();
        String fileName = "notebooks.txt";

        catalog = notebook.GetData(fileName);
        System.out.println("Добро пожаловать!");

        String userChoice;
        boolean flag = true;
        System.out.println();
        while (flag) {
            System.out.println("Выберите пункт:");
            System.out.println("   1 - показать весь каталог;");
            System.out.println("   2 - отфильтровать каталог;");
            System.out.println("   0 - выход.");
            userChoice = mainScanner.nextLine();
            System.out.println("-----------------------------");
            switch (userChoice) {
                case "1":
                    notebook.ShowCatalog(catalog);
                    break;
                case "2":
                    notebook.ShowCatalog(notebook.ApplyFilter(catalog, notebook.SetFilter(mainScanner)));
                    break;            
                case "0":
                    flag = false;
                    System.out.println("Всего доброго!\n");
                    break; 
                default:
                    System.out.printf("Пункта меню %s не существует.\n", userChoice);
                    break;
            }
            System.out.println("===========================================================");
        }

        mainScanner.close();
    }
}
