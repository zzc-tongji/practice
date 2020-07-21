package leetcode._0140_WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc app=leetcode id=140 lang=java
// @lc code=start
public class Solution2 {
  /*
   * DP
   *
   * Use 2D matrix store solutions of all subarray by diagonal traverse.
   *
   * LeetCode: Time Limit Exceeded
   *
   * time: O(n ^ 4)
   *
   * space: O(n ^ 2)
   */

  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return new ArrayList<>();
    }
    if (wordDict == null || wordDict.size() == 0) {
      return new ArrayList<>();
    }
    Object[][] dp = new Object[s.length()][s.length()];
    String substr;
    Set<String> temp;
    // diagonal traverse
    for (int distance = 0; distance < dp.length; distance++) {
      for (int start = 0, end = start + distance; end < dp.length; start++, end++) {
        // When `distance == 0`, the following loop will not be executed.
        for (int k = start + 1; k <= end; k++) {
          if (dp[start][k - 1] != null && dp[k][end] != null) {
            temp = merge(dp[start][k - 1], dp[k][end]);
            dp[start][end] = appendSet(dp[start][end], temp);
          }
        }
        substr = s.substring(start, end + 1);
        if (wordDict.contains(substr)) {
          dp[start][end] = appendString(dp[start][end], substr);
        }
      }
    }
    if (dp[0][s.length() - 1] == null) {
      return new ArrayList<>();
    }
    @SuppressWarnings("unchecked")
    List<String> res = new ArrayList<>((Set<String>) dp[0][s.length() - 1]);
    return res;
  }

  private Set<String> merge(Object o1, Object o2) {
    @SuppressWarnings("unchecked")
    Set<String> l1 = (HashSet<String>) o1;
    @SuppressWarnings("unchecked")
    Set<String> l2 = (HashSet<String>) o2;
    Set<String> res = new HashSet<>();
    for (String s1 : l1) {
      for (String s2 : l2) {
        res.add(s1 + " " + s2);
      }
    }
    return res;
  }

  private Object appendSet(Object a, Set<String> b) {
    if (a == null) {
      return b;
    }
    @SuppressWarnings("unchecked")
    Set<String> aList = (HashSet<String>) a;
    aList.addAll(b);
    return aList;
  }

  private Object appendString(Object a, String b) {
    if (a == null) {
      Set<String> bList = new HashSet<>();
      bList.add(b);
      return bList;
    }
    @SuppressWarnings("unchecked")
    Set<String> aList = (HashSet<String>) a;
    aList.add(b);
    return aList;
  }
}
// @lc code=end
