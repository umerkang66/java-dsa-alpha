package bit_manipulation;

// in this whole class "i" is 1 based (not zero based)
public class Main {
  public static void main(String[] args) {
    int num = 2;
    System.out.println(evenOrOdd(num));

    int[] nums = { 1, 3, 6, 4, 1, 3, 4 };
    System.out.println(findNumThatExistOneTime(nums));

    int num2 = 15;
    System.out.println(findIthBit(num2, 3));
    System.out.println(setIthBit(num2, 2));
    System.out.println(resetIthBit(num2, 3));
    System.out.println(updateIthBit(num2, 2, 1));
    System.out.println(clearLastIthBits(num2, 3));
    System.out.println(clearRangeOfBits(10, 2, 4));
    System.out.println(isPowerOfTwo(num2));
    System.out.println(setBitsCount(10));
  }

  private static boolean evenOrOdd(int num) {
    // Every number in binary ends with 1, or 0. When this number is converted into
    // decimal, every digit expect the first one will be multiplied with the
    // multiple of 2, because power will be ranged from 1 to n.
    // only the first element will be odd or even that will decide that the number
    // is even or odd. So we have to retrieve that number.
    // we can & the whole number with 1 (or 000001). Anything & with 1 will retrieve
    // the original thing. It will be 0 for even, and 1 for odd.
    // last number will return 0 or 1, other numbers will always be 0, because they
    // are & with 0.
    return (num & 1) == 0;
  }

  private static int findNumThatExistOneTime(int[] nums) {
    int ans = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // XOR every element with each other, if one element is XORed with same element,
      // this will add up to zero, ad the end, only that element will be remained,
      // that is not present twice. And in operators, order doesn't matter
      ans ^= nums[i];
    }
    return ans;
  }

  private static int findIthBit(int num, int i) {
    // if we AND anything with 1, the answer will always be 1 (in case of 0, or 1)
    int bitMask = 1 << (i - 1);
    return num & bitMask;
  }

  private static int setIthBit(int num, int i) {
    // set the Ith bit to 1, if we OR the ith bit with 1, the answer will be 1 (in
    // both cases 0, and 1)
    int bitMask = 1 << (i - 1);
    return num | bitMask;
  }

  private static int resetIthBit(int num, int i) {
    // set the IthBit to 0, if we AND anything with 0, answer will always be zero.
    // for to set the Ith bit to 0, bitMask should be 0 at the ith position, and 1
    // at every other position, because we need the same elements of num except the
    // ith element
    int bitMask = ~(1 << (i - 1));
    return num & bitMask;
  }

  private static int updateIthBit(int num, int i, int newBit) {
    if (newBit == 0) {
      return resetIthBit(num, i);
    } else {
      return setIthBit(num, i);
    }
  }

  private static int clearLastIthBits(int num, int i) {
    // (~0) is "-1", -1 in binary is 111111, when this will be leftshift leftshift
    // by i, this will become 111000
    int bitMask = (~0) << (i - 1);
    return num & bitMask;
  }

  private static int clearRangeOfBits(int num, int i, int j) {
    int leftBitMask = (~0) << j;
    int rightBitMask = (1 << i) - 1;
    int bitMask = leftBitMask | rightBitMask;

    return num & bitMask;
  }

  private static boolean isPowerOfTwo(int num) {
    // if a number is power of 2, when it will be & with its previous number,
    // results in 0.
    return (num & (num - 1)) == 0;
  }

  private static int setBitsCount(int num) {
    int count = 0;
    while (num > 0) {
      int lsb = num & 1;
      if (lsb == 1) {
        count++;
      }
      // shift the lsb, by discarding the previous lsb
      num >>= 1;
    }
    return count;
  }
}
