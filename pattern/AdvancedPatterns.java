package pattern;

import java.util.Scanner;

public class AdvancedPatterns {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int rows = scanner.nextInt();
    int cols = scanner.nextInt();

    hollowRectangle(rows, cols);
    invertedRotatedHalfPyramid(rows);
    halfPyramidWithNums(rows);
    floydTriangle(rows);
    zeroOneTriangle(rows);
    zeroOneTriangleSecondSolution(rows);
    butterflyPattern(rows);
    butterflyPatternSolution2(rows);
    solidRhombus(rows);
    solidRhombusSolution2(rows);
    hollowRhombus(rows);
    hollowRhombusSecondSolution(rows);
    diamondPattern(rows);
  }

  private static void hollowRectangle(int rows, int cols) {
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (i == 1 || i == rows || j == 1 || j == cols) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        // just for beautification
        if (j < cols) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void invertedRotatedHalfPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (j <= n - i) {
          System.out.print(" ");
        } else {
          System.out.print("*");
        }

        // just for beautification
        if (j < n) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void halfPyramidWithNums(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i + 1; j++) {
        // j can be used as number
        System.out.print(j);

        if (j < n) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void floydTriangle(int n) {
    int counter = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(counter);

        // just for beautification
        if (j < i) {
          System.out.print(" ");
        }
        if (counter <= 9) {
          System.out.print("  ");
        }
        if (counter >= 10 && counter <= 99) {
          System.out.print(" ");
        }

        // functionality
        counter++;
      }
      System.out.println();
    }
  }

  private static void zeroOneTriangle(int n) {
    for (int i = 1; i <= n; i++) {
      // from where the binary digit should start
      int binaryDigit;
      if (i % 2 == 0) {
        // if row is even, binaryDigit should start with 0
        binaryDigit = 0;
      } else {
        // if the row is odd it should starts with 1
        binaryDigit = 1;
      }

      for (int j = 1; j <= i; j++) {
        System.out.print(binaryDigit);
        binaryDigit = binaryDigit == 0 ? 1 : 0;
        // for beautification
        if (j < i) {
          System.out.print(" ");
        }
      }
      // add the new line
      System.out.println();
    }
  }

  private static void zeroOneTriangleSecondSolution(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 == 0) {
          // i+j is even
          System.out.print(1);
        } else {
          // i+j is odd
          System.out.print(0);
        }

        if (j < i) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void butterflyPattern(int n) {
    // print the upper half of butterfly
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n * 2; j++) {
        if (j <= i || j >= (n * 2) - i + 1) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        // for beautification
        if (j < n * 2) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    // print the upper half of butterfly
    // here we are not utilizing the the mirror image (that we start the loop from
    // the n to 1)
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n * 2; j++) {
        if (j <= n - i + 1 || j >= (n * 2) - n + i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        // for beautification
        if (j < n * 2) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void butterflyPatternSolution2(int n) {
    // first half
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        // print the left side stars
        System.out.print("*");
      }
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        // print the left side stars
        System.out.print("*");
      }
      // new line
      System.out.println();
    }
    // second half
    // in you want to invert the pattern, just start the loop from n to 1 (opposite
    // direction)
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        // print the left side stars
        System.out.print("*");
      }
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        // print the left side stars
        System.out.print("*");
      }
      // new line
      System.out.println();
    }
  }

  private static void solidRhombus(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= (n * 2) - 1; j++) {
        if (j >= n - i + 1 && j <= (n * 2) - i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        if (i < n * 2 - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void solidRhombusSolution2(int n) {
    for (int i = 1; i <= n; i++) {
      // spaces loop
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
        // beautification
        if (j <= n - i) {
          // we also have to print out extra space after after the last actual space
          // because, after that are actual stars
          System.out.print(" ");
        }
      }
      // stars loop
      for (int j = 1; j <= n; j++) {
        System.out.print("*");
        // beautification
        if (j < n) {
          System.out.print(" ");
        }
      }
      // next line
      System.out.println();
    }
  }

  private static void hollowRhombus(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n * 2 - i; j++) {
        if (j <= n - i) {
          System.out.print(" ");
        } else {
          // same as the hollow rectangle
          if (i == 1 || i == n || j == n - i + 1 || j == (n * 2) - i) {
            System.out.print("*");
          } else {
            System.out.print(" ");
          }
        }
        // for beautification
        if (j < n * 2 - i) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void hollowRhombusSecondSolution(int n) {
    for (int i = 1; i <= n; i++) {
      // print spaces
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
        // for beautification
        if (j <= n) {
          System.out.print(" ");
        }
      }
      // print stars
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        // for beautification
        if (j < n) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void diamondPattern(int n) {
    // UPPER PART
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n * 2 - 1; j++) {
        if (j >= n - i + 1 && j < n + i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        // beautification
        if (j < n * 2 - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    // LOWER PART
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= n * 2 - 1; j++) {
        if (j >= n - i + 1 && j < n + i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

        // beautification
        if (j < n * 2 - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
