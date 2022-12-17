package recursion.recursion_basics;

public class PowerOfNumber {
  public static void main(String[] args) {
    System.out.println(powerOfNumber(2, 3));
    System.out.println(powerOfNumber2(2, 3));
    System.out.println(optimizedPowerOfNumber(2, 3));
  }

  private static int powerOfNumber(int n, int p) {
    if (p == 1) {
      return n;
    }
    return n * powerOfNumber(n, p - 1);
  }

  private static int powerOfNumber2(int n, int p) {
    if (p == 1) {
      // if power is 1, the result is same as "n"
      return n;
    }
    // actually these result would be same, so we optimize it in the next method
    int first = powerOfNumber2(n, p / 2);
    int second = powerOfNumber2(n, p / 2);
    int power = first * second;
    // power "p" could be even or odd, dividing by two works for even, but for odd,
    // we have to add one more power (multiply with n)
    if (p % 2 == 0) {
      return power; // even
    }
    return n * power; // odd
  }

  private static int optimizedPowerOfNumber(int n, int p) {
    if (p == 1) {
      return n;
    }
    // we don't have to calculate the second half, because both will be equal, so
    // multiply it with itself
    int halfPower = optimizedPowerOfNumber(n, p / 2);
    int power = halfPower * halfPower;
    // If p is even, just return it, (means n/2 * n/2) otherwise, multiply with n,
    // add one more power, (means n * n/2 * n/2)
    if (p % 2 == 0) {
      return power;
    }
    return n * power;
  }
}
