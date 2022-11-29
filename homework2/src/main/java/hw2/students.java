package hw2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Чтение файла grades.json и формирование сообщения с оценками
 *
 */
public class students {
    public static void main(String[] args) {
        String path = "grades.json";
        System.out.println();
        System.out.printf("Читаем данные из файла %s .\n", path);

        JSONParser parser = new JSONParser();

        try {
            JSONArray jArr = (JSONArray) parser.parse(new FileReader(path));

            System.out.println("Формируем сообщения с оценками:");
            for (Object o : jArr)
            {
                JSONObject person = (JSONObject) o;
                String surname = (String) person.get("фамилия");
                String grade = (String) person.get("оценка");
                String discipline = (String) person.get("предмет");
                System.out.printf("Студент %s получил %s по предмету %s.\n", surname, grade, discipline); 

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}