package strings;

public class Palindrome {
  public static void main(String[] args) {
    String str = "racecar";
    System.out.println(isPalindrome(str));
  }

  private static boolean isPalindrome(String str) {
    int leftPointer = 0;
    int rightPointer = str.length() - 1;

    while (leftPointer < rightPointer) {
      if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
        return false;
      }
      leftPointer++;
      rightPointer--;
    }

    return true;
  }
}
