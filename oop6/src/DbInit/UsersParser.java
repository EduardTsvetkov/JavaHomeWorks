package DbInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Core.User;
import DB.AccountType;

/**
 * Парсер списка, полученного из файла с пользователями
 */
public class UsersParser {

    /**
     * Метод получает список строк из файла с пользователями и возвращает список пользователей
     * @param f
     * @return
     */
    public static HashMap<String, User> getUsers(String f) {
        HashMap<String, User> result = new HashMap<String, User>();
        ArrayList<String> temp = new ArrayList<String>();

        for (String str : Reader.readFile(f)) {
            temp = new ArrayList<String>(Arrays.asList(str.split(";")));
            User user = new User(temp.get(3), temp.get(2), Integer.parseInt(temp.get(4)), 
                                    temp.get(1), AccountType.valueOf(temp.get(5)));

            result.put(temp.get(0), user);
            

        }

        return result; 
    }
    
}