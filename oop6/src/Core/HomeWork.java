package Core;
import DB.ScienceType;

/**
 * Домашнее задание
 */
public class HomeWork {
    ScienceType science;
    String topic;

    /**
     * Конструктор домашнего задания
     * @param science - наука
     * @param topic - задание
     */
    public HomeWork(ScienceType science, String topic) {
        this.science = science;
        this.topic = topic;
    }


    @Override
    public String toString() {
        return String.format("%s %s", science, topic);
    }
}