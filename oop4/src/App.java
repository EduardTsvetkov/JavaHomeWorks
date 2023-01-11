

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        int height = 20;
        int width = 30;
        Maze maze = new Maze(width, height);
        
        int x, y, length;
        Cell beginCell;
        for (int i = 0; i < width * height / 2; i++) { 
            x = RandInt.randInt(1, width - 2);
            y = RandInt.randInt(1, height - 2);
            length = RandInt.randInt(10, 30);
            beginCell = new Cell(x, y, -1);
            maze.buildWall(beginCell, length);
        }

        // // тестовая стена
        // x = 2;
        // y = 18;
        // length = 30;
        // beginCell = new Cell(x, y, -1);
        // maze.buildWall(beginCell, length);
        // // ---    

        Wave wave = new Wave(maze);
        wave.initDoors();
        System.out.println("Исходный лабиринт:");
        maze.print();

        wave.makeWave();
        // System.out.println();  
        // System.out.println("Лабиринт после \"волны\":");
        // maze.print();
        System.out.println();  
        System.out.println("Координаты выходов и расстояния до них:");
        System.out.println(wave.exits);

        wave.pathFinding(); 
        System.out.println();  
        System.out.println("Лабиринт после \"волны\" с кратчайшим путём:");
        maze.print();
    }
    
}