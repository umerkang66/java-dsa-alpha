package recursion.recursion_basics;

public class FirstAndLastOccurrence {
  public static void main(String[] args) {
    int[] arr = { 8, 3, 6, 9, 5, 10, 2, 5, 3, 11 };

    System.out.println(firstOccurrence(arr, 5, 0));
    System.out.println(lastOccurrence(arr, 5, 0, 0));
    System.out.println(lastOccurrence2(arr, 5, arr.length - 1));
  }

  private static int firstOccurrence(int[] arr, int target, int i) {
    if (i == arr.length) {
      // if i has been increased more than the last element arr.length-1, then return,
      // otherwise include the last element
      return -1;
    }
    if (arr[i] == target) {
      return i;
    }
    return firstOccurrence(arr, target, i + 1);
  }

  private static int lastOccurrence(int[] arr, int target, int i, int occurrenceIndex) {
    if (i == arr.length) {
      return occurrenceIndex;
    }
    if (arr[i] == target) {
      occurrenceIndex = i;
    }
    return lastOccurrence(arr, target, i + 1, occurrenceIndex);
  }

  private static int lastOccurrence2(int[] arr, int target, int i) {
    // start the index from the end of array, and move backwards.
    if (i < 0) {
      // if index is 0, still keep looking, if index is less than 0, don't look, just
      // return.
      return -1;
    }
    if (arr[i] == target) {
      return i;
    }
    return lastOccurrence2(arr, target, i - 1);
  }
}
