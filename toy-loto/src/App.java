import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // Game game = new Game();
        // FileRW csv = new FileRW("Toys.csv");
        // Db db = new Db(); 
        // db.toys = game.createToys();
        // csv.writeResult(db.toys.get(0), false);
        // db.toys.remove(0);
        // for (Toy item : db.toys) {
        //     csv.writeResult(item, true);
        // }
        UI ui = new UI();
        ui.menu();
    }
}