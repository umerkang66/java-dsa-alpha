package strings;

public class Substring {
  public static void main(String[] args) {
    String str = "HelloWorld";
    System.out.println(substring(str, 4, 6));
  }

  private static String substring(String str, int startingIndex, int endingIndex) {
    String substr = "";
    // don't include last index
    for (int i = startingIndex; i < endingIndex; i++) {
      substr += str.charAt(i);
    }
    return substr;
  }
}
