import java.util.HashMap;

public class Compass {

    public static final int N = 0;
    public static final int E = 1;
    public static final int S = 2;
    public static final int W = 3;
    public static final int NE = 4;
    public static final int SE = 5;
    public static final int SW = 6;
    public static final int NW = 7;
    public static final HashMap<Integer, Integer[]> delta = new HashMap<>();

    /**
     * Конструктор "компаса", который определяет приращение координат {x, y}
     * в зависимости от направления
     */
    public Compass() {       
        delta.put(N, new Integer[]{0, -1});
        delta.put(E, new Integer[]{1, 0});
        delta.put(S, new Integer[]{0, 1});
        delta.put(W, new Integer[]{-1, 0});
        delta.put(NE, new Integer[]{1, -1});
        delta.put(SE, new Integer[]{1, 1});
        delta.put(SW, new Integer[]{-1, 1});
        delta.put(NW, new Integer[]{-1, -1});
    }

    public int opposite(int direction) {
        switch (direction) {
            case N:
                return S;
            case S:
                return N;
            case W:
                return E;
            case E:
                return W;
            case NE:
                return SW;
            case SE:
                return NW;
            case SW:
                return NE;
            case NW:
                return SE;
                
            default:
                return 1000;
        }
    }

}
