package recursion.recursion_basics;

// See the video to understand the question
public class PrintAllBinaryStrings {
  public static void main(String[] args) {
    printAllBinaryStrings(3, 0, "");
  }

  // There shouldn't be consecutive ones
  private static void printAllBinaryStrings(int n, int lastPlace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }

    // print 0 in both cases, if lastPlace is 1, or 0
    printAllBinaryStrings(n - 1, 0, str + "0");

    // if lastPlace is 1, don't do anything
    if (lastPlace == 0) {
      // print 1, if last place is 0
      printAllBinaryStrings(n - 1, 1, str + "1");
    }
  }
}
