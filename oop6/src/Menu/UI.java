package Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Core.Action;
import Core.GlobalScaner;
import Core.User;
import DB.Db;
import Model.Model;

public class UI {
    private Scanner scan = GlobalScaner.getInput();
    public Db db; 
    public User user;
    private String login;
    private HashMap<Integer, String> menuItems = new HashMap<>();
    private boolean firstAction;
    private int itemNum;
    private Menu menu;
    
    public UI(Db db) {
        this.db = db;
        
    }
    
    

    /**
     * Аутентификация пользователя (проверка логин/пароль)
     * @return - ID пользователя (либо: -1 - неверный логин/пароль)
     */
    public String authentication() {
        String password;
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


    /**
     * Заполнение меню в зависимости от пользователя
     */
    public void fillMenu() {
        firstAction = true;        
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
        menu = new Menu(menuItems);
    }


    public void mainMenu() {
        Model model = new Model(this.db);
        Action action = new Action();
        if (firstAction) {
            action = model.getUserAction(login);
            itemNum = action.itemNum;
            if (itemNum > 0) {
                System.out.println("В предыдущем сеансе вы закончили на меню");
                System.out.println(action.itemString); 
            } else {
                System.out.println(action.itemString);
                Menu menu = new Menu(menuItems);
                itemNum = menu.getChoice();  // получаем выбор пользователя    
            }

            firstAction = false;
        } else {
            itemNum = menu.getChoice();  // получаем выбор пользователя   
        }
        
        boolean exitflag = false;
        
        switch (user.getType().name()) {
            case "ADMIN": 
                switch (itemNum) {
                    case 1:
                        action = new Action(1, "Показать пользователей");
                        model.getUsers();
                        break;
                    case 2:
                        action = new Action(2, "Добавить пользователя");
                        model.addUser();
                        break;
                    case 3:
                    action = new Action(3, "Удалить пользователя");
                        model.delUser();
                        break;                                        
                    default:
                        exitflag = true;
                        break;
                }
        
                break;
            case "TEACHER":
                switch (itemNum) {
                    case 1:
                        action = new Action(1, "Показать ДЗ");
                        model.getHomeWorks();
                        break;
                    case 2:
                        action = new Action(2, "Добавить ДЗ");
                        model.addHomeWork();
                        break;
                    case 3:
                        action = new Action(3, "Показать долги студентов");
                        model.getDebts();  // Показать долги студентов
                        break;         
                    case 4:
                        action = new Action(4, "Оценить ДЗ студента");
                        model.addAchievement();
                        break;   
                        
                    default:
                       exitflag = true;
                        break;
                }


                break;
            case "STUDENT":
                switch (itemNum) {
                    case 1:
                        action = new Action(1, "Показать ДЗ");
                        model.getHomeWorks();  // Показать ДЗ
                        break;
                    case 2:
                        action = new Action(2, "Показать оценки студента");
                        model.getAchievements();  // Показать оценки студента
                        break;
                    case 3:
                        action = new Action(3, "Показать долги студента");
                        model.getDebts();  // Показать долги студента
                        break;                                        
                    default:
                        exitflag = true;
                        break;
                }

                break;
        
            default:
                exitflag = true;
                break;
        }
        if (exitflag) {

            // сохранить данные
            db.actions.put(login, action);
            // сохранить данные

            System.out.println("Всего доброго!");
            System.exit(0);

        }



    }



}