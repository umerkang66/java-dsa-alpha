package recursion.divide_and_conquer;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] nums = { 8, 2, 9, 5, 12, 13, 7, 3, 1 };
    sort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }

  // divide the array into subArrays, that the subArray has only one element,
  // left. Now if there is only one element, it is already sorted, then merge
  // them.
  public static void sort(int[] nums, int start, int end) {
    if (start >= end) {
      // if there is only one element in the array, don't do anything, just return to
      // the previous state, i.e. array has two elements
      return;
    }
    int mid = start + (end - start) / 2;
    sort(nums, start, mid);
    sort(nums, mid + 1, end);
    // here array should have two elements, mid would be the first element, here
    // their are 2 subArrays, from start to mid (mid element in the last subArray),
    // and from mid + 1 to end (end element in the last subArray)
    merge(nums, start, mid, end);
  }

  public static void merge(int[] nums, int start, int mid, int end) {
    int[] ans = new int[end - start + 1];
    // left side should start from start
    int i = start;
    // right side should start from mid + 1, because mid is included in left side
    int j = mid + 1;
    // iterator for answer array
    int k = 0;
    // if there are elements both in left side, and right side, compare them, then
    // add the lowest one
    while (i <= mid && j <= end) {
      if (nums[i] <= nums[j]) {
        ans[k] = nums[i];
        i++;
      } else {
        ans[k] = nums[j];
        j++;
      }
      k++;
    }
    // when these two array should have arrived in merge function, individually
    // these should be sorted
    // at this point, one of the array should be completed (adding in answer array),
    // but the other should not
    while (i <= mid) {
      // if some elements of this current subArray are not added, and this subArray
      // exists, means i should be less than or equal to mid, if it is greater than
      // mid, don't add, this subArray doesn't exist
      ans[k] = nums[i];
      i++;
      k++;
    }
    while (j <= end) {
      // if some elements of this current subArray are not added, and this subArray
      // exists, means j should start from mid + 1, it should be less than or equal to
      // end, if it is greater than end, don't add, this subArray doesn't exist
      ans[k] = nums[j];
      j++;
      k++;
    }
    for (int l = 0; l < ans.length; l++) {
      nums[l + start] = ans[l];
    }
  }
}
