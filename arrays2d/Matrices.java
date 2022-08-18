package arrays2d;

import java.util.Arrays;
import java.util.Scanner;

public class Matrices {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int rows = 3, cols = 3;
    int[][] matrix = createMatrix(rows, cols);
    print(matrix);

    int[] searchedIndexes = search(matrix, 9);
    System.out.println(Arrays.toString(searchedIndexes));
  }

  private static int[][] createMatrix(int rows, int cols) {
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    return matrix;
  }

  private static int[] search(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] { -1, -1 };
  }

  private static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.print("[");
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);
        if (j < matrix[0].length - 1) {
          System.out.print(" ");
        }
      }
      System.out.print("]");
      System.out.println();
    }
  }
}
