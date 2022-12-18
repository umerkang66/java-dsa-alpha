package recursion.recursion_basics;

public class FriendsPairingProblem {
  public static void main(String[] args) {
    System.out.println(friendsPairing(3)); // 4
  }

  private static int friendsPairing(int n) {
    if (n == 1 || n == 2) {
      // if there is 1 person, it can only pair be single, here is only 1 possibility
      // so return 1
      // if there is 2 persons, it can remain single, or can pair with other, so here
      // are 2 possibilities, so return 2
      return n;
    }

    // 1 person remain single, then paired the n-1
    int remainingAfterSingle = friendsPairing(n - 1);
    // here we paired up the person with other remaining peoples after first
    // singlePairing, after this 2 persons are already paired up, then paired up the
    // remaining n-2
    int remainingAfterDouble = (n - 1) * friendsPairing(n - 2);

    return remainingAfterSingle + remainingAfterDouble;
  }
}
