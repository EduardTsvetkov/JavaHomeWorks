public class Cell {
    public int x;
    public int y;
    public int value;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public Cell() {
        
    }



    @Override
    public String toString() {  
        return String.format("x = %d, y = %d, value = %d", this.x, this.y, this.value);
    }
}