import java.util.*;
public class Main {
    public static ArrayList<Tile> search(Tile pos, Tile[][] board) {
        ArrayList<Tile> moves = new ArrayList<>();
        int count = 0;
        int[] row = { 2, 2, 1, -1, -2, -2, 1, -1};
        int[] col = {-1, 1, 2,  2, -1,  1,-2, -2};
        for(int i = 0; i<8; i++) {
            try {
                if (board[pos.getRow() + row[i]][pos.getCollumn() + col[i]].getTaken() == -1)
                {moves.add(board[pos.getRow() + row[i]][pos.getCollumn() + col[i]]);}
            }
            catch(ArrayIndexOutOfBoundsException e) {}
        }

        return moves;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Row: ");
        int rowP = s.nextInt();
        System.out.println("Col: ");
        int colP = s.nextInt();

        Tile start = new Tile(rowP, colP, 0);
        Tile[][] board = new Tile[8][8];
        for(int row = 0; row<8; row++){
            for(int col = 0; col<8; col++){
                board[row][col] = new Tile(row, col, -1);
            }
        }

        System.out.println(search(start, board));


    }
}
