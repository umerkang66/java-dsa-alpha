// https://leetcode.com/problems/contains-duplicate/
package arrays;

import java.util.HashSet;

public class ContainsDuplicate {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 3 };

    System.out.println(containsDuplicate(nums));
    System.out.println(containsDuplicateHash(nums));
  }

  private static boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean containsDuplicateHash(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }
    return false;
  }
}
