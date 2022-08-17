// https://leetcode.com/problems/trapping-rain-water/
package arrays;

public class TrappingRainWater {
  public static void main(String[] args) {
    int[] nums = { 4, 2, 0, 6, 3, 2, 5 };

    System.out.println(trappingRainWater(nums));
  }

  private static int trappingRainWater(int[] nums) {
    int[] leftMax = new int[nums.length];
    int[] rightMax = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        leftMax[i] = nums[i];
      } else {
        leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
      }
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i == nums.length - 1) {
        rightMax[i] = nums[i];
      } else {
        rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
      }
    }

    int maxWater = 0;
    int WIDTH = 1;
    for (int i = 0; i < nums.length; i++) {
      // maximum holding value of water (which would the minimum value of the left max
      // and right max of current index)
      int maxWaterHeightForCurrentIndex = Math.min(leftMax[i], rightMax[i]);
      // we don't need to check for negative values, because leftMax, and rightMax
      // will be itself at first and last index, and higher values of itself values if
      // index is not 0 or lastIndex
      maxWater += maxWaterHeightForCurrentIndex - nums[i] * WIDTH;
    }
    return maxWater;
  }
}
