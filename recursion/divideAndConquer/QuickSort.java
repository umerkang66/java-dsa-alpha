import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] nums = { 8, 2, 9, 5, 12, 13, 7, 3, 1 };
    sort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));

    int[] nums2 = { 8, 2, 9, 5, 12, 13, 7, 3 };
    sort(nums2, 0, nums2.length - 1);
    System.out.println(Arrays.toString(nums2));
  }

  private static void sort(int[] nums, int start, int end) {
    if (start >= end) {
      // if there is only element in the array, return it.
      // that one is already sorted.
      return;
    }
    // set the pivot to the last element, and set it to its current index,
    // and all the elements before it should be less than, and all the
    // elements after it should be greater than mid (not sorted at this point)
    int pivot = partition(nums, start, end);
    // now the pivot is at its correct position, apply the same procedure,
    // first on the left side of pivot,
    sort(nums, start, pivot - 1);
    // then on the right side of pivot
    sort(nums, pivot + 1, end);
  }

  private static int partition(int[] nums, int start, int end) {
    // take the pivot as the last element
    int pivot = end;
    // iterator will put the smaller elements (than pivot), to its left side
    int iterator = start;
    for (int i = start; i <= end; i++) {
      // "i" should go till end (pivot) element, because in the end,
      // pivot element should also be swapped, with next element, that is swapped
      // previously
      if (nums[i] <= nums[pivot]) {
        // only swap the current iterator element with the current "i"th element,
        // if ith element is smaller than the pivot element, then move the iterator to
        // one step further, so that next element should be checked with the next,
        // ith element.
        // If the ith element is greater than the pivot element, don't do anything,
        // don't even move the iterator.
        swap(nums, i, iterator);
        iterator++;
      }
    }
    // at last pivot element should be swapped with the iterator element, and
    // iterator, will be moved ahead by 1 (iterator++), so the pivot element is
    // iterator - 1
    return iterator - 1;
  }

  private static void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }
}
