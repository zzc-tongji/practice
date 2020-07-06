package leetcode._0120_Triangle;

import java.util.List;

// @lc app=leetcode id=120 lang=java
// @lc code=start
public class Solution3 {
  /*
   * directly use DP
   *
   * time: O(n ^ 2)
   *
   * space: O(n ^ 2)
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
    // dp
    Integer[][] dp = new Integer[triangle.size()][triangle.size()];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        if (i == triangle.size() - 1) {
          dp[i][j] = triangle.get(i).get(j);
        } else {
          dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        }
      }
    }
    return dp[0][0];
  }
}
// @lc code=end
