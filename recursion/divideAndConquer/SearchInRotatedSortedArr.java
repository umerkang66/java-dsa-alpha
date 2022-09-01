// see this question notes in SearchInRotatedArr.java in arrays section
public class SearchInRotatedSortedArr {
  public static void main(String[] args) {
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    System.out.println(searchInRotatedSortedArr(nums, 1));
  }

  private static int searchInRotatedSortedArr(int[] nums, int target) {
    int pivot = findPivot(nums, 0, nums.length - 1);
    // apply binary search on the both side of pivot
    int answer = binarySearch(nums, 0, pivot, target);
    if (answer == -1) {
      answer = binarySearch(nums, pivot + 1, nums.length - 1, target);
    }
    return answer;
  }

  // pivot would be the largest element in the array
  private static int findPivot(int[] nums, int start, int end) {
    if (start > end) {
      return -1;
    }

    int mid = start + (end - start) / 2;
    if (mid < end && nums[mid] > nums[mid + 1]) {
      return mid;
    }
    if (mid > start && nums[mid] < nums[mid - 1]) {
      return mid - 1;
    }

    if (nums[start] > nums[mid]) {
      return findPivot(nums, start, mid - 1);
    } else {
      return findPivot(nums, mid + 1, end);
    }
  }

  private static int binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if (target < nums[mid]) {
      return binarySearch(nums, start, mid - 1, target);
    } else if (target > nums[mid]) {
      return binarySearch(nums, mid + 1, end, target);
    } else {
      return mid;
    }
  }
}
