
/**
 * Заполнение БД 
 */
public class DbApi {

    private int humanId = 1;
    public Db db;


    private int getHumanID() {
        return humanId++;
    }

    /**
     * Пока что вручную заполняем БД
     */
    public void initManual() {
        db = new Db();

        db.humans.put(getHumanID(), new Human("Эдуард", "Цветков", "м", 1970));
        db.humans.put(getHumanID(), new Human("Диана", "Цветкова", "ж", 1972));
        db.humans.put(getHumanID(), new Human("Максим", "Цветков", "м", 1997));
        db.humans.put(getHumanID(), new Human("Юлия", "Цветкова", "ж", 1993));

        db.nodes.add(new Node(1, Relationship.HUSBAND, 2));
        db.nodes.add(new Node(2, Relationship.WIFE, 1));
        db.nodes.add(new Node(1, Relationship.FATHER, 3));
        db.nodes.add(new Node(1, Relationship.FATHER, 4));
        db.nodes.add(new Node(2, Relationship.MOTHER, 3));
        db.nodes.add(new Node(2, Relationship.MOTHER, 4));
        db.nodes.add(new Node(3, Relationship.SON, 1));
        db.nodes.add(new Node(3, Relationship.SON, 2));
        db.nodes.add(new Node(4, Relationship.DAUGHTER, 1));
        db.nodes.add(new Node(4, Relationship.DAUGHTER, 2));
        db.nodes.add(new Node(3, Relationship.BROTHER, 4));
        db.nodes.add(new Node(4, Relationship.SISTER, 3));
    }

    /**
     * Возвращаем базу данных
     * @return - база данных
     */
    public Db getDb() {
        return db;
    }
    


}
