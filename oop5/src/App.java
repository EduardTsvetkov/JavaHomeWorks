

public class App {
    public static void main(String[] args) throws Exception {
        
        DbApi dbApi = new DbApi("users.txt", "hworks.txt", "achievements.txt");
        dbApi.initDb();
        Db db = dbApi.getDb();
        UI ui = new UI(db);
        
        ui.identification();
        ui.mainMenu();

        // Menu mainMenu = new Menu() ;
        // mainMenu.menuItems.put(1, "Пункт 1.");
        // mainMenu.menuItems.put(2, "Пункт 2.");
        // mainMenu.menuItems.put(3, "Пункт 3.");
        // System.out.println(mainMenu.getChoice());



        // System.out.println("Users");
        // db.showUsers();
        // System.out.println("HomeWorks");
        // db.showHomeWorks();
        // System.out.println("Achivments");
        // db.showAchievements();

        
    }
}