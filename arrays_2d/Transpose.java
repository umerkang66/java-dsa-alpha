public class Transpose {
  public static void main(String[] args) {
    int[][] matrix = {
        { 2, 3, 7 },
        { 5, 6, 7 }
    };
    int[][] transpose = getTranspose(matrix);
    printMatrix(transpose);
  }

  private static int[][] getTranspose(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int[][] transpose = new int[columns][rows];

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        // it should be in the matrix[row][col] and transpose[col][row],
        // because, we are iterating according to the matrix, not transpose
        transpose[col][row] = matrix[row][col];
      }
    }

    return transpose;
  }

  private static void printMatrix(int[][] matrix) {
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
