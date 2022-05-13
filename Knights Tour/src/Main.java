import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static boolean ifLast(Tile[][] board){
        int n = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j<8; j++){
                if (board[i][j].getTaken() == -1)
                {
                    n++;
                }
            }
        }
        return (n==1);
    }

    public static Tile search(Tile pos, Tile[][] board) {
        Tile temp = new Tile();
        int count = 0;
        int low = 8;
        int[] row = { 2, 2, 1, -1, -2, -2, 1, -1};
        int[] col = {-1, 1, 2,  2, -1,  1,-2, -2};
        if(!(ifLast(board))) {
            for (int i = 0; i < 8; i++) {
                count = 0;
                try {
                    if (board[pos.getRow() + row[i]][pos.getCollumn() + col[i]].getTaken() == -1) {
                        for (int j = 0; j < 8; j++) {
                            try {
                                if (board[pos.getRow() + row[i] + row[j]][pos.getCollumn() + col[i] + col[j]].getTaken() == -1) {
                                    count++;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                if (count < low && count >= 1) {
                    low = count;
                    temp = new Tile(pos.getRow() + row[i], pos.getCollumn() + col[i], -1);
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                try {
                    if (board[pos.getRow() + row[i]][pos.getCollumn() + col[i]].getTaken() == -1) {
                        temp = new Tile(pos.getRow() + row[i], pos.getCollumn() + col[i], -1);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
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
        for(int i = 1; i <= 63; i++){
            l = search(l, board);
            board[l.getRow()][l.getCollumn()].setTaken(i);
        }

        for(int r = 0; r < 8; r++){
            for(int c = 0; c < 8; c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }

        // Testing Search
        //.out.println(search(l, board));
    }
}
