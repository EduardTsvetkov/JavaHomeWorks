import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class queens {
    public static Set<ArrayList<int[]>> mySet = new HashSet<>();
    public static int[] row = new int[8];
    public static int count;

    /**
    * Метод очищает доску
    *(заполняет ее нолями)
    * @param b - шахматная доска (ArrayList<int[]>)
    */  
    public static void clearBoard(ArrayList<int[]> b) {
        if (b.size() == 0) {
            for(int i = 0; i < 8 ; i++){
                row = new int[8];
                b.add(row);
            }             
        } else {
            for(int i = 0; i < 8 ; i++){
                row = new int[8];
                b.set(i, row);
            } 
        }
    }

    /**
    * Метод показывает доску
    * @param b - шахматная доска (ArrayList<int[]>)
    */  
    public static void showBoard(ArrayList<int[]> b) {
        for (int i = 0; i < 8; i++) {
            row = b.get(i);
            for (int j = 0; j < 8; j++) {
                System.out.printf(" %d",row[j]);
            }
            System.out.println();
        }      
        System.out.println();  
    }

    /**
    * Метод проверяет свободные ячейки в указанной линии на доске
    * @param b - шахматная доска (ArrayList<int[]>)
    * @param lineNum - номер проверяемой линн шахматной доски (int)    
    * @return - индекс первой свободной ячейки или -1 если все заняты (int)
    */
    public static int checkNextLine(ArrayList<int[]> b, int num) {
        row = b.get(num);
        for (int i = 0; i < 8; i++) {
            if (row[i] == 0) {
                return i;
            }
        }
        return -1;       
    }

    /**
    * Метод заполняет единицами ячейки, попадающие под удар ферзя,
    * и отмечает место ферзя на доске девяткой
    * @param b - шахматная доска 8х8 (ArrayList<int[]>)
    * @param rowNum - номер линии шахматной доски (int)  
    * @param colNum - номер столбца шахматной доски (int)        
    * @return - индекс первой свободной ячейки или -1 если все заняты (int)
    */
    public static void fillWarCell(ArrayList<int[]> b, int rowNum, int colNum) {

        boolean diagonal, vertical, horizontal;        
        for (int i = 0; i < 8; i++) {  
            row = b.get(i);  // читаем очередные ячейки линии доски 
            for (int j = 0; j < 8; j++) {
                diagonal = (Math.abs(rowNum - i) == Math.abs(colNum - j)); // ячейка на диагонали
                horizontal = (rowNum == i);                                // ячейка на горизонтали
                vertical = (colNum == j);                                  // ячейка на вертикали
                if ((diagonal || vertical || horizontal) && (row[j] == 0)) {  // если там 0
                        row[j] = 1;                                           // то пишем 1
                }
                if (rowNum == i && colNum == j) {  // ставим ферзя
                    row[j] = 9;
                }
            }               
            b.set(i, row); //  меняем на измененную            
        }
    }
      
    /**
    * Метод возвращает копию списка
    * @param arr - исходный список - шахматная доска 8х8 (ArrayList<int[]>)
    * @return - копия исходного списка (ArrayList<int[]>)
    */
    public static ArrayList<int[]> arrayCopy(ArrayList<int[]> arr) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        int[] arrLine = new int[8];     
        
        for (int i = 0; i < arr.size(); i++) {
            int[] rezLine = new int[8];
            arrLine = arr.get(i);
            System.arraycopy (arrLine, 0, rezLine, 0, 8);
            result.add(rezLine);       
        }
        return result;  // можно переделать, чтоб возвращал true/false
    }

    /**
    * Метод заполняет (рекурсивно) шахматную доску небьющимися ферзями
    * @param mainBoard - шахматная доска lдля заполнения на текущем этапе (ArrayList<int[]>)
    * @param lineNum - номер линии доски для заполнения (int)
    */
    public static void fillQueens(ArrayList<int[]> mainBoard, int lineNum) {
        
        ArrayList<int[]> tempBoard = new ArrayList<int[]>();
        tempBoard = arrayCopy(mainBoard);  // копируем состояние доски на начало этапа
        int[] line = tempBoard.get(lineNum);                
        for (int j = 0; j < 8; j++) {                   
            if (line[j] == 0) {
                fillWarCell(mainBoard, lineNum, j);  // ставим ферзя и отмечаем занятые ячейки
                if (lineNum == 7) {  // дошли до последнего ряда, есть решение
                    count++;
                    System.out.printf("Решение № %d\n", count);
                    showBoard(mainBoard);
                    mySet.add(mainBoard);
                    mainBoard = arrayCopy(tempBoard);                     
                    continue;
                }     
                if (checkNextLine(tempBoard, lineNum + 1) == -1) {  // в следующем ряду нет свободных ячеек
                    mainBoard = arrayCopy(tempBoard);
                } else {
                    fillQueens(mainBoard, lineNum + 1);  // идем перебирать следующий ряд
                    mainBoard = arrayCopy(tempBoard);  // возвращаем доску в состояние начала этапа
                }                               
            }    
        }
        
    }


    public static void main(String[] args) {
        ArrayList<int[]> board = new ArrayList<>();
        count = 0;
        clearBoard(board);
        fillQueens(board, 0);
        System.out.printf("Всего %d уникальных решения\n", mySet.size());
    }
}
