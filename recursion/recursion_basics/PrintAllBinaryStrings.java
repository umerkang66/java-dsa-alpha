package recursion.recursion_basics;

public class PrintAllBinaryStrings {
  public static void main(String[] args) {
    printallBinaryStrings(3, 0, "");
  }

  private static void printallBinaryStrings(int n, int lastPlace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }
    // print 0 in both cases, if lastPlace is 1, or 0
    printallBinaryStrings(n - 1, 0, str + "0");
    if (lastPlace == 0) {
      // if print 1, if last place is 0
      printallBinaryStrings(n - 1, 1, str + "1");
    }
  }
}
