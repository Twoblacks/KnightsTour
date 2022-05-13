// Tile class primarily for holding row/column position,
// and number representing either an empty space or its incremented nubmer on the board.
public class Tile {
    private int row;
    private int collumn;
    private int taken;

    // Tile constructors
    public Tile(int row, int collumn, int taken){
        this.row = row;
        this.collumn = collumn;
        this.taken = taken;
    }
    public Tile(){
    }

    // Data getters
    public int getRow(){
        return row;
    }
    public int getCollumn() {
        return collumn;
    }
    public int getTaken() { return taken; }

    // Number setter
    public void setTaken(int num) { taken = num; }

    // Two toStrings one for debugging, one for solution
    //public String toString() {return "(" + row + " " + collumn+ ")";}
    public String toString() {return "" + taken;}
}
