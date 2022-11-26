import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class equation {

/**
* Метод получает строку с математическим примером,
* проверяет на соответствие формату и возвращает список для обработки
* @return - список: число, знак, число (List<String>)
*/ 
static List<String> getData() {
    String userString;
    Scanner iScanner = new Scanner(System.in);
    do {
        System.out.println("Введите пример (в одном слагаемом единицы заменены на '?', в другом - десятки). ");
        System.out.println("Например: 2? + ?7 = 59 или ?4+3?=31");
        System.out.print("-> ");
        userString = iScanner.nextLine(); 
    } while (!userString.matches("\\d+\\? ?\\+ ?\\?\\d+ ?\\= ?\\d+") && !userString.matches("\\?\\d+ ?\\+ ?\\d+\\? ?\\= ??\\d+"));
    iScanner.close();
    // result = userString.split(" ");
    List<String> result = new  ArrayList<String>(Arrays.asList(userString.split(" ?\\+ ?| ?\\= ?")));

    return result;
}

    public static void main(String[] args) {
        List<String> userData = getData();
        String qStr = userData.get(0);
        String wStr = userData.get(1);
        String eStr = userData.get(2);
        int q;
        int w;
        int e = Integer.valueOf(eStr); 
        boolean flag = true;

        for (int i = 0; i < 10; i ++) {
            q = Integer.valueOf(qStr.replace("?", Integer.toString(i)));
            for (int j = 0; j < 10; j ++) {
                w = Integer.valueOf(wStr.replace("?", Integer.toString(j)));
                
                if (q + w == e) {
                    System.out.printf("Задание: %s + %s = %s\n", qStr, wStr, eStr);
                    System.out.printf("Решение: %d + %d = %d\n", q, w, e);
                    flag = false;
                }  
            }

        }
    
        if (flag) {
            System.out.printf("Задание: %s + %s = %s  - не имеет решения\n", qStr, wStr, eStr);;
            } 
        }
}
