package leetcode._0072_EditDistance;

// @lc app=leetcode id=72 lang=java
// @lc code=start
public class Solution1 {
  /*
   * DP
   *
   * time: O(m), let m as the length of the shorter input string
   *
   * space: O(n)
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
    if (word1.length() < word2.length()) {
      String t = word1;
      word1 = word2;
      word2 = t;
    }
    int[] dp = new int[word2.length() + 1];
    for (int j = 0; j < dp.length; j++) {
      dp[j] = j;
    }
    int temp;
    int temp1;
    for (int i = 1; i < word1.length() + 1; i++) {
      temp = i;
      for (int j = 1; j < dp.length; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          // same character
          //
          // insert, delete, replace
          temp1 = min(temp + 1, dp[j] + 1, dp[j - 1]);
        } else {
          // different character
          //
          // insert, delete, replace
          temp1 = min(temp + 1, dp[j] + 1, dp[j - 1] + 1);
        }
        dp[j - 1] = temp;
        temp = temp1;
      }
      dp[dp.length - 1] = temp;
    }
    return dp[dp.length - 1];
  }

  private int min(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }
}
// @lc code=end
