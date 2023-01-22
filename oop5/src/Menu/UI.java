package Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Core.GlobalScaner;
import Core.User;
import DB.Db;

public class UI {
    private Scanner scan = GlobalScaner.getInput();
    public Db db; 
    public User user;

    public UI(Db db) {
        this.db = db;
    }

    /**
     * Аутентификация пользователя (проверка логин/пароль)
     * @return - ID пользователя (либо: -1 - неверный логин/пароль)
     */
    public int authentication() {
        String login, password;
        int result = -1;
        System.out.print("Введитe login: ");
        login = scan.nextLine();
        System.out.print("Введитe password: ");
        password = scan.nextLine();

        for (Map.Entry<Integer, User> entry: db.users.entrySet()) {
            if (entry.getValue().getLogin().equals(login)) {
                if (entry.getValue().getPassword().equals(password)) {
                    result = entry.getKey();  // ID пользователя  
                    return result;                  
                } 
            }    
        } 
        return result;
    }


    /**
     * Идентификация пользователя по его ID
     */
    public void identification() {
        int ID;
        int count = 3; // количество попыток
        boolean flag = false;
        while (count > 0 && !flag) {
            ID = authentication();
            if (ID >= 0) {
                user = db.users.get(ID);
                System.out.print("\033[H\033[2J");  // "стереть" экран
                System.out.println("ДОБРО ПОЖАЛОВАТЬ!");
                flag = true;
            } else {
                System.out.println("Неверный логин/пароль.");
                System.out.printf("Осталось попыток: %d \n", --count);
            }            
        }
        if (!flag) {
            System.out.println("Неудача!... Всего доброго!");
            System.exit(0);
        }
    }

    public void mainMenu() {
        HashMap<Integer, String> menuItems = new HashMap<>();
        
        Menu menu;
        switch (user.getType().name()) {
            case "ADMIN": 
                menuItems.put(1, "Показать пользователей");
                menuItems.put(2, "Добавить пользователя");
                menuItems.put(3, "Удалить пользователя");
                menuItems.put(9, "Выход из программы");
            
                break;
            case "TEACHER":
                menuItems.put(1, "Показать ДЗ");
                menuItems.put(2, "Добавить ДЗ");
                menuItems.put(3, "Показать долги студентов"); 
                menuItems.put(4, "Оценить ДЗ студента");
                menuItems.put(9, "Выход из программы"); 

                break;
            case "STUDENT":
                menuItems.put(1, "Показать ДЗ");
                menuItems.put(2, "Показать оценки студента");
                menuItems.put(3, "Показать долги студента");
                menuItems.put(9, "Выход из программы");

                break;
        
            default:
                menuItems.put(9, "Выход из программы");
                break;
        }
        int itemNum;
        menu = new Menu(menuItems);
        itemNum = menu.getChoice();

    }



}
