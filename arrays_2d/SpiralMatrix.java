// https://leetcode.com/problems/spiral-matrix/

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
    int rowStart = 0;
    int rowEnd = matrix.length - 1;
    int colStart = 0;
    int colEnd = matrix[0].length - 1;
    ArrayList<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

    while (rowStart <= rowEnd && colStart <= colEnd) {
      // TOP: row is rowStart
      for (int j = colStart; j <= colEnd; j++) {
        result.add(matrix[rowStart][j]);
      }
      // RIGHT: col is colEnd
      for (int i = rowStart + 1; i <= rowEnd; i++) {
        result.add(matrix[i][colEnd]);
      }
      // BOTTOM: row is rowEnd
      for (int j = colEnd - 1; j >= colStart; j--) {
        if (rowStart == rowEnd) {
          break;
        }
        result.add(matrix[rowEnd][j]);
      }
      // LEFT: col is colStart
      for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
        if (colStart == colEnd) {
          break;
        }
        result.add(matrix[i][colStart]);
      }
      rowStart++;
      colStart++;
      rowEnd--;
      colEnd--;
    }

    return result;
  }
}
