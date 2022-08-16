package arrays;

public class BinarySearch {
  public static void main(String[] args) {
    int[] nums = { 4, 8, 12, 29, 33, 37, 50 };
    System.out.println(binarySearch(nums, 12));
  }

  private static int binarySearch(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
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
