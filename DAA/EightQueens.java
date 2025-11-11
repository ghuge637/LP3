package DAA;
//6. Design 8-Queens matrix having first Queen placed. Use backtracking to place remaining Queens to generate the final 8-queen’s matrix.
import java.util.Scanner;

public class EightQueens {

    static final int N = 8;  // Size of the chessboard

    // Function to print the board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if a queen can be placed at board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this column on the left
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left
        for (i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve N-Queens problem
    static boolean solveNQueens(int[][] board, int col) {
        // Base case: all queens are placed
        if (col >= N)
            return true;

        // Try placing queen in each row of current column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                // Recur for the next column
                if (solveNQueens(board, col + 1))
                    return true;

                // Backtrack
                board[i][col] = 0;
            }
        }

        return false; // No valid position found in this column
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[N][N];

        System.out.print("Enter the row position (0-7) for the first queen in column 0: ");
        int firstRow = sc.nextInt();

        // Place the first queen
        board[firstRow][0] = 1;

        // Solve remaining queens
        if (!solveNQueens(board, 1)) {
            System.out.println("No solution exists.");
        } else {
            System.out.println("\nFinal 8-Queens Matrix:");
            printBoard(board);
        }
    }
}
