package leetcode;

/**
 * 0240. Search a 2D Matrix II
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * - Integers in each row are sorted in ascending from left to right.
 * 
 * - Integers in each column are sorted in ascending from top to bottom.
 * 
 * Example:
 * 
 * Consider the following matrix:
 * 
 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17,
 * 24], [18, 21, 23, 26, 30] ]
 * 
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 */
public class _0240_SearchA2DMatrixII {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    // validate matrix
    if (matrix == null || matrix.length <= 0) {
      return false;
    }
    int colNum = matrix[0].length;
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i].length != colNum) {
        return false;
      }
    }
    // move from bottom-left to top-right
    int i = matrix.length - 1;
    int j = 0;
    while (i >= 0 && j < colNum) {
      if (matrix[i][j] < target) {
        // move right
        j += 1;
      } else if (matrix[i][j] > target) {
        // move up
        i -= 1;
      } else { // matrix[i][j] == target
        return true;
      }
    }
    return false;
    /*
     * time: O(r + c), r as row number, c as column number
     * 
     * space: O(1)
     */
  }
}
