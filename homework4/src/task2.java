
public class task2 {
    public static void main(String[] args) {
        MyQueue mqS = new MyQueue();
        mqS.enqueue("Первый");
        mqS.enqueue("Второй");
        mqS.enqueue("Третий");

        System.out.println();
        System.out.println(mqS.list);
        System.out.println(mqS.first());  // прочитали первый
        System.out.println(mqS.dequeue());  // прочитали первый и удалили его
        System.out.println(mqS.first());  // прочитали оставшийся первый
        System.out.println(mqS.dequeue());  // прочитали оставшийся первый и удалили его
        System.out.println(mqS.dequeue());  // прочитали оставшийся первый и удалили его
        System.out.println(mqS.dequeue()); // Кончились, будет null
        System.out.println();

        MyQueue mqN = new MyQueue();
        mqN.enqueue(111);
        mqN.enqueue(222);
        mqN.enqueue(333);

        System.out.println(mqN.list);
        System.out.println(mqN.first());  // прочитали первый
        System.out.println(mqN.dequeue());  // прочитали первый и удалили его
        System.out.println(mqN.first());  // прочитали оставшийся первый
        System.out.println(mqN.dequeue());  // прочитали оставшийся первый и удалили его
        System.out.println(mqN.dequeue());  // прочитали оставшийся первый и удалили его
        System.out.println(mqN.dequeue()); // Кончились, будет null
        System.err.println();
    }  
}
