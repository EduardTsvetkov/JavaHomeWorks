/**
 * Достижение (оценка домашнего задания)
 */
public class Achievement {
    int HomeWorkId;
    int studentId;
    int score;
    int teacherId;

    /**
     * Конструктор достижения
     * @param HomeWorkId - ID домашнего задания
     * @param studentId - ID учащегося
     * @param score - оценка
     * @param teacherId - ID учителя
     */
    public Achievement(int HomeWorkId, int studentId, int score, int teacherId) {
        this.HomeWorkId = HomeWorkId;
        this.studentId = studentId;
        this.score = score;
        this.teacherId = teacherId;
    }
}
