package leetcode;

/**
 * 0125 Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 *
 * Output: false
 *
 * Constraints:
 *
 * s consists only of printable ASCII characters.
 */
public class _0125_ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    String str = prepare(s);
    if (str.length() <= 1) {
      return true;
    }
    StringBuilder builder = new StringBuilder(str);
    return str.equals(builder.reverse().toString());
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  private String prepare(String s) {
    StringBuilder builder = new StringBuilder();
    char ch = 0;
    for (int i = 0; i < s.length(); i++) {
      ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        builder.append(Character.toLowerCase(ch));
      }
    }
    return builder.toString();
  }

  public boolean isPalindrome1(String s) {
    if (s == null) {
      return false;
    }
    String str = prepare(s);
    if (str.length() <= 1) {
      return true;
    }
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
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

  public boolean isPalindrome2(String s) {
    if (s == null) {
      return false;
    }
    String str = prepare(s);
    if (str.length() <= 1) {
      return true;
    }
    int left = 0;
    int right = str.length() - 1;
    int middle = left + (right - left) / 2;
    if (str.length() % 2 == 0) {
      // even
      left = middle;
      right = middle + 1;
    } else {
      // odd
      left = middle - 1;
      right = middle + 1;
    }
    while (left >= 0) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left -= 1;
      right += 1;
    }
    return true;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
