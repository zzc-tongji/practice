package leetcode;

// import java.util.HashSet;
// import java.util.Set;

/*
 * 0005. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 */
public class _0005_LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    // LeetCode: Time Limit Exceeded
    //
    // corner case
    if (s == null || s.length() <= 1) {
      return s;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return s;
    }
    // from edge to middle
    String res = "";
    // Set<String> all = new HashSet<>();
    String temp = null;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPalindrome(s, i, j)) {
          temp = s.substring(i, j + 1);
          if (res.length() < temp.length()) {
            res = temp;
          }
          // all.add(temp);
        }
      }
    }
    return res;
    /*
     * time: O(n ^ 3)
     *
     * space: O(1)
     */
  }

  public String longestPalindrome1(String s) {
    // corner case
    if (s == null || s.length() <= 1) {
      return s;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return s;
    }
    // from edge to middle, with prune
    String res = "";
    String temp = null;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        // prune
        if (j - i + 1 <= res.length()) {
          continue;
        }
        if (isPalindrome(s, i, j)) {
          temp = s.substring(i, j + 1);
          if (res.length() < temp.length()) {
            res = temp;
          }
        }
      }
    }
    return res;
    /*
     * time: best = O(n ^ 2), average = worst = O(n ^ 3)
     *
     * space: O(1)
     */
  }

  private boolean isPalindrome(String s, int left, int right) {
    if (left == right) {
      return true;
    }
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left += 1;
      right -= 1;
    }
    return true;
  }

  public String longestPalindrome2(String s) {
    // LeetCode: Time Limit Exceeded
    //
    // corner case
    if (s == null || s.length() <= 1) {
      return s;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return s;
    }
    // from middle to edge
    int left = (s.length() - 1) / 2;
    int right = left + 1;
    String res = "";
    // Set<String> all = new HashSet<>();
    String temp = null;
    boolean firstLoop = true;
    while (left >= 0 || right < s.length()) {
      if (left >= 0) {
        temp = helperOdd(s, left); // , all);
        if (temp.length() > res.length()) {
          res = temp;
        }
        temp = helperEven(s, left, left + 1); // , all);
        if (temp.length() > res.length()) {
          res = temp;
        }
        left -= 1;
      }
      if (right < s.length()) {
        temp = helperOdd(s, right); // , all);
        if (temp.length() > res.length()) {
          res = temp;
        }
        if (!firstLoop) {
          // In first loop, the following statement is same as
          // `helperEven(s, left, left + 1); // , all);`. Skip it to save some time.
          temp = helperEven(s, right - 1, right); // , all);
          if (temp.length() > res.length()) {
            res = temp;
          }
        }
        right += 1;
      }
      firstLoop = false;
    }
    return res;
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */
  }

  public String longestPalindrome3(String s) {
    // corner case
    if (s == null || s.length() <= 1) {
      return s;
    }
    if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
      return s;
    }
    // from middle to edge, with prune
    int left = (s.length() - 1) / 2;
    int right = left + 1;
    String res = "";
    int leftRemain = 0;
    int rightRemain = 0;
    String temp = null;
    boolean firstLoop = true;
    while (left >= 0 || right < s.length()) {
      if (left >= 0) {
        // prune
        leftRemain = left;
        rightRemain = (s.length() - 1) - left;
        if ((Math.min(leftRemain, rightRemain) << 1) + 1 > res.length()) {
          temp = helperOdd(s, left);
          if (temp.length() > res.length()) {
            res = temp;
          }
        }
        // prune
        leftRemain = left;
        rightRemain = (s.length() - 1) - (left + 1);
        if ((Math.min(leftRemain, rightRemain) << 1) + 2 > res.length()) {
          temp = helperEven(s, left, left + 1);
          if (temp.length() > res.length()) {
            res = temp;
          }
        }
        left -= 1;
      }
      if (right < s.length()) {
        // prune
        leftRemain = right;
        rightRemain = (s.length() - 1) - right;
        if ((Math.min(leftRemain, rightRemain) << 1) + 1 > res.length()) {
          temp = helperOdd(s, right);
          if (temp.length() > res.length()) {
            res = temp;
          }
        }
        if (!firstLoop) {
          // In first loop, the following statement is same as
          // `helperEven(s, left, left + 1);`. Skip it to save some time.
          //
          // prune
          leftRemain = right - 1;
          rightRemain = (s.length() - 1) - right;
          if ((Math.min(leftRemain, rightRemain) << 1) + 2 > res.length()) {
            temp = helperEven(s, right - 1, right);
            if (temp.length() > res.length()) {
              res = temp;
            }
          }
        }
        right += 1;
      }
      firstLoop = false;
    }
    return res;
    /*
     * time: best = O(n), average = worst = O(n ^ 2)
     *
     * space: O(1)
     */
  }

  private String helperOdd(String s, int middle) { // , Set<String> all) {
    int l = middle;
    int r = middle;
    String res = null;
    while (l >= 0 && r < s.length()) {
      if (s.charAt(l) == s.charAt(r)) {
        res = s.substring(l, r + 1);
        // all.add(res);
      } else {
        break;
      }
      l -= 1;
      r += 1;
    }
    return res;
  }

  private String helperEven(String s, int l, int r) { // , Set<String> all) {
    String res = null;
    while (l >= 0 && r < s.length()) {
      if (s.charAt(l) == s.charAt(r)) {
        res = s.substring(l, r + 1);
        // all.add(res);
      } else {
        break;
      }
      l -= 1;
      r += 1;
    }
    // all.add("");
    return res != null ? res : "";
  }
}
