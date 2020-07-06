package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Example:
 *
 * Input: 3
 *
 * Output: [1,3,3,1]
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class _0119_PascalsTriangleII {
  public List<Integer> getRow(int rowIndex) {
    // corner case
    if (rowIndex < 0) {
      throw new IllegalArgumentException();
    }
    // `rowIndex` row contains `rowIndex + 1` elements.
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < rowIndex + 1; i++) {
      res.add(0);
    }
    // corner case
    if (rowIndex == 0) {
      res.set(0, 1);
      return res;
    }
    if (rowIndex == 1) {
      res.set(0, 1);
      res.set(1, 1);
      return res;
    }
    // main
    res.set(0, 1);
    res.set(1, 1);
    for (int i = 2; i <= rowIndex; i++) {
      // Worry about override? Do it from right to left.
      for (int j = i; j >= 1; j--) {
        res.set(j, res.get(j - 1) + res.get(j));
      }
    }
    return res;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }
}
