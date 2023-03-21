/**
 * Описание базы данных
 */

import java.util.List;

public class Db {
    public List<Toy> toys;

    public void printToys(){
        for (Toy item: toys) {
            System.out.println(item);
        }
    }
}

