package recursion.recursion_basics;

public class Fibonacci {
  public static void main(String[] args) {
    // 0,1,1,2,3,5,8,13,21,34
    System.out.println(fibonacci(5));
  }

  // here n is the index, that is zero based
  private static int fibonacci(int n) {
    if (n == 0) {
      // technically this if block will never run.
      return 0;
    }
    if (n <= 2) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
