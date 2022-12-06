// 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
// 2. Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
// 3. В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.LinkedList;

public class task1 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        
        ll.add("Первый");
        ll.add("Второй");
        ll.add("Третий");
        ll.add("Четвертый");
        ll.add("Пятый");
        
        System.out.println("Прямой LinkedList:");
        System.out.println(ll);

        for (int i = 0; i < ll.size() - 1; i++) {
            ll.add(i, ll.pollLast());
        }
        System.out.println("Обратный LinkedList:");
        System.out.println(ll);
       
    }
}
