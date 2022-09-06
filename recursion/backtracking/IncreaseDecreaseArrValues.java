package recursion.backtracking;

public class IncreaseDecreaseArrValues {
  public static void main(String[] args) {
    int[] nums = new int[5];
    increaseDecreaseArrValues(nums, 0);
    printArr(nums);
  }

  private static void printArr(int[] arr) {
    StringBuilder ans = new StringBuilder("[");
    for (int i = 0; i < arr.length; i++) {
      ans.append(arr[i]);
      if (i < arr.length - 1) {
        ans.append(", ");
      }
    }
    ans.append("]");
    System.out.println(ans);
  }

  private static void increaseDecreaseArrValues(int[] nums, int index) {
    if (index == nums.length) {
      printArr(nums);
      return;
    }
    // set the values to index + 1
    nums[index] = index + 1;
    increaseDecreaseArrValues(nums, index + 1);
    // decrease the every value by 2
    nums[index] = nums[index] - 2;
  }
}
