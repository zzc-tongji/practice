package leetcode;

import java.util.Stack;

/*
 * 0150. Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 *
 * Note:
 *
 * - Division between two integers should truncate toward zero.
 *
 * - The given RPN expression is always valid. That means the expression would
 * always evaluate to a result and there won't be any divide by zero operation.
 *
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 *
 * Output: 9
 *
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 *
 * Input: ["4", "13", "5", "/", "+"]
 *
 * Output: 6
 *
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 *
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 *
 * Output: 22
 *
 * Explanation:
 *
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class _0150_EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) {
      return 0;
    }
    Stack<Integer> st = new Stack<>();
    int op1 = 0;
    int op2 = 0;
    for (String s : tokens) {
      try {
        op1 = Integer.parseInt(s);
        st.push(op1);
      } catch (NumberFormatException ex) {
        // ATTENTION: first `op2` then `op1`
        op2 = st.pop();
        op1 = st.pop();
        switch (s) {
          case "+":
            st.push(op1 + op2);
            break;
          case "-":
            st.push(op1 - op2);
            break;
          case "*":
            st.push(op1 * op2);
            break;
          default: // "/"
            st.push(op1 / op2);
            break;
        }
      }
    }
    return st.pop();
  }
}
