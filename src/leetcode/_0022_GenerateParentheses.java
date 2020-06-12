package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 0022. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class _0022_GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }
    List<String> res = new ArrayList<>();
    // dfs
    dfs(n, 0, 0, new StringBuilder(), res);
    return res;
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private void dfs(int n, int l, int r, StringBuilder sb, List<String> res) {
    if (l + r >= n * 2) {
      // leaf node as result
      res.add(sb.toString());
      return;
    }
    final int cacheLength = sb.length();
    // add '('
    if (l < n) { // trimming
      sb.append('(');
      dfs(n, l + 1, r, sb, res);
      sb.setLength(cacheLength); // backtracking
    }
    // add ')'
    if (r < l) { // trimming
      sb.append(')');
      dfs(n, l, r + 1, sb, res);
      sb.setLength(cacheLength); // backtracking
    }
  }

  public List<String> generateParenthesis1(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }
    List<String> res = new ArrayList<>();
    // dfs
    dfs1(n, 0, 0, new StringBuilder(), res);
    return res;
    /*
     * time: O(solution number)
     *
     * space: O(1)
     */
  }

  private void dfs1(int n, int l, int r, StringBuilder sb, List<String> res) {
    if (l > n) {
      // trimming
      return;
    }
    if (r > l) {
      // trimming
      return;
    }
    if (l + r >= n * 2) {
      // leaf node as result
      res.add(sb.toString());
      return;
    }
    final int cacheLength = sb.length();
    // add '('
    sb.append('(');
    dfs1(n, l + 1, r, sb, res);
    sb.setLength(cacheLength); // backtracking
    // add ')'
    sb.append(')');
    dfs1(n, l, r + 1, sb, res);
    sb.setLength(cacheLength); // backtracking
  }
}
