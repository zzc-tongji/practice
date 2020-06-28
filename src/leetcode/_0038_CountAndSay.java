package leetcode;

import java.util.Arrays;

/*
 * 0038. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 *
 * 1. 1
 *
 * 2. 11
 *
 * 3. 21
 *
 * 4. 1211
 *
 * 5. 111221
 *
 * 1 is read off as "one 1" or 11.
 *
 * 11 is read off as "two 1s" or 21.
 *
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence. You can do so recursively, in other words from the
 * previous member read off the digits, counting the number of digits in groups
 * of the same digit.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 *
 * Output: "1"
 *
 * Explanation: This is the base case.
 *
 * Example 2:
 *
 * Input: 4
 *
 * Output: "1211"
 *
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and
 * "1", "2" can be read as "12" which means frequency = 1 and value = 2, the
 * same way "1" is read as "11", so the answer is the concatenation of "12" and
 * "11" which is "1211".
 */

// @lc code=start
class _0038_CountAndSay {
  public static void main(String[] args) {
    (new _0038_CountAndSay()).countAndSay(4);
    return;
  }

  public String countAndSay(int n) {
    if (n <= 1) {
      return "1";
    }
    String[] dp = new String[n];
    dp[0] = "1";
    for (int i = 1; i < dp.length; i++) {
      dp[i] = helper(dp[i - 1]);
    }
    return dp[dp.length - 1];
  }

  private String helper(String str) {
    // similar as as `techbow._0015_Encoding`
    //
    // Don't forget corner case and post processing.
    if (str.length() == 1) {
      return str.charAt(0) + "1";
    }
    char[] s = str.toCharArray();
    int segment = 1;
    for (int i = 1; i < s.length; i++) {
      if (s[i] != s[i - 1]) {
        segment += 1;
      }
    }
    char[] res = Arrays.copyOf(s, s.length + segment);
    int slow = res.length - 1;
    int fast = s.length - 2;
    int counter = 1;
    while (fast >= 0) {
      if (res[fast] == res[fast + 1]) {
        counter += 1;
      } else {
        res[slow] = res[fast + 1];
        slow -= 1;
        res[slow] = (char) (counter + 48);
        slow -= 1;
        counter = 1;
      }
      fast -= 1;
    }
    res[slow] = res[0];
    slow -= 1;
    res[slow] = (char) (counter + 48);
    slow -= 1;
    return String.valueOf(res).substring(slow + 1);
  }
}
// @lc code=end
