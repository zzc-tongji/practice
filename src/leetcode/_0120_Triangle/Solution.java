package leetcode._0120_Triangle;

import java.util.List;

/*
 * 0120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 *
 * may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 */

// @lc app=leetcode id=120 lang=java
// @lc code=start
public class Solution {
  /*
   * dfs
   *
   * LeetCode: Time Limit Exceeded
   */

  public int minimumTotal(List<List<Integer>> triangle) {
    // corner case
    if (triangle == null || triangle.size() <= 0) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < triangle.size(); i++) {
      if (triangle.get(i).size() != i + 1) {
        throw new IllegalArgumentException();
      }
    }
    // main
    int[] res = new int[] { Integer.MAX_VALUE };
    dfs(0, 0, 0, res, triangle);
    return res[0];
    /*
     * time: O(2 ^ n)
     *
     * space: O(1)
     */
  }

  private void dfs(int i, int j, int sum, int[] res, List<List<Integer>> triangle) {
    if (i >= triangle.size()) {
      res[0] = Math.min(res[0], sum);
      return;
    }
    dfs(i + 1, j, sum + triangle.get(i).get(j), res, triangle);
    dfs(i + 1, j + 1, sum + triangle.get(i).get(j), res, triangle);
  }
}
// @lc code=end
