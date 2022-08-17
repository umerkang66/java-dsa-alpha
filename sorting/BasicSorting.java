package sorting;

import java.util.Arrays;

public class BasicSorting {
  public static void main(String[] args) {
    int[] nums = { 5, 3, 9, 12, 8, 1 };
    bubbleSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  private static void bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      int swaps = 0;
      // at every index the largest element comes at the very end of index, so we
      // don't have to compare the last element at each index i.e. -i
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
          swaps++;
        }
      }
      if (swaps == 0) {
        // if after inner loop completion, didn't occur a single swap, means the array
        // is already sorted
        return;
      }
    }
  }
}
