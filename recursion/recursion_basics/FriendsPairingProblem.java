package recursion.recursion_basics;

public class FriendsPairingProblem {
  public static void main(String[] args) {
    System.out.println(friendsPairingProblem(5));
  }

  private static int friendsPairingProblem(int people) {
    if (people == 1 || people == 2) {
      return people;
    }

    // people left after single pairing
    int singlePeople = people - 1;
    // people left after double pairing
    int doublePeoples = people - 2;

    return friendsPairingProblem(singlePeople) + singlePeople * friendsPairingProblem(doublePeoples);
  }
}
