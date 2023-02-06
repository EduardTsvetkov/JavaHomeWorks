import DB.Db;
import DbInit.Loader;
import Menu.UI;


public class App {
    public static void main(String[] args) {
        
        Loader loader = new Loader("users.txt", "hworks.txt", "achievements.txt", "app.ini");
        loader.initDb();
        Db db = loader.getDb();
        UI ui = new UI(db);
                
        ui.identification();
        ui.fillMenu();
        while (true) {
            ui.mainMenu();
        }
        



        
    }
}