import java.util.LinkedList;

public class MyQueue {

    public LinkedList<Object> list = new LinkedList<>();

    /**
    * Метод помещает элемент в конец очереди
    * @param args - объект для очереди (Object)
    */    
    public void enqueue(Object args) {
        list.addLast(args); 
    }

    /**
    * Метод возвращает первый элемент из очереди и удаляет его
    * @return - первый элемент из очереди (Object)
    */
    public Object dequeue() {
        return list.pollFirst();
    }

    /**
    * Метод возвращает первый элемент из очереди, не удаляя
    * @return - первый элемент из очереди (Object)
    */
    public Object first() {
        return list.peekFirst();
    }
}

