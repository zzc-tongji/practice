package leetcode._0072_EditDistance;

/*
 * 0072. Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * - Insert a character
 *
 * - Delete a character
 *
 * - Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 *
 * Output: 3
 *
 * Explanation:
 *
 * - horse -> rorse (replace 'h' with 'r')
 *
 * - rorse -> rose (remove 'r')
 *
 * - rose -> ros (remove 'e')
 *
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 *
 * Output: 5
 *
 * Explanation:
 *
 * - intention -> inention (remove 't')
 *
 * - inention -> enention (replace 'i' with 'e')
 *
 * - enention -> exention (replace 'n' with 'x')
 *
 * - exention -> exection (replace 'n' with 'c')
 *
 * - exection -> execution (insert 'u')
 */

// @lc app=leetcode id=72 lang=java
// @lc code=start
public class Solution {
  /*
   * DP
   *
   * time: O(n ^ 2)
   *
   * space: O(n ^ 2)
   */

  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      throw new IllegalArgumentException("invalid input");
    }
    if (word1.length() == 0) {
      return word2.length();
    }
    if (word2.length() == 0) {
      return word1.length();
    }
    // `dp[i][j]` is the minimum steps to convert
    // `word1.substring(0, i)` to `word2.substring(0, j)`.
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        // The index of the last character of `word1.substring(0, i)` is `i - 1`.
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          // same character
          //
          // insert, delete, replace
          dp[i][j] = min(dp[i][j - 1] + 1, dp[i - 1][j] + 1, dp[i - 1][j - 1]);
        } else {
          // different character
          //
          // insert, delete, replace
          dp[i][j] = min(dp[i][j - 1] + 1, dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }

  private int min(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }
}
// @lc code=end
