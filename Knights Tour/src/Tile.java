public class Tile {
    private int row;
    private int collumn;
    private int taken;

    public Tile(int row, int collumn, int taken){
        this.row = row;
        this.collumn = collumn;
        this.taken = taken;
    }
    public Tile(){
    }

    public int getRow(){
        return row;
    }

    public int getCollumn() {
        return collumn;
    }

    public int getTaken() { return taken; }
    public void setTaken(int num) { taken = num; }
    //public String toString() {return "(" + row + " " + collumn+ ")";}
    public String toString() {return "" + taken;}

    public boolean equalTo(Tile til){
        return(row == til.getRow() && collumn == til.getCollumn());
    }
}
