import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.Highlighter.Highlight;


/**
 * Лабиринт
 */
public class Maze {
    private int height;
    private int width;
    // private String brick = "\u25A6\u25A6\u25A6";
    public String brick = "%%%";
    public int[][] platform;

    /**
     * Конструктор пустого лабиринта
     * @param x - ширина лабиринта
     * @param y - высота лабиринта
     */
    public Maze(int x, int y) {
        this.width = x;
        this.height = y;
        platform = new int[height][width];
        for (int i = 0; i < this.height; i++) {
            platform[i][0] = -1;
            platform[i][width - 1] = -1;
        }
        for (int i = 1; i < this.width - 1; i++) {
            platform[0][i] = -1;
            platform[this.height - 1][i] = -1;
        }
    }

    /**
     * Метод выводит лабиринт на экран
     */
    public void print() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (platform[i][j] == -1) {
                    System.out.printf("%s",this.brick);
                } else {
                    System.out.printf(" %-2d",platform[i][j]);    
                }
                
            }
            System.out.println();
        }       
    }

    /**
     * Метод маркирует ячейку
     * @param cell - ячейка
     */
    public void markCell(Cell cell) {
        platform[cell.y][cell.x] = cell.value;        
    }

    public int howAround(int x, int y, int value) {
        int result = 0;
        int newX, newY;
        for (int i = 0; i < 8; i++) {
            newX = x + Compass.delta.get(i)[0];
            newY = y + Compass.delta.get(i)[1]; 
            if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
                continue;
            }            
            if (platform[newY][newX] == value) {
                result++;
            }
        }
        return result;
    }

    public boolean onBorder(Cell cell) {
        if (cell.x == 0 || cell.x == width - 1 || cell.y == 0 || cell.y == height - 1) {
            return true;
        } 
        return false;
    }

    public boolean nearBorder(Cell cell) {
        int newX;
        int newY;
        for (int i = 0; i < 4; i++) {
            newX = cell.x + Compass.delta.get(i)[0];
            newY = cell.y + Compass.delta.get(i)[1]; 
            if (newX == 0 || newX == width - 1|| newY == 0 || newY == height - 1) {
                return true;
            }         
        }
        return false;
    }


    /**
     * Метод "строит стену"
     * @param currentCell - начальная точка
     * @param wallLength - длина стены
     */
    public void buildWall(Cell currentCell, int wallLength) {
        Random rnd = new Random();
        Compass compass = new Compass();
        int previousDirection = 99;
        int direction;
        ArrayList<Integer> blockedDirections = new ArrayList<>();
        Cell nextCell;
        Cell previousCell;
        int counter = 1;
        int bricks;
        bricks = howAround(currentCell.x, currentCell.y, -1);
        if (nearBorder(currentCell))  {
            System.out.println("У границы");
            if (bricks != 3) {
                System.out.println("Первая точка у глухого края");
                return;
            }
        } else {
            System.out.println("Не у границы");
            if (bricks != 0) {
                System.out.println("Первая точка у стены");
                return;
            }
        }
        markCell(currentCell);  // доделать контроль


        while (counter < wallLength) {
            if (blockedDirections.size() == 4) {
                System.out.println("Идти некуда");
                break;
            }
            nextCell = new Cell();
            direction = rnd.nextInt(4);

            if (blockedDirections.contains(direction)) {  // туда нельзя
                direction = previousDirection;
                continue;
            }
            // direction = 2;
            nextCell.x = currentCell.x + Compass.delta.get(direction)[0];
            nextCell.y = currentCell.y + Compass.delta.get(direction)[1]; 
            if (nextCell.x < 0 || nextCell.x >= width || nextCell.y < 0 || nextCell.y >= height || platform[nextCell.y][nextCell.x] == -1) {
                blockedDirections.add(direction);
                direction = previousDirection;
                System.out.println("За край или на край");
                continue;
            }
            nextCell.value = -1;
            bricks = howAround(nextCell.x, nextCell.y, -1);
            if (onBorder(currentCell) && bricks != 3) {
                blockedDirections.add(direction);
                direction = previousDirection;
                System.out.println("От стены не туда пошел");
                continue;
            } 
            
            if (previousDirection == direction && bricks != 1) {
                blockedDirections.add(direction);
                direction = previousDirection;
                continue;
            }

            if (previousDirection != direction && (bricks != 2 && bricks != 1)) {
                blockedDirections.add(direction);
                direction = previousDirection;
                continue;
            }            

            markCell(nextCell);
            counter++;
            currentCell = nextCell;
            previousDirection = direction;

            blockedDirections = new ArrayList<>();
            blockedDirections.add(compass.opposite(previousDirection));  // откуда пришли - туда нельзя...
            
        }


    }
    

}
