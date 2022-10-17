package recursion.recursion_basics;
// https://www.geeksforgeeks.org/tiling-problem/

public class TilingProblem {
  public static void main(String[] args) {
    System.out.println(tilingProblem(1)); // 3
  }

  // height is always 2 => m = 2
  // width "n" can vary
  private static int tilingProblem(int n) {
    // box (where tiles are placed) height 2, and tile height is also 2.
    // tile width is always 1
    if (n <= 1) {
      // if all the tiles have been placed. If n has decreased from "n" to 1 (means
      // only one spot available, and in only 1 way a vertical tile can be placed),
      // "n" == 0 (means all the spots have been filled), in both cases
      // one way of putting tiles has been increased
      return 1;
    }
    // if tile is placed in vertical position, width of box should decrease by 1,
    // because the width is 1 of total n
    int vertical = tilingProblem(n - 1);
    // if 2 tiles are placed in horizontal position, width of should decrease by 2,
    // because the width is 2 of total n
    int horizontal = tilingProblem(n - 2);
    return vertical + horizontal;
  }
}
