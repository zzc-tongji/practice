package leetcode;

import java.util.Stack;

/*
 * 0020. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 *
 * 2. Open brackets must be closed in the correct order.
 *
 * 3. Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 *
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 *
 * Output: true
 */
public class _0020_ValidParentheses {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    char c = '\u0000';
    char c1 = '\u0000';
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        st.push(c);
        continue;
      }
      if (c == ')' || c == ']' || c == '}') {
        if (st.isEmpty()) {
          // more right parentheses
          return false;
        }
        c1 = st.pop();
        if (c == ')' && c1 != '(') {
          // not match
          return false;
        }
        if (c == ']' && c1 != '[') {
          // not match
          return false;
        }
        if (c == '}' && c1 != '{') {
          // not match
          return false;
        }
        continue;
      }
    }
    if (st.isEmpty()) {
      // more right parentheses
      return true;
    }
    return false;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }
}
