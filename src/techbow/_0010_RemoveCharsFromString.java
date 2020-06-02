package techbow;

import java.util.Arrays;

public class _0010_RemoveCharsFromString {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public static String removeChar(String s, char[] removed) {
    if (s == null || s.length() <= 0) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    boolean add = true;
    for (char c : s.toCharArray()) {
      add = true;
      for (char c1 : removed) {
        if (c == c1) {
          add = false;
          break;
        }
      }
      if (add) {
        sb.append(c);
      }
    }
    return sb.toString();
    /*
     * time: O(n ^ 2)
     *
     * space: O(n)
     */
  }

  public static char[] removeChar2(char[] s, char[] removed) {
    // inplace, input changed
    if (s == null || s.length <= 0) {
      return s;
    }
    int slow = 0;
    int fast = 0;
    boolean add = true;
    while (fast < s.length) {
      for (char c : removed) {
        if (s[fast] == c) {
          add = false;
          break;
        }
      }
      if (add) {
        s[slow] = s[fast];
        slow += 1;
      }
      fast += 1;
    }
    return Arrays.copyOf(s, slow);
    /*
     * time: O(n ^ 2)
     *
     * space: O(1)
     */


  }
}
