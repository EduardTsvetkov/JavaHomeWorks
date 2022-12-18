import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FilmBase {

    public ArrayList<Film> films = new ArrayList<Film>();
    private Scanner scan;

    public FilmBase (String path) {
        films = GetData(path);
    }

    public FilmBase (FilmBase _films, Scanner _scan) {
        films = _films.films;
        scan = _scan;
    }
    public FilmBase () {
        
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


/**
 * Метод выводит на экран каталог фильмов
 */
    public void ShowFilms() {
        for (Film item : films) {
            item.ShowFilmInfo();   
        }  
    }

    public void FindFilms(ArrayList<Film> films, Scanner scan) {
        FilmBase result = new FilmBase();
        System.out.println("Введите строку для поиска названия фильма:");
        String filter = scan.nextLine();
        for (Film item : films) {
            if (item.title.toLowerCase().contains(filter.toLowerCase())) {
                result.films.add(item);
            }
              
        }

        if (result.films.size() > 0) {
            result.ShowFilms();
        } else {
            System.out.printf("Строка %s - в названиях фильмов не найдена\n", filter);
        }
        

        
    }



}