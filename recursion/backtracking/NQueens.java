package recursion.backtracking;

public class NQueens {
  public static void main(String[] args) {
    int n = 8;
    char[][] board = new char[n][n];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        // dot is empty
        board[i][j] = 'x';
      }
    }
    nQueens(board, 0);
    System.out.println("\n");
    System.out.println(nQueensFirstSolution(board, 0));
  }

  private static void nQueens(char board[][], int row) {
    if (row == board.length) {
      printMatrix(board);
      return;
    }
    for (int j = 0; j < board[0].length; j++) {
      // only put the queen at the column and increase the row if it is SAFE,
      // otherwise, neither put the queen, nor increase the row, just increase the
      // column
      if (isSafe(board, row, j)) {
        // put the queen at the column, and increase the row
        board[row][j] = 'Q';
        nQueens(board, row + 1);
        // this is backtracking, it will only run after the base case of previous
        // recursive call, so here the in the previous recursive tree branch, solution
        // was not found, so remove the previous current queen from the board, then in
        // the next for loop iteration, queen will be added to to the next column
        board[row][j] = 'x';
      }
    }
  }

  private static boolean nQueensFirstSolution(char board[][], int row) {
    if (row == board.length) {
      printMatrix(board);
      return true;
    }
    for (int j = 0; j < board[0].length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        if (nQueensFirstSolution(board, row + 1) == true) {
          // if first solution is found, return true, to the end.
          return true;
        }
        // otherwise, remove the previous queens, while backtracking, because first base
        // case has been hit, and the solution is not found.
        board[row][j] = 'x';
      }
    }
    // solution is not found, it it has, previously true should be returned.
    return false;
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
