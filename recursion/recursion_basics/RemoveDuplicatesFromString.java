package recursion.recursion_basics;

import java.util.HashSet;

public class RemoveDuplicatesFromString {
  public static void main(String[] args) {
    String str = "appnnacollege";
    System.out.println(removeDuplicatesFromString(str, "", 0, new HashSet<Character>()));
  }

  private static String removeDuplicatesFromString(String str, String ans, int index, HashSet<Character> seen) {
    if (index == str.length()) {
      return ans;
    }
    if (!seen.contains(str.charAt(index))) {
      ans += str.charAt(index);
      seen.add(str.charAt(index));
    }
    return removeDuplicatesFromString(str, ans, index + 1, seen);
  }
}
