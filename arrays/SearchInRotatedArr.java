// https://leetcode.com/problems/search-in-rotated-sorted-array/
package arrays;

public class SearchInRotatedArr {
  public static void main(String[] args) {
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    System.out.println(searchInRotatedArr(nums, 0));
  }

  private static int searchInRotatedArr(int[] nums, int target) {
    int pivot = findPivot(nums);
    int searchedIndex = binarySearch(nums, target, 0, pivot);
    if (searchedIndex == -1) {
      searchedIndex = binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    return searchedIndex;
  }

  private static int findPivot(int[] nums) {
    // pivot is the largest element in array, normally it should be at the end of
    // array, but if it is in the middle it is pivot
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid < end && nums[mid] > nums[mid + 1]) {
        // if next element to mid is pivot
        // In an ascending rotated sorted array every element will be smaller
        // than the next element except the largest element in array
        return mid;
      }
      if (mid > start && nums[mid] < nums[mid - 1]) {
        // if previous element to mid is pivot
        // If the mid is smaller than the previous element then the previous
        // element is the largest element i.e. that is the pivot
        return mid - 1;
      }
      if (nums[start] > nums[mid]) {
        // if start is greater than mid, it means all the elements after mid should be
        // smaller than start (arrays already has been rotated before)
        end = mid - 1;
      } else {
        // if start is smaller than mid, it means this is regular sorted array, rotation
        // has to come after
        // we are using mid + 1, if the middle element was pivot, it should have been
        // already returned from upper cases
        start = mid + 1;
      }
    }
    return -1;
  }

  private static int binarySearch(int[] nums, int target, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target > nums[mid]) {
        start = mid + 1;
      } else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
