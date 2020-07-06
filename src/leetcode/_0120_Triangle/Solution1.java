package leetcode._0120_Triangle;

import java.util.List;

// @lc app=leetcode id=120 lang=java
// @lc code=start
public class Solution1 {
  /*
   * standard recursion
   *
   * LeetCode: Time Limit Exceeded
   *
   * time: O(2 ^ n)
   *
   * space: O(1)
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
    return helper(0, 0, triangle);
  }

  private int helper(int i, int j, List<List<Integer>> triangle) {
    if (i >= triangle.size() - 1) {
      return triangle.get(i).get(j);
    }
    return triangle.get(i).get(j) + Math.min(helper(i + 1, j, triangle), helper(i + 1, j + 1, triangle));
  }
}
// @lc code=end
