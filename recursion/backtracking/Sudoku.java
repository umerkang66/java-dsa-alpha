package recursion.backtracking;

public class Sudoku {
  public static void main(String[] args) {
    int[][] sudokuBoard = {
        { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
    };

    boolean ans = sudoku(sudokuBoard, 0, 0);
    System.out.println(ans);
    printMatrix(sudokuBoard);
  }

  private static boolean sudoku(int[][] sudokuBoard, int row, int col) {
    if (row == sudokuBoard.length && col == 0) {
      // when row is increased, col is reset
      // this will happen after all the cols have been placed
      // return true
      return true;
    }

    int nextRow = row, nextCol = col + 1;
    if (col == sudokuBoard[0].length - 1) {
      nextRow = row + 1;
      nextCol = 0;
    }

    if (sudokuBoard[row][col] != 0) {
      // if already a number is placed, from default, just move to the next row or col
      return sudoku(sudokuBoard, nextRow, nextCol);
    }

    for (int num = 1; num <= 9; num++) {
      if (isSafe(sudokuBoard, row, col, num)) {
        sudokuBoard[row][col] = num;
        if (sudoku(sudokuBoard, nextRow, nextCol)) {
          return true;
        }
        sudokuBoard[row][col] = 0;
      }
    }

    return false;
  }

  private static boolean isSafe(int[][] sudokuBoard, int row, int col, int currentNum) {
    // current num should not be present in current col
    for (int i = 0; i < sudokuBoard.length; i++) {
      // here row will start from 0, to end, but the column will remain the same
      if (sudokuBoard[i][col] == currentNum) {
        return false;
      }
    }

    // current num should not be present in the current row
    for (int j = 0; j < sudokuBoard[0].length; j++) {
      if (sudokuBoard[row][j] == currentNum) {
        return false;
      }
    }

    // current num should not be present in the current subBoard of 3x3
    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;

    for (int i = startRow; i <= startRow + 2; i++) {
      for (int j = startCol; j <= startCol + 2; j++) {
        if (sudokuBoard[i][j] == currentNum) {
          return false;
        }
      }
    }

    return true;
  }

  private static void printMatrix(int[][] mat) {
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
