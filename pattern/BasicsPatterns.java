package pattern;

import java.util.Scanner;

public class BasicsPatterns {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int num = scanner.nextInt();
    diagonalStars(num);
    invertedStars(num);
    halfPyramid(num);
    charPatterns(num);
  }

  private static void diagonalStars(int n) {
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) {
        System.out.print("*");
        if (col < row) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void invertedStars(int n) {
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= n - row + 1; col++) {
        System.out.print("*");
        if (col < n - row + 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void halfPyramid(int n) {
    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) {
        System.out.print(col);
        if (col < row) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void charPatterns(int n) {
    // char can be converted into int by type conversion (no need of type casting)
    int STARTING_CHAR_CODE = 'A';

    for (int row = 1; row <= n; row++) {
      for (int col = 1; col <= row; col++) {
        char character = (char) STARTING_CHAR_CODE;
        System.out.print(character);
        STARTING_CHAR_CODE++;

        if (col < row) {
          System.out.print(' ');
        }
      }
      System.out.println();
    }
  }
}
