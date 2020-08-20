package leetcode._1328_BreakAPalindrome;

/*
 * 1328. Break a Palindrome
 *
 * Given a palindromic string palindrome, replace exactly one character by any
 * lowercase English letter so that the string becomes the lexicographically
 * smallest possible string that isn't a palindrome.
 *
 * After doing so, return the final string. If there is no way to do so, return
 * the empty string.
 *
 * Example 1:
 *
 * Input: palindrome = "abccba"
 *
 * Output: "aaccba"
 *
 * Example 2:
 *
 * Input: palindrome = "a"
 *
 * Output: ""
 *
 * Constraints:
 *
 * 1 <= palindrome.length <= 1000
 *
 * palindrome consists of only lowercase English letters.
 */

// @lc app=leetcode id=1328 lang=java
// @lc code=start
public class Solution {
  /*
   * [me]
   *
   * Amazon - 2020 new graduate - OA2
   *
   * greedy
   *
   * - For the first half of the string, replace the first non 'a' character to
   * 'a'.
   *
   * - If not found which means the the entire string is 'a' expect the middle one
   * if the length is odd, like aa or aba, replace the last character to 'b'.
   *
   * reference:
   * https://zxi.mytechroad.com/blog/greedy/leetcode-1328-break-a-palindrome/
   *
   * time: O(n)
   *
   * space: O(n)
   */

  public String breakPalindrome(String palindrome) {
    if (palindrome == null || palindrome.length() <= 1) {
      return "";
    }
    char[] array = palindrome.toCharArray();
    for (int i = 0; i < palindrome.length() / 2; i++) {
      if (array[i] != 'a') {
        array[i] = 'a';
        return new String(array);
      }
    }
    array[array.length - 1] = 'b';
    return new String(array);
  }
}
// @lc code=end
