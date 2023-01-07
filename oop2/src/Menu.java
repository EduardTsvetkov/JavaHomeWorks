import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Основное меню программы.
 */
public class Menu {
    private HashMap<String, String> menu = new HashMap<>();
    private Scanner scan = GlobalScaner.getInput();

    public Menu() {
        menu.put("1", "Показать все связи.");
        menu.put("2", "Показать всех людей.");
        menu.put("3", "Поиск.");
        menu.put("9", "Выход.");
    }

    /**
     * Выводит меню на экран.
     * @return - номер выбраного пункта меню.
     */
    public String ShowMenu() {
        String result;
        while (true) {
            System.out.println();
            for (HashMap.Entry<String, String> punkt : menu.entrySet()) {
                System.out.printf(" %s - %s \n", punkt.getKey(), punkt.getValue() );
                
            }  
            System.out.print("Введите номер пункта меню: ");
            result = scan.nextLine();
            Set<String> myKeySet = menu.keySet();
            if (myKeySet.contains(result)) {
                return result;
            }  else {
                System.out.printf("Вы ввели несуществующий пункт %s \n", result);
            }

        }

    }
}


