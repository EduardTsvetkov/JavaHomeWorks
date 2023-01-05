import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        Db db = new Db();
        ArrayList<Node> rel = db.fillDb();


        for (Node item : rel) {
            System.out.println((String.format("%s %s является %s для %s %s", item.h1.firstName, item.h1.lastName, item.rel1, item.h2.firstName, item.h2.lastName)));
            System.out.println((String.format("%s %s является %s для %s %s", item.h2.firstName, item.h2.lastName, item.rel2, item.h1.firstName, item.h1.lastName)));

    }
}
}