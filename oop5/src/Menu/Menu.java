package Menu;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import Core.GlobalScaner;


/**
 * Меню
 */
public class Menu {
    public HashMap<Integer, String> menuItems = new HashMap<>();
    private Scanner scan = GlobalScaner.getInput();

    /**
     * Конструктор меню
     * @param menu - HashMap в котором ключ - номер пункта меню, значение - текст пункта
     */
    public Menu(HashMap<Integer, String> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Конструктор по умолчанию
     */
    public Menu() {
    }

    /**
     * Метод показывает пункты меню и возвращает выбор пользователя
     * @return - номер пункта меню
     */
    public Integer getChoice() {
        Integer result;
        while (true) {
            System.out.println("Выберите:");
            for (HashMap.Entry<Integer, String> punkt : menuItems.entrySet()) {
                System.out.printf(" %d - %s \n", punkt.getKey(), punkt.getValue());
            }  
            System.out.print("Введите номер пункта меню: ");
            if (scan.hasNextInt()) {
                result = scan.nextInt();
                Set<Integer> myKeySet = menuItems.keySet();
                if (myKeySet.contains(result)) {
                    return result;
                }  else {
                    System.out.printf("Вы ввели несуществующий пункт %s. \n", result);
                }                
            } else {
                System.out.printf("Вы ввели несуществующий пункт %s. \n", scan.nextLine());
            }

        }

    }
}


