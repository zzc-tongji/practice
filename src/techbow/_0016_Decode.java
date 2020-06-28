package techbow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * example: a3b4c2d1e3 ==> aaabbbbccdeee
 */
public class _0016_Decode {
  public static char[] decode(char[] s) {
    // from left to right
    //
    // corner case
    if (s == null || s.length < 0) {
      return s;
    }
    if (s.length == 1) {
      // The minimun length of input is 2 (an alphabit + a number).
      throw new IllegalArgumentException("invalid format");
    }
    if (charToInt(s[0]) >= 0) {
      // The first character must be an alphabit.
      throw new IllegalArgumentException("invalid format");
    }
    if (charToInt(s[s.length - 1]) < 0) {
      // The last character must be a number.
      throw new IllegalArgumentException("invalid format");
    }
    for (int i = 0; i < s.length - 1; i++) {
      // No adjacent alphabits.
      if (charToInt(s[i]) < 0 && charToInt(s[i + 1]) < 0) {
        throw new IllegalArgumentException("invalid format");
      }
    }
    // decode
    List<Character> res = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    Character c = s[0];
    int number = 0;
    int counter = 0;
    for (int i = 1; i < s.length; i++) {
      number = charToInt(s[i]);
      if (number >= 0) {
        // number
        q.offer(number);
        if (i == s.length - 1 || charToInt(s[i + 1]) < 0) {
          // last digit
          while (!q.isEmpty()) {
            counter = counter * 10 + q.poll();
          }
          while (counter > 0) {
            res.add(c);
            counter -= 1;
          }
        }
      } else {
        // alphabet
        c = s[i];
      }
    }
    // generate result
    char[] result = new char[res.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = res.get(i);
    }
    return result;
  }

  private static int charToInt(char c) {
    if (c >= 48 && c < 58) { // '0' - '9
      return c - 48;
    }
    return -1;
  }

  public static char[] decode1(char[] s) {
    // from right to left
    //
    // corner case
    if (s == null || s.length < 0) {
      return s;
    }
    if (s.length == 1) {
      // The minimun length of input is 2 (an alphabit + a number).
      throw new IllegalArgumentException("invalid format");
    }
    if (charToInt(s[0]) >= 0) {
      // The first character must be an alphabit.
      throw new IllegalArgumentException("invalid format");
    }
    if (charToInt(s[s.length - 1]) < 0) {
      // The last character must be a number.
      throw new IllegalArgumentException("invalid format");
    }
    for (int i = 0; i < s.length - 1; i++) {
      // No adjacent alphabits.
      if (charToInt(s[i]) < 0 && charToInt(s[i + 1]) < 0) {
        throw new IllegalArgumentException("invalid format");
      }
    }
    // decode
    Stack<Character> res = new Stack<>();
    Stack<Integer> st = new Stack<>();
    int number = 0;
    int counter = 0;
    for (int i = s.length - 1; i >= 0; i--) {
      number = charToInt(s[i]);
      if (number >= 0) {
        // number
        st.push(number);
        if (i == 0 || charToInt(s[i - 1]) < 0) {
          // first digit
          while (!st.empty()) {
            counter += counter * 10 + st.pop();
          }
        }
      } else {
        // alphabit
        while (counter > 0) {
          res.push(s[i]);
          counter -= 1;
        }
      }
    }
    // generate result
    char[] result = new char[res.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = res.pop();
    }
    return result;
  }
}
