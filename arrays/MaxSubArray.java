package arrays;

public class MaxSubArray {
  public static void main(String[] args) {
    int[] nums = { 1, -2, 6, -1, 3 };

    System.out.println(maxSubArrayBF(nums));
    System.out.println(maxSubArrayPrefixArray(nums));
    System.out.println(kadane(nums));
    System.out.println(kadane2(nums));
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

  private static int kadane(int[] nums) {
    // if the currentSum is negative, consider it as zero
    // because if integers that are greater than 0 are present in array
    // then only that integers in array will return the highest sum
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (currentSum < 0) {
        // if previous current sum is negative, don't join the previous value, but start
        // a new one from 0, then add itself
        currentSum = 0;
      }
      currentSum += nums[i];
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }

  private static int kadane2(int[] nums) {
    // current element should join the previous currentSum, if it is contributing to
    // the total sum (currentSum + ith element is greater than ith element:
    // currentSum is non-negative), it will add itself in the previous currentSum,
    // otherwise (currentSum is negative), it will start the new currentSum with
    // itself or 0 (if zero then add latter)
    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (currentSum + nums[i] >= 0) {
        // it is better for me to join the previous current sum
        // because i will be contributing in the total sum
        currentSum += nums[i];
      } else {
        // if i join the previous currentSum, that value would be even lower than
        // myself, so i would start the new currentSum combination
        currentSum = nums[i];
      }

      // compare for maxSum
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }

    return maxSum;
  }
}
