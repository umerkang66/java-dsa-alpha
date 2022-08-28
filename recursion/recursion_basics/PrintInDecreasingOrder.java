package recursion.recursion_basics;

public class PrintInDecreasingOrder {
  public static void main(String[] args) {
    printInDecreasingOrder(10);
  }

  private static void printInDecreasingOrder(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);
    printInDecreasingOrder(n - 1);
  }
}
