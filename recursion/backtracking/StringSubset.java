package recursion.backtracking;

public class StringSubset {
  public static void main(String[] args) {
    String str = "abc";
    findSubset(str, "", 0);
    findSubsets2(str, "");
  }

  private static void findSubset(String str, String ans, int index) {
    if (index == str.length()) {
      System.out.println(ans);
      return;
    }
    // if the current element should be added
    findSubset(str, ans + str.charAt(index), index + 1);
    // if the current element should not be added
    findSubset(str, ans, index + 1);
  }

  private static void findSubsets2(String str, String ans) {
    // this is without keeping the track of index
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }

    String firstCharRemoved = str.substring(1);

    findSubsets2(firstCharRemoved, ans + str.charAt(0));

    findSubsets2(firstCharRemoved, ans);
  }
}
