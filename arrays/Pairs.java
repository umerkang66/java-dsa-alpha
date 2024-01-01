package arrays;

import java.util.Arrays;

public class Pairs {
  public static void main(String[] args) {
    int[] nums = { 2, 4, 6, 8 };
    int[][] result = getPairs(nums);

    for (int i = 0; i < result.length; i++) {
      System.out.print(Arrays.toString(result[i]));
    }
    System.out.println();
  }

  private static int[][] getPairs(int[] nums) {
    int[][] pairs = new int[nums.length * (nums.length - 1) / 2][2];
    int counter = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        pairs[counter][0] = nums[i];
        pairs[counter][1] = nums[j];
        counter++;
      }
    }
    return pairs;
  }
}
