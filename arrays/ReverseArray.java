package arrays;

import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5 };
    reverseArray(nums);
    System.out.println(Arrays.toString(nums));

    reverseArray2(nums);
    System.out.println(Arrays.toString(nums));
  }

  private static void reverseArray(int[] nums) {
    for (int i = 0; i < nums.length / 2; i++) {
      int temp = nums[nums.length - 1 - i];
      nums[nums.length - 1 - i] = nums[i];
      nums[i] = temp;
    }
  }

  private static void reverseArray2(int[] nums) {
    int leftPointer = 0;
    int rightPointer = nums.length - 1;

    while (leftPointer < rightPointer) {
      // swap
      int temp = nums[rightPointer];
      nums[rightPointer] = nums[leftPointer];
      nums[leftPointer] = temp;
      // move the pointer in opposite direction
      leftPointer++;
      rightPointer--;
    }
  }
}
