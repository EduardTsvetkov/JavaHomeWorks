
import java.util.List;

public class Film {
    public String filmId;
    public String title;
    public String year;
    public String duration;
    public String country;
    public String genre;
    public String director;
    public String cast;

    public Film(List<String> l){
        this.filmId = l.get(0);
        this.title = l.get(1);
        this.year = l.get(2);
        this.duration = l.get(3);
        this.country = l.get(4);
        this.genre = l.get(5);
        this.director = l.get(6);
        this.cast = l.get(7);
    }
/**
 * Метод показывает информацию о фильме
 */
    public void ShowFilmInfo() {
        System.out.printf("ID: %s, %s \n", filmId, title);
        System.out.printf("%s г., %s мин., %s, %s\n", year, duration, country, genre);
        System.out.printf("Режисер: %s, в ролях: %s\n", director, cast);
        System.out.println();
    
    }
}
