package recursion.backtracking;

public class StringSubset {
  public static void main(String[] args) {
    String str = "abc";
    findSubset(str, "", 0);
  }

  private static void findSubset(String str, String ans, int index) {
    if (index == str.length()) {
      if (ans.length() != 0) {
        System.out.println(ans);
      }
      return;
    }
    // if the current element should be added
    findSubset(str, ans + str.charAt(index), index + 1);
    // if the current element should not be added
    findSubset(str, ans, index + 1);
  }
}
