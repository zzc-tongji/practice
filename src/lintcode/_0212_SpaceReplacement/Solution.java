package lintcode._0212_SpaceReplacement;

import java.util.Arrays;

/**
 * 0212. Space Replacement
 *
 * Description
 *
 * Write a method to replace all spaces in a string with %20. The string is
 * given in a characters array, you can assume it has enough space for
 * replacement and you are given the true length of the string.
 *
 * You code should also return the new length of the string after replacement.
 *
 * If you are using Java or Python，please use characters array instead of
 * string.
 *
 * Example
 *
 * Example 1:
 *
 * Input: string[] = "Mr John Smith" and length = 13
 *
 * Output: string[] = "Mr%20John%20Smith" and return 17
 *
 * Explanation:
 *
 * The string after replacement should be "Mr%20John%20Smith", you need to
 * change the string in-place and return the new length 17.
 *
 * Example 2:
 *
 * Input: string[] = "LintCode and Jiuzhang" and length = 21
 *
 * Output: string[] = "LintCode%20and%20Jiuzhang" and return 25
 *
 * Explanation:
 *
 * The string after replacement should be "LintCode%20and%20Jiuzhang", you need
 * to change the string in-place and return the new length 25.
 *
 * Challenge
 *
 * Do it in-place.
 */

public class Solution {
  /*
   * time: O(n)
   *
   * space: O(1)
   */

  public int replaceBlank(char[] string, int length) {
    // The length of string is NOT LESS THAN the length of result.
    if (string == null || string.length <= 0) {
      return 0;
    }
    // preprocessing
    int match = 0;
    for (int i = 0; i < string.length; i++) {
      if (string[i] == ' ') {
        match += 1;
      }
    }
    int newLength = length + (3 - 1) * match;
    // allocate space (which is not valid in Java)
    // string = Arrays.copyOf(string, newLength);
    //
    // replace
    int slow = newLength - 1;
    int fast = length - 1;
    while (fast >= 0) {
      if (string[fast] == ' ') {
        // "" ==> "%20"
        string[slow] = '0';
        slow -= 1;
        string[slow] = '2';
        slow -= 1;
        string[slow] = '%';
        slow -= 1;
      } else {
        string[slow] = string[fast];
        slow -= 1;
      }
      fast -= 1;
    }
    return newLength;
  }

  public static void main(String[] args) {
    System.out.println("Hello world.");
    //
    Solution test = new Solution();
    //
    char[] input = Arrays.copyOf("\"Mr John Smith\"".toCharArray(), 19);
    int output = test.replaceBlank(input, 15);
    System.out.println(output);
    return;
  }
}
