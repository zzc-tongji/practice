package leetcode;

/**
 * 0074. Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * - Integers in each row are sorted from left to right.
 * 
 * - The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * target = 3
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input:
 * 
 * matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * target = 13
 * 
 * Output: false
 */
public class _0074_SearchA2DMatrix {
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
    // binary search
    int left = 0;
    int right = (matrix.length - 1) * colNum + (colNum - 1);
    int mid = 0;
    int midValue = 0;
    while (left <= right) {
      mid = left + (right - left) / 2;
      midValue = getValue(matrix, mid);
      if (midValue < target) {
        left = mid + 1;
      } else if (midValue > target) {
        right = mid - 1;
      } else { // midValue == target
        return true;
        // return getRowColumnIndex(mid);
      }
    }
    return false;
    // return new int[]{-1, -1};

    /*
     * time: O(r) + O(log rc), r as row number, c as column number
     * 
     * If the for-loop of validating the matrix is excluded, the time complexity
     * will be O(log rc).
     * 
     * space: O(1)
     */
  }

  private int getValue(int[][] matrix, int index) {
    int colNum = matrix[0].length;
    return matrix[index / colNum][index % colNum];
  }

  // private int[] getRowColumnIndex(int[][] matrix, int index) {
  // int colNum = matrix[0].length;
  // return new int[] { index / colNum, index % colNum };
  // }
}
