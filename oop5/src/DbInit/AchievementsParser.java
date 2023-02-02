package DbInit;
import java.util.ArrayList;
import java.util.Arrays;

import Core.Achievement;

/**
 * Парсер списка, полученного из файла с оценками ДЗ
 */
public class AchievementsParser {

    /**
     * Метод получает список строк с оценками домашних заданий и возвращает список достижений
     * @param f - путь к файлу с оценками
     * @return - список достижений
     */
    public static ArrayList<Achievement> getAchievements(String f) {
        ArrayList<Achievement> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<String>();
        for (String str : Reader.readFile(f)) {
            temp = new ArrayList<String>(Arrays.asList(str.split(";")));
            Achievement achievement = new Achievement(Integer.parseInt(temp.get(0)), 
                                                      temp.get(1), 
                                                      Integer.parseInt(temp.get(2)), 
                                                      temp.get(3));
            result.add(achievement);
        }
        
        return result;
    }
}