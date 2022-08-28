package recursion.recursion_basics;

public class PrintInIncreasingOrder {
  public static void main(String[] args) {
    printInIncreasingOrder(10);
  }

  private static void printInIncreasingOrder(int n) {
    if (n == 0) {
      return;
    }
    printInIncreasingOrder(n - 1);
    System.out.println(n);
  }
}
