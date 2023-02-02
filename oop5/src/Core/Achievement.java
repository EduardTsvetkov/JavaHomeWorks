package Core;
/**
 * Достижение (оценка домашнего задания)
 */
public class Achievement {
    int HomeWorkId;
    String student;
    int score;
    String teacher;

    /**
     * Конструктор достижения
     * @param HomeWorkId - ID домашнего задания
     * @param studentId - ID учащегося
     * @param score - оценка
     * @param teacherId - ID учителя
     */
    public Achievement(int HomeWorkId, String student, int score, String teacher) {
        this.HomeWorkId = HomeWorkId;
        this.student = student;
        this.score = score;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        // навести бы красоту
        return String.format("ДЗ id=%d, студент-%s, оценка-%d, преподаватель-%s", HomeWorkId, student, score, teacher);
    }
}