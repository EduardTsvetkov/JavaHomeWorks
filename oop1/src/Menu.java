import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public HashMap<String, String> m = new HashMap<>();

    public Menu() {
        m.put("1", "Показать каталог.");
        m.put("2", "Поиск.");
        m.put("9", "Выход.");
    }

    public String ShowMenu(Scanner scan) {
        String result;
        while (true) {
            
            for (HashMap.Entry<String, String> punkt : m.entrySet()) {
                System.out.printf(" %s - %s \n", punkt.getKey(), punkt.getValue() );
                
            }  
            System.out.print("Введите номер пункта меню: ");
            result = scan.nextLine();
            Set<String> myKeySet = m.keySet();
            if (myKeySet.contains(result)) {
                return result;
            }  else {
                System.out.printf("Вы ввели несуществующий пункт %s \n", result);
            }

        }

    }
}


