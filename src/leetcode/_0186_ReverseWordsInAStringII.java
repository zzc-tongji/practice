package leetcode;

/*
 * 0186. Reverse Words in a String II
 *
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 *
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Note:
 *
 * - A word is defined as a sequence of non-space characters.
 *
 * - The input string does not contain leading or trailing spaces.
 *
 * - The words are always separated by a single space.
 *
 * - Follow up: Could you do it in-place without allocating extra space?
 */
public class _0186_ReverseWordsInAStringII {
  public void reverseWords(char[] s) {
    if (s == null || s.length <= 0) {
      return;
    }
    // reverse string by character
    reverse(s, 0, s.length - 1);
    // search range of each word
    int slow = 0;
    int fast = 0;
    while (fast <= s.length) {
      if (fast == s.length || s[fast] == ' ') {
        // reverse word
        reverse(s, slow, fast - 1);
        slow = fast + 1;
      }
      fast += 1;
    }
    /*
     * time: O(n)
     *
     * space: O(1)
     */
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
