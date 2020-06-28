package leetcode;

/*
 * 0091. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 *
 * 'A' -> 1
 *
 * 'B' -> 2
 *
 * ...
 *
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 *
 * Output: 2
 *
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: "226"
 *
 * Output: 3
 *
 * Explanation: 
 *
 * It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 26).
 */

public class _0091_DecodeWays {
  public int numDecodings(String s) {
    // [own]
    if (s == null || s.length() <= 0) {
      return 0;
    }
    if (s.length() == 1) {
      return s.charAt(0) - 48 != 0 ? 1 : 0;
    }
    // `dp[i]` means the answer of the substring s[len-1-i] ~ s[len-1].
    int[] dp = new int[s.length()];
    dp[0] = isZero(s.charAt(s.length() - 1)) ? 0 : 1;
    //
    dp[1] = 0;
    if (helper(s.charAt(s.length() - 2), s.charAt(s.length() - 1))) {
      dp[1] += 1; // "10" ~ "26"
    }
    if (!isZero(s.charAt(s.length() - 2)) && dp[0] == 1) {
      dp[1] += 1; // '1' ~ '9' && '1' ~ '9'
    }
    //
    for (int i = 2; i < dp.length; i++) {
      dp[i] = 0;
      if (isZero(s.charAt(s.length() - 1 - i))) {
        continue;
      }
      dp[i] += dp[i - 1];
      if (helper(s.charAt(s.length() - 1 - i), s.charAt(s.length() - 1 - i + 1))) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[dp.length - 1];
  }

  private boolean helper(char left, char right) {
    // check whether `left` & `right` is from "11" to "26"
    if (left - 48 <= 0) {
      return false;
    }
    if (left - 48 == 1) {
      return true;
    }
    if (left - 48 == 2) {
      if (right - 48 >= 0 && right - 48 <= 6) {
        return true;
      } else {
        return false;
      }
    }
    // left - 48 >= 2
    return false;
  }

  private boolean isZero(char c) {
    return c - 48 == 0;
  }
}
