package techbow._0015_Encoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * example: aaabbbbccdeee => a3b4c2d1e3
 */

public class Solution {
  public static char[] encode(char[] s) {
    // Duplicates of each character should NOT larger than 9.
    //
    // corner case
    if (s == null || s.length < 0) {
      return s;
    }
    if (s.length == 1) {
      return new char[] { s[0], '1' };
    }
    // get segment number
    int segmentNumber = 1;
    for (int i = 1; i < s.length; i++) {
      if (s[i] != s[i - 1]) {
        segmentNumber += 1;
      }
    }
    // encode
    char[] temp = Arrays.copyOf(s, s.length + segmentNumber);
    int slow = temp.length - 1;
    int fast = s.length - 2;
    int counter = 1;
    while (fast >= 0) {
      if (temp[fast] == temp[fast + 1]) {
        counter += 1;
      } else {
        temp[slow] = (char) (48 + counter); // ASCII of '0' is 48.
        slow -= 1;
        temp[slow] = temp[fast + 1];
        slow -= 1;
        //
        counter = 1;
      }
      fast -= 1;
    }
    // post processing
    temp[slow] = (char) (48 + counter);
    slow -= 1;
    temp[slow] = temp[0];
    slow -= 1;
    return Arrays.copyOfRange(temp, slow + 1, temp.length);
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  public static char[] encode1(char[] s) {
    // [me]
    //
    // corner case
    if (s == null || s.length < 0) {
      return s;
    }
    if (s.length == 1) {
      return new char[] { s[0], '1' };
    }
    // encode
    Stack<Character> st = new Stack<>();
    List<Character> res = new ArrayList<>();
    int counter = 1;
    int fast = 1;
    while (fast < s.length) {
      if (s[fast] == s[fast - 1]) {
        counter += 1;
      } else {
        res.add(s[fast - 1]);
        generateDuplicateNumber(res, st, counter);
        counter = 1;
      }
      fast += 1;
    }
    // post processing
    res.add(s[s.length - 1]);
    generateDuplicateNumber(res, st, counter);
    // generate result
    char[] result = new char[res.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = res.get(i);
    }
    return result;
  }

  private static void generateDuplicateNumber(List<Character> res, Stack<Character> st, int counter) {
    while (counter > 0) {
      st.push((char) (48 + counter % 10)); // ASCII of '0' is 48.
      counter /= 10;
    }
    while (!st.isEmpty()) {
      res.add(st.pop());
    }
  }
}
