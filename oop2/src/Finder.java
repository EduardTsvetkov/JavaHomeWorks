import java.util.Scanner;

public class Finder {
    private Db db;
    private Scanner scan = GlobalScaner.getInput();

    public Finder(Db db) {
        this.db = db;
    }


    public void getFamily() {
        int humanId;
        Human human1;
        Human human2;
        boolean flag = true;

        while (true) {
            System.out.print("Введите ID человека для поиска родственников (-1 для выхода): ");
            if (scan.hasNextInt()) {
                humanId = scan.nextInt();
                if (humanId == -1) {
                    flag = false;
                    System.out.println("Поиск отменен.");
                    break;
                }
                if (db.humans.containsKey(humanId)) {
                    human1 = db.humans.get(humanId);
                    System.out.println("-------------");
                    System.out.println(human1);
                    break;
                } else {
                    System.out.printf("%d - нет такого ID.\n", humanId);
                }

            } else {
                System.out.println(String.format("%s - это не число.", scan.nextLine()));
            }
        }
        if (flag) {
            for (Node item : db.nodes) {
                if (item.humanId1 == humanId) {
                    human2 = db.humans.get(item.humanId2);
                    System.out.println(String.format("является %s для  %s", 
                                                    item.relation, human2));                
                }

            }
        System.out.println("Поиск родственников завершен.");    
        System.out.println("----------------------------");
        }
        scan.nextLine();
    }





}
