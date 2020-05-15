package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 0938. Range Sum of BST
 *
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 *
 * Output: 32
 *
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 *
 * Output: 23
 *
 * Note:
 *
 * - The number of nodes in the tree is at most 10000. - The final answer is
 * guaranteed to be less than 2^31.
 */
public class _0938_RangeSumOfBst {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  List<Integer> array;
  int answer = 0;

  public int rangeSumBST(TreeNode root, int L, int R) {
    array = new ArrayList<>();
    int res = 0;
    helper(root);
    for (int i = 0; i < array.size(); i++) {
      int value = array.get(i);
      if (value < L) {
        continue;
      }
      if (value > R) {
        break;
      }
      res += value;
    }
    return res;
    /*
     * time: O(n)
     *
     * space: O(n)
     */
  }

  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    array.add(root.val);
    helper(root.right);
  }

  public int rangeSumBST1(TreeNode root, int L, int R) {
    answer = 0;
    helper1(root, L, R);
    return answer;
    /*
     * time: O(level) ~ O(n), dependes on range
     *
     * space: O(1)
     */
  }

  private void helper1(TreeNode root, int L, int R) {
    if (root == null) {
      return;
    }
    if (root.val > L) {
      helper1(root.left, L, R);
    }
    if (root.val >= L && root.val <= R) {
      answer += root.val;
    }
    if (root.val < R) {
      helper1(root.right, L, R);
    }
  }
}
