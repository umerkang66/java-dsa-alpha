package recursion.backtracking;

public class NQueens {
  public static void main(String[] args) {
    int n = 4;
    char[][] board = new char[n][n];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        // dot is empty
        board[i][j] = 'x';
      }
    }
    nQueens(board, 0);
  }

  private static void nQueens(char board[][], int row) {
    if (row == board.length) {
      printMatrix(board);
      return;
    }
    for (int j = 0; j < board[0].length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        nQueens(board, row + 1);
        board[row][j] = 'x';
      }
    }
  }

  private static boolean isSafe(char[][] board, int row, int col) {
    // vertically
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }
    // diagonal left up
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    // diagonal right up
    for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  private static void printMatrix(char[][] mat) {
    System.out.println("--- chess board ---");

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        System.out.print(mat[i][j]);
        if (j < mat[0].length - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
