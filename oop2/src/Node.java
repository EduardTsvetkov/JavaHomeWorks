public class Node {
    Human h1;
    Human h2;
    Relationship rel1;
    Relationship rel2;
    /**
     * Конструктор связи
     * @param _h1
     * @param _rel1
     * @param _rel2
     * @param _h2
     */
    public Node(Human _h1, Relationship _rel1, Relationship _rel2, Human _h2) {
        this.h1 = _h1;
        this.h2 = _h2;
        this.rel1 = _rel1;
        this.rel2 = _rel2;
    }
}
