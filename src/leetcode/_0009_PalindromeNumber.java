package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 0009. Palindrome Number
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: -121
 *
 * Output: false
 *
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: 10
 *
 * Output: false
 *
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class _0009_PalindromeNumber {
  public static void main(String[] args) {
    (new _0009_PalindromeNumber()).isPalindrome(1410110141);
  }

  public boolean isPalindrome(int x) {
    // [me]
    if (x < 0) {
      return false;
    }
    if (x >= 0 && x <= 9) {
      return true;
    }
    List<Integer> bit = new ArrayList<>();
    // use "/" rather than "*" to avoid overflow
    int temp = x;
    while (temp > 0) {
      bit.add(temp % 10);
      temp /= 10;
    }
    int left = 0;
    int right = bit.size() - 1;
    while (left <= right) {
      if (bit.get(left) != bit.get(right)) {
        return false;
      }
      left += 1;
      right -= 1;
    }
    return true;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
