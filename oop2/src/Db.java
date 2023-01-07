import java.util.ArrayList;
import java.util.HashMap;

/**
 * Описание БД
 */
public class Db {
    public HashMap<Integer, Human> humans = new HashMap<>();
    public ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Вывод на экран списка людей
     */
    public void printHumans() {
        System.out.println("Список людей");
        for (HashMap.Entry<Integer, Human> entry : humans.entrySet()) {
            Integer humanId = entry.getKey();
            Human human = entry.getValue();        
            System.out.println(String.format("%d  %s", humanId, human));
        }
        System.out.println("Это все имеющиеся люди");
        System.out.println("----------------------");
    }

    /**
     * Вывод на экран списка связей
     */
    public void printNodes() {
        Human human1;
        Human human2;
        System.out.println("Список связей");
        for (Node item : nodes) {
            human1 = humans.get(item.humanId1);
            human2 = humans.get(item.humanId2);
            System.out.println(String.format("%s  является %s для  %s", 
                                             human1, item.relation, human2));
        }
        System.out.println("Это все имеющиеся связи");
        System.out.println("-----------------------");
    }
}
