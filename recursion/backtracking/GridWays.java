package recursion.backtracking;

public class GridWays {
  public static void main(String[] args) {
    int rows = 3;
    int cols = 3;

    int count = gridWays(0, 0, rows, cols);
    System.out.println(count);
  }

  private static int gridWays(int i, int j, int rows, int cols) {
    if (i == rows - 1 && j == cols - 1) {
      return 1;
    }
    if (i == rows || j == cols) {
      // if row is at the end, but col is not at the end, and if col is at the end,
      // but row is not at the end, just return 0, because this is not the bottom last
      // element
      return 0;
    }
    // moveDown, row should increase, but column should remain the same.
    int moveDown = gridWays(i + 1, j, rows, cols);
    // moveRight, column should increase, but row should remain the same.
    int moveRight = gridWays(i, j + 1, rows, cols);
    return moveDown + moveRight;
  }
}
