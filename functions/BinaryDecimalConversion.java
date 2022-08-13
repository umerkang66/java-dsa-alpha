package functions;

public class BinaryDecimalConversion {
  public static void main(String[] args) {
    int n = 101; // binary
    System.out.println(binaryToDecimal(n));

    // int d = 5; // decimal
    int d = 7;
    System.out.println(decimalToBinary(d));
  }

  private static int binaryToDecimal(int b) {
    // multiply the right most digit with 2^0, then 2^1 to the left, and so on.
    int decimal = 0;
    int power = 0;
    while (b != 0) {
      int lastDigit = b % 10;
      decimal += lastDigit * (int) Math.pow(2, power);
      power++;
      b /= 10;
    }
    return decimal;
  }

  private static int decimalToBinary(int d) {
    // divide by 2 while my number is greater than 0
    // and collect the remainders
    // then put the remainders from below to above
    int binary = 0;
    int power = 0;
    while (d > 0) {
      int binaryDigit = d % 2;
      // every binary digit should be at the 10^power (power starting from zero)
      binary += binaryDigit * (int) Math.pow(10, power);
      power++;
      d /= 2;
    }
    return binary;
  }
}
