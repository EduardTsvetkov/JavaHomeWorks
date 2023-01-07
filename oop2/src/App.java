import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        DbApi dbApi = new DbApi();
        dbApi.initManual();
        Db db = dbApi.getDb();

        Menu menu = new Menu();
        boolean flag = true;
        while (flag) {
            
            switch (menu.ShowMenu()) {
                case "1":
                    db.printNodes();
                    break;
                case "2":
                    db.printHumans();
                    break;
                case "3":
                    Finder find = new Finder(db) ;
                    find.getFamily();
                    break;
                     
                case "9":
                    flag = false;
                    System.out.println("Всего доброго!\n");
                    break;
                default:
                    break;
            }
        }


    GlobalScaner.closeInput();
    }
}