package recursion.backtracking;

import java.util.HashSet;

public class FindPermutations {
  public static void main(String[] args) {
    String str = "abc";
    findPermutations(str, "");

    System.out.println();

    String strDuplicate = "aba";
    findPermutationsDuplicate(strDuplicate, "");
  }

  private static void findPermutations(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
      // Technically we don't need to return it, because string is empty, so the next
      // for loop will not run
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char curChar = str.charAt(i);
      String strWithoutCurChar = str.substring(0, i) + str.substring(i + 1);

      // current characters has been removed from string, pass the string, and add the
      // current char to the ans
      findPermutations(strWithoutCurChar, ans + curChar);
    }
  }

  private static void findPermutationsDuplicate(String str, String ans) {
    // Here "str" is sorted

    if (str.length() == 0) {
      System.out.println(ans);
      // Technically we don't need to return it, because string is empty, so the next
      // for loop will not run
      return;
    }

    HashSet<Character> set = new HashSet<>();

    for (int i = 0; i < str.length(); i++) {
      char curChar = str.charAt(i);

      if (!set.contains(curChar)) {
        String temp = str.substring(0, i) + str.substring(i + 1);
        findPermutationsDuplicate(temp, ans + curChar);
      }

      set.add(curChar);
    }
  }
}
