import java.util.ArrayList;

public class queens {

    public static int[] row = new int[8];

    /**
    * Метод очищает доску
    *(заполняет ее нолями)
    * @param b - шахматная доска (ArrayList<int[]>)
    */  
    public static void clearBoard(ArrayList<int[]> b) {
        for(int i = 0; i <8 ; i++){
            row = new int[8];
            b.add(row);
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
    }
    /**
    * Метод проверяет свободные ячейки в указанной линии на доске
    * @param b - шахматная доска (ArrayList<int[]>)
    * @param lineNum - номер проверяемой линн шахматной доски (int)    
    * @return - индекс первой свободной ячейки или -1 если все заняты (int)
    */
    public static int checkNextLine(ArrayList<int[]> b, int lineNum) {
        row = b.get(lineNum);
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
    


    public static void main(String[] args) {
        ArrayList<int[]> board = new ArrayList<>();

        clearBoard(board);     
     
        fillWarCell(board, 0, 7);
        fillWarCell(board, 3, 6);
        fillWarCell(board, 5, 4);
        fillWarCell(board, 0, 2);
        showBoard(board);

        for (int i = 0; i < 8; i++) {
            System.out.println(checkNextLine(board, i));
        }



    }
}
