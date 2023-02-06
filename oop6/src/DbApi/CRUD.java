package DbApi;
import java.util.ArrayList;
import java.util.HashMap;

import Core.Achievement;
import Core.HomeWork;
import Core.User;
import DB.Db;

public class CRUD {
    private Db db;

    public CRUD(Db db) {
        this.db = new Db();
        this.db = db;
    }

    public void createUser(User user) {
        System.err.printf("Создаем юзера %s!\n", user);
    }

    public void createHomeWork(HomeWork homeWork) {
        System.err.println("Создаем ДЗ!");
        
    }

    public void createAchievement(Achievement achievement) {
        System.err.println("Создаем достижение!");
    }

    public HashMap<String, User> readAllUsers() {
        HashMap<String, User> result = new HashMap<>();
        result = db.users;
        return result;
    }

    public HashMap<Integer, HomeWork> readAllHomeWorks() {
        return db.homeWorks;
        
    }

    public ArrayList<Achievement> readAllAchievements() {
        return db.achievements;
    }
    
    public void updateUser(User user) {
        System.err.printf("Обновляем юзера %s!\n", user);
    }

    public void updateHomeWork(HomeWork homeWork) {
        System.err.println("Обновляем ДЗ!");
    }

    public void updateAchievement(Achievement achievementr) {
        System.err.println("Обновляем достижение!");
    }

    public void deleteUser(User user) {
        System.err.printf("Удаляем юзера %s!\n", user);
    }

    public void deleteHomeWork(HomeWork homeWork) {
        System.err.println("Удаляем ДЗ!");
    }

    public void deleteAchievement(Achievement achievement) {
        System.err.println("Удаляем достижение!");
    }

    public User readUser(String login) {
        System.err.printf("Читаем юзера по login %s!\n", login);
        User result = db.users.get(login);
        return result;
    }

    public HomeWork readHomeWork(int ID) {
        System.err.printf("Читаем ДЗ по ID %d!\n", ID);
        HomeWork result = db.homeWorks.get(ID);
        return result;
    }



}
