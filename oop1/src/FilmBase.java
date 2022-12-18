import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FilmBase {

    public ArrayList<Film> films = new ArrayList<Film>();

    public FilmBase (String path) {
        films = GetData(path);
    }


/**
* Метод читает данные о фильмах
* @param f путь к фпйлу с данными (String)
* @return - каталог фильмов из файла (ArrayList<Film>)
*/    
    private static ArrayList<Film> GetData(String f) {
        ArrayList<Film> result = new ArrayList<Film>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str;

            while ((str = br.readLine()) != null) { 
                Film film = new Film(Arrays.asList(str.split(";")));
                result.add(film);
    
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



    public void ShowFilms() {
        for (Film item : films) {
            item.ShowFilmInfo();
            
        }

        
    }

}