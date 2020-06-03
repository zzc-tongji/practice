package techbow;

import java.util.Arrays;

/*
 * Remove leading/trailing space and duplicate space with one remaining/
 */
public class _0011_RemoveSpace {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public static char[] removeSpace(char[] s) {
    // inplace, input changed
    if (s == null || s.length <= 0) {
      return s;
    }
    int slow = 0;
    int fast = 0;
    while (fast < s.length) {
      if (s[fast] == ' ' || (fast != 0 && s[fast - 1] == ' ')) {
        // skip
      } else {
        s[slow] = s[fast];
        slow += 1;
      }
      fast += 1;
    }
    // post processing: the last character might be ' '
    if (slow == 0) {
      return new char[0];
    }
    if (s[slow - 1] == ' ') { // `s[fast - 1] == ' '` is also OK.
      slow -= 1;
    }
    return Arrays.copyOf(s, slow);
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }

  public static String removeSpace1(String s) {
    if (s == null || s.length() <= 0) {
      return s;
    }
    char[] c = s.toCharArray();
    int slow = 0;
    int fast = 0;
    while (fast < s.length()) {
      if (c[fast] == ' ' || (fast != c.length - 1 && c[fast + 1] == ' ')) {
        // skip
      } else {
        c[slow] = c[fast];
        slow += 1;
      }
      fast += 1;
    }
    // post processing: the first character might be ' '
    if (slow == 0) {
      return "";
    }
    if (c[0] == ' ') {
      return new String(c, 1, slow - 1);
    }
    return new String(c, 0, slow);
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
