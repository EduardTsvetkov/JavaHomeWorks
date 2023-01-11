
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Wave {
    private Cell entrance;
    private Cell exit1;
    private Cell exit2;
    private Cell exit3;
    private Queue<Cell> forProcessing = new LinkedList<>(); 
    public ArrayList<Cell> exits = new ArrayList<>();
    
    Maze maze;

    public Wave(Maze maze) {
        this.maze = maze;
    }

    /**
     * Метод расставляет по четырем четвертям лабиринта вход и три выхода
     */
    public void initDoors() {
        int x, y;
        int halfHeight = maze.height / 2;
        int halfWidth = maze.width / 2;
        
        x = RandInt.randInt(1, halfWidth - 1);  // вход в верхней левой четверти
        y = RandInt.randInt(1, halfHeight - 1 );
        entrance = new Cell(x, y, 1); 
        maze.markCell(entrance);
        forProcessing.offer(entrance);

        // x = RandInt.randInt(halfWidth + 1, maze.width - 2);  // выход в верхней правой четверти
        // y = RandInt.randInt(1, halfHeight - 1);
        // exit1 = new Cell(x, y, -8); 
        // maze.markCell(exit1);

        // x = RandInt.randInt(1, halfWidth - 1);  // выход в нижней левой четверти
        // y = RandInt.randInt(halfHeight + 1, maze.height - 2);
        // exit2 = new Cell(x, y, -8); 
        // maze.markCell(exit2);

        x = RandInt.randInt(halfWidth + 1, maze.width - 2);  // выход в нижней правой четверти
        y = RandInt.randInt(halfHeight + 1, maze.height - 2);
        exit3 = new Cell(x, y, -8); 
        maze.markCell(exit3);


        System.out.printf("Вход  %s \n", entrance);
        System.out.printf("Выход %s \n",exit1);
        System.out.printf("Выход %s \n",exit2);
        System.out.printf("Выход %s \n",exit3);
    }


    /**
     * Метод запускает "волну"
     */
    public void makeWave() {
        Cell currentCell;
        int newX, newY;
        Cell cellForProcessing;

        while ((currentCell = forProcessing.poll()) != null) {
            for (int i = 0; i < 4; i++) {  // волна по 4 направлениям
                newX = currentCell.x + Compass.delta.get(i)[0];
                newY = currentCell.y + Compass.delta.get(i)[1]; 
                if (maze.platform[newY][newX] == 0 || maze.platform[newY][newX] == -8) {  // пусто или выход
                    cellForProcessing = new Cell(newX, newY, currentCell.value + 1);

                    if (maze.platform[newY][newX] == -8) {  // выход добавляем в список выходов
                        exits.add(cellForProcessing);
                    }

                    maze.platform[newY][newX] = currentCell.value + 1;
                    forProcessing.offer(cellForProcessing);
                }            
            }
        }
    }



    public void pathFinding() {
        Cell currentCell = new Cell();
        currentCell = exits.get(0);
        int newValue = currentCell.value;
        Cell nextCell = new Cell();
        int newX, newY;

        while (currentCell.value > 2) {

            for (int i = 3; i >= 0; i--) {  // проверка по 4 направлениям
                newX = currentCell.x + Compass.delta.get(i)[0];
                newY = currentCell.y + Compass.delta.get(i)[1]; 
                nextCell = new Cell(newX, newY, currentCell.value - 1);
                
                if (maze.platform[newY][newX] != -1 && maze.platform[newY][newX] == nextCell.value) {  // "ближайшая" ячейка
                    newValue = maze.platform[newY][newX] + 1000;  // добавляем 1000 для последующего выделения
                    maze.platform[newY][newX] = newValue;
                    currentCell = nextCell;
                }            
            }           
        }  
        for (Cell cell : exits) {
            newValue = maze.platform[cell.y][cell.x] + 1000;  // добавляем 1000 для последующего выделения
            maze.platform[cell.y][cell.x] = newValue;
        }  
    }
}
