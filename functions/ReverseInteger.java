package functions;

public class ReverseInteger {
  public static void main(String[] args) {
    int n = 1234;
    System.out.println(reverseInteger(n));
  }

  private static int reverseInteger(int n) {
    int reverse = 0;
    while (n != 0) {
      int lastDigit = n % 10;
      reverse = reverse * 10 + lastDigit;
      n /= 10;
    }
    return reverse;
  }
}
