package leetcode;

import java.util.Arrays;

/*
 * 0151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 *
 * Output: "blue is sky the"
 *
 * Example 2:
 *
 * Input: " hello world! "
 *
 * Output: "world! hello"
 *
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 *
 * Example 3:
 *
 * Input: "a good example"
 *
 * Output: "example good a"
 *
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 *
 * Note:
 *
 * - A word is defined as a sequence of non-space characters.
 *
 * - Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 *
 * - You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class _0151_ReverseWordsInAString {
  public static void main(String[] args) {
    System.out.println("Hello world.");
   }

  public String reverseWords(String s) {
    if (s == null || s.length() <= 0) {
      return s;
    }
    // trim unnecessary space
    char[] c = trim(s.toCharArray());
    // char[] c = s.trim().replaceAll("\\s+", " ").toCharArray();
    if (c == null || c.length <= 0) {
      return "";
    }
    // reverse string by character
    reverse(c, 0, c.length - 1);
    // search range of each word
    int slow = 0;
    int fast = 0;
    while (fast <= c.length) {
      if (fast == c.length || c[fast] == ' ') {
        // reverse word
        reverse(c, slow, fast - 1);
        slow = fast + 1;
      }
      fast += 1;
    }
    return new String(c);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  private char[] trim(char[] c) {
    if (c == null || c.length <= 0) {
      return c;
    }
    // remove space on head and tail
    int begin = 0;
    while (begin < c.length) {
      if (c[begin] != ' ') {
        break;
      }
      begin += 1;
    }
    int end = c.length - 1;
    while (end >= 0) {
      if (c[end] != ' ') {
        break;
      }
      end -= 1;
    }
    if (begin > end) {
      return new char[0];
    }
    // remove duplicate space with 1 left
    //
    // range [begin, end]
    if (begin == end) {
      return Arrays.copyOfRange(c, begin, end + 1);
    }
    int slow = begin + 1;
    int fast = slow;
    while (fast <= end) {
      if (c[slow - 1] == c[fast] && c[fast] == ' ') {
        // skip
      } else {
        c[slow] = c[fast];
        slow += 1;
      }
      fast += 1;
    }
    // range [begin, slow)
    return Arrays.copyOfRange(c, begin, slow);
  }

  private void reverse(char[] c, int begin, int end) {
    int i = begin;
    int j = end;
    while (i < j) {
      swap(c, i, j);
      i += 1;
      j -= 1;
    }
  }

  private void swap(char[] c, int i, int j) {
    char temp = c[i];
    c[i] = c[j];
    c[j] = temp;
  }
}
