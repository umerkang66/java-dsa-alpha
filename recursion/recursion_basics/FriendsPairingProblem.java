package recursion.recursion_basics;

public class FriendsPairingProblem {
  public static void main(String[] args) {
    System.out.println(friendsPairing(4)); // 3->4 4->10
  }

  private static int friendsPairing(int n) {
    if (n == 1 || n == 2) {
      // if there is 1 person, it can only pair be single, here is only 1 possibility
      // so return 1
      // if there is 2 persons, it can remain single, or can pair with other, so here
      // are 2 possibilities, so return 2
      return n;
    }

    // 1 person remain single, then remaining will be n - 1, recursively, pair
    // those n - 1
    // we have to multiply with 1, because it can negligible we can ignore it
    int remainSinglePossibilities = 1 * friendsPairing(n - 1);
    // if that person decides to pair himself with some other, he would have
    // the (n - 1) persons to pair with, so multiply n - 1 with further recursively
    // founded results
    int pairWithSomeOtherPossibilities = (n - 1) * friendsPairing(n - 2);

    return remainSinglePossibilities + pairWithSomeOtherPossibilities;
  }
}
