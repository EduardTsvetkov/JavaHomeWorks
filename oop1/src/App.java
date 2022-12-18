import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in, "Cp866");
        FilmBase db = new FilmBase("films.csv");
        Menu menu = new Menu();

        boolean flag = true;
        while (flag) {
            
            switch (menu.ShowMenu(mainScanner)) {
                case "1":
                    db.ShowFilms();
                    break;
                case "2":
                    db.FindFilms(db.films, mainScanner);
                    break;
                case "9":
                    flag = false;
                    break;
                default:
                    break;
            }
        }

        mainScanner.close();
    }
}
