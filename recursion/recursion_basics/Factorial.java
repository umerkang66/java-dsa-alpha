package recursion.recursion_basics;

public class Factorial {
  public static void main(String[] args) {
    System.out.println(factorial(5)); // 120
  }

  // multiply a n with (n-1), then (n-1), ..., 1
  private static int factorial(int n) {
    if (n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}
