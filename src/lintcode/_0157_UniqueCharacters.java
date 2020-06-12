package lintcode;

/*
 * 0157. Unique Characters
 *
 * Description
 *
 * Implement an algorithm to determine if a string has all unique characters.
 *
 * Example
 *
 * Example 1:
 *
 * Input: "abc_____"
 *
 * Output: false
 *
 * Example 2:
 *
 * Input: "abc"
 *
 * Output: true
 *
 * Challenge
 *
 * What if you can not use additional data structures?
 */
public class _0157_UniqueCharacters {
  public boolean isUnique(String str) {
    if (str.length() <= 1) {
      return true;
    }
    char[] chars = str.toCharArray();
    int[] bitmap = new int[8];
    int row = 0;
    int column = 0;
    for (int i = 0; i < chars.length; i++) {
      row = chars[i] / 32;
      column = chars[i] % 32;
      if ((bitmap[row] & (1 << column)) != 0) {
        return false;
      } else {
        bitmap[row] |= (1 << column);
      }
    }
    return true;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
