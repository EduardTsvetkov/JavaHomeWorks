import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Описание базы данных
 */
public class Db {
    public HashMap<Integer, User> users;
    public HashMap<Integer, HomeWork> homeWorks;
    public ArrayList<Achievement> achievements;


    public void showUsers() {
        for (Map.Entry<Integer, User> entry: users.entrySet()) {
            System.out.printf("ID=%d %s\n", entry.getKey(), entry.getValue());
        } 
    }


    public void showHomeWorks() {
        for (Map.Entry<Integer, HomeWork> entry: homeWorks.entrySet()) {
            System.out.printf("ID=%d %s\n", entry.getKey(), entry.getValue());
        } 
    }


    public void showAchievements() {
        for (Achievement achievement : achievements) {
            System.out.println(achievement);
            
        }
    }
}
