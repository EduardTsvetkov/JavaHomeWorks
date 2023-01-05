import java.util.ArrayList;
import java.util.HashMap;

public class Db {
    public ArrayList<Node> fillDb() {
        ArrayList<Node> relations = new ArrayList<>();

        relations.add(new Node(new Human("Эдуард", "Цветков", "м", "52"), Relationship.HUSBAND, Relationship.WIFE,
                        new Human("Диана", "Цветкова", "ж", "50"))); 
        relations.add(new Node(new Human("Эдуард", "Цветков", "м", "52"), Relationship.FATHER, Relationship.SON, new Human("Максим", "Цветков", "м", "25"))); 
        relations.add(new Node(new Human("Диана", "Цветкова", "ж", "50"), Relationship.MOTHER, Relationship.SON, new Human("Максим", "Цветков", "м", "25")));
        relations.add(new Node(new Human("Эдуард", "Цветков", "м", "52"), Relationship.FATHER, Relationship.DAUGHTER, new Human("Юлия", "Цветкова", "ж", "29"))); 
        relations.add(new Node(new Human("Диана", "Цветкова", "ж", "50"), Relationship.MOTHER, Relationship.DAUGHTER, new Human("Юлия", "Цветкова", "ж", "29")));
        relations.add(new Node(new Human("Юлия", "Цветкова", "ж", "29"), Relationship.SISTER, Relationship.BROTHER, new Human("Максим", "Цветков", "м", "25")));
         
        return relations;
    }

    


}
