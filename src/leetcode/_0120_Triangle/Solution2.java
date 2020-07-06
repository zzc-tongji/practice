package leetcode._0120_Triangle;

import java.util.List;

// @lc app=leetcode id=120 lang=java
// @lc code=start
public class Solution2 {
  /*
   * standard recursion, remove redundant computation by DP
   *
   * time: O(n ^ 2)
   *
   * space: O(n ^ 2)
   */

  private Integer[][] dp;

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
    // init dp
    dp = new Integer[triangle.size()][triangle.size()];
    return helper(0, 0, triangle);
  }

  private int helper(int i, int j, List<List<Integer>> triangle) {
    // with pruning
    if (i >= triangle.size() - 1) {
      return triangle.get(i).get(j);
    }
    if (dp[i + 1][j] == null) {
      dp[i + 1][j] = helper(i + 1, j, triangle);
    }
    int left = dp[i + 1][j];
    if (dp[i + 1][j + 1] == null) {
      dp[i + 1][j + 1] = helper(i + 1, j + 1, triangle);
    }
    int right = dp[i + 1][j + 1];
    return triangle.get(i).get(j) + Math.min(left, right);
  }
}
// @lc code=end
