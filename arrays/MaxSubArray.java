package arrays;

public class MaxSubArray {
  public static void main(String[] args) {
    int[] nums = { 1, -2, 6, -1, 3 };
    System.out.println(maxSubArrayBF(nums));
  }

  private static int maxSubArrayBF(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int start = i;
      for (int j = i; j < nums.length; j++) {
        int end = j;
        int currentSum = 0;
        for (int k = start; k <= end; k++) {
          currentSum += nums[k];
        }
        maxSum = Math.max(maxSum, currentSum);
      }
    }
    return maxSum;
  }
}
