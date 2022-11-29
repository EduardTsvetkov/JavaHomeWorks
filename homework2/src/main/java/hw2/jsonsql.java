package hw2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonsql {

	public static void main(String[] args) {
        String path = "forsql.json";
        System.out.println();
        System.out.printf("Читаем данные из файла %s .\n", path);
		JSONParser parser = new JSONParser();
		try {
			/* Читаем из файла в JSONObject */
			Object obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject)obj;
			
			String name = (String) jsonObject.get("name");
			String country = (String) jsonObject.get("country");         
			String city = (String) jsonObject.get("city");         
			String age = (String) jsonObject.get("age");

			System.out.printf("Из полученных данных: %s \n", jsonObject);
            System.out.println("формируем запрос: ");
			StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append("SELECT * FROM students");

            boolean firstFlag = true;

            if (!name.equals("null")) {
                if (firstFlag) {
                    sqlQuery.append(" WHERE name=" + name);
                    firstFlag = false;
                } else {
                    sqlQuery.append(" AND name=" + name);
                }
            }
            if (!country.equals("null")) {
                if (firstFlag) {
                    sqlQuery.append(" WHERE country=" + country);
                    firstFlag = false;
                } else {
                    sqlQuery.append(" AND country=" + country);
                }
            }
            if (!city.equals("null")) {
                if (firstFlag) {
                    sqlQuery.append(" WHERE city=" + city);
                    firstFlag = false;
                } else {
                    sqlQuery.append(" AND city=" + city);
                }
            }
            if (!age.equals("null")) {
                if (firstFlag) {
                    sqlQuery.append(" WHERE age=" + age);
                    firstFlag = false;
                } else {
                    sqlQuery.append(" AND age=" + age);
                }
            }     
            System.out.println(sqlQuery.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
	}
	
}