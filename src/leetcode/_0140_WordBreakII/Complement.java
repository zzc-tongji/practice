package leetcode._0140_WordBreakII;

import java.util.List;

public class Complement {
  /*
   * It is similiar as `Solution2.java` but return true or false.
   *
   * time: O(n ^ 3)
   *
   * space: O(n ^ 2)
   */

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return false;
    }
    if (wordDict == null || wordDict.size() == 0) {
      return false;
    }
    // diagonal traverse
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int distance = 0; distance < dp.length; distance++) {
      for (int start = 0, end = start + distance; end < dp.length; start++, end++) {
        // When `distance == 0`, the following loop will not be executed.
        for (int k = start + 1; k <= end; k++) {
          if (dp[start][k - 1] && dp[k][end]) {
            dp[start][end] = true;
          }
        }
        if (!dp[start][end]) {
          dp[start][end] = wordDict.contains(s.substring(start, end + 1));
        }
      }
    }
    return dp[0][s.length() - 1];
  }
}
