package leetcode._0140_WordBreakII;

import java.util.ArrayList;
import java.util.List;

public class Complement3 {
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
    List<Integer> dp = new ArrayList<>();
    dp.add(0);
    for (int i = 1; i <= s.length(); i++) {
      // search the whole substring
      if (wordDict.contains(s.substring(0, i + 1))) {
        dp.add(i);
        continue;
      }
      for (int j : dp) {
        if (wordDict.contains(s.substring(j + 1, i + 1))) {
          dp.add(i);
          break;
        }
      }
    }
    return dp.contains(s.length() - 1);
  }
}
