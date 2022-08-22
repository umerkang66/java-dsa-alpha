package strings;

// lexo graphical comparisons
public class LargestCharString {
  public static void main(String[] args) {
    // string that is started with biggest character. If strings are sorted, print
    // that is at the end
    String[] strings = { "apple", "mango", "banana" };
    System.out.println(largestString(strings));
  }

  private static String largestString(String[] strings) {
    String largestString = strings[0];
    for (int i = 1; i < strings.length; i++) {
      if (strings[i].compareTo(largestString) > 0) {
        largestString = strings[i];
      }
    }
    return largestString;
  }
}
