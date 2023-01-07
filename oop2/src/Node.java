public class Node {
    public int humanId1;
    public int humanId2;
    public Relationship relation;
    
    /**
     * Конструктор связи
     * @param id1 - идентификатор первого человека
     * @param rel - вид связи со вторым человеком
     * @param id2 - идентификатор второго человека
     */
    public Node(int id1, Relationship rel, int id2) {
        this.humanId1 = id1;
        this.humanId2 = id2;
        this.relation = rel;
    }
}
