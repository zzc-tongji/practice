package leetcode;

/*
 * 0344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 *
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 *
 * Output: ["h","a","n","n","a","H"]
 */
public class _0344_ReverseString {
  public void reverseString(char[] s) {
    if (s == null || s.length <= 1) {
      return;
    }
    int left = 0;
    int right = s.length - 1;
    while (left <= right) {
      swap(s, left, right);
      left += 1;
      right -= 1;
    }
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private void swap(char[] s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }

  public void reverseString1(char[] s) {
    if (s == null || s.length <= 1) {
      return;
    }
    helper(s, 0, s.length - 1);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private void helper(char[] s, int begin, int end) {
    if (begin > end) {
      return;
    }
    // Swaping the following two statements is also accepted.
    swap(s, begin, end);
    helper(s, begin + 1, end - 1);
  }
}
