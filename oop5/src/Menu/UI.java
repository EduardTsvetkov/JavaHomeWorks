package Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Core.GlobalScaner;
import Core.User;
import DB.Db;
import Model.Model;

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
    public String authentication() {
        String login, password;
        String result = "";
        System.out.print("Введитe login: ");
        login = scan.nextLine();
        System.out.print("Введитe password: ");
        password = scan.nextLine();

        for (Map.Entry<String, User> entry: db.users.entrySet()) {
            if (entry.getKey().equals(login)) {
                if (entry.getValue().getPassword().equals(password)) {
                    result = entry.getKey();  // login пользователя  
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
        String login;
        int count = 3; // количество попыток
        boolean flag = false;
        while (count > 0 && !flag) {
            login = authentication();
            if (login.equals("")) {
                System.out.println("Неверный логин/пароль.");
                System.out.printf("Осталось попыток: %d \n", --count);                
            } else {
                user = db.users.get(login);
                System.out.print("\033[H\033[2J");  // "стереть" экран
                System.out.println("ДОБРО ПОЖАЛОВАТЬ!");
                flag = true;
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
                System.exit(0);
                break;
        }
        int itemNum;
        menu = new Menu(menuItems);
        itemNum = menu.getChoice();  // получаем выбор пользователя
        Model model = new Model(this.db);

        switch (user.getType().name()) {
            case "ADMIN": 
                switch (itemNum) {
                    case 1:
                        model.getUsers();
                        break;
                    case 2:
                        model.addUser();
                        break;
                    case 3:
                        model.delUser();
                        break;                                        
                    default:
                        System.exit(0);
                        break;
                }
        
                break;
            case "TEACHER":
                switch (itemNum) {
                    case 1:
                        model.getHomeWorks();
                        break;
                    case 2:
                        model.addHomeWork();
                        break;
                    case 3:
                        model.getDebts();  // Показать долги студентов
                        break;         
                    case 4:
                        model.addAchievement();
                        break;   
                        
                    default:
                        System.exit(0);
                        break;
                }


                break;
            case "STUDENT":
                switch (itemNum) {
                    case 1:
                        model.getHomeWorks();  // Показать ДЗ
                        break;
                    case 2:
                        model.getAchievements();  // Показать оценки студента
                        break;
                    case 3:
                        model.getDebts();  // Показать долги студента
                        break;                                        
                    default:
                        System.exit(0);
                        break;
                }

                break;
        
            default:
                System.exit(0);
                break;
        }




    }



}