package recursion.recursion_basics;

public class PowerOfNumber {
  public static void main(String[] args) {
    System.out.println(powerOfNumber(2, 3));
    System.out.println(optimizedPowerOfNumber(2, 3));
  }

  private static int powerOfNumber(int n, int p) {
    if (p == 1) {
      return n;
    }
    return n * powerOfNumber(n, p - 1);
  }

  private static int optimizedPowerOfNumber(int n, int p) {
    if (p == 1) {
      return n;
    }
    int halfPower = optimizedPowerOfNumber(n, p / 2);
    int halfPowerSquare = halfPower * halfPower;
    // If halfPowerSquare is even, just return it, otherwise, multiply with n, add
    // one more power
    if (p % 2 == 0) {
      return halfPowerSquare;
    }
    return n * halfPowerSquare;
  }
}
