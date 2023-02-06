package Model;

import java.util.Map;
import java.util.Set;

import DB.Db;

import Core.Achievement;
import Core.Action;
import Core.HomeWork;
import Core.User;

public class Model {
    public Db db;
    // public User users;

    public Model(Db db) {
        this.db = db;
    }


    public void getUsers() {
        for (Map.Entry<String, User> entry: db.users.entrySet()) {
            System.out.printf("ID=%s %s\n", entry.getKey(), entry.getValue());
        } 
    }

    public void addUser() {
        System.err.println("---------------");
        System.err.println("Тут будет метод добавления пользователя");
        System.err.println("---------------");
    }

    public void delUser() {
        System.err.println("---------------");
        System.err.println("Тут будет метод удаления пользователя");
        System.err.println("---------------");
    }


    public void getHomeWorks() {
        for (Map.Entry<Integer, HomeWork> entry: db.homeWorks.entrySet()) {
            System.out.printf("ID=%d %s\n", entry.getKey(), entry.getValue());
        } 
    }

    public void addHomeWork() {
        System.err.println("---------------");
        System.err.println("Тут будет метод добавления ДЗ");
        System.err.println("---------------");
    }

    public void getAchievements() {
        for (Achievement achievement : db.achievements) {
            System.err.println("---------------");
            System.out.println(achievement);
            System.err.println("---------------");            
        }
    }

    public void addAchievement() {
        System.err.println("---------------");
        System.err.println("Тут будет метод добавления оценок");
        System.err.println("---------------");
    }

    public void getDebts() {
        System.err.println("---------------");
        System.err.println("Тут будет метод показа долгов");
        System.err.println("---------------");
    }
    
    /**
     * Метод возвращает сведения о последнем действии пользователя
     * @param login
     * @return
     */
    public Action getUserAction(String login) {
        Set<String> myKeySet = db.actions.keySet();
        if (myKeySet.contains(login)) {
            Action result = db.actions.get(login);
            return result;
        }  else {
            Action result = new Action(0, "Ранее Вы не работали с программой"); 
            return result;
        }                
    }
}
