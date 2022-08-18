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
    int[] nums4 = { 1, 4, 1, 3, 2, 4, 3, 7 };
    countingSort(nums4);
    System.out.println(Arrays.toString(nums4));
    int[] nums5 = { 1, 4, 1, 3, 2, 4, 3, 7 };
    countingSortDescending(nums5);
    System.out.println(Arrays.toString(nums5));
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
          // already sorted, so break the inner loop, because outer loop
          // has already gone through previous elements
          break;
        }
      }
    }
  }

  private static void countingSort(int[] nums) {
    // create a countArr with the length of largest element in nums + 1, with index
    // as number and its frequency as value
    int maxNum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxNum = Math.max(maxNum, nums[i]);
    }

    // we have to store till largest index, that is length - 1, so increase the
    // length by 1
    int[] countArr = new int[maxNum + 1];
    for (int i = 0; i < nums.length; i++) {
      // count array is created with every element in nums array as index, and
      // frequency as its value
      countArr[nums[i]]++;
    }

    int originalArrCounter = 0;
    for (int i = 0; i < countArr.length; i++) {
      while (countArr[i] > 0) {
        nums[originalArrCounter] = i;
        originalArrCounter++;
        countArr[i]--;
      }
    }
  }

  private static void countingSortDescending(int[] nums) {
    int largest = nums[0];
    for (int i = 1; i < nums.length; i++) {
      largest = Math.max(largest, nums[i]);
    }

    int[] count = new int[largest + 1];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    int originalArrCounter = 0;
    for (int i = count.length - 1; i > 0; i--) {
      while (count[i] > 0) {
        nums[originalArrCounter] = i;
        originalArrCounter++;
        count[i]--;
      }
    }
  }

  private static void swap(int[] nums, int firstIndex, int secondIndex) {
    int temp = nums[firstIndex];
    nums[firstIndex] = nums[secondIndex];
    nums[secondIndex] = temp;
  }
}
