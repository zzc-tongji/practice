package lintcode;

/*
 * 0008. Rotate String
 *
 * Description
 *
 * Given a string (Given in the way of char array) and an offset, rotate the
 * string by offset in place. (rotate from left to right).
 *
 * offset >= 0, the length of str >= 0, Make changes on the original input data
 *
 * Clarification
 *
 * in place means you should change string s in the function. You don't return
 * anything.
 *
 * Example
 *
 * Example 1:
 *
 * Input: str="abcdefg", offset = 3
 *
 * Output: str = "efgabcd"
 *
 * Explanation: Note that it is rotated in place, that is, after str is rotated,
 * it becomes "efgabcd".
 *
 * Example 2:
 *
 * Input: str="abcdefg", offset = 0
 *
 * Output: str = "abcdefg"
 *
 * Explanation: Note that it is rotated in place, that is, after str is rotated,
 * it becomes "abcdefg".
 *
 * Example 3:
 *
 * Input: str="abcdefg", offset = 1
 *
 * Output: str = "gabcdef"
 *
 * Explanation: Note that it is rotated in place, that is, after str is rotated,
 * it becomes "gabcdef".
 *
 * Example 4:
 *
 * Input: str="abcdefg", offset = 2
 *
 * Output: str = "fgabcde"
 *
 * Explanation: Note that it is rotated in place, that is, after str is rotated,
 * it becomes "fgabcde".
 *
 * Example 5:
 *
 * Input: str="abcdefg", offset = 10
 *
 * Output: str = "efgabcd"
 *
 * Explanation: Note that it is rotated in place, that is, after str is rotated,
 * it becomes "efgabcd".
 *
 * Challenge
 *
 * Rotate in-place with O(1) extra memory.
 */
public class _0008_RotateString {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public void rotateString(char[] str, int offset) {
    if (str == null || str.length <= 0) {
      return;
    }
    int breakPoint = str.length - offset % str.length;
    if (breakPoint == 0 || breakPoint == str.length) {
      return;
    }
    // two words: [0, breakPoint) and [breakPoint, str.length)
    //
    // reverse string and break point
    reverse(str, 0, str.length - 1);
    breakPoint = str.length - breakPoint;
    // reverse word
    reverse(str, 0, breakPoint - 1);
    reverse(str, breakPoint, str.length - 1);
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
