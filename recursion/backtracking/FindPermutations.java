package recursion.backtracking;

public class FindPermutations {
  public static void main(String[] args) {
    String str = "abc";
    findPermutations(str, "");
  }

  private static void findPermutations(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
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
}
