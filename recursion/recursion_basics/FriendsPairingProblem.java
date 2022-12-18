package recursion.recursion_basics;

public class FriendsPairingProblem {
  public static void main(String[] args) {
    System.out.println(friendsPairingProblem(3));
  }

  private static int friendsPairingProblem(int people) {
    if (people == 1 || people == 2) {
      // if there is 1 person, it can only pair be single, here is only 1 possibility
      // so return 1
      // if there is 2 persons, it can remain single, or can pair with other, so here
      // are 2 possibilities, so return 2
      return people;
    }

    // people left after single pairing
    int singlePaired = people - 1;
    // people left after double pairing
    int doublePaired = people - 2;

    return friendsPairingProblem(singlePaired) +
    // pairChoices * numberOfWays after one pair
        singlePaired * friendsPairingProblem(doublePaired);
  }
}
