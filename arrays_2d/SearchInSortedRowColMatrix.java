// https://leetcode.com/problems/search-a-2d-matrix-ii

// USING BINARY SEARCH
// O(n+m), if m>>n then O(m), if n>>m then O(n)
public class SearchInSortedRowColMatrix {
  public static void main(String[] args) {
    int[][] matrix = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 }
    };
    System.out.println(searchInSortedMatrixWithTopRightKey(matrix, 39));
    System.out.println(searchInSortedMatrixWithBottomLeftKey(matrix, 39));
  }

  // rows are sorted in ascending order, and columns are also sorted in ascending
  // order, first item of row might not be smaller than last item of previous row
  private static boolean searchInSortedMatrixWithTopRightKey(int[][] matrix, int target) {
    // take an element where only two ways are possible, downward, or before, it can
    // be top-right or bottom-left, we are choosing top-right
    int row = 0;
    int col = matrix[0].length - 1;

    // if one of the row, or col reach the end, stop the loop
    while (row <= matrix.length - 1 && col >= 0) {
      if (target < matrix[row][col]) {
        // move left
        col--;
      } else if (target > matrix[row][col]) {
        // move downward
        row++;
      } else {
        return true;
      }
    }

    return false;
  }

  private static boolean searchInSortedMatrixWithBottomLeftKey(int[][] matrix, int target) {
    int row = matrix.length - 1;
    int col = 0;
    while (row >= 0 && col <= matrix[0].length) {
      if (target < matrix[row][col]) {
        row--;
      } else if (target > matrix[row][col]) {
        col++;
      } else {
        return true;
      }
    }
    return false;
  }
}
