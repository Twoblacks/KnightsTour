import java.util.*;
public class Main {
    public static Tile search(Tile pos, Tile[][] board) {
        Tile temp = new Tile();
        int count = 0;
        int low = 8;
        int[] row = { 2, 2, 1, -1, -2, -2, 1, -1};
        int[] col = {-1, 1, 2,  2, -1,  1,-2, -2};
        for(int i = 0; i<8; i++) {
            try {
                if (board[pos.getRow() + row[i]][pos.getCollumn() + col[i]].getTaken() == -1) {
                    try {
                        if (board[pos.getRow() + row[i] + row[i]][pos.getCollumn() + col[i] + col[i]].getTaken() == -1) {
                            count++;
                            if(count < low){
                                low = count;
                                temp  = new Tile(pos.getRow() + row[i], pos.getCollumn() + col[i], -1);
                            }
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {}
                }
            }
            catch(ArrayIndexOutOfBoundsException e) {}
        }

        return temp;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Row: ");
        int rowP = s.nextInt();
        System.out.println("Col: ");
        int colP = s.nextInt();

        Tile[][] board = new Tile[8][8];
        for(int row = 0; row<8; row++){
            for(int col = 0; col<8; col++){
                board[row][col] = new Tile(row, col, -1);
            }
        }
        // Setting Start Position
        board[rowP][colP].setTaken(0);
        Tile l = new Tile(rowP, colP, -1);

        System.out.println();
        for(int i = 1; i < 16; i++){
            l = search(l, board);
            board[l.getRow()][l.getCollumn()].setTaken(i);
        }

        System.out.println(search(new Tile(6,3,-1),board));
        for(int r = 0; r < 8; r++){
            for(int c = 0; c < 8; c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
    }
}
