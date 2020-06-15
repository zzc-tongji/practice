package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 0018. Pascal's Triangle
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 *
 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Example:
 *
 * Input: 5
 *
 * Output:
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class _0118_PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    // [me]
    //
    // if (numRows <= 0) {
    // throw new IllegalArgumentException();
    // }
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      res.add(generateRow(i, res));
    }
    return res;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }

  private List<Integer> generateRow(int rowIndex, List<List<Integer>> res) {
    List<Integer> cursor = new ArrayList<>();
    if (rowIndex == 0) {
      cursor.add(1);
      return cursor;
    }
    for (int i = 0; i < rowIndex + 1; i++) {
      cursor.add(generateItem(i, rowIndex, res));
    }
    return cursor;
  }

  private int generateItem(int index, int rowIndex, List<List<Integer>> res) {
    if (index == 0) {
      return 1;
    }
    if (index == rowIndex) {
      return 1;
    }
    return res.get(rowIndex - 1).get(index - 1) + res.get(rowIndex - 1).get(index);
  }
}
