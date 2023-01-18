import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * "Читатель" файлов
 */
public class Reader {

    /**
     * Метод читает строки из файла в список строк
     * @param f - путь к файлу
     * @return - список строк
     */
    public static ArrayList<String> readFile(String f) {
        ArrayList<String> result = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;
            while ((str = br.readLine()) != null) { 
                result.add(str);
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