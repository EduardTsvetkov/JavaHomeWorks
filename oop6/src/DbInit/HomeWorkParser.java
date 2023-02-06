package DbInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Core.HomeWork;
import DB.ScienceType;

/**
 * Парсер списка, полученного из файла с домашними заданиями
 */
public class HomeWorkParser {
    
    /**
     * Метод получает список строк с из файла с домашними заданиями и возвращает список ДЗ
     * @param f - путь к файлу с домашними заданиями
     * @return - список домашних заданий
     */
    public static HashMap<Integer, HomeWork> getHomeWorks(String f) {
        HashMap<Integer, HomeWork> result = new HashMap<Integer, HomeWork>();
        ArrayList<String> temp = new ArrayList<String>();
            
        for (String str : Reader.readFile(f)) {
            temp = new ArrayList<String>(Arrays.asList(str.split(";")));
            HomeWork homeWork = new HomeWork(ScienceType.valueOf(temp.get(1)), temp.get(2));

            result.put(Integer.parseInt(temp.get(0)), homeWork);
        }

        return result; 
    }
    

}