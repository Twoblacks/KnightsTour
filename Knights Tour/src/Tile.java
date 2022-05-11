public class Tile {
    private int row;
    private int collumn;
    private boolean taken;

    public Tile(int row, int collumn, boolean taken){
        this.row = row;
        this.collumn = collumn;
        this.taken = taken;
    }

    public int getRow(){
        return row;
    }

    public int getCollumn() {
        return collumn;
    }
}
