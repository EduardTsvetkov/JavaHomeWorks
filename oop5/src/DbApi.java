import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DbApi {
    public Db db;
    private String pathUsers = "users.txt";
    private String pathHworks = "hworks.txt";
    private String pathAchievements = "achievements.txt";

    public void getDb() {
        db = new Db();
        db.users = getUsers(pathUsers);
        db.homeWorks = getHomeWorks(pathHworks);
        db.achievements = getAchievements(pathAchievements);
    }

    private static HashMap<Integer, User> getUsers(String f) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            ArrayList<String> temp = new ArrayList<String>();
            while ((str = br.readLine()) != null) { 
                temp = new ArrayList<String>(Arrays.asList(str.split(";")));
                User user = new User(temp.get(4), temp.get(3), Integer.parseInt(temp.get(5)), 
                                     temp.get(1), temp.get(2), AccountType.valueOf(temp.get(6)));

                result.put(Integer.parseInt(temp.get(0)), user);
    
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.printf("Загрузка данных из файла %s завершена!\n", f);
            System.out.println("-------------------------------------");
        }

        return result; 
    }



    // 1;MATHEMATICS;РЕШИТЬ ЗАДАЧИ 1-5
    private static HashMap<Integer, HomeWork> getHomeWorks(String f) {
        HashMap<Integer, HomeWork> result = new HashMap<Integer, HomeWork>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            ArrayList<String> temp = new ArrayList<String>();
            while ((str = br.readLine()) != null) { 
                temp = new ArrayList<String>(Arrays.asList(str.split(";")));
                HomeWork homeWork = new HomeWork(ScienceType.valueOf(temp.get(1)), temp.get(2));

                result.put(Integer.parseInt(temp.get(0)), homeWork);

            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.printf("Загрузка данных из файла %s завершена!\n", f);
            System.out.println("-------------------------------------");
        }

        return result; 
    }
}