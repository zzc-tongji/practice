package leetcode._0140_WordBreakII;

import java.util.ArrayList;
import java.util.List;

// @lc app=leetcode id=140 lang=java
// @lc code=start
public class Solution1 {
  /*
   * dfs: the node of each level defines the next search search position
   *
   * LeetCode: Time Limit Exceeded
   *
   * time: O((2 ^ n) * n)
   *
   * space: O(1)
   */

  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return new ArrayList<>();
    }
    if (wordDict == null || wordDict.size() == 0) {
      return new ArrayList<>();
    }
    StringBuilder builder = new StringBuilder();
    List<String> res = new ArrayList<>();
    dfs(s, wordDict, 0, builder, res);
    return res;
  }

  private void dfs(String s, List<String> wordDict, int cut, StringBuilder builder, List<String> res) {
    if (cut == s.length()) {
      res.add(builder.toString().trim());
      return;
    }
    String substr;
    int len;
    for (int i = cut + 1; i <= s.length(); i++) {
      substr = s.substring(cut, i); // [cut, i)
      // prune
      if (wordDict.contains(substr)) {
        // do
        len = builder.length();
        builder.append(substr);
        builder.append(" ");
        //
        dfs(s, wordDict, i, builder, res);
        // backtracking
        builder.delete(len, len + substr.length() + 1);
      }
    }
  }
}
// @lc code=end
