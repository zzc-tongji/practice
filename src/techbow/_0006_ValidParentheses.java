package techbow;

/*
 * It is similiar as LeetCode 22 but:
 *
 * - only validate '(' and ')'
 * - at most there are n pairs of '()'.
 */
public class _0006_ValidParentheses {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  /*
   * Solutions of LeetCode 22 are also correct.
   */

  public static boolean isValid(String s, int n) {
    int leftSoFar = 0;
    int rightSofar = 0;
    char c = '\u0000';
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c == '(') {
        leftSoFar += 1;
        if (leftSoFar > n) {
          return false;
        }
        continue;
      }
      if (c == ')') {
        rightSofar += 1;
        if (rightSofar > leftSoFar) {
          return false;
        }
        continue;
      }
    }
    return leftSoFar == rightSofar;
    /*
     * time: O(n)
     *
     * space: O(1)
     */
  }
}
