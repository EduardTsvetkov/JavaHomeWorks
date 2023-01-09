import java.util.Random;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        int height = 15;
        int width = 20;
        Maze maze = new Maze(width, height);
        maze.print();

        Random rnd = new Random();
        int x, y, length;
        Cell beginCell;
        for (int i = 0; i < 20; i++) {
            x = rnd.nextInt(width - 1);
            y = rnd.nextInt(height - 1);
            length = rnd.nextInt(width);
            System.out.printf("x=%d y=%d l=%d\n", x, y, length);
            beginCell = new Cell(x, y, -1);
            maze.buildWall(beginCell, length);
        }

        maze.print();

    }
    
}