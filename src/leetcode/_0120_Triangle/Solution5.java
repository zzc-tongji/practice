package leetcode._0120_Triangle;

import java.util.List;

// @lc app=leetcode id=120 lang=java
// @lc code=start
public class Solution5 {
  /*
   * directly use DP, optimize space to inplace
   *
   * time: O(n ^ 2)
   *
   * space: O(n)
   */

  public static int minimumTotal(List<List<Integer>> triangle) {
    // corner case
    if (triangle == null || triangle.size() <= 0) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < triangle.size(); i++) {
      if (triangle.get(i).size() != i + 1) {
        throw new IllegalArgumentException();
      }
    }
    // inplace dp
    if (triangle.size() == 1) {
      return triangle.get(0).get(0);
    }
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        triangle.get(i).set(j,
            triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
      }
    }
    return triangle.get(0).get(0);
  }
}
// @lc code=end
