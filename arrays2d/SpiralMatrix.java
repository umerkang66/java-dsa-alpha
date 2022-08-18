package arrays2d;

import java.util.ArrayList;

public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }
    };
    int[][] matrix2 = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 }
    };

    ArrayList<Integer> result = spiralMatrix(matrix);
    System.out.println(result);
    ArrayList<Integer> result2 = spiralMatrix(matrix2);
    System.out.println(result2);
  }

  private static ArrayList<Integer> spiralMatrix(int[][] matrix) {
    int startRow = 0;
    int endRow = matrix.length - 1;
    int startCol = 0;
    int endCol = matrix[0].length - 1;

    ArrayList<Integer> result = new ArrayList<>();

    while (startRow <= endRow && startCol <= endCol) {
      // print the TOP boundary, where row is fixed (startRow), but columns will
      // increase, this is loop is for columns
      for (int j = startCol; j <= endCol; j++) {
        result.add(matrix[startRow][j]);
      }
      // print the RIGHT boundary, where column is fixed (endCol), but row will
      // increase, this loop is for increasing row
      for (int i = startRow + 1; i <= endRow; i++) {
        result.add(matrix[i][endCol]);
      }
      // print the BOTTOM boundary, where row is fixed (endRow) but col will decrease
      // this loop is for decreasing column
      for (int j = endCol - 1; j >= startCol; j--) {
        // in odd number of rows and columns
        if (startRow == endRow) {
          // if our cols are more, but row is one, break the loop,
          // otherwise it will be printed twice
          break;
        }
        result.add(matrix[endRow][j]);
      }
      // print the LEFT boundary, where col is fixed(startCol), but row will decrease
      // this loop is for decreasing row
      for (int i = endRow - 1; i >= startRow + 1; i--) {
        // in odd number of rows and columns
        if (startCol == endCol) {
          // if our rows are more, but column is one, break the loop
          // otherwise that element will be printed twice
          break;
        }
        result.add(matrix[i][startCol]);
      }

      // When the outer most boundary will be printed, decrease the row and columns
      // for inner boundaries
      startRow++;
      startCol++;
      endRow--;
      endCol--;
    }

    return result;
  }
}
