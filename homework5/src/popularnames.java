import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class popularnames {
    public static void main(String[] args) {
        ArrayList<String> staffList = new ArrayList<String>(Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова",
            "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",        
            "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин",
            "Иван Ежов"));
        String[] tempArr = new String[2];    
        int count;
        HashMap<String, Integer> names = new HashMap<>();
        for (String str : staffList) {  // пробегаем по списку, сплитим по пробелу, берем имя в качестве "ключа"
            tempArr = str.split(" ");
            if (names.containsKey(tempArr[0])) {  // если имя есть в мапе, увеличивыаем счетчик и перезаписываем
                count = names.get(tempArr[0]) + 1;
                names.put(tempArr[0], count);
            } else {                              // иначе добавляем имя и сетчик = 1
                names.put(tempArr[0], 1);
            }
        }

        ArrayList<String> nameList = new ArrayList<>();
        for (HashMap.Entry<String, Integer> rec : names.entrySet()) {  // пробегаем по мапе и формируем список строк "счетчик - имя"
            nameList.add(rec.getValue() + " - " + rec.getKey()); 
        }
        Collections.sort(nameList);     // сортируем список строк
        Collections.reverse(nameList);  // разворачиваем список строк
        for (String str : nameList) {
            System.out.println(str);    // вуаля
        }
        System.out.println();
    }
}
