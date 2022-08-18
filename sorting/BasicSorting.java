package sorting;

import java.util.Arrays;

public class BasicSorting {
  public static void main(String[] args) {
    int[] nums = { 5, 3, 9, 12, 8, 1 };
    bubbleSort(nums);
    System.out.println(Arrays.toString(nums));

    int[] nums2 = { 5, 3, 9, 12, 8, 1 };
    selectionSort(nums2);
    System.out.println(Arrays.toString(nums2));

    int[] nums3 = { 5, 3, 9, 12, 8, 1 };
    insertionSort(nums3);
    System.out.println(Arrays.toString(nums3));
  }

  private static void bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      int swaps = 0;
      // at every index the largest element comes at the very end of index, so we
      // don't have to compare the last element at each index i.e. -i
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
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

  private static void selectionSort(int[] nums) {
    // get the min value at each inner iteration, and put it on the start
    for (int i = 0; i < nums.length - 1; i++) {
      // don't check the last element, because at the last outer iteration, last
      // element would have been at the correct position
      // take current element as the i, and start the inner loop as the i+1
      int minNumIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        // inner loop should always go to the end, because minimum element might be at
        // the end at every iteration
        if (nums[j] < nums[minNumIndex]) {
          minNumIndex = j;
        }
      }
      swap(nums, i, minNumIndex);
    }
  }

  // 4,3,2,1
  private static void insertionSort(int[] nums) {
    // pick an element from unsorted part, and place it at the right position.
    // don't go till last element because, j is "i+1"
    for (int i = 0; i < nums.length - 1; i++) {
      // at every index, check if next element to ith element is greater or less than
      // ith element, it it is greater swap them
      for (int j = i + 1; j > 0; j--) {
        // "j" should not go to 0, because we are checking "j-1"
        if (nums[j] < nums[j - 1]) {
          swap(nums, j, j - 1);
        } else {
          // if "j" is not smaller than "j-1" it means previous to the "j" elements are
          // already sorted, so break the inner loop
          break;
        }
      }
    }
  }

  private static void swap(int[] nums, int firstIndex, int secondIndex) {
    int temp = nums[firstIndex];
    nums[firstIndex] = nums[secondIndex];
    nums[secondIndex] = temp;
  }
}
