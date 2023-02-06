package DbInit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Core.Action;

public class ActionsParser {
    
    /**
     * Метод получает список строк с из файла с последними действиями пользователей 
     * и возвращает список последних действий пользователей
     * @param f - путь к файлу с последними действиями пользователей
     * @return - список последних действий пользователей
     */
    public static HashMap<String, Action> getActions(String f) {
        HashMap<String, Action> result = new HashMap<String, Action>();
        ArrayList<String> temp = new ArrayList<String>();
            
        for (String str : Reader.readFile(f)) {
            temp = new ArrayList<String>(Arrays.asList(str.split(";")));
            Action action = new Action(Integer.parseInt(temp.get(1)), temp.get(2));

            result.put(temp.get(0), action);
        }

        return result; 
    }
    

}

