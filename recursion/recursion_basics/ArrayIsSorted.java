package recursion.recursion_basics;

public class ArrayIsSorted {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };

    System.out.println(arrayIsSorted(arr, 0));
  }

  private static boolean arrayIsSorted(int[] arr, int i) {
    if (i == arr.length - 1) {
      return true;
    }
    if (arr[i] > arr[i + 1]) {
      // if both are equal, then also they are true.
      return false;
    }
    return arrayIsSorted(arr, i + 1);
  }
}
