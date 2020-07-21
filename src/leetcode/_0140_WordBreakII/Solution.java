package leetcode._0140_WordBreakII;

import java.util.ArrayList;
import java.util.List;

/*
 * 0140. Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 *
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 *
 * Input:
 *
 * s = "catsanddog"
 *
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 *
 * Output:
 *
 * ["cats and dog", "cat sand dog"]
 *
 * Example 2:
 *
 * Input:
 *
 * s = "pineapplepenapple"
 *
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 *
 * Output:
 *
 * [ "pine apple pen apple", "pineapple pen apple", "pine applepen apple" ]
 *
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input:
 *
 * s = "catsandog"
 *
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 *
 * Output:
 *
 * []
 */

// @lc app=leetcode id=140 lang=java
// @lc code=start
public class Solution {
  /*
   * dfs: for every posible cut point, decide cut or not
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
    dfs(s, wordDict, 0, 1, builder, res);
    return res;
  }

  private void dfs(String s, List<String> wordDict, int prevCut, int cut, StringBuilder builder, List<String> res) {
    String substr = s.substring(prevCut, cut); // [prevCut, cut)
    int len;
    // base case
    if (cut == s.length()) {
      // only branch: cut
      if (!wordDict.contains(substr)) {
        return;
      }
      // do
      len = builder.length();
      builder.append(substr);
      //
      res.add(builder.toString());
      // backtracking
      builder.delete(len, len + substr.length());
      return;
    }
    // branch #0: not cut
    dfs(s, wordDict, prevCut, cut + 1, builder, res);
    // branch #1: cut
    if (!wordDict.contains(substr)) {
      return;
    }
    // do
    len = builder.length();
    builder.append(substr);
    builder.append(" ");
    //
    dfs(s, wordDict, cut, cut + 1, builder, res);
    // backtracking
    builder.delete(len, len + substr.length() + 1);
  }
}
// @lc code=end
