package arrays;

public class MaxSubArray {
  public static void main(String[] args) {
    int[] nums = { 1, -2, 6, -1, 3 };

    System.out.println(maxSubArrayBF(nums));
    System.out.println(maxSubArrayPrefixArray(nums));
    System.out.println(subArrayKadaneAlgorithm(nums));
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

  private static int maxSubArrayPrefixArray(int[] nums) {
    int[] prefixArr = new int[nums.length];
    prefixArr[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixArr[i] = prefixArr[i - 1] + nums[i];
    }

    // at this point prefixArr is ready
    int maxSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int start = i;
      for (int j = i; j < nums.length; j++) {
        int end = j;
        if (i == 0) {
          // if start index 0, end index element should be the total sum
          // no need to subtract anything
          int subArraySum = prefixArr[end];
          maxSum = Math.max(maxSum, subArraySum);
        } else {
          // subtract the previous sum from current subArray sum
          int subArraySum = prefixArr[end] - prefixArr[start - 1];
          maxSum = Math.max(maxSum, subArraySum);
        }
      }
    }

    return maxSum;
  }

  private static int subArrayKadaneAlgorithm(int[] nums) {
    // if the currentSum is negative, consider it as zero
    // because if integers that are greater than 0 are present in array
    // then only that integers in array will return the highest sum
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      if (currentSum < 0) {
        currentSum = 0;
      }
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }
}
