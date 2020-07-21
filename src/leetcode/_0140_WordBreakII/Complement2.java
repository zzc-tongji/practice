package leetcode._0140_WordBreakII;

import java.util.List;

public class Complement2 {
  /*
   * Return true or false.
   *
   * time: O(n ^ 3)
   *
   * space: O(n)
   */

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return false;
    }
    if (wordDict == null || wordDict.size() == 0) {
      return false;
    }
    boolean[] dp = new boolean[s.length()];
    for (int i = 0; i < dp.length; i++) {
      // search the whole substring
      if (wordDict.contains(s.substring(0, i + 1))) {
        dp[i] = true;
        continue;
      }
      // iterate all cut point
      for (int j = 0; j < i; j++) {
        // left (dp) && right (use "dictionary contains" rather than "is word break")
        if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[dp.length - 1];
  }
}
