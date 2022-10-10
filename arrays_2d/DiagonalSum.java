// https://leetcode.com/problems/matrix-diagonal-sum/

public class DiagonalSum {
  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 }
    };
    int[][] matrix2 = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };
    System.out.println(diagonalSum(matrix));
    System.out.println(diagonalSum2(matrix));
    System.out.println(diagonalSum(matrix2));
    System.out.println(diagonalSum2(matrix2));
  }

  private static int diagonalSum(int[][] matrix) {
    // matrix always be nxn row==col
    int row = 0;
    int col = 0;
    int sum = 0;
    // primary diagonal
    // we can also take col<=matrix[0].length-1;
    while (row <= matrix.length - 1) {
      sum += matrix[row][col];
      row++;
      col++;
    }
    // secondary diagonal
    row = 0;
    col = matrix[0].length - 1;
    while (col >= 0) {
      if (row == col) {
        // when "n" is odd number don't include the single element (center element) that
        // has already being summed
        row++;
        col--;
        continue;
      }
      sum += matrix[row][col];
      row++;
      col--;
    }
    return sum;
  }

  private static int diagonalSum2(int[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      // primary diagonal
      sum += matrix[i][i];
      // secondary diagonal
      // i+j = matrix[length]-1 => j = matrix[length]-1-i
      int j = matrix.length - 1 - i;
      if (j != i) {
        // if j==i it is in the primary diagonal
        sum += matrix[i][j];
      }
    }
    return sum;
  }
}
