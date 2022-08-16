package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArray {
  public static void main(String[] args) {
    int[] nums = { 2, 4, 6, 8, 10 };
    ArrayList<int[]> result = getSubArray(nums);

    for (int i = 0; i < result.size(); i++) {
      System.out.println(Arrays.toString(result.get(i)));
    }
  }

  private static ArrayList<int[]> getSubArray(int[] nums) {
    ArrayList<int[]> subArray = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int[] subArr = new int[j - i + 1];
        int index = 0;
        for (int k = i; k <= j; k++) {
          subArr[index] = nums[k];
          index++;
        }
        subArray.add(subArr);
      }
    }
    return subArray;
  }
}
