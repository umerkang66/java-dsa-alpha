package functions;

public class NumberComputation {
  public static void main(String[] args) {
    int n = 1234;
    System.out.println(reverseInteger(n));

    System.out.println(digitSum(n));
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

  private static int digitSum(int num) {
    int sum = 0;
    while (num != 0) {
      int lastDigit = num % 10;
      sum += lastDigit;
      num /= 10;
    }
    return sum;
  }
}
