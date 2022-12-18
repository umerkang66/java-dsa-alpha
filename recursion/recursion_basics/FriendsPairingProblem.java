package recursion.recursion_basics;

public class FriendsPairingProblem {
  public static void main(String[] args) {
    System.out.println(friendsPairing(3));
  }

  private static int friendsPairing(int n) {
    if (n == 1 || n == 2) {
      // if there is 1 person, it can only pair be single, here is only 1 possibility
      // so return 1
      // if there is 2 persons, it can remain single, or can pair with other, so here
      // are 2 possibilities, so return 2
      return n;
    }

    int singlePaired = friendsPairing(n - 1);
    int doublePaired = friendsPairing(n - 2);
    // howManyPeopleRemainToPair * numberOfWays after one pair
    int pairWays = (n - 1) * doublePaired;

    return singlePaired + pairWays;
  }
}
