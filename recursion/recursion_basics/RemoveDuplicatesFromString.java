package recursion.recursion_basics;

import java.util.HashSet;

public class RemoveDuplicatesFromString {
  public static void main(String[] args) {
    String str = "appnnacollege";
    System.out.println(removeDuplicatesFromString(str, "", 0, new HashSet<Character>()));
    System.out.println(removeDuplicatesFromString2(str, "", 0, new HashSet<Character>()));
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

  private static String removeDuplicatesFromString2(String str, String ans, int index, HashSet<Character> seen) {
    if (index == str.length()) {
      // If index has pass the last character, return the ans
      return ans;
    }
    if (!seen.contains(str.charAt(index))) {
      seen.add(str.charAt(index));
      // If it is not seen, append the character to the ans, and pass that
      return removeDuplicatesFromString2(str, ans + str.charAt(index), index + 1, seen);
    }
    // If it is seen, just add the same answer to the next call
    return removeDuplicatesFromString(str, ans, index + 1, seen);
  }
}
