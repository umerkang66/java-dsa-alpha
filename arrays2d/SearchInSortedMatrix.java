// https://leetcode.com/problems/search-a-2d-matrix
package arrays2d;

public class SearchInSortedMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 3, 5, 7 },
        { 10, 11, 16, 20 },
        { 23, 30, 34, 60 }
    };
    System.out.println(binarySearchInSortedMatrix(matrix, 30));

    int[][] matrix2 = {
        { 1 }
    };
    System.out.println(binarySearchInSortedMatrix(matrix2, 1));
  }

  public static boolean binarySearchInSortedMatrix(int[][] matrix, int target) {
    // first find the correct row by binary search, which includes the target, then
    // apply binary search on that row
    int correctRow = binarySearchRow(matrix, target);
    if (correctRow == -1) {
      return false;
    }

    // if correctRow is found, apply binary search between columns of that row
    return binarySearchColumn(matrix, correctRow, target);
  }

  private static int binarySearchRow(int[][] matrix, int target) {
    int rowStart = 0;
    int rowEnd = matrix.length - 1;

    int correctRow = -1;
    while (rowStart <= rowEnd) {
      int rowMid = rowStart + (rowEnd - rowStart) / 2;
      if (target >= matrix[rowMid][0] && target <= matrix[rowMid][matrix[0].length - 1]) {
        correctRow = rowMid;
        break;
      } else if (target > matrix[rowMid][matrix[0].length - 1]) {
        rowStart = rowMid + 1;
      } else {
        // if (target < matrix[rowMid][0])
        rowEnd = rowMid - 1;
      }
    }

    return correctRow;
  }

  private static boolean binarySearchColumn(int[][] matrix, int correctRow, int target) {
    int colStart = 0;
    int colEnd = matrix[0].length - 1;

    while (colStart <= colEnd) {
      int colMid = colStart + (colEnd - colStart) / 2;
      if (target < matrix[correctRow][colMid]) {
        colEnd = colMid - 1;
      } else if (target > matrix[correctRow][colMid]) {
        colStart = colMid + 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
